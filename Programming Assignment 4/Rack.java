// Name: Ajit Pandey
// USC NetID: ajitpand
// CS 455 PA4
// Fall 2019

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


/**
   This class is for developing a Rack of Scrabble tiles.
   Constructor accepts the String and includes GetScrabble(..), printScrabble(..) and allSubsets(..) methods. I 
   Pre: compares the scores and words to assure thatthey are printed in decreasing order of individual scores.
   
 */

public class Rack {
	private Map<Character,Integer> rack;       // to store Rack as a Map
	private Map<String,Integer> rackList;      //this stores the unique character and their respective frequency
	private String rackWord;      			// Rack word entered on console. This allows to race the original word typed on Rack at console.
	private int[] numOfTimes;         //to store frequency of number of words in a rack word

	//constructor for Rack class. It initiates the rack in to unique characters and stores the frequency of each character. initializes numOfTimes array for allSubSets method of this class.
	
	public Rack(String str) {
	      rack = new TreeMap<Character, Integer>();
	      if (str.length() == 0) {
	          str = "";
	          numOfTimes = new int[]{};
	      }
	      for (int i = 0; i < str.length(); i++) {
	    	  Integer val = rack.get(str.charAt(i));
	          if (!(val == null)) {
	              rack.put(str.charAt(i), rack.get(str.charAt(i)) + 1);
	          } else {
	              rack.put(str.charAt(i), 1);
	          }
	      }
	      numOfTimes = new int[rack.size()];
	      rackList = new TreeMap<String,Integer>();
	      this.rackWord = str;
	   }
    
	
	//method to build the scrabble words and their respective scores. Utilizes AnagramDictionary and ScoreTable classes. Class upon allSubsets method 
	//from this class to find all subsets of given word
	
	private void getScrabble(AnagramDictionary dictionary) {
	      String uniqueStr = "";									//Unique word from Rack, e.g. leer > elr
	      int index= 0;
	      for (Map.Entry<Character, Integer> entry : rack.entrySet()) {
	          uniqueStr = uniqueStr + entry.getKey();
	          numOfTimes[index] = entry.getValue();
	          index++;
	      }
	      ArrayList<String> stringArrayList = allSubsets(uniqueStr, numOfTimes, 0);
	      for(String subset : stringArrayList) {
	    	  ArrayList<String> val = dictionary.getAnagramsOf(subset);
	         if (val != null) {
	            for (String target : dictionary.getAnagramsOf(subset)) {
	               ScoreTable table = new ScoreTable(target);					// an instance of ScoreTable class to calculate the scores of respective word tiles
	               rackList.put(target, table.getScore(target));
	            }
	         }
	      }
	   }
	
	//a method used by WordFinder class main method. This facilitates the print of scrabble words in order of their scores.
	
	public void printScrabble(AnagramDictionary dictionary) {
	      getScrabble(dictionary);
	      ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
	      for(Map.Entry<String, Integer> rackAll : rackList.entrySet()) {
	         list.add(rackAll);
	      }
	      Collections.sort(list, new RackComparator());       //Utilizes Comparator interface for sorting the list and display as decreasing order of individual scores.
	      int size = rackList.size();						// size of the ArrayList which stores the entry from all words.
	      System.out.println("We can make " + size + " words from " + "\"" + rackWord + "\"");
	      if(list.size() > 0) {
	         System.out.println("All of the words with their scores (sorted by score):");
	         for (Map.Entry<String, Integer> rackAll : list) {
	            System.out.println(rackAll.getValue() + ": " + rackAll.getKey());
	         }
	      }
	   }
	
	
   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
// Comparator interface implemented by an external class. This allows to compare object Integer which does not use Comparables. String use 
//compareTo() method from Comparable a part of Object class.

class RackComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> rackAll1, Map.Entry<String, Integer> rackAll2) {
       String rackWord1 = rackAll1.getKey();       // Stores Integer value from TreeMap
       String rackWord2 = rackAll2.getKey();	    // Stores Integer value from TreeMap     
       int rackScore1 = rackAll1.getValue();      // Stores String value from TreeMap
       int rackScore2 = rackAll2.getValue();     // Stores String value from TreeMap
       
       if (rackScore1 != rackScore2){           
      	 return rackScore2-rackScore1;            // arranges Integer values in descending order
       }
       else {
          return rackWord1.compareTo(rackWord2);  // for same score it arranges alphabetically increasing order
       }
    }
 }