package main.java.com.naveen.tictactoe.strategies;

import java.util.HashMap;
import java.util.Map;

import main.java.com.naveen.tictactoe.model.Board;

import main.java.com.naveen.tictactoe.model.Move;
import main.java.com.naveen.tictactoe.model.Symbol;

public class ColumnWinningStrategy implements WinningStrategy {
    private final Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        // | 0 | -> {'X' -> 0, 'O' -> 2}
        // | 1 | -> {'X' -> 0, 'O' -> 2}
        // | 2 | -> {'X' -> 0, 'O' -> 2}
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }

        HashMap<Symbol, Integer> colMap = counts.get(col);
        if (!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }
        colMap.put(symbol, colMap.get(symbol) + 1);

        // checking the winning condition
        return colMap.get(symbol) == board.getSize();
    }

    @Override
    public void handleUndo(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol, Integer> colMap = counts.get(col);
        colMap.put(symbol, colMap.get(symbol) - 1);
    }
}