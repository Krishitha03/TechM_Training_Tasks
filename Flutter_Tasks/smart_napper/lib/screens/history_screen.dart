import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import '../models/nap.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import '../widgets/language_toggle.dart';

class HistoryScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalizations.of(context)!.nap_history),
        actions: [
          LanguageToggle(), // Using the reusable widget
        ],
      ),
      body: StreamBuilder(
        stream: FirebaseFirestore.instance.collection('naps').snapshots(),
        builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return Center(child: Text(AppLocalizations.of(context)!.no_naps_recorded));
          }

          return ListView(
            children: snapshot.data!.docs.map((doc) {
              Nap nap = Nap.fromFirestore(doc);
              return ListTile(
                title: Text('${AppLocalizations.of(context)!.nap_duration} ${nap.duration} ${AppLocalizations.of(context)!.minutes}'),
                subtitle: Text('${AppLocalizations.of(context)!.wake_up_time} ${nap.wakeUpTime}'),
                leading: Icon(Icons.bedtime),
              );
            }).toList(),
          );
        },
      ),
    );
  }
}
