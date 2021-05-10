import 'package:flutter/material.dart';

class DialogHelper {

  static void show(BuildContext context, String title, String text) {
    showDialog(
        context: context,
        builder: (ctx) => AlertDialog(
          title: Text(title),
          content: Text(text),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Ok"),
            )
          ],
        )
    );
  }
}