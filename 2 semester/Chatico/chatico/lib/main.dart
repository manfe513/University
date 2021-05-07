import 'package:chatico/LaunchScreen.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) => MaterialApp(
        title: "Chatico",
        home: LaunchScreen(),
        theme: ThemeData(primaryColor: Colors.blue),
      );
}
