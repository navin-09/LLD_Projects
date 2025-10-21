package main.java.com.navin.tictactoe.strategies;

import java.util.HashMap;

import main.java.com.navin.tictactoe.model.Board;
import main.java.com.navin.tictactoe.model.Move;
import main.java.com.navin.tictactoe.model.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {

    HashMap<Symbol, Integer> leftDiagonalMapCounts = new HashMap<>();
    HashMap<Symbol, Integer> rightDiagonalMapCounts = new HashMap<>();

    // left diagonal -> i == j
    // right diagonal -> i + j == N - 1
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            if (!leftDiagonalMapCounts.containsKey(symbol)) {
                leftDiagonalMapCounts.put(symbol, 0);

            }
            leftDiagonalMapCounts.put(symbol, leftDiagonalMapCounts.get(symbol) + 1);
        } else if (row + col == board.getSize() - 1) {
            if (!rightDiagonalMapCounts.containsKey(symbol)) {
                rightDiagonalMapCounts.put(symbol, 0);

            }
            rightDiagonalMapCounts.put(symbol, rightDiagonalMapCounts.get(symbol) + 1);
        }

        return leftDiagonalMapCounts.get(symbol) == board.getSize()
                || rightDiagonalMapCounts.get(symbol) == board.getSize();

    }

    @Override
    public void undo(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagonalMapCounts.put(symbol, leftDiagonalMapCounts.get(symbol) - 1);

        }
        if (row + col == board.getSize() - 1) {
            rightDiagonalMapCounts.put(symbol, rightDiagonalMapCounts.get(symbol) - 1);

        }

    }

}
