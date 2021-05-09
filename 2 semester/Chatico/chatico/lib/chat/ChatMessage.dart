import 'package:flutter/material.dart';

class ChatMessage extends StatelessWidget {

  ChatMessage({
    this.author,
    this.text});

  final String author;
  final String text;

  @override
  Widget build(BuildContext context) {
    return Container(
        padding: EdgeInsets.symmetric(vertical: 5),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              margin: const EdgeInsets.only(right: 16.0),
              child: CircleAvatar(child: Text(author[0])),
            ),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(author, style: Theme.of(context).textTheme.subtitle1),
                Container(
                  margin: EdgeInsets.only(top: 5.0),
                  child: Text(text),
                ),
              ],
            ),
          ],
        )
    );
  }
}
