/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Logic;
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.OwnStructures.OwnList;

/**
 *
 * @author kukkojoo
 */
public class ChessLogic {
    
    /**
     * Returns a list of legal moves in certain chessboard and for specific player
     * @param board a chessboard
     * @param player a player
     * @return list of legal moves
     */
    
    public OwnList legalMoves(ChessBoard board, int player) {
        
        if (player == 1) {
            ChessLogicWhite w = new ChessLogicWhite();
            return w.legalMoves(board);
        } else {
            ChessLogicBlack b = new ChessLogicBlack();
            return b.legalMoves(board);
        }
    } 
}
