/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject;

/**
 *
 * @author kukkojoo
 */
public class ChessBoard {
    private String[][] board;
    
    public ChessBoard() {
        this.board = new String[9][9];
    }

    public String[][] getBoard() {
        return this.board;
    }
    
    public void initBoard() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (i == 2) {
                    this.board[2][j] = "p";
                } else if ((i == 1 && j == 1) || (i == 1 && j == 8)) {
                    this.board[i][j] = "r";
                } else if ((i == 1 && j == 2) || (i == 1 && j == 7)) {
                    this.board[i][j] = "n";
                } else if ((i == 1 && j == 3) || (i == 1 && j == 6)) {
                    this.board[i][j] = "b";
                } else if (i == 1 && j == 4) {
                    this.board[i][j] = "q";
                } else if (i == 1 && j == 5) {
                    this.board[i][j] = "k";
                } else if (i == 7) {
                    this.board[7][j] = "P";
                } else if ((i == 8 && j == 1) || (i == 8 && j == 8)) {
                    this.board[i][j] = "R";
                } else if ((i == 8 && j == 2) || (i == 8 && j == 7)) {
                    this.board[i][j] = "N";
                } else if ((i == 8 && j == 3) || (i == 8 && j == 6)) {
                    this.board[i][j] = "B";
                } else if (i == 8 && j == 4) {
                    this.board[i][j] = "Q";
                } else if (i == 8 && j == 5) {
                    this.board[i][j] = "K";
                } else {
                    this.board[i][j] ="x";
                }
            }
        }
    }
    
    public void movePiece(Move move) {
        this.board[move.getNewY()][move.getNewX()] = this.board[move.getOldY()][move.getOldX()];
        this.board[move.getOldY()][move.getOldX()] = "x";
    }
    
    public void printBoard() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println("");
        }
    }
    
}
