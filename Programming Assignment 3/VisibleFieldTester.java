import java.util.Arrays;

// Name: Ajit Pandey
// USC NetID:ajitpand
// CS 455 PA3
// Fall 2019

// this class is for testing VisibleField class. Each method and variable are verified in this class. A mineData with 9x9 2D array is fed to the class and constructor.

public class VisibleFieldTester {
   public static void main(String[] args) {
      boolean[][] testerVisField = {
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
      
      int rows = testerVisField.length;    // row length of 2D mineData
      int cols = testerVisField[0].length; // column length of 2D mineData

      MineField  mineFiTest= new MineField(testerVisField);   // instance variable of MineField class
      VisibleField visFieldTest = new VisibleField(mineFiTest); //instance variable of VisibleField Class
      
      System.out.println("The mineData for MineField Constructor is: "+"\n"+mineFiTest.toString());
      System.out.println();
      System.out.println("The mineData for VisibleField Constructor is: "+"\n"+visFieldTest.toString());
      System.out.println("Game Over Expected[false]: "+visFieldTest.isGameOver());
      System.out.println("Number of Mines Left in VisibleField Expected[10]: "+visFieldTest.numMinesLeft());
      System.out.println("Number of Mines Left in MineField Expected[10]: "+mineFiTest.numMines());
      System.out.println();
      
      System.out.println("The mineField that this VisibleField covers [expected same testerVisField]: "+"\n"+visFieldTest.getMineField());
      System.out.println();

      System.out.println("numAdjacentMines() method output:");
      int[][] vizAdjacent = new int[rows][cols];     // this is to check number of adjacent mines
      
      for (int i = 0; i < rows; i ++) {
         for (int j = 0; j < cols; j ++) {
        	 vizAdjacent[i][j] = mineFiTest.numAdjacentMines(i, j);
         }
      }
      for (int i = 0; i < vizAdjacent.length; i ++) {
      	 
          System.out.println(Arrays.toString(vizAdjacent[i]));
       }
      
      System.out.println();

      System.out.println("visible status of the square indicated [expected -1]: "+"\n"+visFieldTest.getStatus(3,4));
      System.out.println();

      System.out.println("cycleGuess(int row, int col) Method output when square guessed does not have mine: ");
      visFieldTest.cycleGuess(1, 3);
      visFieldTest.cycleGuess(8, 2);
      visFieldTest.cycleGuess(8, 7);
      visFieldTest.cycleGuess(5, 8);
      visFieldTest.cycleGuess(0, 8);
      visFieldTest.cycleGuess(6, 8);
      System.out.println();
      System.out.println(visFieldTest);
      System.out.println("Game Over Expected[false]: "+visFieldTest.isGameOver());
      System.out.println();
      
      System.out.println("Reset the object to its initial state, method output: ");
      visFieldTest.resetGameDisplay();
      System.out.println(visFieldTest);
      System.out.println();
      
      visFieldTest.cycleGuess(0, 4);
      visFieldTest.cycleGuess(8, 3);
      System.out.println(visFieldTest);
      
      System.out.println("Uncovers this square expected [true], method output: ");
      
      System.out.println(visFieldTest.uncover(8, 2));
      System.out.println();
      System.out.println(visFieldTest);
      System.out.println();
      System.out.println("Game Over Expected[false]: "+visFieldTest.isGameOver());
      System.out.println();
      
      System.out.println("Uncovers this square expected [false], method output: ");
      System.out.println(visFieldTest.uncover(1, 1));
      System.out.println();
      System.out.println(visFieldTest);
      System.out.println();
      System.out.println("Game Over Expected[true]: "+visFieldTest.isGameOver());
      System.out.println();

      visFieldTest.resetGameDisplay();
      System.out.println(visFieldTest.uncover(1, 8));
      System.out.println("Game Over Expected[false]: "+visFieldTest.isGameOver());
      System.out.println();
      
      System.out.println(visFieldTest.uncover(1, 7));
      System.out.println("Game Over Expected[true]: "+visFieldTest.isGameOver());
      System.out.println(visFieldTest);
      
      System.out.println("Uncovers this square (Uncovered vs covered state) expected [false], method output: ");
      System.out.println(visFieldTest.isUncovered(1, 7));
      System.out.println("Game Over Expected[true]: "+visFieldTest.isGameOver());
      System.out.println(visFieldTest);

   }
   
}
