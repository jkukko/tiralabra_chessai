/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Logic;
import datastructureproject.Move;
import datastructureproject.ChessBoard;
import datastructureproject.Coordinate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author kukkojoo
 */
public class ChessLogicBlack {
    
    public List<Move> legalMoves(ChessBoard board) {
        List<Move> moves = new ArrayList<>();
        
        for (int i = 8; i > 0; i--) {
            for (int j = 8; j > 0; j--) {
                Coordinate coor = new Coordinate(j, i);
                int piece = board.getBoard()[i][j];         
                if (piece == 11) {
                    moves.addAll(checkPawnMoves(coor, board));
                } else if (piece == 12) {
                    moves.addAll(checkRookMoves(coor, board));
                } else if (piece == 13) {
                    moves.addAll(checkKnightMoves(coor, board));
                } else if (piece == 14) {
                    moves.addAll(checkBishopMoves(coor, board));
                } else if (piece == 15) {
                    moves.addAll(checkQueenMoves(coor, board));
                } else if (piece == 16) {
                    moves.addAll(checkKingMoves(coor, board));
                }
            }
            
        }
        return moves;
    }

    private List<Move> checkPawnMoves(Coordinate coor, ChessBoard board) {
        List<Move> moves = new ArrayList<>();

        if (coor.getY() == 0) {
            return moves;
        }
        
        if (coor.getX() < 8) {
            int possiblePlace = board.getBoard()[coor.getY() - 1][coor.getX() + 1];
            if (possiblePlace != 0 && possiblePlace < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() + 1, coor.getY() - 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }  
        }
        
        if (coor.getX() > 0) {
            int possiblePlace = board.getBoard()[coor.getY() - 1][coor.getX() - 1];
            if (possiblePlace != 0 && possiblePlace < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() - 1, coor.getY() - 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }  
        }
        
        if (coor.getY() > 0) {
            if (board.getBoard()[coor.getY() - 1][coor.getX()] == 0) {
                Move move = new Move(coor, new Coordinate(coor.getX(), coor.getY() - 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }

            }                
        }        
        
        if (coor.getY() == 7) {
            if (board.getBoard()[coor.getY() - 2][coor.getX()] == 0 && board.getBoard()[coor.getY() - 1][coor.getX()] == 0) {
                Move move = new Move(coor, new Coordinate(coor.getX(), coor.getY() - 2));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }                           
        }
        
        return moves;
    }

    private List<Move> checkRookMoves(Coordinate coor, ChessBoard board) {
        List<Move> moves = new ArrayList<>();
        int earlier = 0;
        
        // Rook moves downwards
        for (int i = coor.getY()+1; i < 9; i++) {
           earlier = board.getBoard()[i][coor.getX()];

            if ((earlier > 0 && earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(coor.getX(), i));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
                break;
            }     
        }

        // Rook moves upwards
        earlier = 0;
        for (int i = coor.getY()-1; i > 0; i--) {
           earlier = board.getBoard()[i][coor.getX()];

            if ((earlier > 0 && earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(coor.getX(), i));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
                break;
            }     
        }


        // Rook moves to right
        earlier = 0;
        for (int i = coor.getX()+1; i < 9; i++) {
           earlier = board.getBoard()[coor.getY()][i];

            if ((earlier > 0 && earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(i, coor.getY()));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
                break;
            }
        }

        // Rook moves to left
        earlier = 0;
        for (int i = coor.getX()-1; i > 0; i--) {
            earlier = board.getBoard()[coor.getY()][i];

            if ((earlier > 0 && earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(i, coor.getY()));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
                break;
            }
        }            

        return moves;
    }
    
    private List<Move> checkKnightMoves(Coordinate coor, ChessBoard board) {
        List<Move> moves = new ArrayList<>();

        if ((coor.getX() + 2 < 9) && (coor.getY() + 1 < 9)) {
            int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() + 2];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX()+2, coor.getY() + 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                   
            }
        }

