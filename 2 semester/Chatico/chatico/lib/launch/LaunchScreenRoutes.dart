import 'dart:ui';
import 'package:chatico/style/ButtonWhiteStyle.dart';
import 'package:flutter/material.dart';

class LaunchRoutes extends StatefulWidget {
  const LaunchRoutes({Key key}) : super(key: key);

  @override
  LaunchRoutesState createState() => LaunchRoutesState();
}

class LaunchRoutesState extends State<LaunchRoutes> {
  @override
  Widget build(BuildContext context) => Row(
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
          Padding(
            padding: EdgeInsets.only(bottom: 10),
            child: SizedBox(
              width: 200,
              child: ElevatedButton(
                onPressed: pushLoginScreen,
                child: Text("Вход", style: TextStyle(color: Theme.of(context).primaryColor),),
                style: ButtonStyleWhite(),
              ),
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

  void pushLoginScreen() {
    Navigator.of(context).push(
        MaterialPageRoute(builder: (BuildContext buildContext) => LoginScreen())
    );
  }

  void pushRegistrationScreen() {
    Navigator.of(context).push(
        MaterialPageRoute(builder: (BuildContext buildContext) => RegistrationScreen())
    );
  }
}
