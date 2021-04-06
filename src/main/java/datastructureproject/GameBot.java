/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject;

/**
 *
 * @author kukkojoo
 */

import chess.bot.ChessBot;
import chess.engine.GameState;
import datastructureproject.ChessBoard;

public class GameBot implements ChessBot {
    private ChessBoard board;
    
    public GameBot() {
        this.board = new ChessBoard();
        this.board.initBoard();
    }
    
    public void printBoard() {
        this.board.printBoard();
    }

    @Override
    public String nextMove(GameState gamestate) {
        this.board.printBoard();
        return "h7h5";
    }
    
    // GET LEGAL MOVE
    
    
    
    // GET POSSIBLE MOVES
    
}
