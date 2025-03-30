import 'package:cloud_firestore/cloud_firestore.dart';

class Nap {
  final int duration;
  final DateTime wakeUpTime;

  Nap({required this.duration, required this.wakeUpTime});

  factory Nap.fromFirestore(DocumentSnapshot doc) {
    Map data = doc.data() as Map<String, dynamic>;
    return Nap(
      duration: data['duration'],
      wakeUpTime: DateTime.parse(data['wakeUpTime']),
    );
  }
}
