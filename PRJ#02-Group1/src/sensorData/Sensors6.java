package sensorData;

import Controller.DataRelay;
public class Sensors6 implements ConsoleSensor {
		
	DataRelay sensorRelay;

	/**
	 * Initializes sensor by creating a data relay object
	 */
	@Override
	public void Initialize() {
		sensorRelay = new DataRelay();
	}

	@Override
	public double pressure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double windchill() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		
		new Sensors6().Initialize();
		
	}

	@Override
	public double rainFall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double rainRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double humOut() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double humIn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double tempOut() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double tempIn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double windDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double windSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
