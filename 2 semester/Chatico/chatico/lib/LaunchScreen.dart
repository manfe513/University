import 'dart:ui';

import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';

import 'style/ButtonWhiteStyle.dart';

class LaunchScreen extends StatefulWidget {
  const LaunchScreen({Key key}) : super(key: key);

  @override
  LaunchScreenState createState() => LaunchScreenState();
}

class LaunchScreenState extends State<LaunchScreen> {

  @override
  Widget build(BuildContext context) => Scaffold(
    body: Container(
      color: Theme.of(context).primaryColor,
      child: buildRoutesWidget()
    )
  );

  Widget buildRoutesWidget() => Row(
    mainAxisAlignment: MainAxisAlignment.center,
    children: [
      Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Padding(
            padding: EdgeInsets.only(bottom: 50),
            child: Text(
              "Chatico",
              style: TextStyle(color: Colors.white, fontSize: 36),
            ),
          ),
          SizedBox(
            width: 200,
            child: ElevatedButton(
              onPressed: pushRegistrationScreen,
              child: Text("Вход", style: TextStyle(color: Theme.of(context).primaryColor),),
              style: ButtonStyleWhite(),
            ),
          ),
          SizedBox(
            width: 200,
            child: ElevatedButton(
                onPressed: pushRegistrationScreen,
                child: Text("Регистрация")
            ),
          ),
        ],
      )
    ],
  );

  void pushRegistrationScreen() {
      Navigator.of(context).push(
        
        MaterialPageRoute(
            builder: (BuildContext buildContext) {


              return Scaffold(
                appBar: AppBar(
                  title: Text("Saved list")
                ),
                // body: ListView(children: dividedTiles),
              );
            }
        )
      );
  }

  void pushLoginScreen() {

  }
}