        if ((coor.getX() + 1 < 9) && (coor.getY() + 2 < 9)) {
            int possiblePosition = board.getBoard()[coor.getY() + 2][coor.getX() + 1];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() + 1, coor.getY() + 2));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                  
            }
        }

        if ((coor.getX() + 1 < 9) && (coor.getY() - 2 > 0)) {
            int possiblePosition = board.getBoard()[coor.getY() - 2][coor.getX() + 1];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() + 1, coor.getY() - 2));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                    
            }
        }

        if ((coor.getX() + 2 < 9) && (coor.getY() - 1 > 0)) {
            int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() + 2];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() + 2, coor.getY() - 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                   
            }
        }
        
        if ((coor.getX() - 2 > 0) && (coor.getY() + 1 < 9)) {
            int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() - 2];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() - 2, coor.getY() + 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                   
            }
        }
        
        if ((coor.getX() - 1 > 0) && (coor.getY() + 2 < 9)) {
            int possiblePosition = board.getBoard()[coor.getY() + 2][coor.getX() - 1];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() - 1, coor.getY() + 2));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                    
            }
        }
        
        if ((coor.getX() - 1 > 0) && (coor.getY() - 2 > 0)) {
            int possiblePosition = board.getBoard()[coor.getY() - 2][coor.getX() - 1];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() - 1, coor.getY() - 2));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                  
            }
        }

        if ((coor.getX() - 2 > 0) && (coor.getY() - 1 > 0)) {
            int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() - 2];
            if(possiblePosition == 0 || possiblePosition < 7) {
                Move move = new Move(coor, new Coordinate(coor.getX() - 2, coor.getY() - 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }                   
            }
        }         
        
        return moves;
    }
    
    
    
    private List<Move> checkBishopMoves(Coordinate coor, ChessBoard board) {
        List<Move> moves = new ArrayList<>();
        
        int earlier = 0;
        int xCoor = coor.getX() + 1;
        for (int i = coor.getY() + 1; i < 9; i++) {
            earlier = board.getBoard()[i][xCoor];

            if ((earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(xCoor, i));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
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

            if ((earlier > 10)) {
                break;
            }

            Move move = new Move(coor, new Coordinate(xCoor, i));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
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

            if ((earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(xCoor, i));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
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

            if ((earlier > 10)) {
               break;
            }

            Move move = new Move(coor, new Coordinate(xCoor, i));
            if (checkMate(move, board)) {
                moves.add(move);
            }

            if (earlier > 0 && earlier < 7) {
                break;
            }

            xCoor -=1;

            if (xCoor == 0) {
               break;
            }
        }         

        return moves;
    }
    
    private List<Move> checkQueenMoves(Coordinate coor, ChessBoard board) {
        List<Move> moves = new ArrayList<>();
        
        moves.addAll(checkBishopMoves(coor, board));
        moves.addAll(checkRookMoves(coor, board));
        
        return moves;
    }

    private List<Move> checkKingMoves(Coordinate coor, ChessBoard board) {
        List<Move> moves = new ArrayList<>();
        
        if (coor.getY() < 8) {
            int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX()];
            if ((possiblePosition == 0) || (possiblePosition < 7)) {
                Move move = new Move(coor, new Coordinate(coor.getX(), coor.getY() + 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }

        if (coor.getY() > 1) {
            int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX()];
            if ((possiblePosition == 0) || (possiblePosition < 7)) {
                Move move = new Move(coor, new Coordinate(coor.getX(), coor.getY() - 1));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }

        if (coor.getX() < 8) {
            int possiblePosition = board.getBoard()[coor.getY()][coor.getX() + 1];
            if ((possiblePosition == 0) || (possiblePosition < 7)) {
                Move move = new Move(coor, new Coordinate(coor.getX() + 1, coor.getY()));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }

        if (coor.getX() > 1) {
            int possiblePosition = board.getBoard()[coor.getY()][coor.getX() - 1];
            if ((possiblePosition == 0) || (possiblePosition < 7)) {
                Move move = new Move(coor, new Coordinate(coor.getX() - 1, coor.getY()));
                if (checkMate(move, board)) {
                    moves.add(move);
                }
            }
        }

        if (coor.getY() > 1) {            
            if (coor.getX() > 1) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() - 1];
                if ((possiblePosition == 0) || (possiblePosition < 7)) {
                    Move move = new Move(coor, new Coordinate(coor.getX() - 1, coor.getY() - 1));
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }
            if (coor.getX() < 8) {
                int possiblePosition = board.getBoard()[coor.getY() - 1][coor.getX() + 1];
                if ((possiblePosition == 0) || (possiblePosition < 7)) {
                    Move move = new Move(coor, new Coordinate(coor.getX() + 1, coor.getY() - 1));
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }
        }

        if (coor.getY() < 8) {            
            if (coor.getX() > 1) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() - 1];
                if ((possiblePosition == 0) || (possiblePosition < 7)) {
                    Move move = new Move(coor, new Coordinate(coor.getX() - 1, coor.getY() + 1));
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }
            if (coor.getX() < 8) {
                int possiblePosition = board.getBoard()[coor.getY() + 1][coor.getX() + 1];
                if ((possiblePosition == 0) || (possiblePosition < 7)) {
                    Move move = new Move(coor, new Coordinate(coor.getX() + 1, coor.getY() + 1));
                    if (checkMate(move, board)) {
                       moves.add(move);
                    }
                }            
            }
        }        
        
        return moves;
    }    

    private boolean checkMate(Move move, ChessBoard board) {
        ChessBoard chessBoardNew = new ChessBoard();
        chessBoardNew.initBoard();
        chessBoardNew.setBoard(board);
        chessBoardNew.movePiece(move);
        Coordinate kingCoordinate = chessBoardNew.kingLocation(2);
        int xKing = kingCoordinate.getX();
        int yKing = kingCoordinate.getY();
        
        // Check Pawn attack
        if (xKing < 8) {
            if (chessBoardNew.getBoard()[yKing-1][xKing+1] == 1) {
                return false;
            }
        }
        if (xKing > 0) {
            if (chessBoardNew.getBoard()[yKing-1][xKing-1] == 1) {
                return false;
            }
        }
        
        // Check Rook attack queen Rook attact right
        for (int i = xKing+1; i < 9; i++) {
            int possiblePosition = chessBoardNew.getBoard()[yKing][i];
            if (possiblePosition != 0 && possiblePosition != 2 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 2 || possiblePosition == 5) {
                return false;
            }            
        }
        
        // check Rook and queen Rook attack left
        for (int i = xKing-1; i > 0; i--) {
            int possiblePosition = chessBoardNew.getBoard()[yKing][i];
            if (possiblePosition != 0 && possiblePosition != 2 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 12 || possiblePosition == 15) {
                return false;
            }            
        }
        // check Rook and queen Rook attack down
        for (int i = yKing+1; i < 9; i++) {
            int possiblePosition = chessBoardNew.getBoard()[i][xKing];
            if (possiblePosition != 0 && possiblePosition != 2 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 2 || possiblePosition == 5) {
                return false;
            }            
        }         
        // check Rook and queen Rook attack up
        for (int i = yKing-1; i > 0; i--) {
            int possiblePosition = chessBoardNew.getBoard()[i][xKing];
            if (possiblePosition != 0 && possiblePosition != 2 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 2 || possiblePosition == 5) {
                return false;
            }            
        }
        // check Knight attact y+2 x+1
        if (yKing < 6 && xKing < 7) {
            if (chessBoardNew.getBoard()[yKing + 2][xKing + 1] == 3) {
                return false;
            }
        }

        // check Knight attact y+2 x-1
        if (yKing < 6 && xKing > 1) {
            if (chessBoardNew.getBoard()[yKing + 2][xKing - 1] == 3) {
                return false;
            }
        }
        
        // check Knight attact y-2 x+1
        if (yKing > 2 && xKing < 7) {
            if (chessBoardNew.getBoard()[yKing - 2][xKing + 1] == 3) {
                return false;
            }
        }

        // check Knight attact y-2 x-1
        if (yKing > 2 && xKing > 1) {
            if (chessBoardNew.getBoard()[yKing - 2][xKing - 1] == 3) {
                return false;
            }
        }
        
        // check Knight attact y+1 x+2
        if (yKing < 7 && xKing < 6) {
            if (chessBoardNew.getBoard()[yKing + 1][xKing + 2] == 3) {
                return false;
            }
        }

        // check Knight attact y-1 x+2
        if (yKing > 1 && xKing < 6) {
            if (chessBoardNew.getBoard()[yKing - 1][xKing + 2] == 3) {
                return false;
            }
        }

        // check Knight attact y+1 x-2
        if (yKing < 7 && xKing > 2) {
            if (chessBoardNew.getBoard()[yKing + 1][xKing - 2] == 3) {
                return false;
            }
        }

        // check Knight attact y-1 x-2
        if (yKing > 1 && xKing > 2) {
            if (chessBoardNew.getBoard()[yKing - 1][xKing - 2] == 3) {
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
            int possiblePosition = chessBoardNew.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 4 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 4 || possiblePosition == 5) {
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
            int possiblePosition = chessBoardNew.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 4 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 4 || possiblePosition == 5) {
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
            int possiblePosition = chessBoardNew.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 4 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 4 || possiblePosition == 5) {
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
            int possiblePosition = chessBoardNew.getBoard()[y][x];
            if (possiblePosition != 0 && possiblePosition != 4 && possiblePosition != 5) {
                break;
            }
            if (possiblePosition == 4 || possiblePosition == 5) {
                return false;
            }                    
        }        
        
        return true;
        
        
    }    

    
}
