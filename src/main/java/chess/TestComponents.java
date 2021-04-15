/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import datastructureproject.GameBot;
import datastructureproject.ChessLogic;
import datastructureproject.ChessBoard;
import datastructureproject.Coordinate;
import datastructureproject.Move;
import chess.engine.GameState;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kukkojoo
 */
public class TestComponents {
    
    public static void main(String [] args) {
        
        List<Move> moves = new ArrayList<>();
        GameBot gamebot = new GameBot(); 
        GameState gs = new GameState();
        ChessLogic logic = new ChessLogic();
        ChessBoard board = new ChessBoard();
        Move m1 = new Move("h2h4");
        Move m2 = new Move("h7h5");
        board.initBoard();
        board.printBoard();
        board.movePiece(m1);
        board.movePiece(m2);
        board.printBoard();
        Coordinate coor = new Coordinate("h1");
        moves = logic.checkRook(coor, board);
        
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(moves.get(i).getNewCoordinate().getCoordinate());
        }
        
        gs.setMoves("h2h4");
        //gamebot.parseLatestMove(gs);
        gs.setMoves("h7h5");
        //gamebot.parseLatestMove(gs);
        System.out.println(gs.getLatestMove());
        
        
        
        gamebot.nextMove(gs);
        
    }
    
}
