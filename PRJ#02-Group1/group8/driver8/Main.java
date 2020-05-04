package driver8;

import java.util.ArrayList;

import model.ISS;
import model.AbstractOutputDevice;
import model.WeatherMonitoringApp;

/**
 * Launches the ISS program.
 * @author Adam Amado
 * @version Spring 2020
 */
final class Main {
	
	/**
	 * Empty private constructor.
	 */
    private Main() {
    }
	
	/**
	 * 
	 * Runs the program.
	 * @param theArgs used for command line arguments
	 */
    public static void main(final String[] theArgs) {

        //Test output device used exclusively for testing purposes.
        final WeatherMonitoringApp testApp = new WeatherMonitoringApp();

        final ArrayList<AbstractOutputDevice> testDeviceArray = 
				new ArrayList<AbstractOutputDevice>();
        testDeviceArray.add(testApp);

        new ISS(testDeviceArray);
    }
}
