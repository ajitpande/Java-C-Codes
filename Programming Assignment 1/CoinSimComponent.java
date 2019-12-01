//Name: Ajit Pandey
//USC NetID:ajitpand
//CS 455 PA1
//Fall 2019

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

//Extends to JComponent
// Constructor initializes data and runs the simulation, also check the error for entered trial value on prompt.
//Overrides paintComponent for bar graph using Bar class
//Uses CoinTossSimulator and Bar class


public class CoinSimComponent extends JComponent {

	private int numT;  	// variable for number of trials input by user
	private int nHH;  	// for percentage of two heads in total trials
	private int nHT;	// for percentage of one head and one tail in total trials
	private int nTT;	//for percentage of two tails in trials
	private int numHH;	//for number of two heads in trials	
	private int numHT;	//for number of one head and one tail in trials
	private int numTT;	//for number of two tails in trials
	

	CoinTossSimulator coin = new CoinTossSimulator(); // initiates instance of CoinTossSimulator class
	
	// Constructor,initializes number of trial data and runs the simulation with user input, also check the error for entered trial value on prompt. 
	
	public CoinSimComponent(int numTrl) {
		
		this.numT = numTrl;
		if (numT > 0){
			coin.run(numT);
			numT = coin.getNumTrials();
			numHH = coin.getTwoHeads();
			numTT = coin.getTwoTails();
			numHT = coin.getHeadTails();
			System.out.println("Number of Trials: "+numT);
			System.out.println("Two-head tosses: "+numHH);
			System.out.println("Two-tail tosses: "+numTT);
			System.out.println("One-head one-tail tosses: "+numHT);
			nHH= (int)(Math.round(numHH*100.0/(numT)));
			nTT= (int) (Math.round(numTT*100.0/(numT)));
			nHT= (int) (Math.round(numHT*100.0/(numT)));

		} else {
			System.out.println("ERROR: Number entered must be greater than 0.");
			
		}
	}
	
	//this overrides paintComponent for bar graph using Bar object.
	@Override
	
	public void paintComponent(Graphics g)
	   {  
	      Graphics2D g2 = (Graphics2D) g;
	      
	      	int y = getHeight(); //CoinSim Component Height from JFrame in CoinSimViewer class
	        int x =  getWidth(); //coinSim Component width from JFrame in CoinSimViewer class
	        
	        
	        int labelBottomLocation = (int)(0.8*y) ; // vertical buffer of 0.2. This is a fixed value in the program. Tallest bar means the tallest possible bar you could draw.
	        int barWidth = (int) Math.round(getWidth() * 0.1); // bar width as 10% of Component width. This is a fixed value in the program. 
	        int twoHeadsBarLeft = (int)(x / 5.0); //This is to calculate the location of the Two Heads Bar. 
	        int headTailBarLeft = (int) (( x/2.0)-(0.5*barWidth)); //This is to calculate the location of the a head and tail Bar. 
	        int twoTailsBarLeft = (int) ((x * 8) / 10 -(barWidth)); ////This is to calculate the location of the Two Tails Bar. 
	      
	      //To calculate the pixel scale as needed in Bar Class. subtracted 20% vertical buffer to calculate the scale.
	        
	        double scalePixel = (double) numT / (y - (int) Math.round(0.2*y)); 
	        
	        // To initiate instances of Bar object for Two heads, a Head -Tail and Two Tail bar graphs. It uses the Bar class constructer to initiate the objects.
	        
	        Bar twoHeadsBar = new Bar (labelBottomLocation,twoHeadsBarLeft,barWidth,numHH,scalePixel,Color.RED, "Two Heads: " 
	                + numHH + " (" + nHH + "%)");
	        
	        Bar headTailBar = new Bar (labelBottomLocation,headTailBarLeft,barWidth,numHT,scalePixel,Color.GREEN, "A Head and a Tail: " 
	                + numHT + " (" + nHT + "%)");
	        
	        Bar twoTailsBar = new Bar (labelBottomLocation,twoTailsBarLeft,barWidth,numTT,scalePixel,Color.BLUE, "Two Tails: " 
	                + numTT + " (" + nTT + "%)");	    
	       
	        twoHeadsBar.draw(g2); //Draw the Two Heads labeled bar, g2 graphic context
	        headTailBar.draw(g2);//Draw the a head and Tail labeled bar, g2 graphic context
	        twoTailsBar.draw(g2);//Draw the two Tails labeled bar, g2 graphic context
	   }
	
	
}

