/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureproject.GameLogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.BasicElements.Coordinate;
import datastructureproject.Logic.ChessLogicWhite;
import datastructureproject.BasicElements.Move;
import datastructureproject.OwnStructures.OwnList;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kukkojoo
 */
public class ChessLogicWhiteTest {
   
    ChessBoard board;
    ChessLogicWhite logic;
    OwnList moves;
    
    public ChessLogicWhiteTest() {
        logic = new ChessLogicWhite();
        board = new ChessBoard();
        board.initBoard();
        moves = new OwnList();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        moves.clear();
    } 
    
    @Test
    public void testReturnStartSituationAllMoves() {
        moves = logic.legalMoves(board);
        assertEquals(20, moves.size());
    }
    
    @Test
    public void testPawnLogic() {
        int[][] table = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0,11, 0,11, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table);
        moves = logic.checkPawnMoves(new Coordinate(2, 2), board1);
        assertEquals(4, moves.size());            
    }
    
    @Test
    public void testRookLogic() {
        int[][] table = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 2, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table);
        moves = logic.checkRookMoves(new Coordinate(2, 2), board1);
        assertEquals(14, moves.size());
        moves.clear();
        
        int[][] table1 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 1, 2, 0, 1, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board2 = new ChessBoard(table1);
        moves = logic.checkRookMoves(new Coordinate(2, 2), board2);
        assertEquals(2, moves.size());
        moves.clear();
        
        int[][] table2 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0,11, 2, 0,11, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    ChessBoard board3 = new ChessBoard(table2);
    moves = logic.checkRookMoves(new Coordinate(2, 2), board3);
    assertEquals(6, moves.size());
    moves.clear();
    }
    
    @Test
    public void testKnightLogic() {
        int[][] table1 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 3, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table1);
        moves = logic.checkKnightMoves(new Coordinate(5, 5), board1);
        assertEquals(8, moves.size());
    }
    
    @Test
    public void testBishopLogic() {
        int[][] table1 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 4, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table1);
        moves = logic.checkBishopMoves(new Coordinate("d4"), board1);
        assertEquals(13, moves.size());
        moves.clear();
        
        int[][] table2 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 1, 0, 0, 0},
            { 0, 0, 0, 0, 4, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 1, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board2 = new ChessBoard(table2);
        moves = logic.checkBishopMoves(new Coordinate("d4"), board2);
        assertEquals(2, moves.size());
        moves.clear();
        
        int[][] table3 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 6},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0,11, 0, 0, 0},
            { 0, 0, 0, 0, 4, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0,11, 0, 0, 0},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board3 = new ChessBoard(table3);
        moves = logic.checkBishopMoves(new Coordinate("d4"), board3);
        assertEquals(6, moves.size());
        moves.clear();
    }
    
    @Test
    public void testQueenLogic() {
        int[][] table1 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 5, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        ChessBoard board1 = new ChessBoard(table1);
        moves = logic.checkQueenMoves(new Coordinate("d4"), board1);
        assertEquals(27, moves.size());
    }
    
    @Test
    public void testKingLogic() {
        int[][] table1 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 6, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        ChessBoard board1 = new ChessBoard(table1);
        moves = logic.checkKingMoves(new Coordinate("d4"), board1);
        assertEquals(8, moves.size());        
    }
}
