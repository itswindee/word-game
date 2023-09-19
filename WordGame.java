import java.util.*;

public class WordGame {

    private char[][] board;
    private boolean[][] truthBoard;

    public WordGame(int size) {
        this.board = new char[size][size];
        this.truthBoard = new boolean[size][size];
        fillBoard(board, size);
        fillTruthBoard(truthBoard, size);
    }


    //create a method fillBoard()
    public void fillBoard(char[][] board, int size) {
        int row, col;
        char myChar = 'A';
        int totalEntries = 0;
        do {
            int counter = 0;
            while (counter < 2) {
                row = randomNum(size);
                col = randomNum(size);
                if (board[row][col] == '\u0000') {
                    board[row][col] = myChar;
                    totalEntries++;
                    counter++;
                }
            }
            myChar++;
        } while (totalEntries != size * size);
    }

    public void fillTruthBoard(boolean[][] truthBoard, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                truthBoard[i][j] = false;
            }
        }
    }

    //method printBoard()
    public void printBoard(int size) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < size * 2; i++) {
            System.out.print('-');
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < size; j++) {
                if (this.truthBoard[i][j]) {
                    System.out.print(this.board[i][j] + " ");
                } else
                    System.out.print("+ ");
            }
            System.out.println();
        }
    }

    //random number generator function
    public static int randomNum(int input) {
        Random randNum = new Random();
        return randNum.nextInt(input);
    }

    //method to show the entire board
    public void printRevealedBoard(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
    }

    //method showPosition() that sets revealed to true on a specific space
    public void showPosition(int row, int col) {
        this.truthBoard[row][col] = true;
    }


    //method hidePosition() which does the opposite of show position
    public void hidePosition(int row, int col) {
        this.truthBoard[row][col] = false;
    }


    //method allRevealed() which will tell you whether every spot has been found or not
    public boolean allRevealed(int size) {
        int notRevealed = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!this.truthBoard[i][j]) {
                    notRevealed++;
                }
            }
        }
        if (notRevealed != 0) {
            return false;
        } else
            return true;
    }

    public boolean match(int row1, int col1, int row2, int col2) {
        if (this.board[row1][col1] == this.board[row2][col2])
            return true;
        else
            return false;
    }
}

