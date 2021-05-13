/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import datastructureproject.Evaluation.SimpleBoardEvaluation;
import datastructureproject.ChessBoard;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author kukkojoo
 */
public class SimpleBoardEvaluationTest {
    
    SimpleBoardEvaluation evaluation;
    ChessBoard board;
    
    public SimpleBoardEvaluationTest() {
        evaluation = new SimpleBoardEvaluation();
        board = new ChessBoard();
        board.initBoard();
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
    public void whiteBoardEvaluationEqualSituation() {
        assertEquals(0, evaluation.evalueation(board, 1));
    }
    
    @Test
    public void blackBoardEvaluationEqualSituation() {
        assertEquals(0, evaluation.evalueation(board, 2));
    }

    @Test
    public void whiteBoardEvaluationWhiteLeading() {
        int[][] table1 = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 4, 5, 6, 4, 3, 2},
            {0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0,11,11,11,11,11,11},
            {0, 0,13,14,15,16,14,13,12},
        };        
        ChessBoard board1 = new ChessBoard(table1);
        assertEquals(5, evaluation.evalueation(board1, 1));
    }

    @Test
    public void blackBoardEvaluationWhiteLeading() {
        int[][] table1 = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 4, 5, 6, 4, 3, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0,11,11,11,11,11,11},
            {0, 0,13,14,15,16,14,13,12},
        };        
        ChessBoard board1 = new ChessBoard(table1);
        assertEquals(-3, evaluation.evalueation(board1, 1));
    }
    
}
