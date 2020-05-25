package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import consoleDataCollectors.DataType;
import consoleView.ConsoleGUI;
import consoleView.Graph;
import sensorData.ConsoleSensor;
import sensorData.Sensors6;

/**
 * ConsoleGUI test.
 * @author Xiuxiang Wu
 * @version 5-24-2020
 */
class ConsoleGUITest {
	
	ConsoleGUI gui;
	DataType myData;
	Graph myGraph;
	ArrayList<Double> list;
	String[] timeStr = java.time.LocalTime.now().toString().split(":");
	int hr = Integer.parseInt(timeStr[0]);
	String ampm;

	@BeforeEach
	void setUp() throws Exception {

		ArrayList<ConsoleSensor> sensors = new ArrayList<ConsoleSensor>();
		sensors.add(new Sensors6());
		
		myData = new DataType(sensors);
		myData.update();
		
		gui= new ConsoleGUI(myData);
        myGraph = new Graph();
	}


	@Test
	void testUpdate() {

		gui.update();		
		assertTrue(myData.getCurrentHumIn() >= 0);
		assertTrue(myData.getCurrentHumOut() >= 0);
		assertTrue(myData.getCurrentPressure() >= 0);
		assertTrue(myData.getCurrentRainFall() >= 0);
		assertTrue(myData.getCurrentRainRate() >= 0);
		assertTrue(myData.getCurrentTempIn()>= 0);
		assertTrue(myData.getCurrentTempOut()>= 0);
		assertTrue(myData.getCurrentWindChill()>= 0);
		assertTrue(myData.getCurrentWindDirection()>= 0);
		assertTrue(myData.getCurrentWindSpeed() >= 0);

	}

	@Test
	void testButtonAction() {
		assertEquals("Temperature", myGraph.getLabel() );

	}


}
