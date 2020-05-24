package sensorData;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import model.AbstractOutputDevice;
import model.ISS;

public class Sensors8 extends AbstractOutputDevice implements ConsoleSensor {


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

		ArrayList<AbstractOutputDevice> myDevices = new ArrayList<AbstractOutputDevice>();
		myDevices.add(this);
		new ISS(myDevices);
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
		read(theFileName);

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