import 'package:cloud_firestore/cloud_firestore.dart';

class DatabaseService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

  Future<void> saveNap(int duration, DateTime wakeUpTime) async {
    await _db.collection('naps').add({
      'duration': duration,
      'wakeUpTime': wakeUpTime.toIso8601String(),
    });
  }
}
