# Program structure
My chess ai program has following structure. Structure can be divided to six different elements: 
* basic chess elements
* game logic
* Ownstructures
* evaluation
* Brain
* Bot

### Basic elements
Basic elements includes chessboard, move and coordinate. Chessboard is basicly a two dimension integer table. As name indicates it is chessboard that has pieces in specific situation. Additionally, Chessboard class includes relevants methods. For example moving pieces and fetting information about board. Move is a class for specific move. It works by gining infomation about the move bny either string or two coordinates. Coordinate class is a coordination in chessboard (for example A1).

### Game Logic
Game Logic have three classes: game logic, white logic and black logic. These three classes provides all legal moves in specific situation. GameLogic class only function is to receive information about which player is needing legal moves, then it uses either white or black logic. Both White and black logic have same functionality. It takes as a parameter current game situation and it loops this chessboard and provides all the legal moves. 

### OwnStructures
OwnStructures includes my own creation of list and it is called OwnList. 

### Evaluation
My functionality of this element is to evaluate specific chessboard. It has two classes: basic and bonus evaluation. Both classes evaluates chessboard base on certain rules. Bonus Board evaluation uses more complex/better way to evaluate the board.

### Brain
Brain stucture includes two different versions of minimax algorithms: basic minimax algorithm and alpha beta pruning minimax algorithm.

### Bot
Bot includes two different ai chess bots. First uses basic minimax algorithm and other uses alpha beta pruning minimax algorithm.

# Time and memory complexity

Time complexity is quite hard. MiniMax theoretical time complexity is O(b^m), where b is the legal moves at each level and m is the depth of the tree. Memory theoretical space complexity is O(bm), where b and m are same as in time complexity.

# Performance Tests
There is quite big difference in performance when compare basic minimax algorithm and alpha beta pruning algoritm. Here are some examples:

Starting situations and depth is 5
* Basic minimax took ~16s
* Alpha beta minimax took ~1s
* Alpha beta only inspect 5.8 % of branches

Board with almoust all pieces (not start situation) and depth is 5
* Basic minimax took ~120s
* Alpa beta minimax took ~4s
* Alpha beta only inspect 1.27 % of branches

Middle game and depth 5
* Basic minimax took ~160s
* Alpha beta minimax took ~3s
* Alpha beta only inspect 0.26 % of branches

End Game and depth 5
* Basic minimax took ~0s
* Alpha beta minimax took ~0s
* Alpha beta only inspect 2.17 % of branches

# Missing things and improvements
There is still work need for game logic engine. For example I did not manage to do upgrade from pawn to queen. This should be actually pretty easy fix. Additionally, I would like to create better evaluation function. BonusBoard is at least giving better evaluation than simple. I think the most problematic part of evaluation is start of the game.

# Sources
* [Evaluation](https://www.chessprogramming.org/Simplified_Evaluation_Function)
