// Name: Ajit Pandey
// USC NetID:ajitpand
// CS 455 PA1
// Fall 2019

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;


public class CoinTossSimulator {


		private int numberOfTrials = 0;
		private int numTwoHeads;
		private int numTwoTails;
		private int numHeadTails;
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
	   this.numberOfTrials=0;
	   this.numTwoHeads=0;
	   this.numTwoTails=0;
	   this.numHeadTails=0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials is total number of trials.  Error for numTrials >1 is checked in CoinSimComponent class.
    */
   public void run(int numTrials) {
	   Random generator = new Random(); 
	   
	   numberOfTrials = numberOfTrials + numTrials;	  // this line adds the number of trials for multiple trial runs.
      
	   for (int i = 1; i <= numTrials; i++)
		   {
		   int coin1 = 1 + generator.nextInt(2);
		   int coin2 = 1 + generator.nextInt(2);
		   
		   if (coin1 ==1 && coin2==1){
			   numTwoHeads=numTwoHeads+1;
			   			   
		   		}else if (coin1==2 && coin2==2){
			   numTwoTails=numTwoTails+1;
			   
		   		}else if (coin1==1 && coin2==2){
			   numHeadTails=numHeadTails+1;
			   
		   		}else if (coin1==2 && coin2==1){
			   numHeadTails=numHeadTails+1;
			   }
		   }
 }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       
	   return numberOfTrials; // returns number of trials
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return numTwoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return numTwoTails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return numHeadTails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   numberOfTrials=0;
	   numTwoHeads =0;
	   numTwoTails=0; 
	   numHeadTails=0;
		
   }

}
