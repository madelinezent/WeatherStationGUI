package sensorData;

/**
 * The ConsoleSensor interface represents the common behaviors expected from the classes that translate
 * code of each specific ISS implementation to retrieving their specific data values, as float-returning
 * methods.
 * 
 * If the sensor suite does not include a particular value, it is to return the value -1; this is to ensure
 * that when the values are averaged, it is easy to detect and discard values that do not exist.
 * 
 * @author Maxfield England
 *
 */
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
