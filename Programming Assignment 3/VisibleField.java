import java.util.Arrays;

// Name: Ajit Pandey
// USC NetID: ajitpand
// CS 455 PA3
// Fall 2019


/**
  VisibleField class
  This is the data that's being displayed at any one point in the game (i.e., visible field, because it's what the
  user can see about the minefield), Client can call getStatus(row, col) for any square.
  It actually has data about the whole current state of the game, including  
  the underlying mine field (getMineField()).  Other accessors related to game status: numMinesLeft(), isGameOver().
  It also has mutators related to actions the player could do (resetGameDisplay(), cycleGuess(), uncover()),
  and changes the game state accordingly.
  
  It, along with the MineField (accessible in mineField instance variable), forms
  the Model for the game application, whereas GameBoardPanel is the View and Controller, in the MVC design pattern.
  It contains the MineField that it's partially displaying.  That MineField can be accessed (or modified) from 
  outside this class via the getMineField accessor.  
 */
public class VisibleField {
   // ----------------------------------------------------------   
   // The following public constants (plus numbers mentioned in comments below) are the possible states of one
   // location (a "square") in the visible field (all are values that can be returned by public method 
   // getStatus(row, col)).
   
   // Covered states (all negative values):
   public static final int COVERED = -1;   // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // Uncovered states (all non-negative values):
   
   // values in the range [0,8] corresponds to number of mines adjacent to this square
   
   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------   
  
   // <put instance variables here>
   private int numRows;
   private int numColumns;
   private MineField visMineField;
   private int numberMinesLeft;
   private int[][] visField;
   boolean gameOver;
   

