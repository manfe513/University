import 'dart:ui';

import 'package:chatico/widget/TextFieldLogin.dart';
import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';

import 'style/ButtonWhiteStyle.dart';

class RegistrationScreen extends StatefulWidget {
  const RegistrationScreen({Key key}) : super(key: key);

  @override
  RegistrationScreenState createState() => RegistrationScreenState();
}

class RegistrationScreenState extends State<RegistrationScreen> {
  final loginController = TextEditingController();
  final passController = TextEditingController();

  @override
  Widget build(BuildContext context) => Scaffold(
      body: Container(
          color: Theme.of(context).primaryColor, child: buildWidget()));

  Widget buildWidget() => Row(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          Expanded(
              child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Padding(
                padding: EdgeInsets.all(10),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: [
                    Text(
                      "Chatico",
                      style: TextStyle(color: Colors.white, fontSize: 36),
                    )
                  ],
                ),
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Логин", loginController)
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Пароль", passController)
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                  Padding(
                    padding: EdgeInsets.all(10),
                    child: SizedBox(
                      width: 100,
                      child: ElevatedButton(
                        onPressed: checkLogin,
                        child: Text("Войти", style: TextStyle(color: Theme.of(context).primaryColor),),
                        style: ButtonStyleWhite(),
                      ),
                    ),
                  )
                ],
              )
            ],
          ))
        ],
      );

  void checkLogin() {
    Navigator.of(context)
        .push(MaterialPageRoute(builder: (BuildContext buildContext) {
      return Scaffold(
        appBar: AppBar(title: Text("Saved list")),
        // body: ListView(children: dividedTiles),
      );
    }));
  }

  void pushLoginScreen() {}
}
