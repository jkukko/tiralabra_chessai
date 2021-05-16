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
import datastructureproject.Evaluation.MiniMax;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import datastructureproject.OwnStructures.OwnList;

public class GameBot implements ChessBot {
    private ChessBoard board;
    private OwnList movesList;
    private ChessLogic logic;
    private Random random; 
    
    public GameBot() {
        this.board = new ChessBoard();
        this.board.initBoard();
        this.movesList = new OwnList();
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
            //myMove = this.getMove(); Testin Minimax
            MiniMax mm = new MiniMax(board);
            myMove = mm.getBestMove(board, 2, 1);
            this.board.movePiece(myMove);
            
            return myMove.getMove();
        } catch (Exception e) {
            System.out.println("Issue");
        }
        return null;
    }
    
    public Move getMove() throws Exception {
        OwnList moves = new OwnList();
        
        moves = this.logic.legalMoves(this.board, 1);
        TimeUnit.SECONDS.sleep(1);
        Move mv = (Move) moves.get(this.random.nextInt(moves.size()));
        return mv;
    }

    public Move getMoveByPlayer(int player) {
        OwnList moves = new OwnList();
        moves = this.logic.legalMoves(this.board, player);
        Move mv = (Move) moves.get(this.random.nextInt(moves.size()));
        return mv;
    }
    
    // Gameboard does not know about players moves
    
    
    
    // GET LEGAL MOVE
    
    
    
    // GET POSSIBLE MOVES
    
}