//Name:Ajit Pandey
//USC NetID:ajitpand
//CSCI 455 Fall 2019
//Lab 4
/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
import java.util.ArrayList;
import java.util.Arrays;


public class Nums {

private ArrayList<Integer> number;
   /**
      Create an empty sequence of nums.
   */
   public Nums () {
      number = new ArrayList<Integer>();

   }

   /**
      Add a value to the end of the sequence.
   */
   public void add(int value) {
	   number.add(value);
   }


   /**
      Return the minimum value in the sequence.
      If the sequence is empty, returns Integer.MAX_VALUE
   */
   public int minVal() {
	  
      
       if(number.size() == 0){
           return Integer.MAX_VALUE;
       } else {
    	   		 int min = number.get(0);
    	   		 for (int i = 1; i < number.size(); i++){
    	   			 if (number.get(i) < min ){
    	   				 min = number.get(i);
    	   			 }
    	   		 }
	   
         return min; //stub code to get it to compile  
	   }
       }

   /**
      Prints out the sequence of values as a space-separated list 
      on one line surrounded by parentheses.
      Does not print a newline.
      E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
   */
   public void printVals() {
	   	   
	   System.out.print("(");
	   if (number.size() ==0){
		   System.out.print(")");
	   } else {
		   for (int i=0; i < number.size()-1; i++){
			   System.out.print(number.get(i)+" "); 
		   	}
		   System.out.print(number.get(number.size()-1)+")");
	   }	
	   
	     
    	  
      
	   
   }

   /**
      Returns a new Nums object with all the values from this Nums
      object that are above the given threshold.  The values in the
      new object are in the same order as in this one.
      E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
      returns      (19 21 19)
      myNums after call:  (3 7 19 4 21 19 10)
      The method does not modify the object the method is called on.
   */
   public Nums valuesGT(int threshold) {

      int m = threshold;
     Nums newNumber = new Nums();
      for (int i=0; i< number.size(); i++){
    	  if (number.get(i) > m){
    		  newNumber.add(number.get(i));
    	  }
      }
	   
	   return newNumber;  // stub code to get it to compile

   }

    
}