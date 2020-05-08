package consoleDataCollectors;

import java.util.ArrayList;

import sensorData.ConsoleSensor;

public abstract class DataType {

	//TODO: Determine if ArrayList is the best data structure for maintaining history. It won't ever be too large, and not too expensive to update,
	//so our choice shouldn't be incredibly important as long as we can access top ~10 or so values for graphing.
	public ArrayList<Double> history = new ArrayList<Double>();
	
	ArrayList<ConsoleSensor> sensors;
	
	public double currentVal;
	
	DataType(ArrayList<ConsoleSensor> sensors) {
		
		this.sensors = sensors;
		currentVal = 0;
		
	}
	
	public abstract void update();
	
	
	
}
