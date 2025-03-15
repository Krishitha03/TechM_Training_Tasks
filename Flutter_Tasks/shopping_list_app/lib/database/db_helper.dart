import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DBHelper {
  static Future<Database> _database() async {
    final path = join(await getDatabasesPath(), 'shopping_list.db');
    return openDatabase(
      path,
      version: 1,
      onCreate: (db, version) async {
        await db.execute(
          "CREATE TABLE items(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, quantity INTEGER, price REAL, isCompleted INTEGER)",
        );
      },
    );
  }

  // Insert a new item into the shopping list
  static Future<int> insertItem(String name, int quantity, double price) async {
    final db = await _database();
    return db.insert(
      'items',
      {'name': name, 'quantity': quantity, 'price': price, 'isCompleted': 0},
      conflictAlgorithm: ConflictAlgorithm.replace,
    );
  }

  // Get all shopping items
  static Future<List<Map<String, dynamic>>> getItems() async {
    final db = await _database();
    return db.query('items', orderBy: 'id DESC');
  }

  // Update item details (name, quantity, price)
  static Future<void> updateItemDetails(int id, String name, int quantity, double price) async {
    final db = await _database();
    await db.update(
      'items',
      {'name': name, 'quantity': quantity, 'price': price},
      where: 'id = ?',
      whereArgs: [id],
    );
  }

  // Mark an item as completed or move it back to shopping list
  static Future<void> updateItem(int id, int isCompleted) async {
    final db = await _database();
    await db.update(
      'items',
      {'isCompleted': isCompleted},
      where: 'id = ?',
      whereArgs: [id],
    );
  }

  // Delete an item completely
  static Future<void> deleteItem(int id) async {
    final db = await _database();
    await db.delete(
      'items',
      where: 'id = ?',
      whereArgs: [id],
    );
  }
}
