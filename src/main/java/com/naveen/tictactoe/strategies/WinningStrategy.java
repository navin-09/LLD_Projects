package main.java.com.navin.tictactoe.strategies;

import main.java.com.navin.tictactoe.model.Board;
import main.java.com.navin.tictactoe.model.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move, Board board);

    public void undo(Move move, Board board);
    

}
