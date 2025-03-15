import 'package:flutter/material.dart';

class CompletedListScreen extends StatelessWidget {
  final List<Map<String, dynamic>> completedItems;

  const CompletedListScreen({super.key, required this.completedItems});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Completed Items")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: completedItems.isEmpty
            ? const Center(
                child: Text(
                  "No completed items yet!",
                  style: TextStyle(fontSize: 20, color: Colors.white),
                ),
              )
            : ListView.builder(
                itemCount: completedItems.length,
                itemBuilder: (context, index) {
                  final item = completedItems[index];
                  return Card(
                    color: Colors.green[900],
                    margin: const EdgeInsets.symmetric(vertical: 8),
                    child: ListTile(
                      title: Text(
                        item["name"],
                        style: const TextStyle(fontSize: 20, color: Colors.white),
                      ),
                      subtitle: Text(
                        "Quantity: ${item["quantity"]} | Price: \$${item["price"].toStringAsFixed(2)}",
                        style: const TextStyle(fontSize: 18, color: Colors.white70),
                      ),
                    ),
                  );
                },
              ),
      ),
    );
  }
}
