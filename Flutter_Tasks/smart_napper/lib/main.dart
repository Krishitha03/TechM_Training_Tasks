import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:provider/provider.dart';
import 'package:smart_napper/firebase_options.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'localization/language_provider.dart';
import 'screens/home_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);
  runApp(
    ChangeNotifierProvider(
      create: (context) => LanguageProvider(),
      child: SmartNapperApp(),
    ),
  );
}

class SmartNapperApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Consumer<LanguageProvider>(
      builder: (context, languageProvider, child) {
        return MaterialApp(
          title: 'Smart Napper',
          theme: ThemeData.dark(),
          home: HomeScreen(),
          locale: languageProvider.locale,
          supportedLocales: [
            Locale('en', ''),
            Locale('es', ''),
            Locale('ta', ''),
          ],
          localizationsDelegates: [
            AppLocalizations.delegate,
            GlobalMaterialLocalizations.delegate,
            GlobalWidgetsLocalizations.delegate,
            GlobalCupertinoLocalizations.delegate,
          ],
          localeResolutionCallback: (locale, supportedLocales) {
            return supportedLocales.contains(locale) ? locale : Locale('en', '');
          },
        );
      },
    );
  }
}
