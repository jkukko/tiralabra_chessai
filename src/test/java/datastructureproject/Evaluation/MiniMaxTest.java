/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.Evaluation;
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.Brain.MiniMax;
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
public class MiniMaxTest {
    MiniMax mm;
    ChessBoard board;
    
    public MiniMaxTest() {
        board = new ChessBoard();
        board.initBoard();
        mm = new MiniMax(board);
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
    public void testOneDepthMove() {
        
    }
    
}
