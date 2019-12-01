//Name: Ajit Pandey
//USC NetID:ajitpand
//CS 455 PA1
//Fall 2019

import java.util.Scanner;
import javax.swing.JFrame;

//contains main
//prompts Number of Trials
//creates JFrame and creates instance of CoinSimComponent class.
//does not connect to any other class except CoinSimComponent.

public class CoinSimViewer {

	public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of trials: ");
		int numTrial = in.nextInt(); // numTrial is number of trials input by user.
			
		CoinSimComponent csc =new CoinSimComponent(numTrial); //Instance of CoinSimComponent Class
		
		JFrame frame = new JFrame();
		frame.setSize(800, 400);
		frame.setTitle("Coin Simulation");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(csc);
	    frame.setVisible(true);
	}
}

