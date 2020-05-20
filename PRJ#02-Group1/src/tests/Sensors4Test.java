package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sensorData.ConsoleSensor;
import sensorData.Sensors4;

/**
 * Tests the Sensor4 implementation of the CosoleSensor interface.
 * @author Xiuxiang Wu
 * @version 5-20-2020
 */
class Sensors4Test {
	ConsoleSensor ISS4;
	
	@BeforeEach
	void seUp() {
		ISS4 = new Sensors4();
		ISS4.Initialize();
	}

	@Test
	void testRainFall() {
		double rainFall = ISS4.rainFall();
		assertFalse(rainFall >= 0);
	}

	@Test
	void testRainRate() {
		double rainRate = ISS4.rainRate();
		assertTrue(rainRate >= 0);
	}

	@Test
	void testHumOut() {
		double humOut = ISS4.humOut();
		assertTrue(humOut >= 0);
	}

	@Test
	void testHumIn() {
		double humIn = ISS4.humIn();
		assertTrue(humIn >= 0);

		}

	@Test
	void testTempOut() {
		double tempOut = ISS4.tempOut();
		assertTrue(tempOut >= 0);
	}

	@Test
	void testTempIn() {
		double tempIn = ISS4.tempIn();
		assertTrue(tempIn >= 0);
	}

	@Test
	void testWindDirection() {
		double windDir = ISS4.windDirection();
		assertTrue(windDir >= 0);
	}

	@Test
	void testWindSpeed() {
		double windSpeed = ISS4.windSpeed();
		assertTrue(windSpeed >= 0);
	}

	@Test
	void testPressure() {
		double pressure = ISS4.pressure();
		assertFalse(pressure >= 0);
	}

	@Test
	void testWindchill() {
		double windChill = ISS4.windchill();
		assertFalse(windChill >= 0);
	}
	
	@Test
	void testLastValues() {

		
		for(int i = 0; i < 100; i++) {
			ISS4.humIn();
			ISS4.humOut();
			ISS4.tempIn();
			ISS4.tempOut();
			ISS4.windDirection();
			ISS4.windSpeed();
			ISS4.rainRate();
		}
		double humIn = ISS4.humIn();
		double humOut = ISS4.humOut();
		double tempIn = ISS4.tempIn();
		double tmepOut = ISS4.tempOut();
		double windDir = ISS4.windDirection();
		double windSpeed = ISS4.windSpeed();
		double rainRate = ISS4.rainRate();
		
		assertTrue(humIn >= 0);
		assertTrue( humOut >= 0);
		assertTrue(tempIn >= 0);
		assertTrue(tmepOut >= 0);
		assertTrue(windDir >= 0);
		assertTrue(windSpeed >= 0);
		assertTrue(rainRate >= 0);
		
	}

}
