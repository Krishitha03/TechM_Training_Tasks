import 'package:flutter/material.dart';

class NapCard extends StatelessWidget {
  final int duration;
  final DateTime wakeUpTime;

  const NapCard({super.key, required this.duration, required this.wakeUpTime});

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.all(10),
      child: ListTile(
        title: Text('Nap Duration: $duration min'),
        subtitle: Text('Wake Up Time: ${wakeUpTime.toLocal()}'),
      ),
    );
  }
}
