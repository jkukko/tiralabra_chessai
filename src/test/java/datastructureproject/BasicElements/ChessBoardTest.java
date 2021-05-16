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


/**
 *
 * @author kukkojoo
 */
public class ChessBoardTest {
    
    ChessBoard board;
    
    public ChessBoardTest() {
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
    public void testBoardConstructorOtherBoard() {
        ChessBoard board1 = new ChessBoard();
        board1.initBoard();   
        board1.movePiece(new Move("a2a3"));
        
        ChessBoard board2 = new ChessBoard(board1);
        assertEquals(1, board2.getBoard()[3][1]);
    }
    
    @Test 
    public void testBoardConstructorTable() {
        int[][] table = 
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 10, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board1 = new ChessBoard(table);
        assertEquals(10, board1.getBoard()[1][1]);
    }
    
    @Test
    public void testMovePiece() {
        Move m = new Move("a2a3");
        board.movePiece(m);
        assertEquals(1, board.getBoard()[3][1]);
    }
    
    @Test
    public void testUndoMove() {
        Move m = new Move("a2a3");
        board.movePiece(m);
        assertEquals(1, board.getBoard()[3][1]);
        board.undoMove(m);
        assertEquals(0, board.getBoard()[3][1]);
    }
    
    @Test
    public void testUndoMoveWithOldValue() {
        Move m = new Move("a2a3");
        board.movePiece(m);
        assertEquals(1, board.getBoard()[3][1]);
        board.undoMoveWithOldValue(m, 5);
        assertEquals(5, board.getBoard()[3][1]);        
    }
    
    @Test
    public void testSetBoard() {
        ChessBoard board1 = new ChessBoard();
        board1.initBoard();   
        board1.movePiece(new Move("a2a3"));
       
        ChessBoard board2 = new ChessBoard();
        board2.initBoard();
        assertEquals(0, board2.getBoard()[3][1]);
        board2.setBoard(board1);
        assertEquals(1, board2.getBoard()[3][1]);
    }
    
    @Test
    public void testKingLocationWhite() {
        assertEquals(1, board.kingLocation(1).getY());
    }
    
    @Test
    public void testKingLocationBlack() {
        assertEquals(8, board.kingLocation(2).getY());
    }
    
    @Test
    public void testMovePieceAndGetNewPositionValue() {
        assertEquals(0, board.movePieceAndGetNewPositionValue(new Move("a2a3")));
    }
    
    
}
