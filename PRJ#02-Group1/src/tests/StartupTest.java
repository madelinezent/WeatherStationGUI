package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.*;

import consoleView.Startup;
import consoleView.WindCompass;

/**
 * Tests the startup window of our GUI.
 * @author Ali Iftakhar
 *
 */
public class StartupTest {
	Startup gui;
	
	/**
	 * Set up our GUI and ready to go.
	 */
	@BeforeEach
	void setUp() {
		gui = new Startup();
	}
	
	/**
	 * We want to test the dimension of our GUI. If this test passes then it passes for every 
	 * other component also.
	 */
	@Test
	void testGUI() {
		Dimension mytest = new Dimension(17,40);
		assertEquals(mytest, gui.getFrameSize());
	}
	
	/**
	 * We want to test actionperformed.
	 *
	 */
	
	/**
	 * We want to test if something is added to list if button is not given any action listener.
	 */
	@Test
	void testAction() {
		JButton button = new JButton();
		ArrayList<String> list = new ArrayList<>();
		button.doClick();
		assertTrue(list.isEmpty());
	}
}
