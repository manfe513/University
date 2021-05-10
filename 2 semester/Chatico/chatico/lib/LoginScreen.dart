import 'dart:ui';

import 'package:chatico/chat/ChatScreen.dart';
import 'package:chatico/widget/TextFieldLogin.dart';
import 'package:flutter/material.dart';

import 'style/ButtonWhiteStyle.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key key}) : super(key: key);

  @override
  LoginScreenState createState() => LoginScreenState();
}

class LoginScreenState extends State<LoginScreen> {
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
                      "Вход",
                      style: TextStyle(color: Colors.white, fontSize: 26),
                    )
                  ],
                ),
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Логин", loginController, false)
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Пароль", passController, true)
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
        .push(MaterialPageRoute(builder: (BuildContext buildContext) =>
        ChatScreen()
    ));
  }

  void pushLoginScreen() {}
}
