import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:audioplayers/audioplayers.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:timezone/data/latest.dart' as tz;
import 'package:timezone/timezone.dart' as tz;
import 'dart:async';
import '../widgets/language_toggle.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

class SmartNapScreen extends StatefulWidget {
  @override
  _SmartNapScreenState createState() => _SmartNapScreenState();
}

class _SmartNapScreenState extends State<SmartNapScreen> {
  final List<int> napDurations = [1, 5, 10, 15, 20, 30, 45, 60];
  int selectedDuration = 10;
  Timer? _napTimer;
  final AudioPlayer _audioPlayer = AudioPlayer();
  DateTime? wakeUpTime;
  bool wakeUpTimeEnded = false;

  final FlutterLocalNotificationsPlugin flutterLocalNotificationsPlugin =
      FlutterLocalNotificationsPlugin();

  @override
  void initState() {
    super.initState();
    tz.initializeTimeZones();
    _loadWakeUpTime();
    _initializeNotifications();
  }

  Future<void> _initializeNotifications() async {
    const AndroidInitializationSettings initializationSettingsAndroid =
        AndroidInitializationSettings('@mipmap/ic_launcher');
    final InitializationSettings initializationSettings =
        InitializationSettings(android: initializationSettingsAndroid);
    await flutterLocalNotificationsPlugin.initialize(initializationSettings);
  }

  Future<void> _loadWakeUpTime() async {
    final prefs = await SharedPreferences.getInstance();
    String? wakeUpString = prefs.getString('wakeUpTime');
    if (wakeUpString != null) {
      DateTime storedTime = DateTime.parse(wakeUpString);
      if (storedTime.isAfter(DateTime.now())) {
        setState(() {
          wakeUpTime = storedTime;
          _startCountdown();
        });
      } else {
        _resetNap();
      }
    }
  }

  void startNap() async {
    setState(() {
      wakeUpTime = DateTime.now().add(Duration(minutes: selectedDuration));
      wakeUpTimeEnded = false;
    });

    await FirebaseFirestore.instance.collection('naps').add({
      'duration': selectedDuration,
      'wakeUpTime': wakeUpTime!.toIso8601String(),
    });

    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('wakeUpTime', wakeUpTime!.toIso8601String());

    _showSetAlarmNotification();
    _startCountdown();
    _scheduleNotification();
  }

  void _startCountdown() {
    _napTimer?.cancel();
    if (wakeUpTime != null) {
      final remainingTime = wakeUpTime!.difference(DateTime.now());
      if (remainingTime.inSeconds > 0) {
        _napTimer = Timer(remainingTime, _wakeUp);
      }
    }
  }

  void _wakeUp() {
    setState(() {
      wakeUpTimeEnded = true;
      wakeUpTime = null;
    });
    _playAlarm();
  }

  Future<void> _scheduleNotification() async {
    await flutterLocalNotificationsPlugin.zonedSchedule(
      0,
      AppLocalizations.of(context)!.wake_up,
      AppLocalizations.of(context)!.wake_up_message,
      tz.TZDateTime.from(wakeUpTime!, tz.local),
      const NotificationDetails(
          android: AndroidNotificationDetails('channel_id', 'channel_name')),
      androidScheduleMode: AndroidScheduleMode.exactAllowWhileIdle,
      uiLocalNotificationDateInterpretation:
          UILocalNotificationDateInterpretation.absoluteTime,
    );
  }

  void _showSetAlarmNotification() async {
    await flutterLocalNotificationsPlugin.show(
      1,
      AppLocalizations.of(context)!.nap_started,
      '${AppLocalizations.of(context)!.wake_up_time}: ${wakeUpTime!.hour}:${wakeUpTime!.minute}',
      const NotificationDetails(
          android: AndroidNotificationDetails('channel_id', 'channel_name')),
    );
  }

  void _playAlarm() async {
    await _audioPlayer.setReleaseMode(ReleaseMode.loop);
    await _audioPlayer.play(AssetSource('alarm.mp3'));
  }

  void _stopAlarm() async {
    await _audioPlayer.stop();
  }

  void _resetNap() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove('wakeUpTime');
    _stopAlarm();
    _napTimer?.cancel();
    setState(() {
      wakeUpTime = null;
      wakeUpTimeEnded = false;
    });
    flutterLocalNotificationsPlugin.cancelAll();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text(AppLocalizations.of(context)!.app_title),
        backgroundColor: Colors.grey[900],
        actions: [
          LanguageToggle(),
        ],
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            if (!wakeUpTimeEnded)
              Column(
                children: [
                  Text(
                    AppLocalizations.of(context)!.select_nap_duration,
                    style: TextStyle(color: Colors.white, fontSize: 18),
                  ),
                  DropdownButton<int>(
                    dropdownColor: Colors.black87,
                    value: selectedDuration,
                    items: napDurations.map((int minutes) {
                      return DropdownMenuItem<int>(
                        value: minutes,
                        child: Text(
                          '$minutes ${AppLocalizations.of(context)!.minutes}',
                          style: TextStyle(color: Colors.white),
                        ),
                      );
                    }).toList(),
                    onChanged: (int? newValue) {
                      setState(() {
                        selectedDuration = newValue!;
                      });
                    },
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.blueGrey[800],
                        ),
                        onPressed: startNap,
                        child: Text(
                          AppLocalizations.of(context)!.start_nap,
                          style: TextStyle(color: Colors.white),
                        ),
                      ),
                      SizedBox(width: 10),
                      ElevatedButton(
                        onPressed: _resetNap,
                        style:
                            ElevatedButton.styleFrom(backgroundColor: Colors.red),
                        child: Text(
                          AppLocalizations.of(context)!.reset,
                          style: TextStyle(color: Colors.white),
                        ),
                      ),
                    ],
                  ),
                  if (wakeUpTime != null)
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Text(
                        "${AppLocalizations.of(context)!.wake_up_time}: ${wakeUpTime!.hour}:${wakeUpTime!.minute}",
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: Colors.white),
                      ),
                    ),
                ],
              )
            else
              Column(
                children: [
                  Text(
                    AppLocalizations.of(context)!.wake_up_message,
                    style: TextStyle(
                        fontSize: 20,
                        color: Colors.white,
                        fontWeight: FontWeight.bold),
                  ),
                  SizedBox(height: 10),
                  ElevatedButton(
                    onPressed: _resetNap,
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.red,
                    ),
                    child: Text(
                      AppLocalizations.of(context)!.off,
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ],
              ),
          ],
        ),
      ),
    );
  }
}
