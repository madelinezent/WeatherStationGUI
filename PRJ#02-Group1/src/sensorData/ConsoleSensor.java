package sensorData;

public interface ConsoleSensor {

	/**
	* Defines setup protocol for creating a new sensor suite for connecting to the console.
	**/
	public void Initialize(); // needs arguments? Return?
	
	//Sensor fields to be displayed by the console	
	public double rainFall();

	public double rainRate();
	
	public double humOut();
	
	public double humIn();
	
	public double tempOut();
	
	public double tempIn();
	
	public double windDirection();
	
	public double windSpeed();
	
	public double pressure();
	
	public double windchill();

	
}
