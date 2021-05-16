/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;

import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.Evaluation.BonusBoardEvaluation;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kukkojoo
 */
public class BonusBoardEvaluationTest {
    
    BonusBoardEvaluation eva;
    
    
    public BonusBoardEvaluationTest() {
        eva = new BonusBoardEvaluation();
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
    public void testEvaluationInitSituation() {
        int[][] table = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 4, 5, 6, 4, 3, 2},
            {0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0,11,11,11,11,11,11,11,11},
            {0,12,13,14,15,16,14,13,12},
        };

        ChessBoard board = new ChessBoard(table);
        assertEquals(0, eva.evalueation(board, 1));
    }
    
    @Test
    public void testEvaluationWhiteLeading() {
        int[][] table = 
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
        ChessBoard board = new ChessBoard(table);
        assertEquals(515, eva.evalueation(board, 1));
    }
    
    @Test
    public void testEvaluationBlackLeading() {
        int[][] table = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 5, 6, 4, 3, 2},
            {0, 0, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0,11,11,11,11,11,11},
            {0, 0,13,14,15,16,14,13,12},
        };
        ChessBoard board = new ChessBoard(table);
        assertEquals(-260, eva.evalueation(board, 1));        
    }
    
}
