package main.java.com.navin.tictactoe.model;

import java.util.Scanner;

import main.java.com.navin.tictactoe.enums.PlayerType;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private Scanner scanner;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("please enter the row number which you want place the Symbol.");
        int row = scanner.nextInt();
        System.out.println("please enter the column number which you want place the Symbol.");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

}
