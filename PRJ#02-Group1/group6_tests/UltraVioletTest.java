/*
 * A test case demonstrating the warning function of the
 * UltraViolet class.
 */

import org.junit.Assert;
import org.junit.Test;

import WeatherData.Sensor;
import WeatherData.UltraViolet;


/**
 * @author Paras Sharma
 *
 */
public class UltraVioletTest {

	/**
	 * Test method for {@link WeatherData.UltraViolet#alarmWarning(double)}.
	 */
	@Test
	public void testAlarmWarning() {
		String expected = "WARNING!, UV dosage is HIGH";
		String expected2 = "No protection needed";
		UltraViolet test = new UltraViolet(Sensor.OUTSIDE);
		String actual = test.alarmWarning(19.9);
		String actual2 = test.alarmWarning(0);
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected2, actual2);
	}

}
