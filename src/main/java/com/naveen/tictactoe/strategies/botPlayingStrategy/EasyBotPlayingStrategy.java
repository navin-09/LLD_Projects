package main.java.com.naveen.tictactoe.strategies.botPlayingStrategy;

import java.util.List;

import main.java.com.naveen.tictactoe.enums.CellState;
import main.java.com.naveen.tictactoe.model.Board;
import main.java.com.naveen.tictactoe.model.Cell;
import main.java.com.naveen.tictactoe.model.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }

}
