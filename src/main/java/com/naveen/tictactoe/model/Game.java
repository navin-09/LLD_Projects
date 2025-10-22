package main.java.com.naveen.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

import main.java.com.naveen.tictactoe.enums.CellState;
import main.java.com.naveen.tictactoe.enums.GameState;
import main.java.com.naveen.tictactoe.strategies.WinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<WinningStrategy> winningStrategies;

    public Game(int dimensionForGame, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimensionForGame);
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int dimensionForGame;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public int getDimensionForGame() {
            return dimensionForGame;
        }

        public Builder setDimensionForGame(int dimensionForGame) {
            this.dimensionForGame = dimensionForGame;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() {
            return new Game(dimensionForGame, players, winningStrategies);
        }

    }

    public void printBoard() {
        board.printBoard();
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row >= board.getSize()) {
            return false;
        }
        if (col >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public boolean checkWinner(Board board, Move move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(move, board)) {
                return true;
            }
        }
        return false;
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn. please make your move.");
        Move move = currentPlayer.makeMove(board);

        if (!validateMove(move)) {
            System.out.println("Invalid move! please try again.");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToBeUpdated = board.getBoard().get(row).get(col);
        cellToBeUpdated.setCellState(CellState.FILLED);
        cellToBeUpdated.setPlayer(currentPlayer);

        Move finalMove = new Move(cellToBeUpdated, currentPlayer);
        moves.add(finalMove);

        nextPlayerMoveIndex += 1;
        nextPlayerMoveIndex = nextPlayerMoveIndex % players.size();
        System.out.println("done");
        if (checkWinner(board, finalMove)) {
            gameState = GameState.SUCCESS;
            winner = currentPlayer;
        } else if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }

        System.out.println("Player " + currentPlayer.getName() + " moved at " + move.getCell().getRow() + " , "
                + move.getCell().getCol());

    }

    public void undo() {
        if (moves.isEmpty()) {
            System.out.println("No moves to undo");
            return;
        }
        Move move = moves.get(moves.size() - 1);
        moves.remove(move);
        Cell cell = move.getCell();

        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);

        nextPlayerMoveIndex -= 1;
        nextPlayerMoveIndex = (nextPlayerMoveIndex + players.size()) % players.size();

        for (WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.undo(move, board);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

}
