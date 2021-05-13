/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import datastructureproject.ChessBoard;
import datastructureproject.Evaluation.MiniMax;
import datastructureproject.Evaluation.MiniMaxAlphaBeta;
import datastructureproject.Move;
import datastructureproject.Logic.ChessLogicBlack;

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
            {0, 0,11, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,11, 0,11,11,11,11,11,11},
            {0,12,13,14,15,16,14,13,12},
        };  
        int[][] table1 = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 4, 5, 6, 4, 3, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,11,11,11,11,11,11,11,11},
            {0,12,13,14,15,16,14,13,12},
        };

        ChessBoard board = new ChessBoard(table);
        board.printBoard();
        
        MiniMax mm = new MiniMax(board);
        MiniMaxAlphaBeta mmAB = new MiniMaxAlphaBeta(board);
        
        long startTime = System.currentTimeMillis();
        //Move m = mm.getBestMove(board, 5, 1);
        Move mab = mmAB.getBestMove(board, 5, 1);
        long stopTime = System.currentTimeMillis();
        
        System.out.println("Elapsed time was " + (double) ((stopTime - startTime) / 1000) + " miliseconds.");
        //m.printMove();
        //mab.printMove();
        //System.out.println(mm.getCount());
        //System.out.println(mmAB.getCount());
       
        //System.out.println(m.getNewCoordinate().getX() + " " + m.getNewCoordinate().getY());
        
     }
    
}
