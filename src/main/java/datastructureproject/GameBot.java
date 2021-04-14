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
import datastructureproject.ChessLogic;
import datastructureproject.ChessBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBot implements ChessBot {
    private ChessBoard board;
    private List<Move> movesList;
    private ChessLogic logic;
    private Random random; 
    
    public GameBot() {
        this.board = new ChessBoard();
        this.board.initBoard();
        this.movesList = new ArrayList<>();
        this.logic = new ChessLogic();
        this.random = new Random();
    }
    
    public void printBoard() {
        this.board.printBoard();
    }

    @Override
    public String nextMove(GameState gamestate) {
        List<Move> moves = this.logic.legalMoves(this.board);
        Move mv = moves.get(this.random.nextInt(moves.size()));
        return mv.getMove();
    }
    
    // GET LEGAL MOVE
    
    
    
    // GET POSSIBLE MOVES
    
}
