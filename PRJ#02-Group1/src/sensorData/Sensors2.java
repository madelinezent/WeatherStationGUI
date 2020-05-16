package sensorData;

import sensors2.HumiditySensor;
import sensors2.RainSensor;
import sensors2.TemperatureSensor;
import sensors2.WindSensor;

/**
 * Collects data from every sensor in the weather station.
 *
 * @author Deline Zent
 * @version 05/06/20
 */

public class Sensors2 implements ConsoleSensor {

    /** All sensors. */
    private HumiditySensor humid;
    private RainSensor rain;
    private TemperatureSensor temp;
    private WindSensor wind;

    /**
     * Initializes each sensor class in group 2's project 1.
     * 
     * @author Deline Zent
     * @versio 05/08/20
     */
    public Sensors2() {
        humid = new HumiditySensor();
        rain = new RainSensor();
        temp = new TemperatureSensor();
        wind = new WindSensor();
        Initialize();
    }

    public void Initialize() {
        //TODO Add additional initializations 
    }
    
    //Sensor fields to be displayed by the console
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
        return humid.getInData();
    }

    public double tempOut() {
        return temp.getData();
    }

    public double tempIn() {
        return temp.getInData();
    }

    public double windDirection() {
        return wind.getData();
    }

    public double windSpeed() {
        return wind.getWindSpeedData();
    }

    public double pressure() {
        return -1;
    }

    public double windchill() {
        return -1;
    }
}
