import 'package:flutter/material.dart';

class WakeUpTimeProvider extends ChangeNotifier {
  DateTime? _wakeUpTime;

  DateTime? get wakeUpTime => _wakeUpTime;

  void setWakeUpTime(DateTime wakeTime) {
    _wakeUpTime = wakeTime;
    notifyListeners();
  }
}
