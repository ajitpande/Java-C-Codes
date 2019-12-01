// Name:Ajit Pandey
// USC NetID: ajitpand
// CSCI455 PA2
// Fall 2019

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total 
  number of cards is for the game by changing NUM_FINAL_PILES, below.  
  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.  (See comments 
  below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt 
   // description for details.1``
   
   
   /** 
      Representation invariant:

      <put rep. invar. comment here>
      The summation of all elements (piles) in initSolitaire at all times should be equal to CARD_TOTAL.
      All elements(piles) should be positive integer.
      All elements must be less than CARD_TOTAL.

   */
   
   // <add instance variables here>
   Random randomNumber = new Random(); //this is used when user input is not provided.
   private int[] initSolitaire = new int[CARD_TOTAL]; //initSolitaire stores each pile as an array element
 
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of 
      cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to 
      SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {

     for (int i = 0; i < piles.size(); i++){
    	 initSolitaire[i] = piles.get(i);
     }
	   // sample assert statement (you will be adding more of these calls)
      // this statement stays at the end of the constructor.
      assert isValidSolitaireBoard();   
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration. This will be used when user does not 
      provide initial numbers for piles. This will use Random number generation class.
      Another thing to note here that all operations are linear in this method, O(n) order. no two for loop used.
   */
   public SolitaireBoard() {
	   int initNumber = CARD_TOTAL; //initNumber is equal to CARD_TOTAL and it is used to calculate the initiasl solitaire configuration.
	   for (int i =0; i < initSolitaire.length; i++){
		   if (initNumber > 0){
			   initSolitaire[i] = randomNumber.nextInt(initNumber)+1;
			   initNumber = initNumber - initSolitaire[i];
		   } else {
			   break;
		   }
	   }
	   assert isValidSolitaireBoard();  
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration 
      according to the rules of Bulgarian solitaire: Takes one card from each
      pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
      Per Bulgarian Solitaire rules, zero is replaced by next pile with integer element.
      In this case, zero will be counted in each subtraction and total number of non-zero elements at the beginning of the
      round will be added to the place where zero elements starts in initSolitaire. basically all elements after this introduction 
      will be zero up to CARD_TOTAL element.
      
      Another thing to note here that all operations are linear in this method, O(n) order. no two for loop used.
      
   */
   public void playRound() {
	   int count =0;        // it counts the number of elements those undergo substraction, means how many cards are pulled in new pile.
	   int countZero = 0;   // this counts number of piles which have no cards left. This helps to move the array.
   
	   for (int i = 0; i< initSolitaire.length; i++){
		   initSolitaire[i] = initSolitaire[i]-1;
		   if (initSolitaire[i] == 0){
			   countZero++;
			   count++;
		   } else if (initSolitaire[i] > 0){
			   initSolitaire[i-countZero] = initSolitaire[i];
			   count++;
		   } else {
			   initSolitaire[i] =0;
		   }
	   }
	   initSolitaire[count - countZero]= count;
	   
	   for (int i = count-countZero+1; i < initSolitaire.length; i++){
		   initSolitaire[i] = 0;
	   }
	   
	   assert isValidSolitaireBoard();
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, 
      there are NUM_FINAL_PILES piles that are of sizes 
      1, 2, 3, . . . , NUM_FINAL_PILES, 
      in any order.
      Another thing to note here that all operations are linear in this method, O(n) order. no two for loop used.
      
   */
   
   public boolean isDone() {

	   boolean done = true;
	   
      // This is used to develop a new array which stores number 1 and is used to conclude that the final BulgarianSoltaire numbers
      // are ready, 1, 2, 3, 4, 5, 6,7, 8, 9
      // Another thing to note here that all operations are linear in this method, O(n) order. no two for loop used.
      // count variable counts the sum of all the elements of finalSolitaire array.
      
       int[] finalSolitaire = new int[NUM_FINAL_PILES];  
	   int count = 0;
	   for (int i =0; i< NUM_FINAL_PILES; i++){
		   if ((initSolitaire[i]-1) < NUM_FINAL_PILES && (initSolitaire[i]-1) >= 0){
			   finalSolitaire[(initSolitaire[i]-1)] = 1;
		   }
	   }
	   for (int i =0; i < NUM_FINAL_PILES; i++){
		   count = finalSolitaire[i]+count;
	   }
	   if (count == NUM_FINAL_PILES){
		   done = true;
	   } else {
		   done = false;
	   }
	   assert isValidSolitaireBoard();
	   return done;  
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
      
      string is used to store the output and displayed after each turn.
      
      Another thing to note here that all operations are linear in this method, O(n) order. no two for loop used.
      
   */
   public String configString() {
	   String string = "";
	   for (int i=0; i < initSolitaire.length-1; i++){
		   if (initSolitaire[i] != 0 && initSolitaire[i+1] ==0){
			   		string = string+ initSolitaire[i];
			   } else if (initSolitaire[i] != 0 && initSolitaire[i+1] !=0 ){
				   string = string+ initSolitaire[i]+ " ";
		   } else {
			   string = string;
		   }
	   } 
	   if (initSolitaire[initSolitaire.length-1] !=0){
		   string = string + initSolitaire[initSolitaire.length-1];
	   }
	   
	   assert isValidSolitaireBoard();
	   return string;   
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      int sumPiles = 0;
      int count = 0;
	  for (int i = 0; i < initSolitaire.length; i++){ 
		  sumPiles = initSolitaire[i]+ sumPiles;
	  }
	  if ((initSolitaire.length == CARD_TOTAL) || (sumPiles == CARD_TOTAL)){
		  return true;
	  } else {
		  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
		  return false;  
		
	  }
   }
   

   // <add any additional private methods here>


}
