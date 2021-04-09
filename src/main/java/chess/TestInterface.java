/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author kukkojoo
 */

import datastructureproject.GameBot;
import chess.engine.GameState;
import chess.bot.ChessBot;
import chess.bot.TestBot;
import datastructureproject.ChessBoard;
import datastructureproject.Coordinate;
import datastructureproject.Move;
        
public class TestInterface {
    
    public static void main(String [] args) {
        System.out.println("TEST");
        
        GameState gs = new GameState();
        gs.setMoves("a2a3,b8c6,e2e3");
        System.out.println(gs.getLatestMove());
/*        
        ChessBot bot = new TestBot();
        ChessBot bot2 = new GameBot();
        String move = bot.nextMove(gs);
        String move2 = bot2.nextMove(gs);
        System.out.println(move + ", " + move2);
        ChessBoard board = new ChessBoard();
        board.initBoard();
        board.printBoard();

        ChessBot bot = new GameBot();
        System.out.println(bot.nextMove(gs));
*/
        ChessBoard board = new ChessBoard();
        board.initBoard();
        board.printBoard();
        Coordinate coor = new Coordinate("a2");
        String piece = board.getBoard()[coor.getY()][coor.getX()];
        System.out.println(piece);

        //Move move = new Move("a2a3");
        //System.out.println(move.getOldX() + " " + move.getOldY());
        //System.out.println(move.getNewX() + " " + move.getNewY());
    }
    
}
