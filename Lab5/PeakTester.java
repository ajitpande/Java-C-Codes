//Name: Ajit Pandey
//USC Net ID: AJITPAND
//CS455 Fall 2019

/* 
 * Contains hasPeak method and
 * tests it on a bunch of hardcoded test cases, printing out test
 * data, actual results, and a FAILED message if actual results don't
 * match expected results.
 */

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PeakTester {


   /*
    * see lab assgt for specification of hasPeak method.
    */
   public static boolean hasPeak(LinkedList<Integer> list) {
      boolean done=false;
      int tempLeft =0; //count for peak number from left side
      int tempRight =0; // count for peak number from right side
      
      if (list.size() ==0){
         return done;
      } else if (list.size() <3){
         return done;
      } else {
         
         for (int i =0; i<list.size()-1;i++){

            if (list.get(i)> list.get(i+1)){
               tempLeft=i;
               break;
            }
         }

         for (int j =list.size()-1; j>0;j--){

            if (list.get(j)> list.get(j-1)){
               tempRight=j;
               break;
            }
         }
                  
         if (tempLeft == 0 ){
            return done;
         } else if (tempLeft == list.size()){
            return done;
         } else if ( (tempLeft == tempRight)) {
            done = true;
         }
      }    
      return done; 
   }



   public static void main(String args[]) {

      testPeak("", false);
      testPeak("3", false);
      testPeak("3 4", false);
      testPeak("4 2", false);
      testPeak("3 4 5", false);
      testPeak("5 4 3", false);
      testPeak("3 4 5 3", true);
      testPeak("3 4 5 3 2", true);
      testPeak("3 7 9 11 8 4 3 1", true);
      testPeak("3 5 4", true);
      testPeak("4 3 5", false);
      testPeak("2 4 3 5", false);
      testPeak("5 2 4 3 5", false);
      testPeak("5 2 4 3", false);
      testPeak("2 4 3 5 2", false);  // 2 peaks
   }

    
    
   /*  Assumes the following format for listString parameter, shown by example
    * (first one is empty list):
    *   "", "3", "3 4", "3 4 5", etc.
    */
   private static LinkedList<Integer> makeList(String listString) {
      Scanner strscan = new Scanner(listString);

      LinkedList<Integer> list = new LinkedList<Integer>();

      while (strscan.hasNextInt()) {
         list.add(strscan.nextInt());
      }

      return list;
   }


   /* Test hasPeak method on a list form of input given in listString
    * Prints test data, result, and whether result matched expectedResult
    *
    * listString is a string form of a list given as a space separated
    * sequence of ints.  E.g.,
    *  "" (empty string), "3" (1 elmt string), "2 4" (2 elmt string), etc.
    *
    */
   private static void testPeak(String listString, boolean expectedResult) {

      LinkedList<Integer> list = makeList(listString);

      boolean result = hasPeak(list);
      System.out.print("List: " + list
                       + " hasPeak? " + result);
      if (result != expectedResult) {
         System.out.print("...hasPeak FAILED");
      }
      System.out.println();
   }
}
