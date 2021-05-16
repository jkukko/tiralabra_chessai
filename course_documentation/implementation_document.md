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



