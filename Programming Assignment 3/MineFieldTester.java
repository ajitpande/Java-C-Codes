import java.util.Arrays;

// Name: Ajit Pandey
// USC NetID:ajitpand
// CS 455 PA3
// Fall 2019

// this class is for testing MineField class. Each method and variable are verified in this class. A mineData with 9x9 2D array is fed to the class and constructor.

public class MineFieldTester {
	
   public static void main(String[] args) {
	  
	  
      boolean[][] testerMineField = {
              {false, false, false, false, true, false, false, true, false},
              {false, true, false, false, true, false, false, true, false},
              {false, false, true, false, false, false, false, false, false},
              {false, false, false, false, false, false, false, true, false},
              {false, false, false, false, false, false, false, false, false},
              {false, false, false, false, true, false, false, true, false},
              {false, false, false, false, false, false, false, false, false},
              {false, false, false, false, false, false, false, false, false},
              {false, false, false, false, false, false, false, true, false},
         };
      
      int numberRows = testerMineField.length;   // number of rows in mineData
      int numberCols = testerMineField[0].length; // number of columns in mineData
      
      MineField mineField = new MineField(testerMineField);     //instance variable of MineField class
      System.out.println("The mineData for MineField Constructor is: "+"\n"+mineField.toString());
      System.out.println();

      System.out.println("numRows() Expected [9] : "+mineField.numRows() );  //testing number of rows
      System.out.println("numCols() Expected [9] : "+mineField.numCols());   //testing number of columns
      System.out.println();
      
      mineField.populateMineField(4, 5);
      System.out.println("addMines (number of Mines added) Expected[10]: "+mineField.numMines());
      System.out.println("The mineData for MineField with populateMineField() is: "+"\n"+mineField.toString());
      System.out.println();

      //New MineField Instance Variable to send the original values for testing. populateMineField creates random mines. So sending back to original amineData for testing.
     
      MineField mineFieldTest = new MineField(testerMineField);   
      
      System.out.println("numAdjacentMines() method output:");
      int[][] testAdjacent = new int[numberRows][numberCols];
      for (int i = 0; i < numberRows; i ++) {
         for (int j = 0; j < numberCols; j ++) {
            testAdjacent[i][j] = mineFieldTest.numAdjacentMines(i, j);
         }
      }
           
      for (int i = 0; i < testAdjacent.length; i ++) {
     	 
          System.out.println(Arrays.toString(testAdjacent[i]));
       }
      
      System.out.println();
      
      

      System.out.println("inRange(int row, int col) Method output:");
      System.out.println("Expected [false] :" + mineFieldTest.inRange(9, 9));
      System.out.println("Expected [false] :" + mineFieldTest.inRange(1, 10));
      System.out.println("Expected [false] :" + mineFieldTest.inRange(10, 1));
      System.out.println("Expected [false] :" + mineFieldTest.inRange(-2, -4));
      System.out.println("Expected [true] :" + mineFieldTest.inRange(5, 8));
      System.out.println("Expected [true] :" + mineFieldTest.inRange(6, 5));
      System.out.println("Expected [true] :" + mineFieldTest.inRange(8, 8));
      System.out.println();

      System.out.println("hasMine(int row, int col) Method output: ");
      System.out.println("Expected [false] :" + mineFieldTest.hasMine(1, 0));
      System.out.println("Expected [true] :" + mineFieldTest.hasMine(1, 4));
      System.out.println("Expected [false] :" + mineFieldTest.hasMine(4, 2));
      System.out.println("Expected [true] :" + mineFieldTest.hasMine(5, 7));
      System.out.println("Expected [true] :" + mineFieldTest.hasMine(5, 4));
      System.out.println("Expected [false] :" + mineFieldTest.hasMine(8, 0));
      System.out.println();


   }

      
 }


