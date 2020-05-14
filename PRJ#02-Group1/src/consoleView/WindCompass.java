package consoleView;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

public class WindCompass extends JLayeredPane {

	/**
	 * Auto-generated serial id for the element.
	 */
	private static final long serialVersionUID = 9183581586720047383L;
	

	/**
	 * Compass background as an image icon; to import the the background found in the manual.
	 */
	public final JLabel compassLabel;
	
	
	/**
	 * TODO: Figure out what the hell I'm supposed to do with this. 
	 */
	public WindCompass() {
		super();
		compassLabel = new JLabel();
		ImageIcon compassBG = new ImageIcon("Console_Compass.png");
		
		compassLabel.setIcon(compassBG);
		this.add(compassLabel, 1, 0);
	}
	
	/*
	 * Finds the closest acceptable angle that we have a graphic for, and updates the graphic.
	 * Angle is reported in degrees, and displayed accordingly.
	 * 
	 * @param windAngle The current calculated angle of the wind to display.
	 */
	public void updateDir(double windAngle) {
		
		//Ensure we're working only with angles in range (0, 360).
		windAngle = (windAngle % 360);
		
		int closestAngle = roundByDiscreteNum(windAngle, 15);
		
		//List of mod15 angles we don't have graphics for: test these angles to see if we need to round to the nearest 30 instead
		int[] invalidAngles = {15, 75, 105, 165, 195, 255, 285, 345};
		
		boolean isInvalid = false;
		
		for (int angle : invalidAngles) {
			if (closestAngle == angle) isInvalid = true;
		}
		
		//If we choose a bad multiple of 15, use the closest multiple of 30 instead.
		if (isInvalid) closestAngle = roundByDiscreteNum(windAngle, 30);
		
		String degFileName = ("deg" + closestAngle + ".png");
		compassLabel.setIcon(new ImageIcon(degFileName));
		
	}

	/**
	 * roundByDiscreteNum by Maxfield England
	 * 
	 * Given a (double) number and a discrete integer, returns an integer multiple
	 * of the discrete rounding factor of which the double is closest to.
	 * 
	 * If Java natively has behavior like this, I'll feel pretty silly!
	 * 
	 * @param toRound The number to be rounded.
	 * @param roundingFactor The number to 
	 * @return A discrete multiple of the roundingFactor closest to the double value toRound.
	 */
	public static int roundByDiscreteNum(double toRound, int roundingFactor) {

		double remainder = toRound  % roundingFactor;

		int closest;
		
		if (remainder >= ((double) roundingFactor) / 2) {
			//Rounding up: shed the remainder, but add another discrete rounding factor to the total.
			closest = (int) (toRound - (toRound % roundingFactor) + roundingFactor);
		}
		else {
			closest = (int) (toRound - (toRound % roundingFactor));
		}
		return closest;
	}
		
		
	
		//Set pointer to coordinates (displayX, displayY) as offset from the center of the circle
		//
		
		
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}
	
	
}
