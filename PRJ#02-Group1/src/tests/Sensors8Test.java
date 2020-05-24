package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import sensorData.Sensors8;

/**
 * test the Sensor8 implemenation of retrieving data.
 * @author Nam Hoang.
 *
 */
class Sensors8Test {

	Sensors8 s8;
	/**
	 * Set up.
	 */
	@BeforeEach
	void setUp() {
		
		s8 = new Sensors8();
		s8.Initialize();
	}
	
	/**
	 * Retrieve pressure value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testAnomometer() {
		
		double testVal = s8.windSpeed();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve wind chill value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testHumidityOut() {
		
		double testVal = s8.humOut();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve rainfall value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testRainFall() {
		
		double testVal = s8.rainFall();
		assertTrue(testVal >= 0);
		
	}
	
	/**
	 * Retrieve rain rate value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testRainRate() {
		
		double testVal = s8.rainRate();
		assertTrue(testVal < 0);
		
	}
	
	/**
	 * Retrieve external humidity value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testHumidityIn() {
		
		double testVal = s8.humIn();
		assertTrue(testVal < 0);
	}
	
		
	/**
	 * Retrieve internal temperature value and assert it does NOT exist in this sensor suite.
	 */
	@Test
	void testTempIn() {
		
		double testVal = s8.tempIn();
		assertTrue(testVal < 0);
		
	}
	
	/**
	 * Retrieve external temperature value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testTempOut() {
		double testVal = s8.tempOut();
		assertTrue(testVal >= 0);
	}
	
	/**
	 * Retrieve wind direction value and assert it DOES exist in this sensor suite.
	 */
	@Test
	void testWindDir() {
		
		double testVal = s8.windDirection();
		assertTrue(testVal < 0);
		
	}
	
	@Test
	void testPressure() {
		double testVal = s8.pressure();
		assertTrue(testVal <= 0);
	}
	
	@Test
	void testWindChill() {
		double testVal = s8.windchill();
		assertTrue(testVal <= 0);
	}

	
	
}

