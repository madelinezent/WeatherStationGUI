package sensorData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import data.WeatherData;
import model.AbstractOutputDevice;
import model.ISS;
import model.WeatherMonitoringApp;



public class Sensors8 implements ConsoleSensor {
	
	AbstractOutputDevice myData;
	
	WeatherData myWeatherData;
	 
    /**
     * Initializes sensor by creating a ISS object.
     */
    @Override
    public void Initialize(){
        myWeatherData = new WeatherData();
        
        final WeatherMonitoringApp testApp = new WeatherMonitoringApp();
        
        final ArrayList<AbstractOutputDevice> testDeviceArray = 
				new ArrayList<AbstractOutputDevice>();
        testDeviceArray.add(testApp);

        new ISS(testDeviceArray);	
        
        
    }
    
    public static void main(String[] args) {
    	
    	Sensors8 testSensor = new Sensors8();
    	
    	testSensor.Initialize();
    	
		System.out.println("Rain:\tRate:\tHum:\tTemp:\tWndDir:\tWindSp:");
		for (int i = 0; i < 20; i++) {
			System.out.println(testSensor.rainFall() + "\t" + testSensor.rainRate() + "\t" + testSensor.humOut() + "\t" + testSensor.tempOut() + "\t" + testSensor.windDirection() + "\t" + testSensor.windSpeed());
		}
    }

	@Override
	public double rainFall() {
		return (double) myWeatherData.getRainfall();
	}

	@Override
	public double rainRate() {
		
		return -1;
	}

	@Override
	public double humOut() {
		
		return (double) myWeatherData.getHumidity();
	}

	@Override
	public double humIn() {
		
		return -1;
	}

	@Override
	public double tempOut() {
		return (double) myWeatherData.getAirTemperatures();
	}

	@Override
	public double tempIn() {
		return -1;
	}

	@Override
	public double windDirection() {
		final ArrayList<Double> winDirectionD = new ArrayList<Double>(Arrays.asList(0.0,45.0,90.0,135.0,180.0,225.0,270.0,315.0));
		final ArrayList<String> winDirectionS = new ArrayList<String>(Arrays.asList("N", "NE", "E", "SE", "S", "SW", "W", "NW"));
		final Map<String, Double> winDirection = new HashMap<String, Double>();
		for(int i = 0; i < winDirectionD.size(); i++) {
			winDirection.put(winDirectionS.get(i), winDirectionD.get(i));
		}
		return winDirection.get(myWeatherData.getWindDirection());
	}

	@Override
	public double windSpeed() {
		return (double) myWeatherData.getWindSpeed();
	}

	@Override
	public double pressure() {
		return myWeatherData.getPressure();
	}

	@Override
	public double windchill() {
		return Double.valueOf(myData.getOutputData().get(1));
	}

}