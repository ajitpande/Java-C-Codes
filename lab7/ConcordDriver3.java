import java.util.Scanner;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Finds frequency of each word in a file.  
 * (Version for Exercise 3.)
 *
 * Optional command line argument is the threshold for the number of
 * letters a word must have to be printed with its number of occurrences.
 *
 * If argument isn't given, prints all words and number of occurrences.
 *
 */

public class ConcordDriver3 {


   public static void main(String[] args) {

      int threshold = 0;

      if (args.length > 0) {
         threshold = Integer.parseInt(args[0]);
      }

      Concord concord = new Concord();
		
     Predicate testLarge = new LargeWordPred(threshold);
      
     Scanner readfile = new Scanner(System.in);
  	 File inFile = new File("melville.txt");

      try
	    {
	     Scanner in = new Scanner(inFile);
	     concord.addData(in);
	     }
	 catch (FileNotFoundException exception)
	     {
	      System.out.println("File not found.");
	     }

      concord.printSatisfying(System.out, testLarge);		
		

      // add code here to print out the selected entries
		
   }

}

   class LargeWordPred implements Predicate{

	   private int number;
	
	   public LargeWordPred (int threshold){
		this.number = threshold;
	   }
	   
      public boolean predicate(Map.Entry<String,Integer> item){

		if(item.getKey().length() >= number && !(item.getKey().contains("-"))){
        return true;
		}

       return false;

	   }
   }
