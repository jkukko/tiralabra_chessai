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


/**
 *
 * @author kukkojoo
 */
public class MiniMax {
    
    private ChessLogic logic;
    private SimpleBoardEvaluation evaluation;
    private ChessBoard orginalBoard;
    
    public MiniMax(ChessBoard board) {
        this.logic = new ChessLogic();
        this.evaluation = new SimpleBoardEvaluation();
        this.orginalBoard = board;
    }
    
    public Move getBestMove(ChessBoard board, int depth, int player) {
        List<Move> moves = this.logic.legalMoves(board, 1);
        ChessBoard testBoard = new ChessBoard();
        testBoard.initBoard();
        testBoard.setBoard(board);
        Move bestMove = null;
        
        int minValue = -99999;
        int maxValue = 99999;
        int value;
        
        for (Move move: moves) {
            int eaten = testBoard.movePieceAndGetNewPositionValue(move);
            
            if (player == 1) {
                value = max(testBoard, (depth - 1));
            } else {
                value = min(testBoard, (depth - 1));
            }
            
            System.out.println(move.getOldCoordinate().getCoordinate() + move.getNewCoordinate().getCoordinate() + ": " + value + " " + eaten);
            testBoard.undoMoveWithOldValue(move, eaten);
            
            if (player == 1 && value <= maxValue) {
                maxValue = value;
                bestMove = move;
            } else if (player == 2 && value >= minValue) {
                minValue = value;
                bestMove = move;                
            }
            
        }
        
        
        return bestMove;
    }

    private boolean whiteTurn() {
        return true;
    }

    private int max(ChessBoard board, int depth) {
        
        if (depth == 0) {
            return evaluation.evalueation(board, 1);
        }
        
        List<Move> moves = this.logic.legalMoves(board, 1);
        
        int maxValue = -99999;
        
        for (Move move: moves) {
            //board.movePiece(move);
            int eaten = board.movePieceAndGetNewPositionValue(move);
            int otherSideScore = min(board, (depth - 1));
            //board.undoMove(move);
            board.undoMoveWithOldValue(move, eaten);
            if(otherSideScore >= maxValue) {
                maxValue = otherSideScore;
            }
            
        }
        
        return maxValue;
    }

    private int min(ChessBoard board, int depth) {
        
        if (depth == 0) {
            return evaluation.evalueation(board, 2);
        }
        
        List<Move> moves = this.logic.legalMoves(board, 1);
        
        int minValue = 99999;
        
        for (Move move: moves) {
            //board.movePiece(move);
            int eaten = board.movePieceAndGetNewPositionValue(move);
            int otherSideScore = max(board, (depth - 1));
            //board.undoMove(move);
            board.undoMoveWithOldValue(move, eaten);
            if (otherSideScore <= minValue) {
                minValue = otherSideScore;
            }
        }
        
        //System.out.println("MIN VALUE: " + minValue);
        
        return minValue;
    }
    
    
    
}
