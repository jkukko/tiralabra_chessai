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
import java.util.ArrayList;
import java.util.List;

public class GameBot implements ChessBot {
    private ChessBoard board;
    private int counter;
    private List<String> movesList;
    
    public GameBot() {
        this.board = new ChessBoard();
        this.board.initBoard();
        this.counter = -1;
        this.movesList = new ArrayList<>();
        this.movesList.add("a7a6");
        this.movesList.add("b7b6");
        this.movesList.add("c7c6");
        this.movesList.add("d7d6");
        this.movesList.add("e7e6");
        this.movesList.add("f7f6");
    }
    
    public void printBoard() {
        this.board.printBoard();
    }

    @Override
    public String nextMove(GameState gamestate) {
        this.counter += 1;
        return this.movesList.get(counter);
    }
    
    // GET LEGAL MOVE
    
    
    
    // GET POSSIBLE MOVES
    
}
