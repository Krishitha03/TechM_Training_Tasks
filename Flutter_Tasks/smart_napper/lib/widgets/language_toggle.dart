import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../localization/language_provider.dart';

class LanguageToggle extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return IconButton(
      icon: Icon(Icons.language),
      onPressed: () {
        _changeLanguage(context);
      },
    );
  }

  void _changeLanguage(BuildContext context) {
    final languageProvider = Provider.of<LanguageProvider>(context, listen: false);
    String currentLang = languageProvider.locale.languageCode;

    if (currentLang == 'en') {
      languageProvider.changeLanguage('es'); // Switch to Spanish
    } else if (currentLang == 'es') {
      languageProvider.changeLanguage('ta'); // Switch to Tamil
    } else {
      languageProvider.changeLanguage('en'); // Switch back to English
    }
  }
}
