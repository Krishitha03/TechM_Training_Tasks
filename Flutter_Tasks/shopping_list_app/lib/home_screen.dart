import 'package:flutter/material.dart';
import 'list_detail_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final List<Map<String, dynamic>> _items = [];
  final List<Map<String, dynamic>> _completedItems = [];

  void _addItem(String name, int quantity, double price) {
    setState(() {
      _items.add({"name": name, "quantity": quantity, "price": price, "isCompleted": false});
    });
  }

  void _toggleCompleted(int index) {
    setState(() {
      _items[index]["isCompleted"] = !_items[index]["isCompleted"];
      if (_items[index]["isCompleted"]) {
        _completedItems.add(_items[index]);
      } else {
        _completedItems.removeWhere((item) => item["name"] == _items[index]["name"]);
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Shopping List App")),
      body: Center(
        child: SizedBox(
          width: 250, // Increased width
          height: 60,
          child: ElevatedButton(
            style: ElevatedButton.styleFrom(
              padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 15), // More horizontal padding
              textStyle: const TextStyle(fontSize: 20), // Increased font size
            ),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => ListDetailScreen(
                    items: _items,
                    completedItems: _completedItems,
                    onItemAdded: _addItem,
                    onToggleCompleted: _toggleCompleted,
                  ),
                ),
              );
            },
            child: const Text("View Shopping List"),
          ),
        ),
      ),
    );
  }
}