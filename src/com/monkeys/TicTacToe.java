package com.monkeys;

public class TicTacToe {
    protected int board[];
    protected static String divider = "|";
    protected static final int playerX = 0;
    protected static final int playerY = 10;
    protected static final int playerUndefined = 100;
    protected static String playerXStr = "X";
    protected static String playerYStr = "O";
    protected int winner;


    protected boolean isXTurn;
    public TicTacToe() {
        board = new int[10];
        board[0] = 0;
        board[1] = 1;
        board[2] = 2;
        board[3] = 3;
        board[4] = 4;
        board[5] = 5;
        board[6] = 6;
        board[7] = 7;
        board[8] = 8;
        board[9] = 9;

        isXTurn = true;
        winner = playerUndefined;

    }


    public void play() {
        while (continueToNextTurn()) {
            int playerMove = getNextInput();
            if (isXTurn) {
                board[playerMove] = playerX;
                isXTurn = false;

            } else {
                board[playerMove] = playerY;
                isXTurn = true;
            }
        }
        announceGameOver();
    }

    protected void announceGameOver() {
        System.out.print("Game Over...");
        if (winner == playerX) {
            System.out.println("Congratulations Player X won!");
        } else if (winner == playerY) {
            System.out.println("Congratulations Player Y won!");
        } else {
            System.out.println("Game tied");
        }
    }
    protected int getNextInput() {
        int slot = 0;
        String player =  (isXTurn) ? "X" : "Y";

        printGameBoard();

        while (!isSlotAvailable(slot)) {
            slot = UserInput.GetIntegerInput(player + " please pick your spot from 1 - 9: ");
        }
        return slot;

    }

    protected boolean isSlotAvailable(int i) {
        if (i < 1 || i > 9)
            return false;
        else
            return (board[i] != playerX && board[i] != playerY);

    }

    protected boolean continueToNextTurn() {
        winner = anyWinner();
        if (winner == playerX || winner == playerY)
            return false;

        return boardHasEmptySlots();


    }


    protected boolean boardHasEmptySlots() {
        if (board[1] == 1 || board[2] == 2 || board[3] == 3 ||
                board[4] == 4 || board[5] == 5 || board[6] == 6 ||
                board[7] == 7 || board[8] == 8 || board[9] == 9)
            return true;
        else
            return false;
    }

    protected int anyWinner() {
        int row1 = board[1] + board[2] + board[3];
        int row2 = board[4] + board[5] + board[6];
        int row3 = board[7] + board[8] + board[9];
        int column1 = board[1] + board[4] + board[7];
        int column2 = board[2] + board[5] + board[8];
        int column3 = board[3] + board[6] + board[9];
        int diag1 = board[1] + board[5] + board[9];
        int diag2 = board[3] + board[5] + board[7];

        int playerXWins = playerX * 3;
        int playerYWins = playerY * 3;
        if (row1 == playerXWins || row2 == playerXWins | row3 == playerXWins ||
                column1 == playerXWins || column2 == playerXWins || column3 == playerXWins ||
                diag1 == playerXWins || diag2 == playerXWins) {
            return playerX;
        } else if (row1 == playerYWins || row2 == playerYWins | row3 == playerYWins ||
                column1 == playerYWins || column2 == playerYWins || column3 == playerYWins ||
                diag1 == playerYWins || diag2 == playerYWins) {
            return playerY;
        } else
            return playerUndefined;
    }

    protected void printGameBoard() {


        System.out.println(divider + printSlot(board[1])
                + divider + printSlot(board[2])
                + divider + printSlot(board[3])
                + divider
        );

        System.out.println(divider + printSlot(board[4])
                + divider + printSlot(board[5])
                + divider + printSlot(board[6])
                + divider
        );

        System.out.println(divider + printSlot(board[7])
                + divider + printSlot(board[8])
                + divider + printSlot(board[9])
                + divider
        );

        return;

    }

    protected String printSlot(int value) {
        switch (value) {
            case playerX:
                return playerXStr;
            case playerY:
                return playerYStr;
            default:
                return Integer.toString(value);
        }
    }


}
