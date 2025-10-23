package main.java.com.naveen.tictactoe.model;

import main.java.com.naveen.tictactoe.enums.BotDifficultyLevel;
import main.java.com.naveen.tictactoe.enums.PlayerType;
import main.java.com.naveen.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;
import main.java.com.naveen.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByLevel(botDifficultyLevel);
    }

    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

}
