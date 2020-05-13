package sensorData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *Implement ISS4 weather station. Read data from OutSide.txt and InSide.txt.
 * @author Xiuxiang Wu
 * @version 5/13/2020
 */ 
public class Sensors4 implements ConsoleSensor {
	private double[] currentData;
	private int hoc = 0, hic = 0, toc = 0, tic = 0, rrc = 0, wsc = 0, wdc = 0, counter = -1;
	private Scanner scannerOut;
	private Scanner scannerIn;
	private File fileOut;
	private File fileIn;
	/**
	 * constructor. call the Initialize method.
	 */
	public void Sensor4() {
		Initialize();
	}

    @Override
	public void Initialize() {
    	currentData = new double[7];
    	fileIn = new File("InSide.txt");
    	fileOut = new File("OutSide.txt");
    	try {
			scannerOut = new Scanner(fileOut);
			scannerIn = new Scanner(fileIn);
		} catch (FileNotFoundException e) {
			System.out.println("File can not be found.");
		} catch (NumberFormatException e) {
			System.out.println("File contains invalid data, please enter only numbers.");
		}
	}
    
    /**
     * Read one line each time from the files and add data into 
     * currentData [windDirection, windSpeed, tempOut, humOut, rainRate, tempIn, tempOut].
     */
	private void update() {
		counter++;
	    	
	    String lineOut = scannerOut.next();
	    String lineIn = scannerIn.next();
	    double[] data = new double[7];
	    if(lineOut != null) {
	    	String[] dataOut = lineOut.split(",");
	    	data[0] = Double.parseDouble(dataOut[1]);			//windDirection
	    	data[1] = Double.parseDouble(dataOut[2]) / 10;		//WindSpeed
	    	data[2] = Double.parseDouble(dataOut[3]) / 10;		//TempOut
	    	data[3] = Double.parseDouble(dataOut[4]) / 10;		//HumOut
	    	data[4] = Double.parseDouble(dataOut[6]) / 100;		//RainRate
	
	    } if(lineIn != null) {
	    	String[] dataIn = lineIn.split(",");
	    	data[5] = Double.parseDouble(dataIn[1]) / 10;		//tempIn
	    	data[6] = Double.parseDouble(dataIn[2]) / 10;		//humidIn
	    	currentData = data;
	    }else {
	    	scannerOut.close();
	    	scannerIn.close();
	    }
	}
/**
 * No data for rainFall.
 * @return -1
 */
	@Override
	public double rainFall() {

		return -1;
	}
	/**
	 * read data from currentData
	 * @return currentData index 4
	 */
	@Override
	public double rainRate() {
		double rainrate = 0;
		
		if(rrc == counter) {
			rainrate = currentData[4];
			rrc++;
		} else {
			update();
		}
		return rainrate;

	}
	/**
	 * read data from currentData
	 * @return currentData index 3
	 */
	@Override
	public double humOut() {
		double humout = 0;
		
		if(hoc == counter) {
			humout = currentData[3];
			hoc++;
		} else {
			update();
		}
		return humout;

	}
	/**
	 * read data from currentData
	 * @return currentData index 6
	 */
	@Override
	public double humIn() {
		double humin = 0;
		
		if(hic == counter) {
			humin = currentData[6];
			hic++;
		} else {
			update();
		}
		return humin;
	}
	/**
	 * read data from currentData
	 * @return currentData index 2
	 */
	@Override
	public double tempOut() {
		double tempout = 0;
		
		if(toc == counter) {
			tempout = currentData[2];
			toc++;
		} else {
			update();
		}
		return tempout;
	}
	/**
	 * read data from currentData
	 * @return currentData index 5
	 */
	@Override
	public double tempIn() {
		double tempin = 0;
		
		if(tic == counter) {
			tempin = currentData[5];
			tic++;
		} else {
			update();
		}
		return tempin;
	}
	/**
	 * read data from currentData
	 * @return currentData index 0
	 */
	@Override
	public double windDirection() {

		double winddirc = 0;
		
		if(wdc == counter) {
			winddirc = currentData[0];
			wdc++;
		} else {
			update();
		}
		return winddirc;
	}
	/**
	 * read data from currentData
	 * @return currentData index 1
	 */
	@Override
	public double windSpeed() {

		double windspeed = 0;
		
		if(wsc == counter) {
			windspeed = currentData[1];
			wsc++;
		} else {
			update();
		}
		return windspeed;
	}

	@Override
	public double pressure() {

		return -1;
	}

	@Override
	public double windchill() {

		return -1;
	}
	public static void main(String[] args){
		Sensors4 sens = new Sensors4();
		System.out.println("tempIn:\thumidIn\tRate:\tHum:\tTemp:\tWndDir:\tWindSp:");
		for (int i = 0; i < 20; i++) {
			System.out.println(sens.tempIn() + "\t" + sens.humIn() + "\t" + sens.rainRate() + "\t" + sens.humOut() + "\t" + sens.tempOut() + "\t" + sens.windDirection() + "\t" + sens.windSpeed());
		}

	}

}
