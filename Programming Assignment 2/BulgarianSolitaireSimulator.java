import java.util.ArrayList;
import java.util.Scanner;

// Name:Ajit Pandey	
// USC NetID:ajitpand
// CSCI455 PA2
// Fall 2019


/**
   class BulgarianSolitaireSimulator
  The Simulator for Bulgarian SolitaireBoard. This holds the main class. 
  SolitaireBoard is initialized. User input is accepted. Single Step is accepted.
  SolitaireBoard constructors are fired depending upon the scenario.
  
  
  (See comments below next to named constant declarations for more details on this.)
*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
	   
	  Scanner in = new Scanner(System.in);   // Scammer to hold the user input as String.
	  SolitaireBoard userSolitaire;   // instance of SolitaireBoard
      boolean singleStep = false;     // for single Step for play
      boolean userConfig = false;      // for user input
      int turn =1;                     // stores number of tunr cards are puuled from piles. number of play round

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      // <add code here>
      if (userConfig) {

          System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
          System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
          System.out.println("Please enter a space-separated list of positive integers followed by newline:");

          String input = in.nextLine();   // user input
          int total=0;                     // this sums up the number of user input
          int initNumber;                  // each user input converted in to Integer
          String test ="";
          ArrayList<Integer> initList = new ArrayList<Integer>();  // This stores the initial ArrayList.
          
          for (int i =0; i < input.length(); i++){
        	  if((input.charAt(i) != ' ' ) && (!Character.isDigit(input.charAt(i)))){
        		  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
        		  break;
        	  } else {
        		  test = test + input.charAt(i);
        	  }
          }   
          Scanner toList = new Scanner(test);     // After verification of the user input, this scanner accepts a clean String.
         
         while (toList.hasNext()){
          initNumber = toList.nextInt();
	          if (initNumber < 0){
	          System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45.");
	          }
          initList.add(initNumber);
          total = total+initNumber;
           }

         if (total != SolitaireBoard.CARD_TOTAL){
        		System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45.");
        		}
          userSolitaire = new SolitaireBoard(initList);  // Constructor fired to create an instance of SOlitaireBoard class.
        } else {
          userSolitaire = new SolitaireBoard();         // Constructor fired to create an instance of SOlitaireBoard class.
        }
   
   // <add private static methods here>
      System.out.println("Initial Solitaire Config: "+userSolitaire.configString());
      
      if (singleStep) {
    	  playSingleStep(userSolitaire, in, turn);
      } else {
    	  playToDone(userSolitaire, turn);
      }
   }
   
   
   // This static method is used when user selects single step at command prompt. It takes an instance of SolitaireBoard class
   // and scanner for each step and number of turns.
   
   private static void playSingleStep(SolitaireBoard userSolitaire, Scanner in, int turn){
	   String nextStepPlay;  // this variable stores output of nextStep method.
	   
	   while(!userSolitaire.isDone()){
		   userSolitaire.playRound();
		   System.out.println("[" + turn +"]"+"Current configuration: "+userSolitaire.configString());
		   turn++;
		   System.out.println("<Type return to continue>");
		   nextStepPlay = nextStep(in);
	   }
	   System.out.println("Done!");
   }
   
      // This static method is used when there is no user input. It takes an instance of SolitaireBoard class
   // and number of turns. Intial configuration is initiated using Random class in java.
   
   private static void playToDone(SolitaireBoard userSolitaire, int turn){
	   while(!userSolitaire.isDone()){
		   userSolitaire.playRound();
		   System.out.println("[" + turn +"]"+"Current configuration: "+userSolitaire.configString());
		   turn++;
	   }
	   System.out.println("Done!");
   }
   
      // This static method is used when user selects single step at command prompt. It takes an instance of scanner for each step and 
   // and returns the String of nextLine on command prompt. This allows that user can press enter to move to next turn of game.
   
   private static String nextStep (Scanner in){
	   if (in.hasNextLine()){
		   String next = in.nextLine();  //next stores output of each turn.
		   return next;
	   } else{
		   return "End";
	   }
   }
   
}
