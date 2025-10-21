package main.java.com.navin.tictactoe.strategies;

import java.util.HashMap;

import main.java.com.navin.tictactoe.model.Board;

import main.java.com.navin.tictactoe.model.Move;
import main.java.com.navin.tictactoe.model.Symbol;

public class ColumnWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
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

        return colMap.get(symbol) == board.getSize();

    }

    @Override
    public void undo(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        HashMap<Symbol, Integer> colMap = counts.get(col);
        colMap.put(symbol, colMap.get(symbol) - 1);

    }

}