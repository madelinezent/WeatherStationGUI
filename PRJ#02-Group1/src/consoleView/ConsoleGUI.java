package consoleView;
import java.awt.*;
import javax.swing.*;

import java.time.LocalDateTime;

/**
 * Console display. Display average data from most 8 different weather stations.
 * @author Xiuxiang Wu
 * @version 5-11-2020
 */

public class ConsoleGUI {
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The width of the screen. */
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width;
    
    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

	/**Create JFrame object to display GUI.*/
	private final JFrame myFrame;

	 /**Containers to organize components.*/
	private JPanel myDisplay, left, temp, graph, compass, buttons;

	/** Multi-line area that displays plain text.*/
	private JTextArea myDate, myTime, myTemp, myRain, myHumid, 
						myTempIn, myHumidIn, myPressure, myWindSpeed;
	/** Multi-line buttons.*/
	private JButton temprature, humidity, windSpeed, rainRate, hilow, graphic,rainFall;

/**
 * Construction for the GUI. Initialize all the global variables.
 */
	public ConsoleGUI(){
		//initialize frame.
		myFrame = new JFrame("Weather");
		
		/** initialize panels.*/
	    myDisplay = new JPanel();
	    left = new JPanel();
	    graph = new JPanel();	
	    compass = new JPanel();	
	    temp = new JPanel();
	    buttons = new JPanel();
	   
	    //initialize buttons.
	    temprature = new JButton("TEMP");
	    humidity = new JButton("HUM");
	    windSpeed = new JButton("WIND");
	    rainRate = new JButton("RAINRATE");
	    hilow = new JButton("HI/LOW");    
	    graphic = new JButton("GRAPH");
	    rainFall = new JButton("RAINFALL"); 
	    
	    //initialize textAreas.
	    myDate = new JTextArea(50, 30);
	    myTime = new JTextArea(50, 30);
	    myTemp = new JTextArea(50, 30);
	    myRain = new JTextArea(50, 30);
	    myHumid = new JTextArea(50, 30);
	    myTempIn = new JTextArea(50, 30);
	    myHumidIn = new JTextArea(50, 30);
	    myPressure = new JTextArea(50, 30);
	    myWindSpeed = new JTextArea(50, 30);
	    	    
	    myFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setupGUI();
		
		
	}
	
	/**
	 * GUI frame to display data. Compass, graph, values for myDate, myTime, myTemp, myRain, myHumid, 
															myTempIn, myHumidIn, myPressure, myWindSpeed;
	 */
	 private void setupGUI() {

		 compass.add(new JLabel("campass"));	     
	     graph.add(new JLabel ("graph"));
	     
	     left.setLayout(new GridLayout(2,1));
	     left.add(compass);
	     left.add(graph);
	     
	     myDisplay.setLayout(new BorderLayout());
	     myDisplay.add(temp, BorderLayout.EAST);
	     myDisplay.add(left, BorderLayout.WEST);

	     temp.setLayout(new GridLayout(6, 3));
	     temp.add(new JLabel("Date"));
	     temp.add(new JLabel("Time"));
	     temp.add(new JLabel("WIND SPEED"));	     
	     temp.add(myDate);
	     temp.add(myTime);
	     temp.add(myWindSpeed);
	     
	     temp.add(new JLabel("TEMP OUT"));
	     temp.add(new JLabel("HUM OUT"));
	     temp.add(new JLabel("PRESSURE"));
	     temp.add(myTemp);
	     temp.add(myHumid);
	     temp.add(myPressure);
	    
	     temp.add(new JLabel("TEMP IN"));
	     temp.add(new JLabel("HUM IN"));
	     temp.add(new JLabel("RAIN RATE"));	
	     temp.add(myTempIn);
	     temp.add(myHumidIn);
	     temp.add(myRain);
	     
	     buttons.setLayout(new GridLayout(4,2));
	     buttons.add(temprature);
	     buttons.add(humidity);
	     buttons.add(windSpeed);
	     buttons.add(rainRate);
	     buttons.add(hilow);
	     buttons.add(rainFall);
	     buttons.add(graphic);

 
	     myFrame.setLayout(new BorderLayout());
	     myFrame.add(myDisplay, BorderLayout.CENTER);
	     myFrame.add(buttons, BorderLayout.EAST);	     
	    	     
		 myFrame.setResizable(false);
		 myFrame.setVisible(true);

			
	 }
	 public void updata() {

		 
	 }
	 public static void main(final String[] theArgs) {
		 ConsoleGUI gui = new ConsoleGUI();

		 
		 
	 }


}
