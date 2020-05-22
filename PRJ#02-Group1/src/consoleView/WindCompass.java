package consoleView;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

/**
 * WindCompass: creates a component that can visually represent wind speed and direction.
 * Wind speed and direction can be updated, such that the compass will match the provided
 * angle with the closest displayable match (based on significant trigonometric angles)
 * and display wind speed superimposed over the compass image.
 * 
 * @author Maxfield England
 *
 */
public class WindCompass extends JLayeredPane {

	/**
	 * Auto-generated serial id for the element.
	 */
	private static final long serialVersionUID = 9183581586720047383L;
	

	/**
	 * Compass background as an image icon; to import the background found in the manual.
	 */
	public final JLabel compassLabel;
	
	/**
	 * Label for updating wind speed laid over the compass.
	 */
	public final JLabel speedLabel;
	
	
	/**
	 * Constructs a Wind Compass of appropriate size, creating the components for the
	 * background image and speed label, in a layered fashion.
	 */
	public WindCompass() {
		super();

		Dimension dim = new Dimension(400, 400);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		
		compassLabel = new JLabel();
		
		ImageIcon compassBG = new ImageIcon(WindCompass.class.getResource("/displayImgs/deg0.png"));
		
		speedLabel = new JLabel("0", SwingConstants.CENTER);
		speedLabel.setFont(new Font("Courier New", Font.BOLD, 30));
		
		//determine speedLabel position
		int speedX = this.getX() + 165;
		int speedY = this.getY() + 195;
		
		speedLabel.setLocation(speedX, speedY);

		compassLabel.setIcon(compassBG);
		
		compassLabel.setBounds( 0, 0,compassBG.getIconWidth(), compassBG.getIconHeight() ); 
		speedLabel.setBounds( speedX, speedY,  80, 80 );
		
		
	    this.add(compassLabel, new Integer(1));  
	    this.add(speedLabel, new Integer(2));  
		
		//this.add(compassLabel);
		//compassLabel.add(speedLabel);
	}
	
	/**
	 * Receives update information: reflects the current angle and wind speed as sent to the GUI from DataType
	 * 
	 * @param windAngle The angle to graphically display (roughly)
	 * @param windSpeed Magnitude of the force of the wind
	 */
	public void update(double windAngle, double windSpeed) {
		updateDir(windAngle);
		
		//Console displays windspeed as an integer value; given a double, round to an integer for display
		long displaySpeed = Math.round(windSpeed);
		speedLabel.setText(Long.toString(displaySpeed));
		
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
		
		
		int closestAngle = roundByDiscreteNum(windAngle, 15) % 360;
		
		//List of mod15 angles we don't have graphics for: test these angles to see if we need to round to the nearest 30 instead
		int[] invalidAngles = {15, 75, 105, 165, 195, 255, 285, 345};
		
		boolean isInvalid = false;
		
		for (int angle : invalidAngles) {
			if (closestAngle == angle) isInvalid = true;
		}
		
		//If we choose a bad multiple of 15, use the closest multiple of 30 instead.
		if (isInvalid) closestAngle = roundByDiscreteNum(windAngle, 30) % 360;
						
		String degFileName = ("/displayImgs/deg" + closestAngle + ".png");
		compassLabel.setIcon(new ImageIcon(WindCompass.class.getResource(degFileName)));
		
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
	
	//Test main TODO: delete
//	public static void main(String[] args) throws InterruptedException {
//		WindCompass w = new WindCompass();
//		
//		JFrame j = new JFrame("Test Window");
//		j.setVisible(true);
//		j.add(w);
//		w.setVisible(true);
//		j.pack();
//		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		for (int i = 0; i < 30; i++) { 
//			
//			double testAngle = Math.random() * 360;
//			double testSpeed = Math.random() * 120;
//			w.update(testAngle, testSpeed);
//			
//			TimeUnit.SECONDS.sleep(1);
//		}
//		
//	}
	
	
}
