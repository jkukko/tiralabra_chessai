/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;

import datastructureproject.BasicElements.ChessBoard;

/**
 *
 * @author kukkojoo
 */
public class BonusBoardEvaluation implements BoardEvaluation {
    int pawnScore = 100;
    int rookScore = 300;
    int knightScore = 300;
    int bishopScore = 500;
    int queenScore = 900;
    int kingScore = 9000;
    
    

    int[][] pawnTableBlack = 
        {
            {0,  0,  0,   0,   0,   0,   0,  0,  0},
            {0,  0,  0,   0,   0,   0,   0,  0,  0},
            {0, 50, 50,  50,  50,  50,  50, 50, 50},
            {0, 10, 10,  20,  30,  30,  20, 10, 10},
            {0,  5,  5,  10,  25,  25,  10,  5,  5},
            {0,  0,  0,   0,  20,  20,   0,  0,  0},
            {0,  5, -5, -10,   0,   0, -10, -5,  5},
            {0,  5, 10,  10, -20, -20,  10, 10,  5},
            {0,  0,  0,   0,   0,   0,   0,  0,  0},
        };
      
    int[][] pawnTableWhite = 
        {
            {0,  0,  0,   0,   0,   0,   0,  0,  0},
            {0,  0,  0,   0,   0,   0,   0,  0,  0},
            {0,  5, 10,  10, -20, -20,  10, 10,  5},
            {0,  5, -5, -10,   0,   0, -10, -5,  5},
            {0,  0,  0,   0,  20,  20,   0,  0,  0},
            {0,  5,  5,  10,  25,  25,  10,  5,  5},
            {0, 10, 10,  20,  30,  30,  20, 10, 10},
            {0, 50, 50,  50,  50,  50,  50, 50, 50},
            {0,  0,  0,   0,   0,   0,   0,  0,  0},
        };
    
