import 'package:flutter/material.dart';
import 'add_item_screen.dart';
import 'completed_list_screen.dart';

class ListDetailScreen extends StatefulWidget {
  final List<Map<String, dynamic>> items;
  final List<Map<String, dynamic>> completedItems;
  final Function(String, int, double) onItemAdded;
  final Function(int) onToggleCompleted;

  const ListDetailScreen({
    super.key,
    required this.items,
    required this.completedItems,
    required this.onItemAdded,
    required this.onToggleCompleted,
  });

  @override
  _ListDetailScreenState createState() => _ListDetailScreenState();
}

class _ListDetailScreenState extends State<ListDetailScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Shopping List")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: ListView.builder(
          itemCount: widget.items.length,
          itemBuilder: (context, index) {
            final item = widget.items[index];
            return Card(
              color: Colors.grey[900],
              margin: const EdgeInsets.symmetric(vertical: 8),
              child: ListTile(
                leading: Checkbox(
                  value: item["isCompleted"],
                  onChanged: (bool? value) {
                    widget.onToggleCompleted(index);
                    setState(() {}); // Refresh UI
                  },
                  activeColor: Colors.green,
                  checkColor: Colors.white,
                ),
                title: Text(
                  item["name"],
                  style: TextStyle(
                    fontSize: 20,
                    color: item["isCompleted"] ? Colors.grey : Colors.white,
                    decoration: item["isCompleted"] ? TextDecoration.lineThrough : null,
                  ),
                ),
                subtitle: Text(
                  "Quantity: ${item["quantity"]} | Price: \$${item["price"].toStringAsFixed(2)}",
                  style: TextStyle(
                    fontSize: 18,
                    color: item["isCompleted"] ? Colors.grey[400] : Colors.grey,
                  ),
                ),
              ),
            );
          },
        ),
      ),
      floatingActionButton: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          SizedBox(
            width: 180,
            height: 60,
            child: FloatingActionButton.extended(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => AddItemScreen(onItemAdded: widget.onItemAdded),
                  ),
                );
              },
              icon: const Icon(Icons.add),
              label: const Text("Add Item", style: TextStyle(fontSize: 18)),
            ),
          ),
          const SizedBox(height: 12),
          SizedBox(
            width: 200,
            height: 60,
            child: FloatingActionButton.extended(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => CompletedListScreen(completedItems: widget.completedItems),
                  ),
                );
              },
              icon: const Icon(Icons.check_circle),
              label: const Text("Completed Items", style: TextStyle(fontSize: 18)),
            ),
          ),
        ],
      ),
    );
  }
}
