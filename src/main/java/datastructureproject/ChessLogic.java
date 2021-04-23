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
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }
                    
                }                
            }
            
            if (coor.getX() > 1) {
                int possiblePlace = board.getBoard()[coor.getY() + 1][coor.getX() - 1];
                if (possiblePlace != 0 && possiblePlace >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }
                    
                }
            }
            
            if (coor.getY() < 8) {
                if (board.getBoard()[coor.getY() + 1][coor.getX()] == 0) {
                    Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }
                    
                }                
            }

            if (coor.getY() == 2) {
                if (board.getBoard()[coor.getY() + 2][coor.getX()] == 0 && board.getBoard()[coor.getY() + 1][coor.getX()] == 0) {
                    Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }
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
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                   
                }
            }
                        
            if ((coor.getX() + 1 < 9) && (coor.getY() + 2 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 2][coor.getX() + 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                  
                }
            }

            if ((coor.getX() + 1 < 9) && (coor.getY() - 2 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 2][coor.getX() + 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() - 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                    
                }
            }            

            if ((coor.getX() + 2 < 9) && (coor.getY() - 1 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() + 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 2, coor.getY() - 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                   
                }
            }            

            // This is for help
            
            if ((coor.getX() - 2 > 0) && (coor.getY() + 1 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() - 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 2, coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                   
                }
            }
                        
            if ((coor.getX() - 1 > 0) && (coor.getY() + 2 < 9)) {
                int possiblePosition = board.getBoard()[coor.getY() + 2][coor.getX() - 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() + 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                    
                }
            }

            if ((coor.getX() - 1 < 9) && (coor.getY() - 2 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 2][coor.getX() - 1];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() - 2);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                  
                }
            }            

            if ((coor.getX() - 2 < 9) && (coor.getY() - 1 > 0)) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() - 2];
                if(possiblePosition == 0 || possiblePosition >= 11) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 2, coor.getY() - 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                        moves.add(move);
                    }                   
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
                if (checkMate(move, board)) {
                    moves.add(move);
                }
                
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
                if (checkMate(move, board)) {
                    moves.add(move);
                }
                
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
                if (checkMate(move, board)) {
                    moves.add(move);
                }

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
                if (checkMate(move, board)) {
                    moves.add(move);
                }

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
                if (checkMate(move, board)) {
                    moves.add(move);
                }

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
                if (checkMate(move, board)) {
                    moves.add(move);
                }

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
                if (checkMate(move, board)) {
                    moves.add(move);
                }

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
                if (checkMate(move, board)) {
                    moves.add(move);
                }

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
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }

        if (coor.getY() > 1) {
            int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX()];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX(), coor.getY() - 1);
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }
        
        if (coor.getX() < 8) {
            int possiblePosition = board.getBoard()[coor.getY()][coor.getX() + 1];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY());
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }

        if (coor.getX() > 1) {
            int possiblePosition = board.getBoard()[coor.getY()][coor.getX() - 1];
            if ((possiblePosition == 0) || (possiblePosition > 10)) {
                Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY());
                Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                Move move = new Move(oldCoordinate, newCoordinate);
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }
        
        if (coor.getY() > 1) {
            
            if (coor.getX() > 1) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() - 1];
                if ((possiblePosition == 0) || (possiblePosition > 10)) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() - 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }

            if (coor.getX() < 8) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() + 1];
                if ((possiblePosition == 0) || (possiblePosition > 10)) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() - 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }
        }
        
        if (coor.getY() < 8) {
            
            if (coor.getX() > 1) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() - 1];
                if ((possiblePosition == 0) || (possiblePosition > 10)) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() - 1, coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }

            if (coor.getX() < 8) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() + 1];
                if ((possiblePosition == 0) || (possiblePosition > 10)) {
                    Coordinate newCoordinate = new Coordinate(coor.getX() + 1, coor.getY() + 1);
                    Coordinate oldCoordinate = new Coordinate(coor.getX(), coor.getY());
                    Move move = new Move(oldCoordinate, newCoordinate);
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }
        }
        
        return moves;
    }
    
    public boolean checkMate(Move move, ChessBoard board) {
        Coordinate coorOld = move.getOldCoordinate();
        Coordinate coorNew = move.getNewCoordinate();
        int piece = board.getBoard()[coorOld.getY()][coorOld.getX()];
        
        if (piece == 6) {
            
            // Check Pawn attack x+1
            if (coorNew.getX() < 8) {
                if (board.getBoard()[coorNew.getY()+1][coorNew.getX()+1] == 11) {
                    return false;
                }                
            }
            
            // Check Pawn attack x-1
            if (coorNew.getX() > 0) {
                if (board.getBoard()[coorNew.getY()+1][coorNew.getX()-1] == 11) {
                    return false;
                }                
            }            
            
            // Check knigh attack y+2 x+1
            if (coorOld.getY() < 6 && coorOld.getX() < 7) {
                if (board.getBoard()[coorNew.getY()+2][coorNew.getX()+1] == 13) {
                    return false;
                }
            }

            // Check knigh attack y+2 x-1
            if (coorOld.getY() < 6 && coorOld.getX() > 1) {
                if (board.getBoard()[coorNew.getY()+2][coorNew.getX()-1] == 13) {
                    return false;
                }
            }
            
            // Check knigh attack y-2 x+1
            if (coorOld.getY() > 2 && coorOld.getX() < 7) {
                if (board.getBoard()[coorNew.getY()-2][coorNew.getX()+1] == 13) {
                    return false;
                }
            }

            // Check knigh attack y-2 x-1
            if (coorOld.getY() > 2 && coorOld.getX() > 1) {
                if (board.getBoard()[coorNew.getY()-2][coorNew.getX()-1] == 13) {
                    return false;
                }
            }
            
            // Check knight attact y+1 x+2   
            if (coorOld.getY() < 7 && coorOld.getX() < 6) {
                if (board.getBoard()[coorNew.getY()+1][coorNew.getX()+2] == 13) {
                    return false;
                }
            }
            
            // Check knight attact y-1 x+2
            if (coorOld.getY() > 1 && coorOld.getX() < 6) {
                if (board.getBoard()[coorNew.getY()-1][coorNew.getX()+2] == 13) {
                    return false;
                }
            }

            
            
            // Check knight attact y+1 x-2   
            if (coorOld.getY() < 7 && coorOld.getX() > 2) {
                if (board.getBoard()[coorNew.getY()+1][coorNew.getX()-2] == 13) {
                    return false;
                }
            }
            
            // Check knight attact y-1 x-2
            if (coorOld.getY() > 1 && coorOld.getX() > 2) {
                if (board.getBoard()[coorNew.getY()-1][coorNew.getX()-2] == 13) {
                    return false;
                }
            }            
                
            
            // check Rook and queen Rook attack right
            for (int i = coorNew.getX(); i < 9; i++) {
                int possiblePosition = board.getBoard()[coorNew.getY()][i];
                if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                    break;
                }
                
                if (possiblePosition == 12 || possiblePosition == 15) {
                    return false;
                }
            }

            // check Rook and queen Rook attack left
            for (int i = coorNew.getX(); i > 0; i--) {
                int possiblePosition = board.getBoard()[coorNew.getY()][i];
                if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                    break;
                }
                
                if (possiblePosition == 12 || possiblePosition == 15) {
                    return false;
                }
            }            
            
            // check Rook and queen Rook attack up
            for (int i = coorNew.getY(); i < 9; i++) {
                int possiblePosition = board.getBoard()[i][coorNew.getX()];
                if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                    break;
                }
                
                if (possiblePosition == 12 || possiblePosition == 15) {
                    return false;
                }
            }
            
            // check Rook and queen Rook attack down
            for (int i = coorNew.getY(); i > 0; i--) {
                int possiblePosition = board.getBoard()[i][coorNew.getX()];
                if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                    break;
                }
                
                if (possiblePosition == 12 || possiblePosition == 15) {
                    return false;
                }
            }
            
            // check bishop and quuen bishop attack right-up
            for (int i = 1; i < 8; i++) {
                int x = coorNew.getX() + i;
                int y = coorNew.getY() + i;  
                if (x == 9 || y == 9) {
                    break;
                }
                int possiblePosition = board.getBoard()[y][x];
                if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                    break;
                }
                if (possiblePosition == 14 || possiblePosition == 15) {
                    return false;
                }                    
            }
            
            // check bishop and quuen bishop attack right-down
            for (int i = 1; i < 8; i++) {
                int x = coorNew.getX() + i;
                int y = coorNew.getY() - i;              
                if (x == 9 || y == 0) {
                    break;
                }
                int possiblePosition = board.getBoard()[y][x];
                if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                    break;
                }
                if (possiblePosition == 14 || possiblePosition == 15) {
                    return false;
                }                    
            }

            // check bishop and quuen bishop attack left-up
            for (int i = 1; i < 8; i++) {
                int x = coorNew.getX() - i;
                int y = coorNew.getY() + i;              
                if (x == 0 || y == 9) {
                    break;
                }
                int possiblePosition = board.getBoard()[y][x];
                if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                    break;
                }
                if (possiblePosition == 14 || possiblePosition == 15) {
                    return false;
                }                    
            }            

            // check bishop and quuen bishop attack left-down
            for (int i = 1; i < 8; i++) {
                int x = coorNew.getX() - i;
                int y = coorNew.getY() - i;              
                if (x == 0 || y == 0) {
                    break;
                }
                int possiblePosition = board.getBoard()[y][x];
                if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                    break;
                }
                if (possiblePosition == 14 || possiblePosition == 15) {
                    return false;
                }                    
            }            
        }
        
        if (piece < 10) {    
            ChessBoard newBoard = new ChessBoard();
            newBoard.initBoard();
            newBoard.setBoard(board);
            newBoard.movePiece(move);
            return checkMove(newBoard, board);
                        
        }
   
        return true;
    }
    
    public boolean checkMove(ChessBoard board, ChessBoard originalBoard) {
        
        int xKing = 1;
        int yKing = 5;

        for (int i = 1; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                if (board.getBoard()[i][j] == 6) {
                    xKing = j;
                    yKing = i;
                    break;
                }
            }
        }
        
        // Check Pawn attack
        if (xKing < 8) {
            if (board.getBoard()[yKing+1][xKing+1] == 11) {
                return false;
            }
        }
        if (xKing > 0) {
            if (board.getBoard()[yKing-1][xKing+1] == 11) {
                return false;
            }
        }
        
        // check Rook and queen Rook attack right
        for (int i = xKing+1; i < 9; i++) {
            int possiblePosition = board.getBoard()[yKing][i];
            if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 12 || possiblePosition == 15) {
                return false;
            }            
        }
        
        // check Rook and queen Rook attack left
        for (int i = xKing+1; i > 0; i--) {
            int possiblePosition = board.getBoard()[yKing][i];
            if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 12 || possiblePosition == 15) {
                return false;
            }            
        }

        // check Rook and queen Rook attack up
        for (int i = yKing+1; i < 9; i++) {
            int possiblePosition = board.getBoard()[i][xKing];
            if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 12 || possiblePosition == 15) {
                return false;
            }            
        }        
        
        // check Rook and queen Rook attack down
        for (int i = yKing+1; i > 0; i--) {
            int possiblePosition = board.getBoard()[i][xKing];
            if (possiblePosition != 0 && possiblePosition != 12 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 12 || possiblePosition == 15) {
                return false;
            }            
        }
        
        // check Knight attact y+2 x+1
        if (yKing < 6 && xKing < 7) {
            if (board.getBoard()[yKing + 2][xKing + 1] == 13) {
                return false;
            }
        }
        
        // check Knight attact y+2 x-1
        if (yKing < 6 && xKing > 1) {
            if (board.getBoard()[yKing + 2][xKing - 1] == 13) {
                return false;
            }
        }

        // check Knight attact y-2 x+1
        if (yKing > 2 && xKing < 7) {
            if (board.getBoard()[yKing - 2][xKing + 1] == 13) {
                return false;
            }
        }        

        // check Knight attact y-2 x-1
        if (yKing > 2 && xKing > 1) {
            if (board.getBoard()[yKing - 2][xKing - 1] == 13) {
                return false;
            }
        }        

        // check Knight attact y+1 x+2
        if (yKing < 7 && xKing < 6) {
            if (board.getBoard()[yKing + 1][xKing + 2] == 13) {
                return false;
            }
        }

        // check Knight attact y-1 x+2
        if (yKing > 1 && xKing < 6) {
            if (board.getBoard()[yKing - 1][xKing + 2] == 13) {
                return false;
            }
        }


        // check Knight attact y+1 x-2
        if (yKing < 7 && xKing > 2) {
            if (board.getBoard()[yKing + 1][xKing - 2] == 13) {
                return false;
            }
        }

        // check Knight attact y-1 x-2
        if (yKing > 1 && xKing > 2) {
            if (board.getBoard()[yKing - 1][xKing - 2] == 13) {
                return false;
            }
        }
        
        // check bishop and quuen bishop attack right-up
        for (int i = 1; i < 8; i++) {
            int x = xKing + i;
            int y = yKing + i;  
            if (x == 9 || y == 9) {
                break;
            }
            int possiblePosition = board.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 14 || possiblePosition == 15) {
                return false;
            }                    
        }
                    
        // check bishop and quuen bishop attack right-down
        for (int i = 1; i < 8; i++) {
            int x = xKing + i;
            int y = yKing - i;              
            if (x == 9 || y == 0) {
                break;
            }
            int possiblePosition = board.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 14 || possiblePosition == 15) {
                return false;
            }                    
        }

        // check bishop and quuen bishop attack left-up
        for (int i = 1; i < 8; i++) {
            int x = xKing - i;
            int y = yKing + i;              
            if (x == 0 || y == 9) {
                break;
            }
            int possiblePosition = board.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 14 || possiblePosition == 15) {
                return false;
            }                    
        } 
        
        // check bishop and quuen bishop attack left-down
        for (int i = 1; i < 8; i++) {
            int x = xKing - i;
            int y = yKing - i;              
            if (x == 0 || y == 0) {
                break;
            }
            int possiblePosition = board.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 14 && possiblePosition != 15) {
                break;
            }
            if (possiblePosition == 14 || possiblePosition == 15) {
                return false;
            }                    
        } 
        
        return true;
    }

    
}
