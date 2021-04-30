/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package chess;

import datastructureproject.GameBot;
import datastructureproject.GameBot2;
import chess.bot.ChessBot;
import chess.bot.TestBot;
import chess.connection.LichessAPI;
import chess.model.Profile;
import chess.connection.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        Map<String, String> env = System.getenv();
        String token = null;
        boolean isLichess = false;
        // Parse passed parameters.
        for (String arg : args) {
            if (arg.contains("--lichess")) {
                isLichess = true;
                if (env.containsKey("LICHESS_TOKEN")) {
                    token = env.get("LICHESS_TOKEN");
                }
            }
            if (arg.contains("--token=")) {
                token = arg.substring(8);
            }
        }
        
        /*
        You need to place your bot implementation to the variable below.
        Make sure it implements the interface ChessBot, and don't change the variable name!
        */
        ChessBot bot = new GameBot2(); // Your bot here!

        if (isLichess) {
            if (token == null) {
                throw new Error("No token found");
            }
            LichessAPI api = new LichessAPI(bot, token);
            Profile myProfile = api.getAccount();
            System.out.println("Profile ID: " + myProfile.id);
            api.beginEventLoop();
            
        } else {

            Long initialTime = System.currentTimeMillis();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (System.currentTimeMillis() - initialTime < 2500 && !in.ready()) {
                Thread.sleep(25);
            }

            if (in.ready()) {
                String input = in.readLine();
                if (input.equalsIgnoreCase("xboard")) {
                    XBoardHandler xb = new XBoardHandler(bot, in);
                    xb.run();
                }
            }
        }
    }
}
