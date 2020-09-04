package ckonta_p1;


/**
 * the TicTocToe function contain the game board element
 *
 *@author cheick
 *@version 1.9
 */
public class TicTacToeX {

    //declaring arrray size
    final int ARRAYSIZE, countie = 0, countWinX = 0, countWinO = 0;
    //declaring marker 1
    char marker1;
    //declaring marker 2
    char marker2;
    //declaring array
    public char[][] board;
    //declaring turn
    char turn;

    /**
     * constructore is use to declare variables
     *
     * @param size containe array soze
     */
    public TicTacToeX(int size) {
        //assigning array size
        ARRAYSIZE = size;
        //creating an array object
        board = new char[ARRAYSIZE][ARRAYSIZE];
    }


    /**
     * setPlayer fucntion  will take input from main and assign marker to
     * player 2
     *
     * @param PLAYER1MARKER marker for player 1
     * @return turn to rotate between players
     */
    public char setPlayer(char PLAYER1MARKER) {
        //if player one choose marker one
        if (PLAYER1MARKER == marker1)
            //set turn to player marker 2
            turn = marker2;
        else {
            //else set turn to marker one
            turn = marker1;
        }
        //return turn
        return turn;
    }

    /**
     * SetMarker function
     * @param marker1 represent X
     */
    public void setMarker(char marker1) {
        //assigning marker one
        this.marker1 = marker1;
        //if marker one is equal to X
        if (marker1 == 'X') {
            //assigned marker two to O
            marker2 = 'O';
        } else
            //or marker 2 equal X
            marker2 = 'X';
        //return turn
        turn = marker1;

    }

    /**
     * function will set board base on array
     */
    public void setBoard() {
        //loop to fill the board with characters (_)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '_';
            }
        }
    }
    /**
     * function will print game board
     */
    public void printBoard() {
        //for loop to print titles
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t " + i + "  ");
        }
        //new line
        System.out.println();
        //print board dividers
        for (int i = 0; i < board.length; i++) {
            System.out.print(i);
            for (int j = 0; j < board.length; j++) {
                System.out.print("\t" + board[i][j] + "   |  ");
            }
            //new line
            System.out.println();
            System.out.println();
        }
        //new line
        System.out.println();
    }

    /**
     * function to uodate the game board
     *
     * @param row number collected from user
     * @param col number collected from user
     */
    public void upDateBoard(int row, int col) {
        //uodate bord with user marker
        if (board[row][col] == '_')
            board[row][col] = turn;
        //call print board function
        printBoard();
    }
    /**
     * function will check if board is full or not by looking for the special
     * character (_)
     *
     * @return true or false if board if full
     */
    public boolean checkBoardFull() {
        //set boardfull to true
        boolean boordFull = true;
        //loop to to chack the entire board
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                if (chars[j] == '_') {
                    //set boardfull to false if special character is found
                    boordFull = false;
                    break;
                }
            }
        }
        //return boardfull
        return boordFull;
    }

    /**
     * check if board is already occupy with a marker
     *
     * @return true or false if board as a marker
     */
    public boolean isBoardTake(int row, int col) {
        //boadTake is set to false
        boolean boardTake = false;
        //if board has any of the following characters X or O
        if (board[row][col] == 'X' || board[row][col] == 'O') {
            //set it to true
            boardTake = true;
            //inform user
            System.out.println("Bad location; Try again!");
        }
        //return boardTake
        return boardTake;
    }

    /**
     * game over function check if the game is over
     *
     * @param row variable from user
     * @param col variable from user
     * @return true or false if condition is satisfy
     */
    public boolean gameOver(int row, int col) {
        //declaring and setting four booleen variables to true
        boolean winRow = true;
        boolean winCol = true;
        boolean winDiag1 = true;
        //loop to check the rows for mach marker
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != turn) {
                winRow = false;
            }
        }
        //loop to check columns for mach marker
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != turn) {
                winCol = false;
            }
        }
        //check diagonal one for match marker
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != turn) {
                winDiag1 = false;
            }
        }
        //check diagonal two for match marker
        boolean winDiag2 = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                if (i + j == board.length - 1) {
                    if (board[i][j] != turn) winDiag2 = false;
                }
        }
        //if the following equal true
        //return true
        return winRow == true || winCol == true || winDiag1 == true || winDiag2 == true;
        //if not return false
    }

}
