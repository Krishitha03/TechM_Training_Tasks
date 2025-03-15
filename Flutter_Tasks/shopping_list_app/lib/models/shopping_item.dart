class ShoppingItem {
  int? id;
  String name;
  int quantity;
  bool isPurchased;

  ShoppingItem({
    this.id,
    required this.name,
    required this.quantity,
    this.isPurchased = false,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'quantity': quantity,
      'isPurchased': isPurchased ? 1 : 0,
    };
  }

  static ShoppingItem fromMap(Map<String, dynamic> map) {
    return ShoppingItem(
      id: map['id'],
      name: map['name'],
      quantity: map['quantity'],
      isPurchased: map['isPurchased'] == 1,
    );
  }
}
