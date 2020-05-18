package consoleDataCollectors;

import java.util.ArrayList;

/**
 * Store data from weather station.
 * 
 * @author Nam Hoang.
 */

import sensorData.ConsoleSensor;

public class SensorList {

	/** List stores all the console sensors used to create sensor list. */
	ArrayList<ConsoleSensor> mySensors;

	/** Lists to store value of each data from sensors */
	ArrayList<Double> myTempIn, myTempOut, myHumIn, myHumOut, myRainRate, myPressure, myRainFall;

	/**
	 * Initializes lists.
	 * 
	 * @param sensors is list of weather station sensors.
	 */
	public SensorList(ArrayList<ConsoleSensor> sensors) {
		mySensors = sensors;
		
		myTempIn = new ArrayList<>();
		myTempOut = new ArrayList<>();
		myHumIn = new ArrayList<>();
		myHumOut = new ArrayList<>();
		myRainRate = new ArrayList<>();
		myPressure = new ArrayList<>();
		myRainFall = new ArrayList<>();
	}

	/**
	 * Getter method for List of TempIn.
	 */
	public ArrayList<Double> getTempInList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.tempIn();
				if (data < 0) {
					continue;
				}
				myTempIn.add(data);
			}
		}
			return myTempIn;
	}

	/**
	 * Getter method for List of TempOut.
	 */
	public ArrayList<Double> getTempOutList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.tempOut();
				if (data < 0) {
					continue;
				}
				myTempOut.add(data);
			}
		}
		return myTempOut;
	}

	/**
	 * Getter method for List of HumIn.
	 */
	public ArrayList<Double> getHumInList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.humIn();
				if (data < 0) {
					continue;
				}
				myHumIn.add(data);
			}
		}
		return myHumIn;
	}

	/**
	 * Getter method for List of HumOut.
	 */
	public ArrayList<Double> getHumOutList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.humOut();
				if (data < 0) {
					continue;
				}
				myHumOut.add(data);
			}
		}
		return myHumOut;
	}

	/**
	 * Getter method for List of RainRate.
	 */
	public ArrayList<Double> getRainRateList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.rainRate();
				if (data < 0) {
					continue;
				}
				myRainRate.add(data);
			}
		}
		return myRainRate;
	}

	/**
	 * Getter method for List of Pressure.
	 */
	public ArrayList<Double> getPressureList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.pressure();
				if (data < 0) {
					continue;
				}
				myPressure.add(data);
			}
		}
		return myPressure;
	}

	/**
	 * Getter method for List of RainFall.
	 */
	public ArrayList<Double> getRainFallList() {
		for (ConsoleSensor sensor : mySensors) {
			if (sensor != null) {
				double data = sensor.rainFall();
				if (data < 0) {
					continue;
				}
				myRainFall.add(data);
			}
		}
		return myRainFall;
	}

}
