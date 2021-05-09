import 'package:flutter/material.dart';

class ChatScreen extends StatelessWidget {
  const ChatScreen({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("Chatico: chat")), body: ChatScreenBody());
  }
}

class ChatScreenBody extends StatefulWidget {
  @override
  _ChatScreenBodyState createState() => _ChatScreenBodyState();
}

class _ChatScreenBodyState extends State<ChatScreenBody> {
  TextEditingController _textController = TextEditingController();

  @override
  Widget build(BuildContext context) => Row(children: [

    Flexible(child: _buildTextComposer()),
    IconTheme(
      data: IconThemeData(color: Theme.of(context).accentColor),
      child: Container(
        margin: EdgeInsets.symmetric(horizontal: 4.0),
        child: IconButton(
          icon: const Icon(Icons.send),
          onPressed: () => _handleSubmitted(_textController.text),
        ),
      ),
    )
  ]);

  Widget _buildTextComposer() {
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 8.0),
      child: TextField(
        controller: _textController,
        onSubmitted: _handleSubmitted,
        decoration: InputDecoration.collapsed(hintText: 'Send a message'),
      ),
    );
  }

  void _handleSubmitted(String text) {
    _textController.clear();
  }
}
