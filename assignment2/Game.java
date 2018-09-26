/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Sammy Chien
 * sc55852
 * Slip days used: <0>
 * Fall 2018
 */

package assignment2;

import java.util.Scanner;

public class Game {
	
//	public int guesses;
	private boolean isCodeSecret;
//	String secretCode;
//	String[] guessHistory;
	
	
	public Game(boolean val) {
		if (val == true) {
			// reveal secret code
			isCodeSecret = true;
		} else {
			// dont reveal secret code
			isCodeSecret = false;
		}
//		guesses = GameConfiguration.guessNumber;
	}
	
	public void runGame(Scanner input) {
		Board.greetingMessage();
		Board.askNewGame();
		// get input from scanner about new game
		while (input.nextLine().equals("Y")) {
		// run until user inputs a "N" or anything else 	
			this.gameLoop(input);
		}
	}
	
	private void gameLoop(Scanner input) {
		String secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		if (isCodeSecret) {
			//reveal secret code
			System.out.println("Secret code: " + secretCode);
		}
		int guesses = GameConfiguration.guessNumber;
		String[] guessHistory = new String[GameConfiguration.guessNumber];
		while (guesses != 0) {
			System.out.println();
			Board.printGuesses(guesses);
			Board.queryGuess();
			String playerGuess = input.nextLine();
			
			if (playerGuess.equals("HISTORY")) {
				Board.printHistory(guesses, guessHistory);
			} else if (ComputerPlayer.checkGuessValidity(playerGuess)) {
				// first reprint the user's guess
				System.out.print(playerGuess + " -> ");
				// determine black and white pegs for answer
				String guessResult = ComputerPlayer.determinePegs(secretCode, playerGuess);
				System.out.println(guessResult);
				if (guessResult.equals(GameConfiguration.pegNumber + "b_0w")) {
					// guessed correctly, 
					Board.printWinner();
					break;
				}
				// add the guess to HISTORY
				guessHistory[GameConfiguration.guessNumber - guesses] = playerGuess + " -> " + guessResult;
				guesses--;
				// guesses-- and check the guess for Black and White pegs
			} else {
				System.out.println("INVALID_GUESS");
			}
		}
		if (guesses == 0) {
			Board.printLoser(secretCode);
		}
		System.out.println();
		Board.askNewGame();	
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




/*
 * Class for each entity in the game:
 * Game board
 * pegs
 * colors 
 * codes
 * feedback results
 * computer player
 * human player
 * game runner
 * 
 * 
 * 
 * 
 * 
 */

