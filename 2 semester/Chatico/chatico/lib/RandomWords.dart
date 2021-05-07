import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';

class RandomWordsWidget extends StatefulWidget {
  const RandomWordsWidget({Key key}) : super(key: key);

  @override
  RandomWordsWidgetState createState() => RandomWordsWidgetState();
}

class RandomWordsWidgetState extends State<RandomWordsWidget> {

  final _suggestions = <WordPair>[];
  final _saved = <WordPair>{};
  final _biggerFont = TextStyle(fontSize: 18.0);

  @override
  Widget build(BuildContext context) => Scaffold(

    appBar: AppBar(
      title: Text("Chatico"),
      actions: [
        IconButton(icon: Icon(Icons.list), onPressed: _pushSaved)
      ],
    ),

    body: _buildSuggestions()
  );

  Widget _buildSuggestions() => Column(
    mainAxisAlignment: MainAxisAlignment.start,
    children: [
      TextField(
        decoration: InputDecoration(
            hintText: "Enter smth",
            hintStyle: TextStyle(color: Colors.grey[600]),
          focusedBorder: UnderlineInputBorder(
            borderSide: BorderSide(
              color: Colors.cyan
            )
          )
        ),
      ),
      ListView.builder(

          padding: EdgeInsets.all(16.0),

          itemBuilder: (context, i) {
            if (i.isOdd) return Divider();

            final index = i ~/ 2;
            if (index >= _suggestions.length) {
              _suggestions.addAll(generateWordPairs().take(10));
            }

            return _buildRow(_suggestions[index]);
          }
      ).build(context)
    ],
  );

  Widget _buildRow(WordPair wp) {

    final saved = _saved.contains(wp);

    return ListTile(
      title: Text(
          wp.asPascalCase,
          style: _biggerFont),
      trailing: Icon(
        saved ? Icons.favorite : Icons.favorite_border,
        color: saved ? Colors.red : null
      ),
      onTap: () {
        setState(() {
          if(saved) {
            _saved.remove(wp);
          } else {
            _saved.add(wp);
          }
        });
      },
    );
  }

  void _pushSaved() {
      Navigator.of(context).push(
        
        MaterialPageRoute(
            builder: (BuildContext buildContext) {
              final tiles = _saved.map((WordPair wp) => ListTile(
                title: Text(wp.asPascalCase, style: _biggerFont),
              ));

              final dividedTiles = ListTile.divideTiles(
                context: buildContext,
                tiles: tiles
              ).toList();

              return Scaffold(
                appBar: AppBar(
                  title: Text("Saved list")
                ),
                body: ListView(children: dividedTiles),
              );
            }
        )
      );
  }
}