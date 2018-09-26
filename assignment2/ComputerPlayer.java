/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Sammy Chien
 * sc55852
 * Slip days used: <0>
 * Fall 2018
 */

package assignment2;

public class ComputerPlayer {
	
	final public static char REPLACECHAR = '.';
	
	public static boolean checkGuessValidity(String playerGuess) {
		boolean localGuess = false;
		if ((playerGuess.length() == GameConfiguration.pegNumber)) {
			for (int i = 0; i < GameConfiguration.pegNumber; i++) {
				for (int j = 0; j < GameConfiguration.colors.length; j++) {
					if (Character.toString(playerGuess.charAt(i)).equals(GameConfiguration.colors[j])) {
						localGuess = true;
					}
				}
				if (!localGuess) {
					// guess at that index of playerGuess was invalid
					return false;
				}
				localGuess = false;
				
			}
			return true;
		} else {
			// invalid guess
			return false;
		}
	}
	
	public static String determinePegs(String secretCode, String inputGuess) {
		
		// secretCode and inputGuess are same length
		// first determine number of black pegs, and 
		
		char[] mutableSecretCode = secretCode.toCharArray();
		char[] mutableInputGuess = inputGuess.toCharArray();
		int black = 0; int white = 0;
		for (int i = 0; i < secretCode.length(); i++) {
			if (mutableSecretCode[i] == mutableInputGuess[i]) {
				black++;
				mutableSecretCode[i] = REPLACECHAR;
				mutableInputGuess[i] = REPLACECHAR;
			}
		}
		for (int i = 0; i < secretCode.length(); i++) {
			if (mutableSecretCode[i] != REPLACECHAR) {
				// check with all nonREPLACECHAR indexes of mutableInputGuess
				for (int j = 0; j < inputGuess.length(); j++) {
					if (mutableInputGuess[j] == mutableSecretCode[i]) {
						white++;
						mutableSecretCode[i] = REPLACECHAR;
						mutableInputGuess[j] = REPLACECHAR;
						break;
					}
				}
			}
		}
		
		return Integer.toString(black) + "b_" + Integer.toString(white) + "w";
	}
	
	
	
	/*
	 * - handles guesses
	 * Anyone who wants to play a game of MasterMind can create a new Game object, 
	 * and use that game object to call runGame
	 * They can also call any function in Board (console) or ComputerPlayer
	 * 
	 * 
	 */
	
}

// Adding another comment to test Github Desktop
// comment #??
