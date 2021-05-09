import 'package:flutter/material.dart';

import 'ChatMessage.dart';
import 'ChatScreen.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class ChatScreenState extends State<ChatScreen>  with TickerProviderStateMixin {

  final TextEditingController _textController = TextEditingController();
  final FocusNode _focusNode = FocusNode();

  @override
  Widget build(BuildContext context) => Scaffold(
        appBar: AppBar(title: Text("Chatico: chat")),
        body: Column(
          children: [
            Flexible(
                child: StreamBuilder(
                  stream: FirebaseFirestore.instance.collection("main_room").snapshots(),
                  builder: (BuildContext context, AsyncSnapshot<QuerySnapshot> snapshot) {

                    if(!snapshot.hasData) return Text("loading...");

                    return ListView.builder(
                      padding: EdgeInsets.all(8.0),
                      reverse: true,
                      itemBuilder: (_, int index) {

                        DocumentSnapshot doc = snapshot.data.docs[index];
                        return ChatMessage(author: doc['author'], text: doc['text']);
                      },
                      itemCount: snapshot.data.docs.length,
                    );
                  }
                )
            ),
            Divider(height: 1.0),
            Container(
                decoration: BoxDecoration(
                    color: Theme
                        .of(context)
                        .cardColor
                ),
                child: _buildTextComposer()
            )
          ],
        )
    );

  Widget _buildTextComposer() {
    return IconTheme(
      data: IconThemeData(color: Theme.of(context).accentColor),
      child: Container(
        margin:
        EdgeInsets.symmetric(horizontal: 8.0),
        child: Row(
          children: [
            Flexible(
                child: TextField(
                  controller: _textController,
                  onSubmitted: _handleSubmitted,
                  focusNode: _focusNode,
                  decoration: InputDecoration.collapsed(hintText: 'Send a message'),
                )
            ),
            Container(
              margin: EdgeInsets.symmetric(horizontal: 4.0),
              child: IconButton(
                icon: const Icon(Icons.send),
                onPressed: () => _handleSubmitted(_textController.text),
              ),
            )
          ],
        ),
      )
    );
  }

  void _handleSubmitted(String text) {
    _textController.clear();

    // ChatMessage newMsg = _buildChatMsg(text);

    // setState(() {
    //   _messages.insert(0, newMsg);
    // });

    _focusNode.requestFocus();
  }

  @override
  void dispose() {

    // for(var msg in _messages) {
    //   msg.animController.dispose();
    // }

    super.dispose();
  }
}