import 'dart:ui';

import 'package:chatico/helper/DialogHelper.dart';
import 'package:chatico/chat/ChatScreen.dart';
import 'package:chatico/helper/EmailValidator.dart';
import 'package:chatico/widget/TextFieldLogin.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'Const.dart';
import 'style/ButtonWhiteStyle.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key key}) : super(key: key);

  @override
  LoginScreenState createState() => LoginScreenState();
}

class LoginScreenState extends State<LoginScreen> {
  final emailController = TextEditingController();
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
                  child: TextFieldLogin("Email", emailController, false)
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
                        onPressed: () { checkLogin(); },
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

  Future<void> checkLogin() async {

    final email = emailController.text;
    final pass = passController.text;

    if(email.isEmpty || pass.isEmpty) {
      showError("Заполните форму");
      return;
    }

    if (!EmailValidator.isEmailValid(email)) {
      showError("Некорректный почтовый адрес");
      return;
    }

    try {
      UserCredential userCredential = await FirebaseAuth.instance.signInWithEmailAndPassword(
          email: email,
          password: pass
      );

      final userSnap = await FirebaseFirestore.instance.collection("users")
          .doc(FirebaseAuth.instance.currentUser.uid)
      .get();

      final userName = userSnap.data()['name'];

      final prefs = await SharedPreferences.getInstance();
      prefs.setString(Const.KEY_USERNAME, userName);

      showChat();

    } on FirebaseAuthException catch (e) {

      if (e.code == 'user-not-found') {
        showError("Пользователь не найден");

      } else if (e.code == 'wrong-password') {
        showError("Неверный пароль");
      }
    }
  }

  void showError(String text) => DialogHelper.show(context, "Ошибка", text);

  void showChat() {
    Navigator.of(context)
        .push(MaterialPageRoute(builder: (BuildContext buildContext) => ChatScreen()
    ));
  }
}
