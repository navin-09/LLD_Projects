package main.java.com.naveen.tictactoe.strategies;

import main.java.com.naveen.tictactoe.model.Board;
import main.java.com.naveen.tictactoe.model.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move, Board board);

    public void handleUndo(Move move, Board board);

}
