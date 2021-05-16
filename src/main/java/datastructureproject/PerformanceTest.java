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
        
        int depth = 0;
        while (true) {
            System.out.println("PERFORMANCE TESTS");
            System.out.println("Commands:");
            System.out.println("1: Run performance test");
            System.out.println("x: Close permance test");
            String command = reader.nextLine();
            
            if (command.equals("x")) {
                break;
            }
            
            if (command.equals("1")) {
                System.out.println("Select depth: 3,4,5,6");
                depth = Integer.parseInt(reader.nextLine());
            }
            
            if (depth > 2 && depth < 7) {
                runPerformanceTest(depth);
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
