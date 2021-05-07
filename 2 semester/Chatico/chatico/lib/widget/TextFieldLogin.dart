import 'package:flutter/material.dart';

class TextFieldLogin extends TextField {
  final String hint;
  final TextEditingController control;

  TextFieldLogin(this.hint, this.control);

  @override
  // TODO: implement controller
  TextEditingController get controller => control;

  @override
  TextStyle get style => TextStyle(color: Colors.white);

  @override
  Color get cursorColor => Colors.white;

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
