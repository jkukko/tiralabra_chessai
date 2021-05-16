package datastructureproject;

import chess.bot.ChessBot;
import chess.engine.GameState;
import datastructureproject.BasicElements.ChessBoard;
import datastructureproject.Bot.GameBotMiniMaxAB;
import datastructureproject.Brain.MiniMax;
import datastructureproject.Brain.MiniMaxAlphaBeta;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Use this class to write performance tests for your bot.
 * 
 */
public class PerformanceTest {

    private ChessBot bot;
    private GameBotMiniMaxAB ownBot;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        ChessBoard board1 = new ChessBoard();
        board1.initBoard();
        
        int[][] table1 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 4, 5, 6, 0, 0, 2},
            {0, 1, 1, 1, 3, 0, 1, 4, 1},
            {0, 0, 0, 0, 1, 0, 3, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0,11,11, 0, 0, 0, 0},
            {0, 0, 0,13, 0,11,13, 0, 0},
            {0,11,11, 0, 0, 0,11,11,11},
            {0,12, 0,14,15,16,14, 0,12}
        };
        ChessBoard board2 = new ChessBoard(table1);

        int[][] table2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 6, 0, 2, 0, 0, 0, 2},
            {0, 1, 1, 1, 0, 4, 1, 0, 1},
            {0, 0, 0, 0, 0, 1, 3, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,14, 0, 0, 0},
            {0, 0, 0,14, 0, 0,11, 0, 0},
            {0,11,11,11, 0, 0,11,11,11},
            {0, 0,16, 0,12, 0,12, 0, 0}
        };
        ChessBoard board3 = new ChessBoard(table2);

        int[][] table3 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 0,11, 0, 0, 0, 0, 0, 0},
            {0, 0, 0,16, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,14, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board4 = new ChessBoard(table3);
        
        int depth = 0;
        while (true) {
            System.out.println("PERFORMANCE TESTS");
            System.out.println("Commands:");
            System.out.println("1: Run minmax vs minmax alpha beta performance test");
            System.out.println("2: Run performance test for basic minimax algorithm");
            System.out.println("3: Run performance test for alpha beta minimax algorithm");
            System.out.println("x: Close permance test");
            String command = reader.nextLine();
            
            if (command.equals("x")) {
                break;
            }
            
            if (command.equals("1")) {
                System.out.println("Select depth: 3,4,5,6");
                depth = Integer.parseInt(reader.nextLine());
                if (depth > 2 && depth < 7) {
                    runPerformanceTest(depth);
                }
            }
            
            if (command.equals("2")) {
                System.out.println("Select deepest depth (5 max)");
                depth = Integer.parseInt(reader.nextLine());
                if (depth > 5) {
                    depth = 5;
                }
                
                System.out.println("Game start situation");
                runPerformanceTestIndividualAlgo(depth, 1, board1);
                System.out.println("Board with most pieces (not starting situation)");
                runPerformanceTestIndividualAlgo(depth, 1, board2);
                System.out.println("Middle game situation");
                runPerformanceTestIndividualAlgo(depth, 1, board3);
                System.out.println("End game situation");
                runPerformanceTestIndividualAlgo(depth, 1, board4);

            }

            if (command.equals("3")) {
                System.out.println("Select deepest depth (7 max)");
                depth = Integer.parseInt(reader.nextLine());
                if (depth > 7) {
                    depth = 7;
                }
                
                System.out.println("Game start situation");
                runPerformanceTestIndividualAlgo(depth, 2, board1);
                System.out.println("Board with most pieces (not starting situation)");
                runPerformanceTestIndividualAlgo(depth, 2, board2);
                System.out.println("Middle game situation");
                runPerformanceTestIndividualAlgo(depth, 2, board3);
                System.out.println("End game situation");
                runPerformanceTestIndividualAlgo(depth, 2, board4);
            }            

            System.out.println("");
        }       
    }
    
    
    private static void runPerformanceTest(int depth) {
        // Creates possible situations 
        System.out.println("Game start situation");
        ChessBoard board1 = new ChessBoard();
        board1.initBoard();
        board1.printBoard();
        int mm = runMiniMaxPerformanceTest(board1, depth);
        int mmAB = runMiniMaxAlphaBetaPerformanceTest(board1, depth);
        printShareOfBranches(mm, mmAB);
        System.out.println("");

        System.out.println("Board with most pieces (not starting situation)");
        int[][] table1 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 4, 5, 6, 0, 0, 2},
            {0, 1, 1, 1, 3, 0, 1, 4, 1},
            {0, 0, 0, 0, 1, 0, 3, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0,11,11, 0, 0, 0, 0},
            {0, 0, 0,13, 0,11,13, 0, 0},
            {0,11,11, 0, 0, 0,11,11,11},
            {0,12, 0,14,15,16,14, 0,12}
        };
        ChessBoard board2 = new ChessBoard(table1);
        board2.printBoard();
        mm = runMiniMaxPerformanceTest(board2, depth);
        mmAB = runMiniMaxAlphaBetaPerformanceTest(board2, depth);
        printShareOfBranches(mm, mmAB);
        System.out.println("");

        System.out.println("Middle game situation");
        int[][] table2 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 6, 0, 2, 0, 0, 0, 2},
            {0, 1, 1, 1, 0, 4, 1, 0, 1},
            {0, 0, 0, 0, 0, 1, 3, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,14, 0, 0, 0},
            {0, 0, 0,14, 0, 0,11, 0, 0},
            {0,11,11,11, 0, 0,11,11,11},
            {0, 0,16, 0,12, 0,12, 0, 0}
        };
        ChessBoard board3 = new ChessBoard(table2);
        board3.printBoard();
        mm = runMiniMaxPerformanceTest(board3, depth);
        mmAB = runMiniMaxAlphaBetaPerformanceTest(board3, depth);
        printShareOfBranches(mm, mmAB);
        System.out.println("");        

        System.out.println("End game situation");
        int[][] table3 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 0,11, 0, 0, 0, 0, 0, 0},
            {0, 0, 0,16, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,14, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ChessBoard board4 = new ChessBoard(table3);
        board3.printBoard();
        mm = runMiniMaxPerformanceTest(board4, depth);
        mmAB = runMiniMaxAlphaBetaPerformanceTest(board4, depth);
        printShareOfBranches(mm, mmAB);
        System.out.println("");         
    }
    
    private static void runPerformanceTestIndividualAlgo(int depth, int algo, ChessBoard board) {
        
        for (int i = 1; i <= depth; i++) {
            if (algo == 1) {
                int mm = runMiniMaxPerformanceTest(board, i);
            } else {
                int mmAB = runMiniMaxAlphaBetaPerformanceTest(board, i);
            }        
        }
        
    }
    
    private static int runMiniMaxPerformanceTest(ChessBoard board, int depth) {
        MiniMax miniMax = new MiniMax(board);
        long startTime = System.currentTimeMillis();
        miniMax.getBestMove(board, depth, 1);
        long endTime = System.currentTimeMillis();
        int branches = miniMax.getCount();
        printPerformance("Basic MiniMax",startTime, endTime, branches);
        return branches;
    }
    
    private static int runMiniMaxAlphaBetaPerformanceTest(ChessBoard board, int depth) {
        MiniMaxAlphaBeta miniMaxAlphaBeta = new MiniMaxAlphaBeta(board);
        long startTime = System.currentTimeMillis();
        miniMaxAlphaBeta.getBestMove(board, depth, 1);
        long endTime = System.currentTimeMillis();
        int branches = miniMaxAlphaBeta.getCount();
        printPerformance("MiniMax Alpha Beta pruning",startTime, endTime, branches);
        return branches;
    }
    
    private static void printPerformance(String method, long startTime, long endTime, int branches) {
        long seconds = (endTime - startTime) / 1000;
        System.out.println(method + ", time taken: " + seconds + ", possible branches: " + branches);
    }


    private static void printShareOfBranches(int mm, int mmAB) {
        double share = (double) mmAB / mm * 100;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Share of branches: " + numberFormat.format(share) + " %");
    }    

}
