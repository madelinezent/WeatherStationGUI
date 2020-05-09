package sensorData;

//Hello

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

import Controller.DataRelay;
import WeatherData.DataType;
import WeatherData.HistoricalDataPoint;
import WeatherData.Sensor;
public class Sensors6 implements ConsoleSensor {

	DataRelay sensorRelay;

	//Create counter variables for every value, such that we make sure we're reading from data synchronously (get next data 
	private int rfCtr = 0, rrCtr = 0, hoCtr = 0, toCtr = 0, wdCtr = 0, wsCtr = 0;

	//Aggregators as represented in LinkedList:
	//[Humidity, Temperature, SoilMoisture, RainFall, UV, SolarRad, WindDireciton, WindSpeed, RainRate]
	//Hum 0, Temp 1, Soil 2, RainF3, X4, X5, WD6, WS7, RR8] -- corresponding indices


	/**
	 * Initializes sensor by creating a data relay object
	 */
	@Override
	public void Initialize() {
		sensorRelay = new DataRelay(DataType.ALL_TYPES, Sensor.OUTSIDE);
		String inputFileLocation = "test10000.txt";
		try {
			File inputFile = new File(inputFileLocation);
			Scanner s = new Scanner(inputFile);   
			int iterations = 0;
			while (s.hasNext()) {
				String next = s.next();
				Double data = Double.parseDouble(next); 
				sensorRelay.acceptDataPoint(data, DataType.ALL_TYPES[iterations % DataType.ALL_TYPES.length]);
				sensorRelay.incrementCal(Calendar.MINUTE, 15); // simulate time passing
				iterations++;
			}
			s.close();

		} catch (FileNotFoundException e) {
			System.out.println("File can not be found.");
		} catch (NumberFormatException e) {
			System.out.println("File contains invalid data, please enter only numbers.");
		}


	}

	/**
	 * Since pressure sensors do not seem to be included, return -1
	 */
	@Override
	public double pressure() {


		return -1;
	}

	/**
	 * Since windchill does not seem to be included, return -1
	 */
	@Override
	public double windchill() {
		return -1;
	}

	/**
	 * Returns the reported rainfall from the rainfall sensor [index 3 in aggregators], and updates the value counter
	 * @Return value at next index in data point list
	 */
	@Override
	public double rainFall() {

		HistoricalDataPoint rain = sensorRelay.getDataPoints().get(3);

		double retVal;

		if (rfCtr < rain.getAllReadings().size()) {
			retVal = rain.getAllReadings().get(rfCtr);

			rfCtr++;
		}
		else {
			retVal = rain.getAllReadings().get(rain.getAllReadings().size() - 1);
		}

		return retVal;


	}

	/**
	 * Returns the reported rainrate from the rainrate sensor [index 8 in aggregators], and updates the value counter
	 * @Return value at next index in data point list
	 */
	@Override
	public double rainRate() {
		HistoricalDataPoint rainRate = sensorRelay.getDataPoints().get(8);
		
		double retVal;

		if (rrCtr < rainRate.getAllReadings().size()) {
			retVal = rainRate.getAllReadings().get(rrCtr);

			rrCtr++;
		}
		else {
			retVal = rainRate.getAllReadings().get(rainRate.getAllReadings().size() - 1);
		}

		return retVal;

		
	}

	/**
	 * Returns the reported humidity from the humidity sensor [index 0 in aggregators], and updates the value counter
	 * @Return value at next index in data point list
	 */
	@Override
	public double humOut() {
		HistoricalDataPoint hum = sensorRelay.getDataPoints().get(0);
		
		double retVal;

		if (hoCtr < hum.getAllReadings().size()) {
			retVal = hum.getAllReadings().get(hoCtr);

			hoCtr++;
		}
		else {
			retVal = hum.getAllReadings().get(hum.getAllReadings().size() - 1);
		}

		return retVal;
		
		
		
	}

	/**
	 * Since interior humidity sensors do not seem to be included, return -1
	 */
	@Override
	public double humIn() {
		return -1;
	}

	/**
	 * Returns the reported temp from the temp sensor [index 1 in aggregators], and updates the value counter
	 * @Return value at next index in data point list
	 */
	@Override
	public double tempOut() {
		HistoricalDataPoint temp = sensorRelay.getDataPoints().get(1);
		double retVal;

		if (toCtr < temp.getAllReadings().size()) {
			retVal = temp.getAllReadings().get(toCtr);

			toCtr++;
		}
		else {
			retVal = temp.getAllReadings().get(temp.getAllReadings().size() - 1);
		}

		return retVal;
		
		
	}

	/**
	 * Since interior temperature sensors do not seem to be included, return -1
	 */
	@Override
	public double tempIn() {
		return -1;
	}

	/**
	 * Returns the reported wind direction from the wind direction sensor [index 6 in aggregators], and updates the value counter
	 * @Return value at next index in data point list
	 */
	@Override
	public double windDirection() {
		HistoricalDataPoint windD = sensorRelay.getDataPoints().get(6);

		double retVal;

		if (wdCtr < windD.getAllReadings().size()) {
			retVal = windD.getAllReadings().get(wdCtr);

			wdCtr++;
		}
		else {
			retVal = windD.getAllReadings().get(windD.getAllReadings().size() - 1);
		}

		return retVal;
	}

	/**
	 * Returns the reported wind speed from the wind speed sensor [index 7 in aggregators], and updates the value counter
	 * @Return value at next index in data point list
	 */
	@Override
	public double windSpeed() {
		HistoricalDataPoint windS = sensorRelay.getDataPoints().get(7);

		double retVal;

		if (wsCtr < windS.getAllReadings().size()) {
			retVal = windS.getAllReadings().get(wsCtr);

			wsCtr++;
		}
		else {
			retVal = windS.getAllReadings().get(windS.getAllReadings().size() - 1);
		}

		return retVal;
	}

}
