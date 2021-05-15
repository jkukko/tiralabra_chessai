/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;

import datastructureproject.ChessBoard;
import datastructureproject.ChessLogic;
import datastructureproject.Move;
import java.util.List;
import datastructureproject.OwnStructures.OwnList;


/**
 *
 * @author kukkojoo
 */
public class MiniMax {
    
    private ChessLogic logic;
    private BonusBoardEvaluation evaluation;
    private ChessBoard orginalBoard;
    private int count;
    
    public MiniMax(ChessBoard board) {
        this.logic = new ChessLogic();
        this.evaluation = new BonusBoardEvaluation();
        this.orginalBoard = board;
        this.count = 0;
    }
    
    /**
     * Returns best move for player in specific chessboard 
     * @param board given chessboard
     * @param depth move many moves ahead is calculated
     * @param player for which player best move is given
     * @return best move
     */
    
    public Move getBestMove(ChessBoard board, int depth, int player) {
        OwnList moves = this.logic.legalMoves(board, player);
        ChessBoard testBoard = new ChessBoard();
        //testBoard.initBoard();
        testBoard.setBoard(board);
        Move bestMove = null;
        
        int minValue = 99999;
        int maxValue = -99999;
        int value;
     
        for (int i = 0; i < moves.size(); i++) {
            Move move = (Move) moves.get(i);
            int eaten = testBoard.movePieceAndGetNewPositionValue(move);
            
            if (player == 1) {
                value = max(testBoard, (depth - 1));
            } else {
                value = min(testBoard, (depth - 1));
            }
            
            System.out.println(move.getOldCoordinate().getCoordinate() + move.getNewCoordinate().getCoordinate() + ": " + value + " " + eaten);
            testBoard.undoMoveWithOldValue(move, eaten);
            
            if (player == 1 && value >= maxValue) {
                maxValue = value;
                bestMove = move;
            } else if (player == 2 && value <= minValue) {
                minValue = value;
                bestMove = move;                
            }
            
        }
        
        
        return bestMove;
    }

    
    /**
     * Returns max value of specific chessboard that can be achieved
     * @param board specific chessboard
     * @param depth how many moves forward
     * @return biggest value
     */

    private int max(ChessBoard board, int depth) {
        
        if (depth == 0) {
            count++;
            return evaluation.evalueation(board, 1);
        }
        
        OwnList moves = this.logic.legalMoves(board, 2);
        
        int maxValue = -99999;
        
        for (int i = 0; i < moves.size(); i++) {
            Move move = (Move) moves.get(i);
            //board.movePiece(move);
            //System.out.println(move.getMove());
            int eaten = board.movePieceAndGetNewPositionValue(move);
            int otherSideScore = min(board, (depth - 1));
            //board.undoMove(move);
            board.undoMoveWithOldValue(move, eaten);
            if(otherSideScore > maxValue) {
                maxValue = otherSideScore;
            }
            
        }
        
        //System.out.println(maxValue);
        
        return maxValue;
    }
    
    /**
     * Returns min value of specific chessboard that can be achieved
     * @param board specific chessboard
     * @param depth how many moves forward
     * @return smallest value
     */

    private int min(ChessBoard board, int depth) {
        
        if (depth == 0) {
            count++;
            return evaluation.evalueation(board, 2);
        }
        
        OwnList moves = this.logic.legalMoves(board, 1);
        
        int minValue = 99999;
        
        for (int i = 0; i < moves.size(); i++) {
            Move move = (Move) moves.get(i);
            //board.movePiece(move);
            int eaten = board.movePieceAndGetNewPositionValue(move);
            int otherSideScore = max(board, (depth - 1));
            //board.undoMove(move);
            board.undoMoveWithOldValue(move, eaten);
            if (otherSideScore < minValue) {
                minValue = otherSideScore;
            }
        }
        
        //System.out.println("MIN VALUE: " + minValue);
        return minValue;
    }
    
    public int getCount() {
        return this.count;
    }
    
}
