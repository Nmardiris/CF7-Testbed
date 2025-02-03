package gr.aueb.cf.projects;

/*
 * Implements a simple Triliza game for two players.
 * Each player alternates turns to place their symbol (X or O) on a 3x3 board.
 * The game ends when one player wins or the board is full (draw).
 */

import java.util.Scanner;
import java.util.Arrays;

public class BoardGame {

    static char [] [] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        initializeBoard();                                  //Initialize the board with empty spaces
        boolean gameOn = true;
        while (gameOn) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter row and column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOn = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Draw!");
                    gameOn = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Position occupied! Try again.");
            }
        }
    }

    // Initializes the board by filling it with empty spaces
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) Arrays.fill(board[i], ' ');
    }

    // Prints the current state of the board
    static void printBoard() {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    //Checks if the current player has won
    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Checks if the board is full
    static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}
