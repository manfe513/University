import 'package:flutter/material.dart';

class ChatMessage extends StatelessWidget {

  ChatMessage({
    this.text,
    this.animController});

  final String text;

  final String _name = "Andrew";

  final AnimationController animController;

  @override
  Widget build(BuildContext context) {
    return SizeTransition(
      sizeFactor: CurvedAnimation(parent: animController, curve: Curves.easeOut),
      axisAlignment: 0.0,
      child: Container(
        padding: EdgeInsets.symmetric(vertical: 5),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              margin: const EdgeInsets.only(right: 16.0),
              child: CircleAvatar(child: Text(_name[0])),
            ),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(_name, style: Theme.of(context).textTheme.subtitle1),
                Container(
                  margin: EdgeInsets.only(top: 5.0),
                  child: Text(text),
                ),
              ],
            ),
          ],
        )
      ),
    );
  }
}
