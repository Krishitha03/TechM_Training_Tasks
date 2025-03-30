import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';

class NotificationService {
  static final FlutterLocalNotificationsPlugin _flutterLocalNotificationsPlugin =
      FlutterLocalNotificationsPlugin();

  static Future<void> initialize() async {
    var androidInit = AndroidInitializationSettings('@mipmap/ic_launcher');
    var initSettings = InitializationSettings(android: androidInit);
    await _flutterLocalNotificationsPlugin.initialize(initSettings);
  }

  static Future<void> scheduleNapNotification(TimeOfDay napTime) async {
    var androidDetails = AndroidNotificationDetails(
      'nap_channel',
      'Nap Alerts',
      importance: Importance.high,
    );

    var generalNotificationDetails = NotificationDetails(android: androidDetails);

    await _flutterLocalNotificationsPlugin.show(
      0,
      "Nap Alert",
      "It's time to wake up!",
      generalNotificationDetails,
    );
  }
}
