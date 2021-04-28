/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject;

import java.util.ArrayList;
import java.util.List;

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

    public int[][] getBoard() {
        return this.board;
    }
    
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
    
    public void movePiece(Move move) {
        this.board[move.getNewY()][move.getNewX()] = this.board[move.getOldY()][move.getOldX()];
        this.board[move.getOldY()][move.getOldX()] = 0;
    }
    
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
    
    public void setBoard(ChessBoard initBoard) {
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                this.board[i][j] = initBoard.getBoard()[i][j];
            }
            
        }
    }
    
    public List<Integer> getScore(Side side) {
        int score = 0;

        if (side == Side.WHITE) {
            return whiteScore();
        } else {
            return blackScore();
        }     
    }

    private List<Integer> whiteScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Integer> blackScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Coordinate kingLocation(int player) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                
                if(player == 1 && this.board[i][j] == 6) {
                    return new Coordinate(i, j);
                }
                
                if (player == 2 && this.board[i][j] == 16) {

                    return new Coordinate(j, i);
                    
                }
            }
        }
        return new Coordinate(1,1);
    }
    
}
