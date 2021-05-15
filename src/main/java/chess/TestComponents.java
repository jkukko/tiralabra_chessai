/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import datastructureproject.GameBot;
import datastructureproject.ChessLogic;
import datastructureproject.ChessBoard;
import datastructureproject.Coordinate;
import datastructureproject.Move;
import chess.engine.GameState;
import datastructureproject.Evaluation.SimpleBoardEvaluation;
import datastructureproject.Evaluation.BonusBoardEvaluation;
import datastructureproject.Logic.ChessLogicWhite;
import java.util.ArrayList;
import java.util.List;
import datastructureproject.OwnStructures.OwnList;

/**
 *
 * @author kukkojoo
 */
public class TestComponents {
    
    public static void main(String [] args) {
        
        List<Move> moves = new ArrayList<>();
        GameBot gamebot = new GameBot(); 
        GameState gs = new GameState();
        ChessLogic logic = new ChessLogic();
        ChessBoard board = new ChessBoard();
        Move m1 = new Move("h2h4");
        Move m2 = new Move("h7h5");
        board.initBoard();
        board.printBoard();
        board.movePiece(m1);
        board.movePiece(m2);
        board.printBoard();
        Coordinate coor = new Coordinate("h1");
        moves = logic.checkRook(coor, board);
        
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(moves.get(i).getNewCoordinate().getCoordinate());
        }
        
        gs.setMoves("h2h4");
        //gamebot.parseLatestMove(gs);
        gs.setMoves("h7h5");
        //gamebot.parseLatestMove(gs);
        System.out.println(gs.getLatestMove());
        
        
        
        gamebot.nextMove(gs);
        
        int[][] table3 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 5, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        ChessBoard board2 = new ChessBoard(table3);
        ChessLogicWhite whiteLogic = new ChessLogicWhite();
        
        System.out.println(whiteLogic.checkQueenMoves(new Coordinate("d4"), board2).size()); 
        
        ChessBoard board3 = new ChessBoard();
        board3.initBoard();
        System.out.println("MOVES " + whiteLogic.legalMoves(board3).size());
        
        OwnList ownList = new OwnList();
        List<String> moveList = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            String moveText = "a" + i;
            ownList.add(moveText);
            moveList.add(moveText);
        }
        
        SimpleBoardEvaluation evaluation = new SimpleBoardEvaluation();
         
        System.out.println(evaluation.evalueation(board, 1));
        
        
        System.out.println("TESTATAAN UUSI ARVIOINTI --------");
        System.out.println("");
        System.out.println("");
        int[][] table1 = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 4, 5, 6, 4, 3, 2},
            {0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,11,11,11,11,11,11,11,11},
            {0,12,13,14,15,16,14,13,12},
        };
        ChessBoard testausta = new ChessBoard(table1);
        BonusBoardEvaluation eva = new BonusBoardEvaluation();
        System.out.println(eva.evalueation(testausta, 2));
        System.out.println(testausta.getPieces());
        
    }
    
}
