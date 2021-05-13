/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject;

import chess.engine.GameState;
import chess.bot.ChessBot;
import datastructureproject.ChessBoard;
import datastructureproject.Move;
import datastructureproject.Evaluation.MiniMax;
import datastructureproject.Evaluation.MiniMaxAlphaBeta;
import chess.engine.GameState;
/**
 *
 * @author kukkojoo
 */
public class GameBot2 implements ChessBot {
    private ChessBoard board;
    
    public GameBot2() {
       this.board = new ChessBoard();
       this.board.initBoard();
    }

    @Override
    public String nextMove(GameState gamestate) {
        parseLatestMove(gamestate);

        Move myMove;
        try {
            //myMove = this.getMove(); Testin Minimax
            MiniMaxAlphaBeta mmAB = new MiniMaxAlphaBeta(board);
            //MiniMax mm = new MiniMax(board);
            myMove = mmAB.getBestMove(board, 4, 1);
            this.board.movePiece(myMove);
            
            return myMove.getMove();
        } catch (Exception e) {
            System.out.println("Issue");
        }
        
        return null;
    }
    
    public void parseLatestMove(GameState gs) {
        this.board = new ChessBoard();
        this.board.initBoard();

        // We play all of the moves onto a new board to ensure a previously
        // started game can be resumed correctly, inefficient but it works
        if (!gs.moves.isEmpty()) {
            gs.moves.forEach(moveString -> {
                Move m = new Move(moveString);
                this.board.movePiece(m);
            });
        }
    }    
    
}
