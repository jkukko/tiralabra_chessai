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
        this.board = new String[8][8];
    }

    public String[][] getBoard() {
        return this.board;
    }
    
    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    this.board[1][j] = "p";
                } else if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    this.board[i][j] = "r";
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    this.board[i][j] = "n";
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    this.board[i][j] = "b";
                } else if (i == 0 && j == 3) {
                    this.board[i][j] = "q";
                } else if (i == 0 && j == 4) {
                    this.board[i][j] = "k";
                } else if (i == 6) {
                    this.board[6][j] = "P";
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    this.board[i][j] = "R";
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    this.board[i][j] = "N";
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    this.board[i][j] = "B";
                } else if (i == 7 && j == 3) {
                    this.board[i][j] = "Q";
                } else if (i == 7 && j == 4) {
                    this.board[i][j] = "K";
                } else {
                    this.board[i][j] ="x";
                }
            }
        }
    }
    
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println("");
        }
    }
    
}
