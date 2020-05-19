package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.Icon;
import javax.swing.JFrame;

import org.junit.jupiter.api.*;

import consoleView.WindCompass;

/**
* This class tests the WindCompass class for proper construction and test of its methods, including the static
* roundByDiscreteNum method used to calculate wind angles.
*
* @author Maxfield England
*/
public class WindCompassTest {
	
	WindCompass wc;
	double testAngle;
	double testSpeed;
	
	@BeforeEach
	void setUp() {
		JFrame j = new JFrame();
		wc = new WindCompass();
		j.add(wc);
		j.setVisible(true);
		wc.setVisible(true);
		testAngle = 90.3;
		testSpeed = 11.3;
		
	}
	
	/**
	 * Test the compass constructor; tests the dimensions and presence of the label.
	 */
	@Test
	void testConstructor() {
		
		//Assert that created compass is (preferred) 400x400
		assertEquals(400, wc.getPreferredSize().width);
		assertEquals(400, wc.getPreferredSize().height);
		
		//assert compass background features an icon
		assertNotNull(wc.compassLabel.getIcon());
		
	}
	
	/**
	 * Tests the update method in that it displays a rounded wind speed
	 * in the text of the speed label, and that the icon changes when a
	 * new angle is selected.
	 */
	@Test
	void testUpdate() {
		Icon icon1 = wc.compassLabel.getIcon();
		wc.update(testAngle, testSpeed);
		Icon icon2 = wc.compassLabel.getIcon();
		assertNotEquals(icon1, icon2);
		assertEquals(wc.speedLabel.getText(), Long.toString(Math.round(testSpeed)));
	}
	
	/**
	 * Tests that an angle rounded to the nearest 15 degrees re-rounds to the nearest
	 * 30 and successfully changes the image.
	 */
	@Test
	void testBadAngle() {
		Icon icon1 = wc.compassLabel.getIcon();
		double badAngle = 15;
		wc.update(badAngle, 10);
		Icon icon2 = wc.compassLabel.getIcon();
		assertNotEquals(icon1, icon2);
	}
	
	/**
	 * Tests the method roundByDiscreteNum(double toRound, int roundingFactor);
	 */
	@Test
	void testAngleRound() {
		int nearest2 = WindCompass.roundByDiscreteNum(17, 2);
		int nearest3 = WindCompass.roundByDiscreteNum(0, 3);
		
		assertEquals(18, nearest2);
		assertEquals(0, nearest3);
		
	}
	

}
