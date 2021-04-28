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

    @Override
    public int evalueation(ChessBoard chessBoard, int player) {
        int value = 0;
        int[][] board = chessBoard.getBoard();
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int piece = board[i][j];
                
                if (piece == 1 || piece == 11) {
                    value += 1;
                } else if (piece == 2 || piece == 12) {
                    value += 3;
                } else if (piece == 3 || piece == 13) {
                    value += 3;
                } else if (piece == 4 || piece == 14) {
                    value += 5;
                } else if (piece == 5 || piece == 15) {
                    value += 9;
                } else if (piece == 6 || piece == 16) {
                    value += 90;
                }
            }
        }
        
        if (player == 2) {
            value = value * (-1);
        }
        
        return value;
    }

    
}
