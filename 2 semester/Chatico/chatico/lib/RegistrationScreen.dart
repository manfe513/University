import 'dart:ui';

import 'package:chatico/Const.dart';
import 'package:chatico/chat/ChatScreen.dart';
import 'package:chatico/widget/TextFieldLogin.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'style/ButtonWhiteStyle.dart';

class RegistrationScreen extends StatefulWidget {
  const RegistrationScreen({Key key}) : super(key: key);

  @override
  RegistrationScreenState createState() => RegistrationScreenState();
}

class RegistrationScreenState extends State<RegistrationScreen> {
  final emailController = TextEditingController();
  final nameController = TextEditingController();
  final passController = TextEditingController();
  final confirmPassController = TextEditingController();

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
                      "Регистрация",
                      style: TextStyle(color: Colors.white, fontSize: 26),
                    )
                  ],
                ),
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Email", emailController)
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Имя", nameController)
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Пароль", passController)
              ),
              Padding(
                  padding: EdgeInsets.all(10),
                  child: TextFieldLogin("Повторите пароль", confirmPassController)
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                  Padding(
                    padding: EdgeInsets.all(10),
                    child: SizedBox(
                      width: 200,
                      child: ElevatedButton(
                        onPressed: checkCredentialsForValidity,
                        child: Text("Зарегистрироваться", style: TextStyle(color: Theme.of(context).primaryColor),),
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

  void checkCredentialsForValidity() {
    final email = emailController.text;
    final pass = passController.text;
    final confirmPass = confirmPassController.text;
    final name = nameController.text;

    if(email.isEmpty || pass.isEmpty || confirmPass.isEmpty || name.isEmpty) {
      showError("Заполните форму");
      return;
    }

    if (!isEmailValid(email)) {
      showError("Некорректный почтовый адрес");
      return;
    }

    if(pass != confirmPass) {
      showError("Пароли не совпадают");
      return;
    }

    performRegistration(email, name, pass);
  }

  Future<void> performRegistration(String email, String name, String pass) async {

    try {
      UserCredential userCredential = await FirebaseAuth.instance.createUserWithEmailAndPassword(
          email: email,
          password: pass
      );

      final prefs = await SharedPreferences.getInstance();
      prefs.setString(Const.KEY_USERNAME, name);

    } on FirebaseAuthException catch (e) {

      if (e.code == 'weak-password') {
        showError("Пароль слишком простой");

      } else if (e.code == 'email-already-in-use') {
        showError("Почтовый адрес уже зарегистрирован");
      }

    } catch (e) {
      showError("Неизвестная ошибка: ${e.toString()}");
    }
  }

  bool isEmailValid(String email) {
    return RegExp(r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+").hasMatch(email);
  }

  void showError(String text) {

    showDialog(
        context: context,
        builder: (ctx) => AlertDialog(
          title: Text("Ошибка"),
          content: Text(text),
          actions: [
            TextButton(
              onPressed: () {},
              child: Text("Ok"),
            )
          ],
        )
    );
  }

  void showChat() {

    Navigator.of(context)
        .push(
          MaterialPageRoute(
            builder: (BuildContext buildContext) => ChatScreen()
          )
    );
  }

  void pushLoginScreen() {}
}
