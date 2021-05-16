/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;

import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.Brain.MiniMaxAlphaBeta;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kukkojoo
 */
public class MiniMaxAlphaBetaTest {
    MiniMaxAlphaBeta mm;
    ChessBoard board;
    
    public MiniMaxAlphaBetaTest() {
        board = new ChessBoard();
        board.initBoard();
        mm = new MiniMaxAlphaBeta(board);
    }
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }
    
    @Test
    public void testInitBoard() {
        assertEquals("e2e4", mm.getBestMove(board, 3, 1).getMove());
    }

    @Test
    public void testOneMove() {
        int[][] table = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 4, 5, 6, 4, 3, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0,11, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,11, 0,11,11,11,11,11,11},
            {0,12,13,14,15,16,14,13,12}            
        };
        ChessBoard board1 = new ChessBoard(table);
        assertEquals("a4b5", mm.getBestMove(board1, 1, 1).getMove());
    }
}
