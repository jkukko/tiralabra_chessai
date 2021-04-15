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
import datastructureproject.ChessLogic;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
        
public class TestInterface {
    
    public static void main(String [] args) {
        System.out.println("TEST");
        Scanner reader = new Scanner(System.in);
        
        //GameState gs = new GameState();
        //gs.setMoves("a2a3,b8c6,e2e3");
        //System.out.println(gs.getLatestMove());
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
        ChessLogic logic = new ChessLogic();
        GameBot gb = new GameBot();
            
        String x = "joo";
        while (true) {
            List<Move> moves = new ArrayList<>();
            printMoves(logic.legalMoves(board));
            board.printBoard();
            System.out.println("Give you move:");
            String m = reader.nextLine();
            
            if (m.equals("x")) {
                break;
            }
            
            Move mv = new Move(m);
            board.movePiece(mv);
            
            //moves = logic.checkPawnMoves(mv.getNewCoordinate(), board);
            //printMoves(moves);
            System.out.println("--------");
        }

    }
    
    public static void printMoves(List<Move> moves) {
        System.out.println("Possible moves: ");
        for (int i = 0; i < moves.size(); i++) {
            Move m = moves.get(i);
            System.out.println(m.getOldCoordinate().getCoordinate() + " -> " + m.getNewCoordinate().getCoordinate());
        }
    }
    
}
