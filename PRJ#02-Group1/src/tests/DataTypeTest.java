package tests;

import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import consoleDataCollectors.DataType;
import sensorData.ConsoleSensor;
import sensorData.*;

/**
 * This class tests the DataType class; that each update method operates properly
 * whether its handed valid values or not, and that the getters all return their
 * appropriate values.
 * 
 * @author Maxfield England
 *
 */
public class DataTypeTest {
	
	DataType dt;
	
	@BeforeEach
	void setUp() {
		
		ArrayList<ConsoleSensor> sensors = new ArrayList<ConsoleSensor>();
		sensors.add(new Sensors6());
		
		dt = new DataType(sensors);
		dt.update();
		
	}
	
	/**
	 * Tests the wind direction methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetWindDir() {
		
		ArrayList<Double> hist = dt.getWindDirectionHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentWindDirection();
		assertEquals(val1, val2);
	}
	

	/**
	 * Tests the wind speed methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetWindSpeed() {
		
		ArrayList<Double> hist = dt.getWindSpeedHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentWindSpeed();
		assertEquals(val1, val2);
	}
	

	/**
	 * Tests the wind chill methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetWindChill() {
		
		ArrayList<Double> hist = dt.getWindChillHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentWindChill();
		assertEquals(val1, val2);
	}
	

	/**
	 * Tests the rain rate methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetRainRate() {
		
		ArrayList<Double> hist = dt.getRainRateHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentRainRate();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests the rain fall methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetRainFall() {
		
		ArrayList<Double> hist = dt.getRainFallHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentRainFall();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests the internal humidity methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetHumIn() {
		
		ArrayList<Double> hist = dt.getHumInHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentHumIn();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests the external humidity methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetHumOut() {
		
		ArrayList<Double> hist = dt.getHumOutHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentHumOut();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests the internal temperature methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetTempIn() {
		
		ArrayList<Double> hist = dt.getTempInHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentTempIn();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests the external temperature methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetTempOut() {
		
		ArrayList<Double> hist = dt.getTempOutHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentTempOut();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests the pressure methods, by comparing the sole history value and current value
	 */
	@Test 
	void testGetPressure() {
		
		ArrayList<Double> hist = dt.getPressureHistory();
		double val1 = hist.get(0);
		double val2 = dt.getCurrentPressure();
		assertEquals(val1, val2);
	}
	
	/**
	 * Tests all sensors in the case where there is always a valid value; using
	 * real sensors as well as a custom test default-to-one sensor.
	 */
	@Test
	void testFullSensors() {
		
		//validSensor is a test sensor that always returns 1 (valid value).
		ConsoleSensor validSensor = new ConsoleSensor() {
			@Override public void Initialize() {}
			@Override public double rainFall() { return 1;}
			@Override public double rainRate() { return 1;}
			@Override public double humOut() { return 1;}
			@Override public double humIn() { return 1;}
			@Override public double tempOut() { return 1;}
			@Override public double tempIn() { return 1;}
			@Override public double windDirection() { return 1;}
			@Override public double windSpeed() { return 1;}
			@Override public double pressure() { return 1;}
			@Override public double windchill() { return 1;}
		};
		
		ArrayList<ConsoleSensor> fullSensors = new ArrayList<ConsoleSensor>();
		fullSensors.add(new Sensors2());
		fullSensors.add(new Sensors4());
		fullSensors.add(new Sensors6());
		fullSensors.add(validSensor);
		
		DataType fullDT = new DataType(fullSensors);
		
		fullDT.update();
		assertNotEquals(fullDT.getCurrentHumIn(), 0);
		assertNotEquals(fullDT.getCurrentHumOut(), 0);
		assertNotEquals(fullDT.getCurrentPressure(), 0);
		assertNotEquals(fullDT.getCurrentRainFall(), 0);
		assertNotEquals(fullDT.getCurrentRainRate(), 0);
		assertNotEquals(fullDT.getCurrentTempIn(), 0);
		assertNotEquals(fullDT.getCurrentTempOut(), 0);
		assertNotEquals(fullDT.getCurrentWindChill(), 0);
		assertNotEquals(fullDT.getCurrentWindDirection(), 0);
		assertNotEquals(fullDT.getCurrentWindSpeed(), 0);
		
	}
	
	/**
	 * Using a default-to-none test sensor, verify that all fields default
	 * to 0 if no valid values are included.
	 */
	@Test
	void testDefaultVals() {
		
		//validSensor is a test sensor that always returns 1 (valid value).
		ConsoleSensor nullSensor = new ConsoleSensor() {
			@Override public void Initialize() {}
			@Override public double rainFall() { return -1;}
			@Override public double rainRate() { return -1;}
			@Override public double humOut() { return -1;}
			@Override public double humIn() { return -1;}
			@Override public double tempOut() { return -1;}
			@Override public double tempIn() { return -1;}
			@Override public double windDirection() { return -1;}
			@Override public double windSpeed() { return -1;}
			@Override public double pressure() { return -1;}
			@Override public double windchill() { return -1;}
		};
		
		ArrayList<ConsoleSensor> nullSensors = new ArrayList<ConsoleSensor>();
		nullSensors.add(nullSensor);
		nullSensors.add(nullSensor);
		nullSensors.add(nullSensor);
		
		DataType nullDT = new DataType(nullSensors);
		
		nullDT.update();
		assertEquals(nullDT.getCurrentHumIn(), 0);
		assertEquals(nullDT.getCurrentHumOut(), 0);
		assertEquals(nullDT.getCurrentPressure(), 0);
		assertEquals(nullDT.getCurrentRainFall(), 0);
		assertEquals(nullDT.getCurrentRainRate(), 0);
		assertEquals(nullDT.getCurrentTempIn(), 0);
		assertEquals(nullDT.getCurrentTempOut(), 0);
		assertEquals(nullDT.getCurrentWindChill(), 0);
		assertEquals(nullDT.getCurrentWindDirection(), 0);
		assertEquals(nullDT.getCurrentWindSpeed(), 0);
		
		
	}
	
	
}
