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
	private double currentWindDirection, currentWindSpeed, currentWindChill, currentRainRate, 
			currentRainFall, currentHumIn, currentHumOut, 
			currentTempIn, currentTempOut, currentPressure;
	
	/**Maximum weather values for each sensor. */
	private double maxWindSpeed, maxWindChill, maxRainRate, maxRainFall,
			maxHumIn, maxHumOut, maxTempIn, maxTempOut, maxPressure;

	/**Minimum weather values for each sensor. */
	private double minWindSpeed, minWindChill, minRainRate, minRainFall,
	minHumIn, minHumOut, minTempIn, minTempOut, minPressure;
	
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
		
		for (ConsoleSensor sensor : sensors) {
			
			sensor.Initialize();
		}
		
		//Initialize all min and max values for comparison: make max values low and min values high
		//so that first compared values are used instead of straight 0 unless it naturally occurs
		maxWindSpeed = 0; maxWindChill = 0;
		maxRainRate = 0; maxRainFall = 0; maxHumIn = 0; maxHumOut = 0;
		maxTempIn = 0; maxTempOut = 0; maxPressure = 0;
		
		minWindSpeed = 1000; minWindChill = 1000;
		minRainRate = 1000; minRainFall = 1000; minHumIn = 1000; minHumOut = 1000;
		minTempIn = 1000; minTempOut = 1000; minPressure = 1000;
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
	public ArrayList<Double> getPressureHistory() {return pressureHistory;}

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
	
	/**Getter methods for maximum data to display on the GUI if selected. */
	public double getMaxWindSpeed() {return maxWindSpeed;}
	public double getMaxWindChill() {return maxWindChill;}
	public double getMaxRainRate() {return maxRainRate;}
	public double getMaxRainFall() {return maxRainFall;}
	public double getMaxHumIn() {return maxHumIn;}
	public double getMaxHumOut() {return maxHumOut; }
	public double getMaxTempIn() {return maxTempIn;}
	public double getMaxTempOut() {return maxTempOut;}
	public double getMaxPressure() {return maxPressure;}
	
	/**Getter methods for minimum data to display on the GUI if selected. */
	public double getMinWindSpeed() {return minWindSpeed;}
	public double getMinWindChill() {return minWindChill;}
	public double getMinRainRate() {return minRainRate;}
	public double getMinRainFall() {return minRainFall;}
	public double getMinHumIn() {return minHumIn;}
	public double getMinHumOut() {return minHumOut; }
	public double getMinTempIn() {return minTempIn;}
	public double getMinTempOut() {return minTempOut;}
	public double getMinPressure() {return minPressure;}

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
		updatePressure();
	}

	private void updateWindDirection() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.windDirection();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentWindDirection = total / sensorsUsed;
		else currentWindDirection = 0;
		windDirectionHistory.add(currentWindDirection);
	}

	private void updateWindSpeed() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.windSpeed();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentWindSpeed = total / sensorsUsed;
		else currentWindSpeed = 0;
		windSpeedHistory.add(currentWindSpeed);
		
		if (currentWindSpeed > maxWindSpeed) maxWindSpeed = currentWindSpeed;
		if (currentWindSpeed < minWindSpeed) minWindSpeed = currentWindSpeed;
	}

	private void updateWindChill() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.windchill();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
			System.out.println("Incrementing sensors");
		}
		if (sensorsUsed > 0) currentWindChill = total / sensorsUsed;
		else currentWindChill = 0;
		windChillHistory.add(currentWindChill);
		
		if (currentWindChill > maxWindChill) maxWindChill = currentWindChill;
		if (currentWindChill < minWindChill) minWindChill = currentWindChill;
	}

	private void updateRainRate() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.rainRate();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentRainRate = total / sensorsUsed;
		else currentRainRate = 0;
		rainRateHistory.add(currentRainRate);
		
		if (currentRainRate > maxRainRate) maxRainRate = currentRainRate;
		if (currentRainRate < minRainRate) minRainRate = currentRainRate;
	}

	private void updateRainFall() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.rainFall();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentRainFall = total / sensorsUsed;
		else currentRainFall = 0;
		rainFallHistory.add(currentRainFall);
		
		if (currentRainFall > maxRainFall) maxRainFall = currentRainFall;
		if (currentRainFall < minRainFall) minRainFall = currentRainFall;
	}

	private void updateHumIn() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.humIn();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentHumIn = total / sensorsUsed;
		else currentHumIn = 0;
		humInHistory.add(currentHumIn);
		
		if (currentHumIn > maxHumIn) maxHumIn = currentHumIn;
		if (currentHumIn < minHumIn) minHumIn = currentHumIn;

	}

	private void updateHumOut() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.humOut();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentHumOut = total / sensorsUsed;
		else currentHumOut = 0;
		humOutHistory.add(currentHumOut);
		
		if (currentHumOut > maxHumOut) maxHumOut = currentHumOut;
		if (currentHumOut < minHumOut) minHumOut = currentHumOut;

	}

	private void updateTempIn() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.tempIn();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentTempIn = total / sensorsUsed;
		else currentTempIn = 0;
		tempInHistory.add(currentTempIn);
		
		if (currentTempIn > maxTempIn) maxTempIn = currentTempIn;
		if (currentTempIn < minTempIn) minTempIn = currentTempIn;

	}

	private void updateTempOut() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.tempOut();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentTempOut = total / sensorsUsed;
		else currentTempOut = 0;
		tempOutHistory.add(currentTempOut);
		
		if (currentTempOut > maxTempOut) maxTempOut = currentTempOut;
		if (currentTempOut < minTempOut) minTempOut = currentTempOut;

	}
	
	private void updatePressure() {
		double total = 0, sensorsUsed = 0;
		for (ConsoleSensor sensor : mySensors) {
			double data = sensor.pressure();
			if (data < 0) {continue;}
			total += data;
			sensorsUsed++;
		}
		if (sensorsUsed > 0) currentPressure = total / sensorsUsed;
		else currentPressure = 0;
		pressureHistory.add(currentPressure);
		
		if (currentPressure > maxPressure) maxPressure = currentPressure;
		if (currentPressure < minPressure) minPressure = currentPressure;

		}

}
