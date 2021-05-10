import 'package:chatico/launch/LaunchScreen.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();

  await Firebase.initializeApp();

  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  final Future<FirebaseApp> _fbApp = Firebase.initializeApp();

  @override
  Widget build(BuildContext context) => MaterialApp(
        title: "Chatico",
        theme: ThemeData(primaryColor: Colors.blue),
        home: FutureBuilder(
            future: _fbApp,
            builder: (context, snapshot) {

              if(snapshot.hasError) {
                print("Firebase init error: ${snapshot.error.toString()}");
                return Text("Firebase error");

              } else if (snapshot.hasData) {
                return LaunchScreen();

              } else {
                return Center(child: CircularProgressIndicator());
              }
            }
        )
      );
}
