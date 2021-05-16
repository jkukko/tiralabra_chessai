package datastructureproject;

import chess.bot.ChessBot;
import chess.engine.GameState;
import datastructureproject.Bot.GameBotMiniMaxAB;
import java.util.ArrayList;
import java.util.List;

/**
 * Use this class to write performance tests for your bot.
 * 
 */
public class PerformanceTest {

    private ChessBot bot;
    private List<GameState> gsList = new ArrayList();
    private GameBotMiniMaxAB ownBot;

    public void setGsList(List<GameState> gsList) {
        this.gsList = gsList;
    }


    public static void main(String[] args) {
        
        /*
        Set your bot and tests here.
        */
    }

}
