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
                int piece = board.getBoard()[i][j];
                if (piece == 1) {
                    possibleMoves = checkPawnMoves(coor, board);
                } else if (piece == 2) {
                    possibleMoves = checkRook(coor, board);
                }
                moves.addAll(possibleMoves);
            }
        }
        
        return moves;
    }
   
    public List<Move> checkPawnMoves(Coordinate coor, ChessBoard board) {
        int piece = board.getBoard()[coor.getY()][coor.getX()];
        List<Move> moves = new ArrayList<>();
        if (piece == 1) {
            
            if (coor.getY() == 8) {
                return moves;
            }
            
           
            if (coor.getX() < 8) {
                int possiblePlace = board.getBoard()[coor.getY() + 1][coor.getX() + 1];
                if (possiblePlace != 0 && possiblePlace >= 11 && coor.getY() < 8) {
                   Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() + 1);
                   Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                   Move move = new Move(oldCoordinate, newCoordinate);
                   moves.add(move);
                }                
            }
            
            if (coor.getX() > 1) {
                int possiblePlace = board.getBoard()[coor.getY() + 1][coor.getX() - 1];
                if (possiblePlace != 0 && possiblePlace >= 11) {
                   Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() + 1);
                   Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                   Move move = new Move(oldCoordinate, newCoordinate);
                   moves.add(move);
                }
            }
            
            if (coor.getY() < 8) {
                if (board.getBoard()[coor.getY() + 1][coor.getX()] == 0) {
                   Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 1);
                   Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                   Move move = new Move(oldCoordinate, newCoordinate);
                   moves.add(move);
                }                
            }

            if (coor.getY() == 2) {
                if (board.getBoard()[coor.getY() + 2][coor.getX()] == 0 && board.getBoard()[coor.getY() + 1][coor.getX()] == 0) {
                    Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);
                }                           
            }
            
        }
       
        return moves;
    }
    
    private List<Move> checkKnight(Coordinate coor, ChessBoard board) {
       int piece = board.getBoard()[coor.getY()][coor.getX()];
       List<Move> moves = new ArrayList<>();
       
       
       return moves;
    }

    public List<Move> checkRook(Coordinate coor, ChessBoard board) {
       int piece = board.getBoard()[coor.getY()][coor.getX()];
       List<Move> moves = new ArrayList<>();
       
       if (piece == 2) {
           int earlier = 0;
           
           // Rook moves upwards
           for (int i = coor.getY()+1; i < 9; i++) {
               earlier = board.getBoard()[i][coor.getX()];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }

                Coordinate newCoordinate = new Coordinate(coor.getX(), i);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);
                
                if (earlier >= 11) {
                    break;
                }     
           }
           
           // Rook moves downwards
           for (int i = coor.getY()-1; i > 0; i--) {
               earlier = board.getBoard()[i][coor.getX()];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }

                Coordinate newCoordinate = new Coordinate(coor.getX(), i);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);
                
                if (earlier >= 11) {
                    break;
                }     
           }           
           
           // Rook moves to right
           earlier = 0;
           for (int i = coor.getX()+1; i < 9; i++) {
               earlier = board.getBoard()[coor.getY()][i];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }
                
                Coordinate newCoordinate = new Coordinate(i, coor.getY());
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);

                if (earlier >= 11) {
                    break;
                }
           }

           // Rook moves to left
           earlier = 0;
           for (int i = coor.getX()-1; i > 0; i--) {
               earlier = board.getBoard()[coor.getY()][i];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }
                
                Coordinate newCoordinate = new Coordinate(i, coor.getY());
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);

                if (earlier >= 11) {
                    break;
                }
           }           

       }
       
       return moves;
    }

    
}
