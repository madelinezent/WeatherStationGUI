package consoleDataCollectors;

import java.util.ArrayList;
import sensorData.ConsoleSensor;

/**
 * Calls and stores data from selected console sensors and saves
 * historical data.
 * 
 * @author Maxfield England
 * @author XiuXiang Wu
 * @author Deline Zent
 */
public class DataType {

	/** Lists for every data type to store historical data. */
	ArrayList<Double> windDirectionHistory, windSpeedHistory, windChillHistory,
			rainRateHistory, rainFallHistory,humInHistory, humOutHistory,
			tempInHistory, tempOutHistory, pressureHistory;
	/** List stores all the console sensors used to calculate averages. */
	ArrayList<ConsoleSensor> mySensors;
	/** Current weather values for each sensor. */
	double currentWindDirection, currentWindSpeed, currentWindChill, currentRainRate, 
			currentRainFall, currentHumIn, currentHumOut, 
			currentTempIn, currentTempOut, currentPressure;

	/**
	 * Initializes every historical data type list and saves the
	 * console sensors which will be used to calculate data averages.
	 *
	 * @param sensors is the list of console sensors used for data collection
	 */
	public DataType(ArrayList<ConsoleSensor> sensors) {
		mySensors = sensors;
		windDirectionHistory = new ArrayList<Double>();
		windSpeedHistory = new ArrayList<Double>();
		windSpeedHistory = new ArrayList<Double>();
		windChillHistory = new ArrayList<Double>();
		rainRateHistory = new ArrayList<Double>();
		rainFallHistory = new ArrayList<Double>();
		humInHistory = new ArrayList<Double>();
		humOutHistory = new ArrayList<Double>();
		tempInHistory = new ArrayList<Double>();
		tempOutHistory = new ArrayList<Double>();
		pressureHistory = new ArrayList<Double>();
	}

	/** Getter methods for historical data lists. */
	public ArrayList<Double> getWindDirectionHistory() {return windDirectionHistory;}
	public ArrayList<Double> getWindSpeedHistory() {return windSpeedHistory;}
	public ArrayList<Double> getWindChillHistory() {return windChillHistory;}
	public ArrayList<Double> getRainRateHistory() {return rainRateHistory;};
	public ArrayList<Double> getRainFallHistory() {return rainFallHistory;}
	public ArrayList<Double> getHumInHistory() {return humInHistory;}
	public ArrayList<Double> getHumOutHistory() {return humOutHistory;}
	public ArrayList<Double> getTempInHistory() {return tempInHistory;}
	public ArrayList<Double> getTempOutHistory() {return tempOutHistory;}

	/** Getter methods for current data to display on the GUI. */
	public double getCurrentWindDirection() {return currentWindDirection;}
	public double getCurrentWindSpeed() {return currentWindSpeed;}
	public double getCurrentWindChill() {return currentWindChill;}
	public double getCurrentRainRate() {return currentRainRate;}
	public double getCurrentRainFall() {return currentRainFall;}
	public double getCurrentHumIn() {return currentHumIn;}
	public double getCurrentHumOut() {return currentHumOut; }
	public double getCurrentTempIn() {return currentTempIn;}
	public double getCurrentTempOut() {return currentTempOut;}
	public double getCurrentPressure() {return currentPressure;}

	/** Updates data for each sensor and their
	 *  corresponding historical data lists. */
	public void update() {
		updateWindDirection();
		updateWindSpeed();
		updateWindChill();
		updateRainRate();
		updateRainFall();
		updateHumIn();
		updateHumOut();
		updateTempIn();
		updateTempOut();
	}

	private void updateWindDirection() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.windDirection();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentWindDirection = total / sensorsUsed;
		windDirectionHistory.add(currentWindDirection);
	}

	private void updateWindSpeed() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.windSpeed();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentWindSpeed = total / sensorsUsed;
		windSpeedHistory.add(currentWindSpeed);
	}

	private void updateWindChill() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.windchill();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentWindChill = total / sensorsUsed;
		windChillHistory.add(currentWindChill);
	}

	private void updateRainRate() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.rainRate();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentRainRate = total / sensorsUsed;
		rainRateHistory.add(currentRainRate);
	}

	private void updateRainFall() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.rainFall();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentRainFall = total / sensorsUsed;
		rainFallHistory.add(currentRainFall);
	}

	private void updateHumIn() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.humIn();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentHumIn = total / sensorsUsed;
		humInHistory.add(currentHumIn);
	}

	private void updateHumOut() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.humOut();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentHumOut = total / sensorsUsed;
		humOutHistory.add(currentHumOut);
	}

	private void updateTempIn() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.tempIn();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentTempIn = total / sensorsUsed;
		tempInHistory.add(currentTempIn);
	}

	private void updateTempOut() {
		int total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.tempOut();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		currentTempOut = total / sensorsUsed;
		tempOutHistory.add(currentTempOut);
	}

}
