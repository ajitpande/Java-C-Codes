import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

/**
 * Finds frequency of each word in a file.
 * Unlike the lecture version of this code, this one is smarter
 * about what it considers a word.
 *
 * Version for the lab.
 */

public class ConcordDriver {


   public static void main(String[] args) {
	       
	  Concord concord = new Concord(Collections.reverseOrder());
	  
	  
	  File inFile = new File("poe.txt");
	  
	  try
      {
         Scanner in = new Scanner(inFile);
         concord.addData(in);
      }
	  catch (FileNotFoundException exception)
      {
         System.out.println("File not found.");
      }
	
      //concord.print(System.out);

      concord.printSorted(System.out);
		
   }

}
