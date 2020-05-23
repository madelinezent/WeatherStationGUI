package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import sensorData.*;

/**
* Tests the Sensor7 implemenation of retrieving data.
*
* @author Ali Iftakhar
**/
public class Sensors7Test {
	
	Sensors7 s7;
	
	/**
	 * Set up the test environment for each individual test; create the sensor suite
	 * and use the initialize method.
	 */
	@BeforeEach
	void setUp() {
		
		s7 = new Sensors7();
		s7.Initialize();
	}
	
	/**
	 * Retrieve pressure value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testAnomometer() {
		
		double testVal = s7.windSpeed();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve wind chill value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testHumidityOut() {
		
		double testVal = s7.humOut();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve rainfall value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testRainFall() {
		
		double testVal = s7.rainFall();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve rain rate value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testRainRate() {
		
		double testVal = s7.rainRate();
		assertTrue(testVal < 0);
		
	}
	
	/**
	 * Retrieve external humidity value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testHumidityIn() {
		
		double testVal = s7.humIn();
		assertTrue(testVal < 0);
	}
	
		
	/**
	 * Retrieve internal temperature value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testTempIn() {
		
		double testVal = s7.tempIn();
		assertTrue(testVal < 0);
		
	}
	
	/**
	 * Retrieve external temperature value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testTempOut() {
		double testVal = s7.tempOut();
		assertTrue(testVal >= 0);
	}
	
	/**
	 * Retrieve wind direction value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testWindDir() {
		
		double testVal = s7.windDirection();
		assertTrue(testVal < 0);
		
	}
	
	@Test
	void testPressure() {
		double testVal = s7.pressure();
		assertTrue(testVal < 0);
	}
	
	@Test
	void testWindChill() {
		double testVal = s7.windchill();
		assertTrue(testVal < 0);
	}

	
	
}
