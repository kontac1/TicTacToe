package ckonta_p1;

import java.util.Scanner;

/**
 * the p1 function will play the game and call other function from TicTocToe
 *
 * @version 1.0
 * @author: Cheick
 */
public class P1X {
    //declaring variables to count wins or tie
    static int countTie = 0, countWinX = 0, countWinO = 0;

    /**
     * the function call other function to play the program
     *
     * @param args contain command line argument
     */
    public static void main(String[] args) {
        //creating a scanner object
        Scanner input = new Scanner(System.in);
        //new line
        System.out.println();
        //Ask user for board size
        System.out.print("What size of board do you want to choose (it has to be even number): ");
        //store user input
        int size = input.nextInt();


        //declaring variable to repeat the game
        String line;
        //declaring variable to store user input when repeating the program
        char choice;


        //new line
        System.out.println();
        //calling welcome function
        welcome();
        //do loop to repeat the game
        do {

            //calling gam play function
            gamePlay(size);
            //ask user if they will like to repeat the game
            System.out.print("Would you like to play again? : ");
            //store user input
            line = input.next();
            //store character
            choice = line.charAt(0);


            //validate user input
        } while (choice == 'y' || choice == 'Y');
        //new line
        System.out.println();

        //close scanner
        input.close();

    }

    /**
     * the game function function conatain the command to play the game
     *
     * @param SIZE array size pass by main
     */
    public static void gamePlay(int SIZE) {
        //declaring col and row
        int row, col;
        //create constructor object
        TicTacToeX object = new TicTacToeX(SIZE);
        //create a scanner object
        Scanner input = new Scanner(System.in);
        //assigning marker one playerName
        char Marker1 = playerName();

        //calling setplayer function and pass marker one
        object.setMarker(Marker1);
        //new line
        System.out.println();
        //call setboard function
        object.setBoard();

        //bollen to check if win equal false
        boolean win = false;
        //call print board function
        object.printBoard();

        //while loop to check if not game is not win
        while (!win) {

            boolean boardTake = false;
            //new line
            System.out.println();

            //do loop to validate user inout
            do {
                //prompt user for row and col input
                System.out.println(Marker1 + ", it is your turn!");
                System.out.print("Enter a row number: ");
                //store user input
                row = input.nextInt();
                System.out.print("Enter a column number: ");
                //store input from user
                col = input.nextInt();
                //consuming new line
                input.nextLine();
                //new line
                System.out.println();
                //valid user input
                if ((row < SIZE && col < SIZE) && (row >= 0 && col >= 0))
                    //assigne boardtake to boadfull
                    boardTake = object.isBoardTake(row, col);
                //check user input
            } while ((row >= SIZE || col >= SIZE) || (row < 0 || col < 0) || boardTake);
            //new line
            System.out.println();
            //update board with user input
            object.upDateBoard(row, col);
            //assigning win to gameOver function
            win = object.gameOver(row, col);
            //if win
            if (win) {
                //print the following
                System.out.println(object.turn + ", Is a winner!");
                //if marker is X
                if (Marker1 == 'X') {
                    //increment win point for X
                    countWinX++;
                } else {
                    //increment win point for 0
                    countWinO++;
                }

            }
            //creating a booleen full to set to checkboard
            boolean full = object.checkBoardFull();
            //check if board is fulll and no winner
            if (full && win == false) {
                //print message
                System.out.println("Game is tie - No winner!");
                //set win to true
                win = true;
                //increment number of tie
                countTie++;
            }
            //new line
            System.out.println();
            //set player marker equal to
            Marker1 = object.setPlayer(Marker1);

        }
        //call game stats funcion
        gameStats();

    }

    /**
     * game stats function will calculate the number of tie, X win and O win
     */
    public static void gameStats() {
        //print the following text on user screen
        System.out.println("Game stats: ");
        System.out.println("There have been " + countTie + " tie game");
        System.out.println("X  has won " + countWinX + " time");
        System.out.println("O has won " + countWinO + " time");
        System.out.println();


    }

    /**
     * playerName function to collect player name
     *
     * @return return name marker
     */
    public static char playerName() {
        //create a scanner object
        Scanner input = new Scanner(System.in);
        //prompt user for name
        System.out.print("Please enter player one name: ");
        //store input
        String player1 = input.next();
        //prompt user for second player name
        System.out.print("Please enter player two name: ");
        //store input
        String player2 = input.next();
        input.nextLine();
        //print new line
        System.out.println();
        //passing player one name to set marker
        char Marker1 = setMarker(player1);
        //return marker
        return Marker1;

    }

    /**
     * set marker function will assigning X or O to player 1 and assigne the
     * remaining character to player two
     *
     * @param player1 return player1 marker
     * @return playerMarker
     */
    public static char setMarker(String player1) {
        //create scanner object
        Scanner input = new Scanner(System.in);
        //prompt user to select marker
        System.out.print(player1 + ", select a marker between X and O: ");
        //store input
        char PLAYER1MARKER = input.next().charAt(0);
        //validate user input to check make sure they enter X or O
        while (PLAYER1MARKER != 'X' && PLAYER1MARKER != 'O') {
            //prompt user for indication
            System.out.print("Invalid marker! Please select between X and O: ");
            //store input
            PLAYER1MARKER = input.next().charAt(0);
        }
        //return player
        return PLAYER1MARKER;
    }

    /**
     * welcome function will print the welcome message
     */
    public static void welcome() {
        //new line
        System.out.println();
        //print welcome message
        System.out.print("Welcome to TicTacToe!");
        //print new line
        System.out.println('\n');
    }

}
