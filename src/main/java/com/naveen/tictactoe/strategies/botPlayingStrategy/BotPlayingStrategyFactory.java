package main.java.com.naveen.tictactoe.strategies.botPlayingStrategy;

import main.java.com.naveen.tictactoe.enums.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByLevel(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel == null) {
            throw new IllegalArgumentException("difficulty level not found.");
        }
        switch (botDifficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new EasyBotPlayingStrategy();
            case HARD:
                return new EasyBotPlayingStrategy();
            default:
                throw new IllegalArgumentException("difficulty level not found.");
        }

    }
}
