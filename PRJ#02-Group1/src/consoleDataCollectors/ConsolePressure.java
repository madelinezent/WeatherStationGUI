package consoleDataCollectors;

import java.util.ArrayList;

import sensorData.ConsoleSensor;

public class ConsolePressure extends DataType {

	public ConsolePressure(ArrayList<ConsoleSensor> sensors) {
		super(sensors);
	}
	
	/**
	 * Collects data from all connected sensor devices and averages them for output. If the individual sensor returns a -1, their data is not
	 * considered.
	 */
	@Override
	public void update() {
		
		double total = 0;
		int numSensors = 0;
		
		for (int i = 0; i < sensors.size(); i++) {
			
			//Get current sensor value
			double currVal = sensors.get(i).pressure();
			
			if (currVal >= 0) {
				total += currVal;
				numSensors++;
			}
		}
		
		double newVal = 0;
		if (numSensors > 0) {
			newVal = total / numSensors;
		}

		this.currentVal = newVal;
		this.history.add(newVal);
		
	}

}
