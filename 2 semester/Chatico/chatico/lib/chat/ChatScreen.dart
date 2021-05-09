import 'package:chatico/chat/ChatMessage.dart';
import 'package:flutter/material.dart';

class ChatScreen extends StatelessWidget {
  const ChatScreen({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("Chatico: chat")),
        body: ChatScreenBody()
    );
  }
}

class ChatScreenBody extends StatefulWidget {
  @override
  _ChatScreenBodyState createState() => _ChatScreenBodyState();
}

class _ChatScreenBodyState extends State<ChatScreenBody> {

  final List<ChatMessage> _messages = [];
  final TextEditingController _textController = TextEditingController();
  final FocusNode _focusNode = FocusNode();

  @override
  Widget build(BuildContext context) =>
      Column(
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
      );


  //     Row(children: [
  //
  //   Flexible(child: _buildTextComposer()),

  // ]);

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
    ChatMessage newMsg = ChatMessage(text: text);

    setState(() {
      _messages.insert(0, newMsg);
    });
    _focusNode.requestFocus();
    _textController.clear();
  }
}
