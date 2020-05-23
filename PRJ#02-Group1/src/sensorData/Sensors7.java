package sensorData;
import sensors7.*;
/**
 * Retrieves data from Group 7's implementation.
 *
 * @author Ali Iftakhar.
 */
public class Sensors7 implements ConsoleSensor {
    private AnemometerSensor meter;
    private HumiditySensor humid;
    private RainSensor rain;
    private TemperatureSensor temp;
    

    public void Initialize()  {
        meter = new AnemometerSensor();
        humid = new HumiditySensor();
        rain = new RainSensor();
        temp = new TemperatureSensor();
    }
    
    public double rainFall() {
    	return rain.getData();
    }
    
    public double rainRate() {
    	return -1;
    }
    
    public double humOut() {
    	return humid.getData();
    }
    
    public double humIn() {
    	return -1;
    }
    
    public double tempOut() {
    	return temp.getData();
    }
    
    public double tempIn() {
    	return -1;
    }
    
    public double windDirection() {
    	return -1;
    }
    
    public double windSpeed() {
    	return meter.getData();
    }
    
    public double pressure() {
    	return -1;
    }

    public double windchill() {
    	return -1;
    }
    
}
