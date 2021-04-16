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
                } else if (piece == 4) {
                    possibleMoves = checkBishop(coor, board);
                } else if (piece == 3) {
                    possibleMoves = checkKnight(coor, board);
                } else if (piece == 5) {
                    possibleMoves = checkQueen(coor, board);
                } else if (piece == 6) {
                    possibleMoves = checkKing(coor, board);
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
       
       if (piece == 3) {
           
            if ((coor.getX() + 2 < 9) && (coor.getY() + 1 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() + 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX()+2, coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }
                        
            if ((coor.getX() + 1 < 9) && (coor.getY() + 2 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 2][coor.getX() + 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }

            if ((coor.getX() + 1 < 9) && (coor.getY() - 2 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 2][coor.getX() + 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() - 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }            

            if ((coor.getX() + 2 < 9) && (coor.getY() - 1 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() + 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 2, coor.getY() - 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }            

            // This is for help
            
            if ((coor.getX() - 2 > 0) && (coor.getY() + 1 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() - 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 2, coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }
                        
            if ((coor.getX() - 1 > 0) && (coor.getY() + 2 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 2][coor.getX() - 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }

            if ((coor.getX() - 1 < 9) && (coor.getY() - 2 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 2][coor.getX() - 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() - 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }            

            if ((coor.getX() - 2 < 9) && (coor.getY() - 1 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() - 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 2, coor.getY() - 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    moves.add(move);                    
                }
            }                       
       
       }
       
       
       return moves;
    }

    public List<Move> checkRook(Coordinate coor, ChessBoard board) {
       int piece = board.getBoard()[coor.getY()][coor.getX()];
       List<Move> moves = new ArrayList<>();
       
       if (piece == 2 || piece == 5) {
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
    
    public List<Move> checkBishop(Coordinate coor, ChessBoard board) {
       int piece = board.getBoard()[coor.getY()][coor.getX()];
       List<Move> moves = new ArrayList<>();
       
       if (piece == 4 || piece == 5) {
           
            int earlier = 0;
            int xCoor = coor.getX() + 1;
            for (int i = coor.getY() + 1; i < 9; i++) {
                earlier = board.getBoard()[i][xCoor];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }
                
                Coordinate newCoordinate = new Coordinate(xCoor, i);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);

                if (earlier >= 11) {
                    break;
                }
                
                xCoor +=1;
                
                if (xCoor == 9) {
                   break;
                }
           }
           
           earlier = 0;
           xCoor = coor.getX() - 1;
           for (int i = coor.getY() + 1; i < 9; i++) {
               earlier = board.getBoard()[i][xCoor];
               
               if ((earlier > 0 && earlier < 7)) {
                   break;
               }
               

               
                Coordinate newCoordinate = new Coordinate(xCoor, i);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);

                if (earlier >= 11) {
                    break;
                }
                
                xCoor -=1;
                
                if (xCoor == 0) {
                   break;
                }
            }

            earlier = 0;
            xCoor = coor.getX() + 1;
            for (int i = coor.getY() - 1; i > 0; i--) {
                earlier = board.getBoard()[i][xCoor];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }
                
                Coordinate newCoordinate = new Coordinate(xCoor, i);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);

                if (earlier >= 11) {
                    break;
                }
                
                xCoor +=1;
                
                if (xCoor == 9) {
                   break;
                }
            }           

            earlier = 0;
            xCoor = coor.getX() - 1;
            for (int i = coor.getY() - 1; i > 0; i--) {
                earlier = board.getBoard()[i][xCoor];
               
                if ((earlier > 0 && earlier < 7)) {
                   break;
                }
                
                Coordinate newCoordinate = new Coordinate(xCoor, i);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);

                if (earlier >= 11) {
                    break;
                }
                
                xCoor -=1;
                
                if (xCoor == 0) {
                   break;
                }
           }            
            
       }
       
       return moves;
    }
    
    public List<Move> checkQueen(Coordinate coor, ChessBoard board) {
        int piece = board.getBoard()[coor.getY()][coor.getX()];
        List<Move> moves = new ArrayList<>();
        List<Move> possibleMoves = new ArrayList<>();
        
        possibleMoves = checkBishop(coor, board);
        possibleMoves.addAll(checkRook(coor, board));
        moves.addAll(possibleMoves);
       
       return moves;
    }
    
    public List<Move> checkKing(Coordinate coor, ChessBoard board) {
        int piece = board.getBoard()[coor.getY()][coor.getX()];
        List<Move> moves = new ArrayList<>();
        
        if (coor.getY() < 8) {
            int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX()];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 1);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);
            }
        }

        if (coor.getY() > 0) {
            int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX()];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() - 1);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);
            }
        }
        
        if (coor.getX() < 8) {
            int possiblePosition = board.getBoard()[coor.getY()][coor.getX() + 1];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY());
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);
            }
        }

        if (coor.getX() > 0) {
            int possiblePosition = board.getBoard()[coor.getY()][coor.getX() - 1];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY());
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                moves.add(move);
            }
        }        
        return moves;
    }

    
}