    int[][] knightTableBlack = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -50, -40, -30, -30, -30, -30, -40, -50},
            {0, -40, -20,   0,   0,   0,   0, -20, -40},
            {0, -30,   0,  10,  15,  15,  10,   0, -30},
            {0, -30,   5,  15,  20,  20,  15,   5, -30},
            {0, -30,   0,  15,  20,  20,  15,   0, -30},
            {0, -30,   5,  10,  15,  15,  10,   5, -30},
            {0, -40, -20,   0,   5,   5,   0, -20, -40},
            {0, -50, -40, -30, -30, -30, -30, -40, -50}
        };
    
    int[][] knightTableWhite = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -50, -40, -30, -30, -30, -30, -40, -50},
            {0, -40, -20,   0,   5,   5,   0, -20, -40},
            {0, -30,   5,  10,  15,  15,  10,   5, -30},
            {0, -30,   0,  15,  20,  20,  15,   0, -30},
            {0, -30,   5,  15,  20,  20,  15,   5, -30},
            {0, -30,   0,  10,  15,  15,  10,   0, -30},
            {0, -40, -20,   0,   0,   0,   0, -20, -40},
            {0, -50, -40, -30, -30, -30, -30, -40, -50}
        };
    
    int[][] rookTableBlack = 
        {
            {0,  0,  0,  0,  0,  0,  0,  0,  0},
            {0,  0,  0,  0,  0,  0,  0,  0,  0},
            {0,  5, 10, 10, 10, 10, 10, 10,  5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0,  0,  0,  0,  5,  5,  0,  0,  0}
        };
    

    int[][] rookTableWhite = 
        {
            {0,  0,  0,  0,  0,  0,  0,  0,  0},
            {0,  0,  0,  0,  5,  5,  0,  0,  0},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0, -5,  0,  0,  0,  0,  0,  0, -5},
            {0,  5, 10, 10, 10, 10, 10, 10,  5},
            {0,  0,  0,  0,  0,  0,  0,  0,  0},
        };
    
    int[][] bishopTableBlack = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -20, -10, -10, -10, -10, -10, -10, -20},
            {0, -10,   0,   0,   0,   0,   0,   0, -10},
            {0, -10,   0,   5,  10,  10,   5,   0, -10},
            {0, -10,   5,   5,  10,  10,   5,   5, -10},
            {0, -10,   0,  10,  10,  10,  10,   0, -10},
            {0, -10,  10,  10,  10,  10,  10,  10, -10},
            {0, -10,   5,   0,   0,   0,   0,   5, -10},
            {0, -20, -10, -10, -10, -10, -10, -10, -20},
        };            

    int[][] bishopTableWhite = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -20, -10, -10, -10, -10, -10, -10, -20},
            {0, -10,   5,   0,   0,   0,   0,   5, -10},
            {0, -10,  10,  10,  10,  10,  10,  10, -10},
            {0, -10,   0,  10,  10,  10,  10,   0, -10},
            {0, -10,   5,   5,  10,  10,   5,   5, -10},
            {0, -10,   0,   5,  10,  10,   5,   0, -10},
            {0, -10,   0,   0,   0,   0,   0,   0, -10},
            {0, -20, -10, -10, -10, -10, -10, -10, -20},
            
        };
    
    int[][] queenTableBlack = 
        {
            {0,   0,   0,   0,  0,  0,   0,   0,   0},
            {0, -20, -10, -10, -5, -5, -10, -10, -20},
            {0, -10,   0,   0,  0,  0,   0,   0, -10},
            {0, -10,   0,   5,  5,  5,   5,   0, -10},
            {0,  -5,   0,   5,  5,  5,   5,   0,  -5},
            {0,   0,   0,   5,  5,  5,   5,   0,  -5},
            {0, -10,   5,   5,  5,  5,   5,   0, -10},
            {0, -10,   0,   5,  0,  0,   0,   0, -10},
            {0, -20, -10, -10, -5, -5, -10, -10, -20},
        };

    int[][] queenTableWhite = 
        {
            {0,   0,   0,   0,  0,  0,   0,   0,   0},
            {0, -20, -10, -10, -5, -5, -10, -10, -20},
            {0, -10,   0,   5,  0,  0,   0,   0, -10},
            {0, -10,   5,   5,  5,  5,   5,   0, -10},
            {0,   0,   0,   5,  5,  5,   5,   0,  -5},
            {0,  -5,   0,   5,  5,  5,   5,   0,  -5},
            {0, -10,   0,   5,  5,  5,   5,   0, -10},
            {0, -10,   0,   0,  0,  0,   0,   0, -10},
            {0, -20, -10, -10, -5, -5, -10, -10, -20},
        };
    
    int[][] kingMiddleTableBlack = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -20, -30, -30, -40, -40, -30, -30, -20},
            {0, -10, -20, -20, -20, -20, -20, -20, -10},
            {0,  20,  20,   0,   0,   0,   0,  20,  20},
            {0,  20,  30,  10,   0,   0,  10,  30,  20},
        };
    
    int[][] kingMiddleTableWhite = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0,  20,  30,  10,   0,   0,  10,  30,  20},
            {0,  20,  20,   0,   0,   0,   0,  20,  20},
            {0, -10, -20, -20, -20, -20, -20, -20, -10},
            {0, -20, -30, -30, -40, -40, -30, -30, -20},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -30, -40, -40, -50, -50, -40, -40, -30},
            {0, -30, -40, -40, -50, -50, -40, -40, -30}

        };
    
    int[][] kingEndTableBlack = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -50, -40, -30, -20, -20, -30, -40, -50},
            {0, -30, -20, -10,   0,   0, -10, -20, -30},
            {0, -30, -10,  20,  30,  30,  20, -10, -30},
            {0, -30, -10,  30,  40,  40,  30, -10, -30},
            {0, -30, -10,  30,  40,  40,  30, -10, -30},
            {0, -30, -10,  20,  30,  30,  20, -10, -30},
            {0, -30, -30,   0,   0,   0,   0, -30, -30},
            {0, -50, -30, -30, -30, -30, -30, -30, -50}        
        };

    int[][] kingEndTableWhite = 
        {
            {0,   0,   0,   0,   0,   0,   0,   0,   0},
            {0, -50, -30, -30, -30, -30, -30, -30, -50},
            {0, -30, -30,   0,   0,   0,   0, -30, -30},
            {0, -30, -10,  20,  30,  30,  20, -10, -30},
            {0, -30, -10,  30,  40,  40,  30, -10, -30},
            {0, -30, -10,  30,  40,  40,  30, -10, -30},
            {0, -30, -10,  20,  30,  30,  20, -10, -30},
            {0, -30, -20, -10,   0,   0, -10, -20, -30},
            {0, -50, -40, -30, -20, -20, -30, -40, -50},
        };
    
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
        
        Object[] pieceList = chessBoard.getPieces().getOwnList();
        int whitePieceCount = (int) pieceList[0] + (int) pieceList[1]
                + (int) pieceList[2] + (int) pieceList[3]
                + (int) pieceList[4] + (int) pieceList[5];
        int blackPieceCount = (int) pieceList[6] + (int) pieceList[7]
                + (int) pieceList[8] + (int) pieceList[9]
                + (int) pieceList[10] + (int) pieceList[11];
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int piece = board[i][j];
                
                if (piece == 0) {
                    continue;
                }
                
                if (piece == 1) {
                    value += pawnScore;
                    value += pawnTableWhite[i][j];
                } else if (piece == 11) {
                    value -= pawnScore;
                    value -= pawnTableBlack[i][j];
                } else if (piece == 2) {
                    value += rookScore;
                    value += rookTableWhite[i][j];
                } else if (piece == 12) {
                    value -= rookScore;
                    value -= rookTableBlack[i][j];
                } else if (piece == 3) {
                    value += knightScore;
                    value += knightTableWhite[i][j];
                } else if (piece == 13) {
                    value -= knightScore;
                    value -= knightTableBlack[i][j];
                } else if (piece == 4) {
                    value += bishopScore;
                    value += bishopTableWhite[i][j];
                } else if (piece == 14) {
                    value -= bishopScore;
                    value -= bishopTableBlack[i][j];
                } else if (piece == 5) {
                    value += queenScore;
                    value += queenTableWhite[i][j];
                } else if (piece == 15) {
                    value -= queenScore;
                    value -= queenTableBlack[i][j];
                } else if (piece == 6) {
                    value += kingScore;
                    if (whitePieceCount <= 4 || blackPieceCount <= 4) {
                        value += kingEndTableWhite[i][j];
                    } else {
                        value += kingMiddleTableWhite[i][j];
                    }              
                } else if (piece == 16) {
                    value -= kingScore;
                    if (whitePieceCount <= 4 || blackPieceCount <= 4) {
                        value -= kingEndTableBlack[i][j];
                    } else {
                        value -= kingMiddleTableBlack[i][j];
                    }
                }
            }
        }
        
        
        
        return value;
    }
    
}
