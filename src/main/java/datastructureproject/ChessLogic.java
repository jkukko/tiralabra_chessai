/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject;

import datastructureproject.Move;
import datastructureproject.ChessBoard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kukkojoo
 */
public class ChessLogic {
    
    
    public List<Move> legalMoves(ChessBoard board) {
        List<Move> moves = new ArrayList<>();
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                List<Move> possibleMoves = new ArrayList<>();
                Coordinate coor = new Coordinate(j, i);
                possibleMoves = checkPawnMoves(coor, board);
                moves.addAll(possibleMoves);
            }
        }
        
        return moves;
    }
   
    public List<Move> checkPawnMoves(Coordinate coor, ChessBoard board) {
        String piece = board.getBoard()[coor.getY()][coor.getX()];
        List<Move> moves = new ArrayList<>();
        if (piece.equals("p")) {
            
            if (coor.getY() == 8) {
                return moves;
            }
            
            
            if (coor.getX() < 8) {
                if (!board.getBoard()[coor.getY() + 1][coor.getX() + 1].equals("x") && coor.getY() < 8) {
                   Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() + 1);
                   Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                   Move move = new Move(oldCoordinate, newCoordinate);
                   moves.add(move);
                }                
            }
            
            if (coor.getX() > 1) {
                if (!board.getBoard()[coor.getY() + 1][coor.getX() - 1].equals("x")) {
                   Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() + 1);
                   Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                   Move move = new Move(oldCoordinate, newCoordinate);
                   moves.add(move);
                }
            }
          
            if (coor.getY() == 2) {
                if (board.getBoard()[coor.getY() + 2][coor.getX()].equals("x")) {
                    Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);
                }                           
            }
            
            if (coor.getY() < 8) {
                if (board.getBoard()[coor.getY() + 1][coor.getX()].equals("x")) {
                   Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 1);
                   Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                   Move move = new Move(oldCoordinate, newCoordinate);
                   moves.add(move);
                }                
            }
        }
       
        return moves;
    } 
    
}
