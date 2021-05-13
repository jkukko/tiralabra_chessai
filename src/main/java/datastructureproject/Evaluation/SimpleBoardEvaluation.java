/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;

import datastructureproject.ChessBoard;

/**
 *
 * @author kukkojoo
 */
public class SimpleBoardEvaluation implements BoardEvaluation {
    
    /**
     * Evaluates given chessboard
     * @param chessBoard a chessboard
     * @param player a player
     * @return value of board
     */

    @Override
    public int evalueation(ChessBoard chessBoard, int player) {
        int value = 0;
        int[][] board = chessBoard.getBoard();
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int piece = board[i][j];
                
                if (piece == 0) {
                    continue;
                }
                
                if (piece == 1) {
                    value += 1;
                } else if (piece == 11) {
                    value -= 1;
                } else if (piece == 2 || piece == 3) {
                    value += 3;          
                } else if (piece == 12 || piece == 13) {
                    value -= 3;
                } else if (piece == 4) {
                    value += 5;
                } else if (piece == 14) {
                    value -= 5;
                } else if (piece == 5) {
                    value += 9;
                } else if (piece == 15) {
                    value -= 9;
                } else if (piece == 6) {
                    value += 90;
                } else if (piece == 16) {
                    value -= 90;
                }
            }
        }
        
        return value;
    }

    
}
