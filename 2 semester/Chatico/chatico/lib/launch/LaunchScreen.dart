
import 'package:chatico/chat/ChatScreen.dart';
import 'package:chatico/launch/LaunchScreenRoutes.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../Const.dart';

class LaunchScreen extends StatefulWidget {
  const LaunchScreen({Key key}) : super(key: key);

  @override
  LaunchScreenState createState() => LaunchScreenState();
}

class LaunchScreenState extends State<LaunchScreen> {

  final prefs = SharedPreferences.getInstance();

  @override
  Widget build(BuildContext context) => Scaffold(
    body: Container(
      color: Theme.of(context).primaryColor,
      child: FutureBuilder(
        future: prefs,
        builder: (ctx, snap) {

          if(snap.hasError) {
            print("Launch screen: get prefs error: ${snap.error}");
            return Center(child: Text("Error init prefs"));

          } else if (snap.hasData) {

            final SharedPreferences prefs = snap.data;
            final login = prefs.getString(Const.KEY_LOGIN);

            if(login != null) return ChatScreen();
            else return LaunchRoutes();

          } else {
            return Center(child: CircularProgressIndicator());
          }
        }
      )
    )
  );

  Widget buildRoutesWidget() => LaunchRoutes();

}