   /**
      Create a visible field that has the given underlying mineField.
      The initial state will have all the mines covered up, no mines guessed, and the game
      not over.
      @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.numRows = mineField.numRows();
      this.numColumns =mineField.numCols();
      this.visMineField = mineField;
      visField = new int[numRows][numColumns];
      resetGameDisplay();
      
   }
   
   
   /**
      Reset the object to its initial state (see constructor comments), using the same underlying
      MineField. 
   */     
   public void resetGameDisplay() {
	   for (int i = 0; i < numRows; i ++) {
	         for (int j = 0; j < numColumns; j ++) {
	            visField[i][j] = COVERED;
	         }
	      }
	   numberMinesLeft = visMineField.numMines();
	   gameOver = false;
   }
  
   
   /**
      Returns a reference to the mineField that this VisibleField "covers"
      @return the minefield
    */
   public MineField getMineField() {
      return visMineField;       
   }
   
   
   /**
      Returns the visible status of the square indicated.
      @param row  row of the square
      @param col  col of the square
      @return the status of the square at location (row, col).  See the public constants at the beginning of the class
      for the possible values that may be returned, and their meanings.
      PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      return visField[row][col];       
   }

   
   /**
      Returns the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
      or not.  Just gives the user an indication of how many more mines the user might want to guess.  This value can
      be negative, if they have guessed more than the number of mines in the minefield.     
      @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      return numberMinesLeft;       

   }
 
   
   /**
      Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
      changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
      changes it to COVERED again; call on an uncovered square has no effect.  
      @param row  row of the square
      @param col  col of the square
      PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
	      if (visField[row][col] == COVERED) {
	          visField[row][col] = MINE_GUESS;
	          numberMinesLeft --;
	       } else if (visField[row][col] == MINE_GUESS) {
	          visField[row][col] = QUESTION;
	          numberMinesLeft ++;
	       } else if(visField[row][col] == QUESTION) {
	          visField[row][col] = COVERED;
	       }      
   }

   
   /**
      Uncovers this square and returns false if you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
      or a loss (opened a mine).
      @param row  of the square
      @param col  of the square
      @return false   iff you uncover a mine at (row, col)
      PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      if (visMineField.hasMine(row, col)){
    	  visField[row][col] = EXPLODED_MINE;
    	  gameOver =true;
    	  gameLost();
    	  return false; 
      } else {
    	  if (visMineField.numAdjacentMines(row, col) ==0){
    		  searchRecursion(row, col);
    	  } else{
    		  visField[row][col] = visMineField.numAdjacentMines(row, col);
    	  }
    	  return true;
      }
   }
 
   
   /**
      Returns whether the game is over.
      (Note: This is not a mutator.)
      @return whether game over
    */
   public boolean isGameOver() {
	
	   if (gameOver ==true){
		   for (int i = 0; i < numRows; i ++) {
		         for (int j = 0; j < numColumns; j ++) {
		            if (visMineField.hasMine(i, j)) {
		               visField[i][j] = MINE_GUESS;
		            }
		         }
		      }
	   }
	   for (int i = 0; i < numRows; i ++) {
	       for (int j = 0; j < numColumns; j ++) {
	           if (!(visMineField.hasMine(i, j))) {
	               if (visField[i][j] >= 0 && visField[i][j] <= 8) 
	            	   continue;
	                else {
	                   break;
	                }
	             }
	          }
	       }
	   
	   return gameOver;
   }
 
   
   /**
      Returns whether this square has been uncovered.  (i.e., is in any one of the uncovered states, 
      vs. any one of the covered states).
      @param row of the square
      @param col of the square
      @return whether the square is uncovered
      PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      return visField[row][col] >= 0;       
   }
   
 
   // <put private methods here>
   
   /*this method utilize flood-fill algorithm. Using recursion, find the are where mine is zero and search until reach to a location where mine is present. Method is lokking for all eight locations from a square. When a mine is located, it stops he recursion. When recursion reaches to an covered square, but has no mines, uncover it and stops recursion. This method follows following steps:
   When row, col is not within range. stop recursion.
   If the selected square is detected or marked as MINE_GUESS, this returns and stop recursion.  
   if there are mines around, we need to stop recursion.
   explore the eight surrounding location.
   */
   private void searchRecursion(int row, int col){
	     
      if(!(visMineField.inRange(row, col)) ) {
	         return;
	      } 

      if (visField[row][col] == MINE_GUESS || visField[row][col] >= 0) {
         return;
      } 

      if (visMineField.numAdjacentMines(row, col) > 0) {
         visField[row][col] = visMineField.numAdjacentMines(row, col);
         return;
      } 

      visField[row][col] = visMineField.numAdjacentMines(row, col);
      searchRecursion(row - 1, col);
      searchRecursion(row + 1, col);
      searchRecursion(row, col + 1);
      searchRecursion(row, col - 1);
      searchRecursion(row - 1, col - 1);
      searchRecursion(row + 1, col - 1);
      searchRecursion(row - 1 , col + 1);
      searchRecursion(row + 1, col + 1);
	
   }
   
   /*Helper method for tester class: this method is used to print the MineField data and VisibleField data in 2D array format. This is a helper method for tester class.*/
   
   public String toString() {
	      StringBuilder visFieldClass = new StringBuilder();
	      for (int i = 0; i < numRows; i ++) {
	    	  visFieldClass.append(Arrays.toString(visField[i]));
	    	  visFieldClass.append('\n');
	      }
	      return visFieldClass.toString();
	   } 
   
   // Helper method: this method executes when user lose the game to set the all mine locations which are uncovered, and also to show the incorrect guesses.
   
   private void gameLost() {
	      for (int i = 0; i < numRows; i ++) {
	         for (int j = 0; j < numColumns; j ++) {
	            if (visMineField.hasMine(i, j)) {
	               if (visField[i][j] == COVERED || visField[i][j] == QUESTION) {
	                  visField[i][j] = MINE;
	               }
	            } else {
	               if (visField[i][j] == MINE_GUESS) {
	                  visField[i][j] = INCORRECT_GUESS;
	               }
	            }
	         }
	      }
	   }
}
