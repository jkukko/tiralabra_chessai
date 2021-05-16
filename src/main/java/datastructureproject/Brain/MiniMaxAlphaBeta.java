/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Brain;

import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.Logic.ChessLogic;
import datastructureproject.BasicElements.Move;
import datastructureproject.Evaluation.BonusBoardEvaluation;
import datastructureproject.OwnStructures.OwnList;

/**
 *
 * @author kukkojoo
 */
public class MiniMaxAlphaBeta {

    private ChessLogic logic;
    private BonusBoardEvaluation evaluation;
    private ChessBoard orginalBoard;
    private int count;
    
    public MiniMaxAlphaBeta(ChessBoard board) {
        this.logic = new ChessLogic();
        this.evaluation = new BonusBoardEvaluation();
        this.orginalBoard = board;
        this.count = 0;    
    }
    
    /**
     * Return best move for player in specific chessboard situation
     * @param board chessboard at the current situation
     * @param depth how many moves ahead is calculated
     * @param player current player
     * @return best available move
     */
    
    public Move getBestMove(ChessBoard board, int depth, int player) {
        OwnList moves = this.logic.legalMoves(board, player);
        ChessBoard testBoard = new ChessBoard();
        testBoard.setBoard(board);
        Move bestMove = null;
        
        int minValue = 99999;
        int maxValue = -99999;
        int value;

        for (int i = 0; i < moves.size(); i++) {
            Move move = (Move) moves.get(i);
            int eaten = testBoard.movePieceAndGetNewPositionValue(move);
            count++;
            if (player == 1) {
                value = max(testBoard, (depth - 1), maxValue, minValue);
            } else {
                value = min(testBoard, (depth - 1), maxValue, minValue);
            }
            
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
     * Returns max value of specific chessboard situation 
     * @param board chessboard in specific situation
     * @param depth how many moves calculated ahead
     * @param alpha current biggest value
     * @param beta current smallest value
     * @return biggest value/score
     */

    private int max(ChessBoard board, int depth, int alpha, int beta) {

        if (depth == 0) {
            count++;
            return evaluation.evalueation(board, 1);
        }
        
        OwnList moves = this.logic.legalMoves(board, 2);
        
        int maxValue = -99999;
        
        for (int i = 0; i < moves.size(); i++) {
            Move move = (Move) moves.get(i);
            int eaten = board.movePieceAndGetNewPositionValue(move);
            int otherSideScore = min(board, (depth - 1), alpha, beta);
            board.undoMoveWithOldValue(move, eaten);
            if (otherSideScore > maxValue) {
                maxValue = otherSideScore;
            }
            if (otherSideScore > beta) {
                return maxValue;
            }
            if (maxValue > alpha) {
                alpha = maxValue;
            }
        }
        
        return maxValue;
        
    }
    
    /**
     * Returns min value of specific chessboard situation
     * @param board chessboard in specific situation
     * @param depth how many moves calculated ahead
     * @param alpha current biggest value
     * @param beta current smallest value
     * @return smalles value/score
     */

    private int min(ChessBoard board, int depth, int alpha, int beta) {

        if (depth == 0) {
            count++;
            return evaluation.evalueation(board, 2);
        }
        
        OwnList moves = this.logic.legalMoves(board, 1);
        
        int minValue = 99999;
        
        for (int i = 0; i < moves.size(); i++) {
            Move move = (Move) moves.get(i);
            int eaten = board.movePieceAndGetNewPositionValue(move);
            int otherSideScore = max(board, (depth - 1), alpha, beta);
            board.undoMoveWithOldValue(move, eaten);
            if (otherSideScore < minValue) {
                minValue = otherSideScore;
            }
            if (minValue < alpha) {
                return minValue;
            }
            if (minValue < beta) {
                beta = minValue;
            }
        }
        
        return minValue;       
    }
    
    public int getCount() {
        return this.count;
    }
    
}
