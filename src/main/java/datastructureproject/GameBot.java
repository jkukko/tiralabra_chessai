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
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
        
        try {
            String move = gamestate.getLatestMove();
            if (move != null) {
                Move mv = new Move(move);
                this.board.movePiece(mv);
            }
        } catch (Exception e) {
            
        }
        
        Move myMove;
        try {
            myMove = this.getMove();
            this.board.movePiece(myMove);
            
            return myMove.getMove();
        } catch (Exception e) {
            System.out.println("Issue");
        }
        return null;
    }
    
    public Move getMove() throws Exception {
        List<Move> moves = new ArrayList<>();
        
        moves = this.logic.legalMoves(this.board, 1);
        TimeUnit.SECONDS.sleep(1);
        Move mv = moves.get(this.random.nextInt(moves.size()));
        return mv;
    }

    public Move getMoveByPlayer(int player) {
        List<Move> moves = new ArrayList<>();
        moves = this.logic.legalMoves(this.board, player);
        Move mv = moves.get(this.random.nextInt(moves.size()));
        return mv;
    }
    
    // Gameboard does not know about players moves
    
    
    
    // GET LEGAL MOVE
    
    
    
    // GET POSSIBLE MOVES
    
}
