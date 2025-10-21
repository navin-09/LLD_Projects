package main.java.com.navin.tictactoe.strategies.botPlayingStrategy;

import java.util.List;

import main.java.com.navin.tictactoe.enums.CellState;
import main.java.com.navin.tictactoe.model.Board;
import main.java.com.navin.tictactoe.model.Cell;
import main.java.com.navin.tictactoe.model.Move;

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
