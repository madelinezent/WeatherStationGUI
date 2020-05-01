package sensorData;

public interface ConsoleSensor {

	/**
	* Defines setup protocol for creating a new sensor suite for connecting to the console.
	**/
	public void Initialize(); // needs arguments? Return?

	/**
	* Returns uniform sensor data to be read by the console.
	**/
	public void getData(); // retrieve sensor data 

	
	//Sensor fields to be displayed by the console
	
	public double rainfall();

	public double humidity();
	
	public double temperature();
	
	public double pressure();
	
	//Provided by sensors, or calculated by console?
	public double windchill();
	
	
	
}
