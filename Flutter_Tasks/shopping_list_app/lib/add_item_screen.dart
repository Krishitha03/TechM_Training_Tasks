import 'package:flutter/material.dart';

class AddItemScreen extends StatefulWidget {
  final Function(String, int, double) onItemAdded;

  const AddItemScreen({super.key, required this.onItemAdded});

  @override
  _AddItemScreenState createState() => _AddItemScreenState();
}

class _AddItemScreenState extends State<AddItemScreen> {
  final _nameController = TextEditingController();
  final _quantityController = TextEditingController();
  final _priceController = TextEditingController();

  void _submitItem() {
    final name = _nameController.text;
    final quantity = int.tryParse(_quantityController.text) ?? 1;
    final price = double.tryParse(_priceController.text) ?? 0.0;

    if (name.isNotEmpty) {
      widget.onItemAdded(name, quantity, price);
      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Add Item")),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          children: [
            TextField(controller: _nameController, decoration: const InputDecoration(labelText: "Item Name")),
            TextField(controller: _quantityController, decoration: const InputDecoration(labelText: "Quantity"), keyboardType: TextInputType.number),
            TextField(controller: _priceController, decoration: const InputDecoration(labelText: "Price"), keyboardType: TextInputType.number),
            const SizedBox(height: 20),
            ElevatedButton(onPressed: _submitItem, child: const Text("Add Item", style: TextStyle(fontSize: 18))),
          ],
        ),
      ),
    );
  }
}
