//Name: Ajit Pandey
//USC NetID:ajitpand
//CS 455 PA1
//Fall 2019

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   
	private int locationBottomLabel;   //location of the bottom of the label
	private int locationLeftBar;       //location of the left side of the bar
	private int barWidth;              //width of the bar (in pixels) 
	private int barHeightAppUnits;     //height of the bar in application units
	private double pixelPerAppUnit;    // how many pixels per application unit 
	private Color barColor;            //the color of the bar
	private String bottomLabel;        //the label at the bottom of the bar 

   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
	   this.locationBottomLabel = bottom;
	   this.locationLeftBar=left;
	   this.barWidth=width;
	   this.barHeightAppUnits=barHeight;
	   this.pixelPerAppUnit=scale;
	   this.barColor=color;
	   this.bottomLabel=label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   
   public void draw(Graphics2D g2) {
	   
	   Font font = g2.getFont();
	   FontRenderContext context = g2.getFontRenderContext();
	   Rectangle2D labelBounds = font.getStringBounds(bottomLabel, context);
	   int widthOfLabel = (int) (Math.round(labelBounds.getWidth()));
	   int heightOfLabel = (int) (Math.round(labelBounds.getHeight()));
	   
      // this is to calculate the bar height which is scaled by pixel per unit. This is used to draw the rectangle.
      
	   int barHeight = (int)(Math.round(barHeightAppUnits/pixelPerAppUnit)); 
      
      //This to calculate the y coordinate for initial coordinates to draw the rectangle.
      
	   int yBar = locationBottomLabel - barHeight -heightOfLabel; 
	   
	   Rectangle body = new Rectangle(locationLeftBar, yBar, barWidth, barHeight);
      
	   g2.setColor(barColor);
	   g2.fill(body);
	   g2.setColor(Color.BLACK); 
      
      //this is calculates the location of the label below the bar. Barwidth/3 is substracted to move the label start locationslightly left.
      
       g2.drawString(bottomLabel, (locationLeftBar-(barWidth/3)), locationBottomLabel); 
   }
}

