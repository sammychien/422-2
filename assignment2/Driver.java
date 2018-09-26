/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Sammy Chien
 * sc55852
 * Slip days used: <0>
 * Fall 2018
 */

package assignment2;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Game newGame;
		if (args.length != 1) {
			newGame = new Game(false);
		} else if (args[0].equals("1")) {
			newGame = new Game(true);
		} else {
			newGame = new Game(false);
		}
		Scanner input = new Scanner(System.in);
		newGame.runGame(input);
	}
}




/*
 * 1. Initialize the game
 * 		Get random code
 * 2. send initial greeting
 * 3. prompt user for new game
 * 4. depending on arg input to main, print secret code
 * 5. print number of guesses
 * 6. prompt user to enter guess
 * 7. input is user's guess
 * 8. determine whether guess is valid or invalid
 * 		8a. if invalid, do not change number of guesses left and print invalid guess
 * 		8b. if valid, then determine number of black and white pegs and decrement number of guesses
 * 9. if number of guesses reaches 0, and solution not found, 
 * 		print "You lose! The pattern was ____"
 * 		if soln found, then do that 
 * 10. prompt user for new game
 * 
 */
