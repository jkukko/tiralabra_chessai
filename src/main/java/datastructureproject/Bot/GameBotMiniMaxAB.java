/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Bot;

import chess.bot.ChessBot;
import datastructureproject.Brain.MiniMaxAlphaBeta;
import chess.engine.GameState;
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.BasicElements.Move;
/**
 *
 * @author kukkojoo
 */
public class GameBotMiniMaxAB implements ChessBot {
    private ChessBoard board;
    private int player;
    
    public GameBotMiniMaxAB(int player) {
        this.board = new ChessBoard();
        this.board.initBoard();
        this.player = player;
    }

    @Override
    public String nextMove(GameState gamestate) {
        parseLatestMove(gamestate);

        Move myMove;
        try {
            //myMove = this.getMove(); Testin Minimax
            MiniMaxAlphaBeta mmAB = new MiniMaxAlphaBeta(board);
            //MiniMax mm = new MiniMax(board);
            myMove = mmAB.getBestMove(board, 4, player);
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
