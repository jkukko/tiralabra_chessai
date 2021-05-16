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
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.BasicElements.Coordinate;
import datastructureproject.Logic.ChessLogicBlack;
import datastructureproject.BasicElements.Move;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import datastructureproject.OwnStructures.OwnList;

/**
 *
 * @author kukkojoo
 */
public class ChessLogicBlackTest {

    ChessBoard board;
    ChessLogicBlack logic;
    OwnList moves;
    
    public ChessLogicBlackTest() {
        logic = new ChessLogicBlack();
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
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 1, 0, 1, 0, 0, 0, 0, 0},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table);
        moves = logic.checkPawnMoves(new Coordinate("b4"), board1);
        assertEquals(3, moves.size());         
    }
    
    @Test
    public void testRookLogic() {
        int[][] table = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0,12, 0, 0, 0, 0, 0, 0},
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
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0,11,12, 0,11, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board2 = new ChessBoard(table1);
        moves = logic.checkRookMoves(new Coordinate("b2"), board2);
        assertEquals(2, moves.size());
        moves.clear();

        int[][] table2 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 1,12, 0, 1, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        ChessBoard board3 = new ChessBoard(table2);
        moves = logic.checkRookMoves(new Coordinate("b2"), board3);
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
            { 0, 0, 0, 0,13, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table1);
        moves = logic.checkKnightMoves(new Coordinate("d4"), board1);
        assertEquals(8, moves.size());
        moves.clear();
        
        int[][] table2 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0,13, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board2 = new ChessBoard(table2);
        moves = logic.checkKnightMoves(new Coordinate("g5"), board2);
        assertEquals(6, moves.size());
        moves.clear();        
    }
    
    @Test
    public void testBishopLogic() {
        int[][] table1 = 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0,14, 0, 0, 0, 0},
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
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0,11, 0, 0, 0},
            { 0, 0, 0, 0,14, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0,11, 0, 0, 0},
            { 0, 0,11, 0, 0, 0, 0, 0, 0},
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
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 1, 0, 0, 0},
            { 0, 0, 0, 0,14, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 1, 0, 0, 0},
            { 0, 0, 1, 0, 0, 0, 0, 0, 0},
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
            { 0, 0, 0, 0,15, 0, 0, 0, 0},
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
            { 0, 0, 0, 0,16, 0, 0, 0, 0},
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
