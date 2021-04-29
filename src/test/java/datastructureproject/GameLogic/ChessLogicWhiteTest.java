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
import datastructureproject.ChessBoard;
import datastructureproject.Logic.ChessLogicWhite;
import datastructureproject.Move;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kukkojoo
 */
public class ChessLogicWhiteTest {
   
    ChessBoard board;
    ChessLogicWhite logic;
    List<Move> moves;
    
    public ChessLogicWhiteTest() {
        logic = new ChessLogicWhite();
        board = new ChessBoard();
        board.initBoard();
        moves = new ArrayList<>();
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
    public void pawnLogicReturnsRightMovesCount() {
        moves = logic.legalMoves(board);
        assertEquals(18, moves.size());
    }
}
