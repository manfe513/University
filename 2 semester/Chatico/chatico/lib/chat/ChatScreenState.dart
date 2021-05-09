import 'package:flutter/material.dart';

import 'ChatMessage.dart';
import 'ChatScreen.dart';

class ChatScreenState extends State<ChatScreen>  with TickerProviderStateMixin {

  final List<ChatMessage> _messages = [];
  final TextEditingController _textController = TextEditingController();
  final FocusNode _focusNode = FocusNode();

  @override
  Widget build(BuildContext context) => Scaffold(
        appBar: AppBar(title: Text("Chatico: chat")),
        body: Column(
          children: [
            Flexible(
                child: ListView.builder(
                  padding: EdgeInsets.all(8.0),
                  reverse: true,
                  itemBuilder: (_, int index) => _messages[index],
                  itemCount: _messages.length,
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

    ChatMessage newMsg = ChatMessage(
        text: text,
        animController: AnimationController(
          duration: const Duration(milliseconds: 700),
          vsync: this
        ),
    );

    setState(() {
      _messages.insert(0, newMsg);
    });

    _focusNode.requestFocus();
    newMsg.animController.forward();
  }

  @override
  void dispose() {

    for(var msg in _messages) {
      msg.animController.dispose();
    }

    super.dispose();
  }
}