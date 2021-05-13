/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.BasicElements;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructureproject.Move;
import datastructureproject.ChessBoard;
import datastructureproject.Coordinate;

/**
 *
 * @author kukkojoo
 */
public class MoveTest {
    
    ChessBoard board;
    
    public MoveTest() {
        this.board = new ChessBoard();
        this.board.initBoard();        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        board.initBoard();
    }

    @Test
    public void testMoveConstructorString() {
        Move move = new Move("a2a3");
        assertEquals("a2a3", move.getMove());
    }
    
    @Test
    public void testMoveConstructorCoordinates() {
        Move move = new Move(new Coordinate("a2"), new Coordinate("a3"));
        assertEquals("a2a3", move.getMove());
    }
    
}
