// Name: Ajit Pandey
// USC NetID: ajitpand
// CS 455 PA4
// Fall 2019

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   
	private Map<String, ArrayList<String>> anagramWord;     // variable for AnagramDictionary
	

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   ArrayList<String> list = new ArrayList<String>();        				// to store each word for given word key in an arrayList.
	   anagramWord = new TreeMap<String, ArrayList<String>>();                 //to store Anagrams as TreeMap
	   File file = new File(fileName);
	   Scanner in = new Scanner(file);
	   while(in.hasNext()){
		   String keyWord ="";
		   String word = in.next();                   
		   char[] character = word.toCharArray();     // breaks the characters of a word
		   Arrays.sort(character);
		   for (int i=0; i < character.length; i++){
			   keyWord += character[i];                        // keyWord stores the Rack word in alphabetical order
		   }
		   ArrayList<String> val = anagramWord.get(keyWord);   // val checks if key is present in TreeMap.
		   if((val == null)) {
			   anagramWord.put(keyWord, new ArrayList<String>());
            }
		   anagramWord.get(keyWord).add(word);
	   }
   }
  
   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
	   String keyWord = "";
	   ArrayList<String> list =new ArrayList<String>();   // to store each word for given word key in an arrayList.
	   char[] character = s.toCharArray();
	   Arrays.sort(character);
	   for (char Char : character){
		   keyWord +=Char;
	   	}
	   ArrayList<String> val = anagramWord.get(keyWord);   // val checks if key is present in TreeMap.
	   if (val == null){
		   return null;
	   	}
       return new ArrayList<String>(anagramWord.get(keyWord));
   	}
}
