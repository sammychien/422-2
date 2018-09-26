/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Sammy Chien
 * sc55852
 * Slip days used: <0>
 * Fall 2018
 */

package assignment2;

public class Board {
	// does everything pertaining to console
	
	public static void greetingMessage() {
		System.out.println("Welcome to Mastermind.");
	}
	
	public static void printGuesses(int guesses) {
		System.out.println("You have " + guesses + " guess(es) left.");
	}
	
	public static void askNewGame() {
		System.out.println("Do you want to play a new game? (Y/N):");
	}
	
	public static void queryGuess() {
		System.out.println("Enter guess:");
	}
	
	public static void printWinner() {
		System.out.println("You win!");
	}
	
	public static void printLoser(String secretCode) {
		System.out.println("You lose! The pattern was " + secretCode);
	}
	
	public static void printHistory(int guesses, String[] guessHistory) {
		for (int i = 0; i < (GameConfiguration.guessNumber - guesses); i++) {
			System.out.println(guessHistory[i]);
		}
	}
	
}
