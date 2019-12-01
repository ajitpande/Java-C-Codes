import java.util.Arrays;
import java.util.Random;

// Name: Ajit Pandey
// USC NetID:ajitpand
// CS 455 PA3
// Fall 2019


/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
	private boolean[][] mineFields;
	private int numberMines;
	private int numberRows;
	private int numberCols;
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
	   numberMines =0;
	   this.numberRows = mineData.length;
	   this.numberCols = mineData[0].length;
	   mineFields = new boolean[numberRows][numberCols];
	   for (int i =0; i <numberRows; i++){
		   for (int j=0;j < numberCols; j++){
			   mineFields[i][j]= mineData[i][j];
			   if (mineData[i][j] == true){
				   numberMines++;
			   }
		   }
	   }
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      this.mineFields = new boolean[numberRows][numberCols];
	  this.numberRows = numRows;
      this.numberCols = numCols;
      this.numberMines = numMines;
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
      resetEmpty();
      int addMines =0;
      Random randomNum = new Random();
      while (addMines < numberMines){
    	  int randomRow = randomNum.nextInt(numberRows);
    	  int randomCol = randomNum.nextInt(numberCols);
    	  if ((randomRow == row && randomCol == col) || (mineFields[randomRow][randomCol])){
    		  addMines +=0;
    	  } else{
    		  mineFields[randomRow][randomCol] = true;
    		  addMines+=1;
    	  }
      }
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
      for (int i =0; i < numberRows; i++){
    	  for (int j=0; j <numberCols; j++){
    		  mineFields[i][j] = false;
    	  }
      }
   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      int numAdjMines =0;
      for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, numberRows-1); i++) {
          for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, numberCols-1); j++) {
             if (mineFields[i][j] == true) {
            	 numAdjMines +=1;
             }
          }
      }
      if (mineFields[row][col] == true) {
    	  numAdjMines -= 1;
       }
       return numAdjMines;  
   }
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   
   public boolean inRange(int row, int col) {
	 boolean range = false;  
	 if ((row >= 0 && row < numberRows) && (col >= 0 && col < numberCols)){
		 range =true;
	 } else {
      range = false;
	 }
	 return range;
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return numberRows;       
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return numberCols;       
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      return mineFields[row][col];       
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
	   return numberMines;       
   }

   
   // <put private methods here>
   
   //Helper method for tester class: this method is used to print the MineField data and VisibleField data in 2D array format. This is a helper method for tester class.
   
   public String toString() {
	      StringBuilder mineFieldClass = new StringBuilder();
	      for (int i = 0; i < numberRows; i ++) {
	    	  mineFieldClass.append(Arrays.toString(mineFields[i]));
	    	  mineFieldClass.append('\n');
	      }
	      return mineFieldClass.toString();
	   }   
}

