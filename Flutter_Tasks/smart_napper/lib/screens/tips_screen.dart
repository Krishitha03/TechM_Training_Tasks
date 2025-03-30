import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import '../widgets/language_toggle.dart';

class TipsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    List<String> tips = [
      AppLocalizations.of(context)!.tip_1,
      AppLocalizations.of(context)!.tip_2,
      AppLocalizations.of(context)!.tip_3,
      AppLocalizations.of(context)!.tip_4,
      AppLocalizations.of(context)!.tip_5,
    ];

    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalizations.of(context)!.nap_tips),
        actions: [
          LanguageToggle(), // Using the reusable widget
        ],
      ),
      body: ListView.builder(
        itemCount: tips.length,
        itemBuilder: (context, index) {
          return ListTile(
            leading: Icon(Icons.lightbulb_outline),
            title: Text(tips[index]),
          );
        },
      ),
    );
  }
}
