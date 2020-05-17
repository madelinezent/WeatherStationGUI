package consoleView;
import java.awt.*;
import javax.swing.*;

import consoleDataCollectors.DataType;

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
    
    private static DataType myData;

	/**Create JFrame object to display GUI.*/
	private final JFrame myFrame;

	 /**Containers to organize components.*/
	private JPanel myDisplay, left, graph, compass, buttons, details, date, values,bottom, top, layer1, layer2, layer3, top1, top2, top3, bottom1, bottom2, bottom3;


	/** Multi-line area that displays plain text.*/
	private JTextField myTemp, myTempIn, myHumid, myHumidIn, myDate, myTime, myRainRate, myRainFall, myPressure, myWindChill, myRainIcon, myCloudIcon, myMoonIcon;
	/** Multi-line buttons.*/
	private JButton temprature, humidity,tempratureIn,humidityIn, rainRate, hilow, pressure,rainFall;
	
	private WindCompass myCompass;

	
	public ConsoleGUI(DataType theData){
		myData = theData;
		//initialize frame.
		myFrame = new JFrame("Weather");
		
		/** initialize panels.*/
	    myDisplay = new JPanel();
	    left = new JPanel();
	    graph = new JPanel();	
	    compass = new JPanel();	
	    details = new JPanel();
	    date = new JPanel();
	    buttons = new JPanel();
	    values = new JPanel();
	    bottom = new JPanel();
	    top = new JPanel();
	    layer1 = new JPanel();
	    layer2 = new JPanel();
	    layer3 = new JPanel();
	    top1 = new JPanel();
	    top2 = new JPanel();
	    top3 = new JPanel();
	    bottom1 = new JPanel();
	    bottom2 = new JPanel();
	    bottom3 = new JPanel();
	    
	   
	    //initialize buttons.
	    temprature = new JButton("TEMP");
	    tempratureIn = new JButton("TEMPIN");
	    humidity = new JButton("HUM");
	    humidityIn = new JButton("HUMIN");
	    rainRate = new JButton("RAINRATE");
	    hilow = new JButton("HI/LOW");    
	    pressure = new JButton("PRESSURE");
	    rainFall = new JButton("RAINFALL"); 

	    myTime = new JTextField(15);
	    myDate = new JTextField(15);
	    myCloudIcon = new JTextField(15);
	    myMoonIcon = new JTextField(15);
	    myTemp = new JTextField(15);
	    myRainRate = new JTextField(15);
	    myRainFall = new JTextField(15);
	    myHumid = new JTextField(15);
	    myTempIn = new JTextField(15);
	    myHumidIn = new JTextField(15);
	    myPressure = new JTextField(15);
	    myWindChill = new JTextField(15);
	    myRainIcon = new JTextField(15);

	    //Initialize compass.
	    myCompass = new WindCompass();
	    
	    //myFrame.setSize(SCREEN_WIDTH*4/5, SCREEN_HEIGHT*4/5);
	    myFrame.setSize(new Dimension(1000, 1000));
	    
		setupGUI();		
	}
	 private void setupGUI() {
		 date.setLayout(new GridLayout(2,4));
		 date.add(new JLabel("CouldIcon"));
		 date.add(new JLabel("MoonIcon"));
		 date.add(new JLabel("TIME"));
		 date.add(new JLabel("DATE"));
		 date.add(myCloudIcon);
		 date.add(myMoonIcon);
		 date.add(myTime);
		 date.add(myDate);

		 details.setLayout(new BorderLayout());
		 details.add(date, BorderLayout.NORTH);
		 details.add(values, BorderLayout.CENTER);
		 
		 top1.setLayout(new GridLayout(2,3));
		 top1.add(new JLabel("           "));
		 top1.add(new JLabel("           "));
		 top1.add(new JLabel("           "));
		 top1.add(new JLabel("TEMP OUt"), new Font("Courier New", Font.BOLD, 30));
		 top1.add(new JLabel("HUM OUT"), new Font("Courier New", Font.BOLD, 30));
		 top1.add(new JLabel("Pressure"), new Font("Courier New", Font.BOLD, 30));

		 bottom1.setLayout(new GridLayout(2,3));
		 bottom1.add(myTemp);
		 bottom1.add(myHumid);
		 bottom1.add(myPressure);
		 bottom1.add(new JLabel("           "));
		 bottom1.add(new JLabel("           "));
		 bottom1.add(new JLabel("           "));
		 
		 top2.setLayout(new GridLayout(2,3));
		 top2.add(new JLabel("           "));
		 top2.add(new JLabel("           "));
		 top2.add(new JLabel("           "));
		 top2.add(new JLabel("TEMP IN"));
		 top2.add(new JLabel("HUM In"));
		 top2.add(new JLabel("WINDCHILL"));
		 bottom2.setLayout(new GridLayout(2,3));
		 bottom2.add(myTempIn);
		 bottom2.add(myHumidIn);
		 bottom2.add(myWindChill);
		 bottom2.add(new JLabel("           "));
		 bottom2.add(new JLabel("           "));
		 bottom2.add(new JLabel("           "));
		 
		 
		 top3.setLayout(new GridLayout(2,3));
		 top3.add(new JLabel("           "));
		 top3.add(new JLabel("           "));
		 top3.add(new JLabel("           "));
		 top3.add(new JLabel("Dayly Inch"));
		 top3.add(new JLabel("RainIcon"));
		 top3.add(new JLabel("RAINRATE"));
		 bottom3.setLayout(new GridLayout(2,3));
		 bottom3.add(myRainFall);
		 bottom3.add(myRainIcon);
		 bottom3.add(myRainRate);
		 bottom3.add(new JLabel("           "));
		 bottom3.add(new JLabel("           "));
		 bottom3.add(new JLabel("           "));

		 layer1.setLayout(new BorderLayout());
		 layer1.add(top1, BorderLayout.NORTH);
		 layer1.add(bottom1, BorderLayout.CENTER);
		 
		 layer2.setLayout(new BorderLayout());
		 layer2.add(top2, BorderLayout.NORTH);
		 layer2.add(bottom2, BorderLayout.CENTER);
		 
		 layer3.setLayout(new BorderLayout());
		 layer3.add(top3, BorderLayout.NORTH);
		 layer3.add(bottom3, BorderLayout.CENTER);
		 
		 values.setLayout(new GridLayout(3,1));
		 values.add(layer1);
		 values.add(layer2);
		 values.add(layer3);
		 
		 compass.add(myCompass);
		 myCompass.setVisible(true);
	     graph.add(new JLabel ("graph"));
	     
	     left.setLayout(new GridLayout(2,1));
	     left.add(compass);
	     left.add(graph);
	     
	     myDisplay.setLayout(new BorderLayout());
	     myDisplay.add(details, BorderLayout.EAST);
	     myDisplay.add(left, BorderLayout.WEST);
     
	     buttons.setLayout(new GridLayout(12,2));
	     buttons.add(new JLabel("           "));
	     buttons.add(new JLabel("           "));
	     buttons.add(new JLabel("           "));
	     buttons.add(new JLabel("           "));
	     buttons.add(temprature);
	     buttons.add(rainRate);
	     buttons.add(new JLabel("           "));
	     buttons.add(new JLabel("           "));
	     buttons.add(tempratureIn);
	     buttons.add(rainFall);
	     buttons.add(new JLabel("           "));
	     buttons.add(new JLabel("           "));
	     buttons.add(humidity);
	     buttons.add(pressure);
	     buttons.add(new JLabel("           "));
	     buttons.add(new JLabel("           "));
	     buttons.add(humidityIn);
	     buttons.add(hilow);

	     myFrame.setLayout(new BorderLayout());
	     myFrame.add(myDisplay, BorderLayout.CENTER);
	     myFrame.add(buttons, BorderLayout.EAST);
	     myFrame.add(bottom, BorderLayout.SOUTH);
	     myFrame.add(top, BorderLayout.NORTH);
	    	     
		 myFrame.setResizable(false);
		 myFrame.setVisible(true);
		 myFrame.pack();			
	 }
	 public void updata() {

	 }
//	 public static void main(final String[] theArgs) {
//		 ConsoleGUI gui = new ConsoleGUI();
//
//		 
//		 
//	 }


}

