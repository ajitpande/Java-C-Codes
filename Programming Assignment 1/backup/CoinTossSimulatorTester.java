//Name: Ajit Pandey
//USC NetID:ajitpand
//CS 455 PA1
//Fall 2019


public class CoinTossSimulatorTester {

	public static void main(String[] args) {
		

		
		CoinTossSimulator coinTest = new CoinTossSimulator();
		
		 coinTest.run(0);
	     System.out.println("After constructor:");
	     System.out.print("Number of trials [exp:0]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(1);
	     System.out.println("After run(1):");
	     System.out.print("Number of trials [exp:1]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(10);
	     System.out.println("After run(10):");
	     System.out.print("Number of trials [exp:11]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(100);
	     System.out.println("After run(100):");
	     System.out.print("Number of trials [exp:111]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(1028);
	     System.out.println("After run(1028):");
	     System.out.print("Number of trials [exp:1139]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(68);
	     System.out.println("After run(68):");
	     System.out.print("Number of trials [exp:1207]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.reset();

	        
	     coinTest.run(0);
	     System.out.println("After reset:");
	     System.out.print("Number of trials [exp:0]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(1000);
	     System.out.println("After run(1000):");
	     System.out.print("Number of trials [exp:1000]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(218);
	     System.out.println("After run(218):");
	     System.out.print("Number of trials [exp:1218]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	     
	     coinTest.run(162);
	     System.out.println("After run(162):");
	     System.out.print("Number of trials [exp:1380]: ");
	     System.out.println(coinTest.getNumTrials());
	     System.out.print("Two-head tosses: ");
	     System.out.println(coinTest.getTwoHeads());
	     System.out.print("Two-tail tosses: ");
	     System.out.println(coinTest.getTwoTails());        
	     System.out.print("One-head one-tail tosses: ");
	     System.out.println(coinTest.getHeadTails());        
	     System.out.print("Tosses add up correctly? ");
	     CoinTossSimulatorTester.checkTrialAddition(coinTest.getTwoHeads(),coinTest.getTwoTails(), coinTest.getHeadTails(), coinTest.getNumTrials());
	     System.out.println();
	}

	// method to check if total coin toss trial from program matches with number of trials input by user.
	
	public static void checkTrialAddition (int numHH, int numTT, 
            int numHT, int numTrials)
	    {
		int trialAdd1 = numHH + numTT+ numHT;
        
				if ( trialAdd1 == numTrials)
				{
					System.out.println("True");
				}
				else {
					System.out.println("False");
				}
	    }
	
}

