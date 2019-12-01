// Name: Ajit Pandey
// USC NetID: ajitpand
// CS 455 PA4
// Fall 2019

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/* This class include main method. When user types ".", it quits the program. Otherwise, it keeps making loop for new Rack and prints all related word. 
 * This class creates an instance of AnagramDictionary class which runs AngramDictionary and getAnagramOf methods to find related anagrams for Rack word.
 * Then it initiates an instance of Rack class which facilitates printing of related words and its respective scrabble scores.
 */


public class WordFinder {

	public static void main(String[] args) throws IOException  {

		String fileName="";   // for file name
		boolean found = false;  // to continue the while loop for Rack loop.
		
		if (args.length != 0){
			fileName = args[0];
		} else if (args.length == 0) {
	           fileName = "sowpods.txt";
	        }

		try{
			AnagramDictionary anagram = new AnagramDictionary(fileName);   //instance of AnagramDictionary class
			System.out.println("Type . to quit.");
			Scanner in = new Scanner(System.in);
			while (!found){
				System.out.print("Rack? ");
				String word = in.next();         //stores the printed word on console
				if (word.equals(".")){
					break;
				}
			Rack rack = new Rack(word);      // instance of Rack class
			rack.printScrabble(anagram);     // this allows to print the words and respective score on console.
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File does not exist."+e.getMessage());
		}
	}
}
