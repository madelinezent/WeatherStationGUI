import sensorData.ConsoleSensor;
import sensorSuite7.SensorSuite;
import views7.ConsoleReceiver;
import views7.WeatherEnvoy;

/**
 * Main program.
 */
public class ISS7 implements ConsoleSensor {
    private static SensorSuite sensorSuite;
    private static ConsoleReceiver consoleReceiver;
    private static WeatherEnvoy weatherEnvoy;


    public void Initialize() {
        sensorSuite = new SensorSuite();
        consoleReceiver = new ConsoleReceiver(sensorSuite); //probably not needed anymore
        weatherEnvoy = new WeatherEnvoy(sensorSuite); //probably not needed anymore
        sensorSuite.addObserver(consoleReceiver); //probably not needed anymore 
        sensorSuite.addObserver(weatherEnvoy);  //probably not needed anymore
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
