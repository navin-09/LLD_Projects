package main.java.com.navin.tictactoe.controller;

import java.util.List;

import main.java.com.navin.tictactoe.Exceptions.InvalidBotCountException;
import main.java.com.navin.tictactoe.enums.GameState;
import main.java.com.navin.tictactoe.model.Game;
import main.java.com.navin.tictactoe.model.Player;
import main.java.com.navin.tictactoe.strategies.WinningStrategy;

public class GameController {

    public Game startGame(int dimensionForGame, List<Player> players, List<WinningStrategy> winningStrategies)
            throws InvalidBotCountException {

        return Game.getBuilder()
                .setDimensionForGame(dimensionForGame)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }

    public void displayBoard(Game game) {
        game.printBoard();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) {
        game.undo();
    }

}
