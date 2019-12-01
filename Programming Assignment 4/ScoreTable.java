// Name: Ajit Pandey
// USC NetID: ajitpand
// CS 455 PA4
// Fall 2019

import java.util.Arrays;

/* this class evaluates the individual scorers of scrabble word. It is called upon in getScrabble method in Rack class.
Pre:
*/
public class ScoreTable  {

	private final int[] scoreAllLetters;  //array individual letter score, final constant integger
	
	// Constructor for ScoreTable class. This creates instance of ScoreTable class. Initializes the individual score array for 26 alphabets.
	
	public ScoreTable(String word){
		scoreAllLetters = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		getScore(word);
	}
	
	// public method to calculate the individual word score. this returns an int in terms of total score of a word.
	
	public int getScore(String word){
		int totalScore =0;
		char tempChar = 'a';
		word = word.toLowerCase();
		char[] character = word.toCharArray();
		Arrays.sort(character);
		for (int i =0; i < character.length; i++){
			int temp = character[i] - tempChar;
			totalScore = totalScore + scoreAllLetters[temp];
		}
		return totalScore;
	}
}
