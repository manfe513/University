import 'package:flutter/material.dart';

class TextFieldLogin extends TextField {
  final String hint;
  final TextEditingController control;
  final bool obscure;

  TextFieldLogin(this.hint, this.control, this.obscure);

  @override
  TextEditingController get controller => control;

  @override
  TextStyle get style => TextStyle(color: Colors.white);

  @override
  Color get cursorColor => Colors.white;

  @override
  bool get obscureText => obscure;

  @override
  // TODO: implement keyboardType
  TextInputType get keyboardType => TextInputType.visiblePassword;

  @override
  bool get autocorrect => false;

  @override
  bool get autofocus => false;

  @override
  // TODO: implement decoration
  InputDecoration get decoration =>
      InputDecoration(
        hintText: hint,
        hintStyle: TextStyle(color: Colors.white70),
        focusedBorder: UnderlineInputBorder(
          borderSide: BorderSide(color: Colors.white),
        ),
        enabledBorder: UnderlineInputBorder(
          borderSide: BorderSide(color: Colors.white),
        ),
      );
// controller: passController,
}
