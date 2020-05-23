package sensorData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import data.WeatherData;
import model.AbstractOutputDevice;
import model.ISS;
import model.WeatherMonitoringApp;

public class Sensors8 extends AbstractOutputDevice implements ConsoleSensor {

	private WeatherData myWeatherThread;
	
	double rainFall;

	double humOut;

	String windDirection;

	double windSpeed;

	double pressure;

	double tempOut;

	double windChill;

	/**
	 * Initializes sensor by creating a ISS object.
	 */
	@Override
	public void Initialize() {
		
		myWeatherThread = new WeatherData();
		
		ArrayList<Sensors8> myDevices = new ArrayList<Sensors8>();
		
		final Runnable myRunTimer = () -> {
			try {
				final Timer weatherTimer = new Timer();
				weatherTimer.schedule(new TimerTask() {

					@Override
					public void run() {
						try {

							final FileOutputStream fileOutputStream = new FileOutputStream("weather.ser");
							final ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
							out.writeObject(myWeatherThread);
							out.close();
							fileOutputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (final Sensors8 output : myDevices) {
							output.ping("weather.ser");
						}
					}
				},res.R.Integers.TWOFIVETHOU, res.R.Integers.TWOFIVETHOU);
			} catch (Exception e) {
				// TODO: handle exception
			}
		};
		final Thread myDataThread = new Thread(myRunTimer);
		myWeatherThread.start();
		myDataThread.start();

	}

	public static void main(String[] args) {

		Sensors8 testSensor = new Sensors8();

		testSensor.Initialize();

		System.out.println("Rain:\tRate:\tHum:\tTemp:\tWndDir:\tWindSp:");
		for (int i = 0; i < 20; i++) {
			System.out.println(testSensor.rainFall() + "\t" + testSensor.rainRate() + "\t" + testSensor.humOut() + "\t"
					+ testSensor.tempOut() + "\t" + testSensor.windDirection() + "\t" + testSensor.windSpeed());
		}
	}

	@Override
	public double rainFall() {
		return rainFall;
	}

	@Override
	public double rainRate() {

		return -1;
	}

	@Override
	public double humOut() {

		return humOut;
	}

	@Override
	public double humIn() {

		return -1;
	}

	@Override
	public double tempOut() {
		return tempOut;
	}

	@Override
	public double tempIn() {
		return -1;
	}

	@Override
	public double windDirection() {
		final ArrayList<Double> windDirectionD = new ArrayList<Double>(
				Arrays.asList(0.0, 45.0, 90.0, 135.0, 180.0, 225.0, 270.0, 315.0));
		final ArrayList<String> windDirectionS = new ArrayList<String>(
				Arrays.asList("N", "NE", "E", "SE", "S", "SW", "W", "NW"));
		final Map<String, Double> windDirectionM = new HashMap<String, Double>();
		for (int i = 0; i < windDirectionD.size(); i++) {
			windDirectionM.put(windDirectionS.get(i), windDirectionD.get(i));
		}
		if (windDirectionM.get(windDirection) != null) {
			double windDirectionDouble = windDirectionM.get(windDirection);
			return windDirectionDouble;
		} else {
			return -1;
		}
	}

	@Override
	public double windSpeed() {
		return windSpeed;
	}

	@Override
	public double pressure() {
		return pressure;
	}

	@Override
	public double windchill() {
		return windChill;
	}

	@Override
	public void ping(String theFileName) {

		ArrayList<String> sensorData = (ArrayList<String>) this.getOutputData();

		rainFall = (Double.parseDouble(sensorData.get(8)));
		humOut = (Double.parseDouble(sensorData.get(9)));
		windDirection = sensorData.get(7);
		windSpeed = (Double.parseDouble(sensorData.get(6)));
		pressure = (Double.parseDouble(sensorData.get(5)));
		tempOut = (Double.parseDouble(sensorData.get(0)));
		windChill = (Double.parseDouble(sensorData.get(1)));

	}

}