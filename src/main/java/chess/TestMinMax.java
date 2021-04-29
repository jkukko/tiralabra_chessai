/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import datastructureproject.ChessBoard;
import datastructureproject.Evaluation.MiniMax;
import datastructureproject.Move;

/**
 *
 * @author kukkojoo
 */
public class TestMinMax {
    
    public static void main(String [] args) {
        int[][] table = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 4, 5, 6, 4, 3, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 11, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,11,0,11,11,11,11,11,11},
            {0,12,13,14,15,16,14,13,12},
        };  
        ChessBoard board = new ChessBoard(table);
        board.printBoard();
        
        MiniMax mm = new MiniMax(board);
        
        Move m = mm.getBestMove(board, 3, 1);
        m.printMove();
        System.out.println(m.getNewCoordinate().getX() + " " + m.getNewCoordinate().getY());
        
     }
    
}
