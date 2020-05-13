package sensorData;
import sensorSuite7.SensorSuite;
/**
 * Retrieves data from Group 7's implementation.
 *
 * @author Ali Iftakhar.
 */
public class Sensors7 implements ConsoleSensor {
    private static SensorSuite sensorSuite;

    public void Initialize() {
        sensorSuite = new SensorSuite();
        try {
			startSensorSuite();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public double rainFall() {
    	return sensorSuite.getSensors().get(0).getData();
    }
    
    public double rainRate() {
    	return -1;
    }
    
    public double humOut() {
    	return sensorSuite.getSensors().get(2).getData();
    }
    
    public double humIn() {
    	return -1;
    }
    
    public double tempOut() {
    	return sensorSuite.getSensors().get(1).getData();
    }
    
    public double tempIn() {
    	return -1;
    }
    
    public double windDirection() {
    	return -1;
    }
    
    public double windSpeed() {
    	return sensorSuite.getSensors().get(3).getData();
    }
    
    public double pressure() {
    	return -1;
    }

    public double windchill() {
    	return -1;
    }
    
    private static void startSensorSuite() throws InterruptedException {
        sensorSuite.run();
    }
}
