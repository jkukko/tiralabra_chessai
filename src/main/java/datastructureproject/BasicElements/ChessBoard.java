/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.BasicElements;

import datastructureproject.OwnStructures.OwnList;

/**
 *
 * @author kukkojoo
 */
public class ChessBoard {
    private int[][] board;
    
    public ChessBoard() {
        this.board = new int[9][9];
    }
    
    public ChessBoard(ChessBoard board) {
        this.board = board.getBoard();
    }
    
    public ChessBoard(int[][] table) {
        this.board = new int[9][9];
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                this.board[i][j] = table[i][j];
            }
        }
    }
    
    /**
     * Returns the chessboard which is two dimension table
     * @return two dimension table of Integers
     */

    public int[][] getBoard() {
        return this.board;
    }
    
    /**
     * Initializing the chessboard
     */
    
    public void initBoard() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (i == 2) {
                    this.board[2][j] = 1;
                } else if ((i == 1 && j == 1) || (i == 1 && j == 8)) {
                    this.board[i][j] = 2;
                } else if ((i == 1 && j == 2) || (i == 1 && j == 7)) {
                    this.board[i][j] = 3;
                } else if ((i == 1 && j == 3) || (i == 1 && j == 6)) {
                    this.board[i][j] = 4;
                } else if (i == 1 && j == 4) {
                    this.board[i][j] = 5;
                } else if (i == 1 && j == 5) {
                    this.board[i][j] = 6;
                } else if (i == 7) {
                    this.board[7][j] = 11;
                } else if ((i == 8 && j == 1) || (i == 8 && j == 8)) {
                    this.board[i][j] = 12;
                } else if ((i == 8 && j == 2) || (i == 8 && j == 7)) {
                    this.board[i][j] = 13;
                } else if ((i == 8 && j == 3) || (i == 8 && j == 6)) {
                    this.board[i][j] = 14;
                } else if (i == 8 && j == 4) {
                    this.board[i][j] = 15;
                } else if (i == 8 && j == 5) {
                    this.board[i][j] = 16;
                } else {
                    this.board[i][j] = 0;
                }
            }
        }
    }
    
    /**
     * Moves a piece in chessboard
     * @param move a move
     */
    public void movePiece(Move move) {
        this.board[move.getNewY()][move.getNewX()] = this.board[move.getOldY()][move.getOldX()];
        this.board[move.getOldY()][move.getOldX()] = 0;
    }
    /**
     * Move a piece in chessboard and returns new position value before move
     * @param move a move
     * @return new position before move
     */
    public int movePieceAndGetNewPositionValue(Move move) {
        int value = this.board[move.getNewY()][move.getNewX()];
        movePiece(move);
        return value;
    }
    
    /**
     * Prints chessboard
     */
    
    public void printBoard() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int piece = this.board[i][j];
                if (piece == 1) {
                    System.out.print("p");
                } else if (piece == 2) {
                    System.out.print("r");
                } else if (piece == 3) {
                    System.out.print("n");
                } else if (piece == 4) {
                    System.out.print("b");
                } else if (piece == 5) {
                    System.out.print("q");
                } else if (piece == 6) {
                    System.out.print("k");
                    
                } else if (piece == 11) {
                    System.out.print("P");
                } else if (piece == 12) {
                    System.out.print("R");
                } else if (piece == 13) {
                    System.out.print("N");
                } else if (piece == 14) {
                    System.out.print("B");
                } else if (piece == 15) {
                    System.out.print("Q");
                } else if (piece == 16) {
                    System.out.print("K");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
    
    /**
     * Initializing chessboard with other board
     * @param initBoard a chessboard to create same
     */
    
    public void setBoard(ChessBoard initBoard) {
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                this.board[i][j] = initBoard.getBoard()[i][j];
            }
            
        }
    }
    
    public OwnList getPieces() {
        OwnList piecesList = new OwnList(12);
        for (int i = 0; i < 12; i++) {
            piecesList.add(0);
        }
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int piece = board[i][j];
                
                if (piece == 1) {
                    piecesList.setOwnList(0, ((Integer) piecesList.get(0) + 1));
                } else if (piece == 2) {
                    piecesList.setOwnList(1, ((Integer) piecesList.get(1) + 1));
                } else if (piece == 3) {
                    piecesList.setOwnList(2, ((Integer) piecesList.get(2) + 1));
                } else if (piece == 4) {
                    piecesList.setOwnList(3, ((Integer) piecesList.get(3) + 1));
                } else if (piece == 5) {
                    piecesList.setOwnList(4, ((Integer) piecesList.get(4) + 1));
                } else if (piece == 6) {
                    piecesList.setOwnList(5, ((Integer) piecesList.get(5) + 1));
                } else if (piece == 11) {
                    piecesList.setOwnList(6, ((Integer) piecesList.get(6) + 1));
                } else if (piece == 12) {
                    piecesList.setOwnList(7, ((Integer) piecesList.get(7) + 1));
                } else if (piece == 13) {
                    piecesList.setOwnList(8, ((Integer) piecesList.get(8) + 1));
                } else if (piece == 14) {
                    piecesList.setOwnList(9, ((Integer) piecesList.get(9) + 1));
                } else if (piece == 15) {
                    piecesList.setOwnList(10, ((Integer) piecesList.get(10) + 1));
                } else if (piece == 16) {
                    piecesList.setOwnList(11, ((Integer) piecesList.get(11) + 1));
                }                
                
            }
        }
        
        return piecesList;
    }
    
    /**
     * Returns king position of specific player
     * @param player a player
     * @return coordinate where king is
     */
    
    public Coordinate kingLocation(int player) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                
                if (player == 1 && this.board[i][j] == 6) {
                    return new Coordinate(j, i);
                }
                
                if (player == 2 && this.board[i][j] == 16) {

                    return new Coordinate(j, i);
                    
                }
            }
        }
        return new Coordinate(1, 1);
    }
    
    /**
     * Undos a move 
     * @param move that is will be undo
     */

    public void undoMove(Move move) {
        Move undoMove = new Move(move.getNewCoordinate(), move.getOldCoordinate());
        movePiece(undoMove);
    }
    
    /**
     * Undo a move and set old value as given old value
     * @param move a move
     * @param oldValue old value that will be set
     */
    
    public void undoMoveWithOldValue(Move move, int oldValue) {
        Coordinate coorOld = move.getOldCoordinate();
        Coordinate coorNew = move.getNewCoordinate();
        this.board[coorOld.getY()][coorOld.getX()] = this.board[coorNew.getY()][coorNew.getX()];
        this.board[coorNew.getY()][coorNew.getX()] = oldValue;
    }
    
}
