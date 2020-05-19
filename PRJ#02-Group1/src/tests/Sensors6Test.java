package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import sensorData.*;

public class Sensors6Test {
	
	ConsoleSensor s6;
	
	/**
	 * Set up the test environment for each individual test; create the sensor suite
	 * and use the initialize method.
	 */
	@BeforeEach
	void setUp() {
		
		s6 = new Sensors6();
		s6.Initialize();
	}
	
	/**
	 * Retrieve pressure value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testPressure() {
		
		double testVal = s6.pressure();
		assertFalse(testVal >= 0);
		
	}
	
	/**
	 * Retrieve wind chill value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testWindChill() {
		
		double testVal = s6.windchill();
		assertFalse(testVal >= 0);
		
	}
	
	/**
	 * Retrieve rainfall value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testRainFall() {
		
		double testVal = s6.rainFall();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve rain rate value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testRainRate() {
		
		double testVal = s6.rainRate();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve external humidity value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testHumOut() {
		
		double testVal = s6.humOut();
		assertTrue(testVal >= 0);
	}
	
	/**
	 * Retrieve internal humidity value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testHumIn() {
		
		double testVal = s6.humIn();
		assertFalse(testVal >= 0);
		
	}
		
	/**
	 * Retrieve internal temperature value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testTempIn() {
		
		double testVal = s6.tempIn();
		assertFalse(testVal >= 0);
		
	}
	
	/**
	 * Retrieve external temperature value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testTempOut() {
		double testVal = s6.tempOut();
		assertTrue(testVal >= 0);
	}
	
	/**
	 * Retrieve wind direction value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testWindDir() {
		
		double testVal = s6.windDirection();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve wind speed value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testWindSpeed() {
		
		double testVal = s6.windSpeed();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Runs each method beyond the maximum length of the file, to show that
	 * each returning method will return the last available field of data.
	 */
	@Test
	void testLastValues() {
		
		for (int i = 0; i < 3000; i++) { 
			
			//
			s6.rainFall(); s6.windDirection(); s6.windSpeed();
			s6.tempOut(); s6.rainRate(); s6.humOut();
		}
		double rf = s6.rainFall();
		double wd = s6.windDirection();
		double ws = s6.windSpeed();
		double to = s6.tempOut();
		double rr = s6.rainRate();
		double ho = s6.humOut();
		
		assertTrue(rf == s6.rainFall());
		assertTrue(wd == s6.windDirection());
		assertTrue(ws == s6.windSpeed());
		assertTrue(to == s6.tempOut());
		assertTrue(rr == s6.rainRate());
		assertTrue(ho == s6.humOut());
	}
	
}
