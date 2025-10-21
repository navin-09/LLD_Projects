package main.java.com.naveen.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.naveen.tictactoe.Exceptions.InvalidBotCountException;
import main.java.com.naveen.tictactoe.controller.GameController;
import main.java.com.naveen.tictactoe.enums.BotDifficultyLevel;
import main.java.com.naveen.tictactoe.enums.GameState;
import main.java.com.naveen.tictactoe.enums.PlayerType;
import main.java.com.naveen.tictactoe.model.Bot;
import main.java.com.naveen.tictactoe.model.Game;
import main.java.com.naveen.tictactoe.model.Player;
import main.java.com.naveen.tictactoe.model.Symbol;
import main.java.com.naveen.tictactoe.strategies.ColumnWinningStrategy;
import main.java.com.naveen.tictactoe.strategies.DiagonalWinningStrategy;
import main.java.com.naveen.tictactoe.strategies.RowWinningStrategy;
import main.java.com.naveen.tictactoe.strategies.WinningStrategy;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Game is Starting...");

        try {
            int dimensionForGame = 3;
            List<Player> players = new ArrayList<>();

            players.add(new Player(1, "Naveen", new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2, "Bot", new Symbol('O'), BotDifficultyLevel.EASY));

            List<WinningStrategy> winningStrategies = List.of(new ColumnWinningStrategy(), new RowWinningStrategy(),
                    new DiagonalWinningStrategy());

            Game game = gameController.startGame(dimensionForGame, players, winningStrategies);

            gameController.displayBoard(game);

            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.makeMove(game);
                System.out.println("Do anyone wants to undo ? (y/n)");
                String undoAnswer = sc.next();
                if (undoAnswer.equals("y")) {
                    gameController.undo(game);
                }
                gameController.displayBoard(game);
            }
            System.out.println("The Game is finished!");
            GameState gameState = gameController.checkState(game);

            if (gameState.equals(GameState.DRAW)) {
                System.out.println("The Result is DRAW!!!!");
            } else {
                System.out.println("The Winner is " + gameController.getWinner(game).getName());
            }

        } catch (Exception e) {
            throw new InvalidBotCountException("can't  create more than one Bot.");
        }

    }

}
