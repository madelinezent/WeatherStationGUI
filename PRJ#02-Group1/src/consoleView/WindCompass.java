package consoleView;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WindCompass extends JPanel {

	/**
	 * Auto-generated serial id for the element.
	 */
	private static final long serialVersionUID = 9183581586720047383L;
	
	/**
	 * Used to determine how far from the center the direction pointer should be
	 * 
	 * Can be changed by whatever's appropriate
	 */
	private static final int POINTER_SCALAR = 50;
	

	/**
	 * Compass background as an image icon; to import the the background found in the manual.
	 */
	public final ImageIcon CompassBG;
	
	/**
	 * TODO: Figure out what the hell I'm supposed to do with this. 
	 */
	public WindCompass() {
		super();
		CompassBG = new ImageIcon("Console_Compass.png");
		
	}
	
	/*
	 * Updates the wind marker on the 
	 * 
	 * @param windAngle The current calculated angle of the wind to display.
	 */
	public void displayDir(double windAngle) {
		
		//int displayX = (int)(POINTER_SCALAR * Math.round(Math.cos(windAngle)));
		//int displayY = (int)(POINTER_SCALAR * Math.round(Math.sin(windAngle)));
	
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
	}
	
	
}
