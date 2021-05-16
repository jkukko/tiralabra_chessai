/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Bot;

/**
 *
 * @author kukkojoo
 */

import chess.bot.ChessBot;
import chess.engine.GameState;
import datastructureproject.Logic.ChessLogic;
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.Brain.MiniMax;
import datastructureproject.BasicElements.Move;
import datastructureproject.OwnStructures.OwnList;

public class GameBotMiniMax implements ChessBot {
    private ChessBoard board;
    private OwnList movesList;
    private ChessLogic logic;
    
    public GameBotMiniMax() {
        this.board = new ChessBoard();
        this.board.initBoard();
        this.movesList = new OwnList();
        this.logic = new ChessLogic();
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
            myMove = mm.getBestMove(board, 4, 1);
            this.board.movePiece(myMove);
            
            return myMove.getMove();
        } catch (Exception e) {
            System.out.println("Issue");
        }
        return null;
    }
    
}
