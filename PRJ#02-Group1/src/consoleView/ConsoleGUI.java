package consoleView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

import consoleDataCollectors.DataType;
import consoleDataCollectors.SensorList;

/**
 * Console display. Display average data from most 8 different weather stations.
 * 
 * @author Xiuxiang Wu
 * @author Nam Hoang
 * @author Maxfield England
 * @version 5-23-2020
 */

public class ConsoleGUI implements ActionListener {

	private static DataType myData;

	private static Font dataFont = new Font("Courier New", Font.BOLD, 30);
	private static Font dataFontMini = new Font("Courier New", Font.BOLD, 14);
	private static Font dataFontMed = new Font("Courier New", Font.BOLD, 18);

	private enum DisplayState {CURRENT, MAX, MIN};
	private DisplayState myState = DisplayState.CURRENT;

	private enum GraphData {TEMPOUT, TEMPIN, HUMOUT, HUMIN, RAINRATE, RAINFALL, PRESSURE};
	private GraphData currGraphing = GraphData.TEMPOUT;

	/** Create JFrame object to display GUI. */
	private final JFrame myFrame;

	/** Containers to organize components. */
	private JPanel myDisplay, left, compass, buttons, top, dataPanel;

	/** Multi-line area that displays plain text. */
	private JLabel myTemp, myTempIn, myHumid, myHumidIn, myDate, myTime, myRainRate, myRainFall, myPressure,
	myWindChill, myCloudIcon, myMoonIcon, displayState;
	/** Multi-line buttons. */
	private JButton temperature, humidity, temperatureIn, humidityIn, rainRate, hilow, pressure, rainFall;
	private String myGraphLabel;
	private WindCompass myCompass;
	private Graph myGraph;
	private JPanel weatherPanel; 
	
	//Display values with decimal format of 1 decimal place.
	private DecimalFormat df = new DecimalFormat("0.0");

	public ConsoleGUI(DataType theData, SensorList theList) {
		myData = theData;
		// initialize frame.
		myFrame = new JFrame("Vantage Pro2 Console Receiver");

		/** initialize panels. */
		myDisplay = new JPanel();
		left = new JPanel();
		//graph = new JPanel();
		compass = new JPanel();
		buttons = new JPanel();
		top = new JPanel();
		weatherPanel = new JPanel();
		
		dataPanel = new JPanel();

		// initialize buttons.
		temperature = new JButton("TEMP");
		temperatureIn = new JButton("TEMPIN");
		humidity = new JButton("HUM");
		humidityIn = new JButton("HUMIN");
		rainRate = new JButton("RAINRATE");
		hilow = new JButton("HI/LOW");
		pressure = new JButton("PRESSURE");
		rainFall = new JButton("RAINFALL");

		myTime = new JLabel();
		myDate = new JLabel();
		myCloudIcon = new JLabel();
		myMoonIcon = new JLabel();
		myTemp = new JLabel();
		myRainRate = new JLabel();
		myRainFall = new JLabel();
		myHumid = new JLabel();
		myTempIn = new JLabel();
		myHumidIn = new JLabel();
		myPressure = new JLabel();
		myWindChill = new JLabel();

		//Collect date and format
		myDate.setFont(dataFontMed);
		myTime.setFont(dataFontMed);
		String[] date = java.time.LocalDate.now().toString().split("-");
		myDate.setText(date[1] + "/" + date[2]);
		
		//Initialize weather/moon phase
		myCloudIcon.setIcon(new ImageIcon(ConsoleGUI.class.getResource("/displayImgs/clear.png")));
		
		//Moon phase will just be static first quarter
		myMoonIcon.setIcon(new ImageIcon(ConsoleGUI.class.getResource("/displayImgs/moonIcon.png")));
		
		weatherPanel.add(myCloudIcon);
		weatherPanel.add(myMoonIcon);
		// Initialize compass and graph.
		myGraphLabel = "Temperature";
		myCompass = new WindCompass();
		myGraph = new Graph(myData.getTempOutHistory(), myGraphLabel );
//		myGraphLabel = new JLabel("Temperature");
//		myGraphLabel.setFont(dataFontMini);
		
		displayState = new JLabel("Displaying CURRENT");
		displayState.setFont(dataFontMini);
		
		myFrame.setSize(new Dimension(1000, 1000));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setupGUI();
		update();
		
		ActionListener updateAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();

			}
		};

		update();
		Timer updateTimer = new Timer(2500, updateAction);
		
		updateTimer.setRepeats(true);
		
		updateTimer.start();

	}

	private void setupGUI() {

		JLabel toLabel = new JLabel("TEMP OUT");
		toLabel.setFont(dataFontMini);
		JLabel hoLabel = new JLabel("HUM OUT");
		hoLabel.setFont(dataFontMini);
		JLabel presLabel = new JLabel("BAROMETER");
		presLabel.setFont(dataFontMini);
		JLabel tiLabel = new JLabel("TEMP IN");
		tiLabel.setFont(dataFontMini);
		JLabel hiLabel = new JLabel("HUM IN");
		hiLabel.setFont(dataFontMini);
		JLabel wcLabel = new JLabel("CHILL");
		wcLabel.setFont(dataFontMini);
		JLabel rrLabel = new JLabel("RAIN");
		rrLabel.setFont(dataFontMini);
		JLabel rfLabel = new JLabel ("DAILY RAIN");
		rfLabel.setFont(dataFontMini);
		
		JPanel toPanel = new JPanel(new BorderLayout());
		toPanel.add(toLabel, BorderLayout.NORTH);
		toPanel.add(myTemp, BorderLayout.SOUTH);
		
		JPanel hoPanel = new JPanel(new BorderLayout());
		hoPanel.add(hoLabel, BorderLayout.NORTH);
		hoPanel.add(myHumid, BorderLayout.SOUTH);
		
		JPanel presPanel = new JPanel(new BorderLayout());
		presPanel.add(presLabel, BorderLayout.NORTH);
		presPanel.add(myPressure, BorderLayout.SOUTH);
		
		JPanel tiPanel = new JPanel(new BorderLayout());
		tiPanel.add(tiLabel, BorderLayout.NORTH);
		tiPanel.add(myTempIn, BorderLayout.SOUTH);
		
		JPanel hiPanel = new JPanel(new BorderLayout());
		hiPanel.add(hiLabel, BorderLayout.NORTH);
		hiPanel.add(myHumidIn, BorderLayout.SOUTH);
		
		JPanel wcPanel = new JPanel(new BorderLayout());
		wcPanel.add(wcLabel, BorderLayout.NORTH);
		wcPanel.add(myWindChill, BorderLayout.SOUTH);
		
		JPanel rrPanel = new JPanel(new BorderLayout());
		rrPanel.add(rrLabel, BorderLayout.NORTH);
		rrPanel.add(myRainRate, BorderLayout.SOUTH);
		
		JPanel rfPanel = new JPanel(new BorderLayout());
		rfPanel.add(rfLabel, BorderLayout.NORTH);
		rfPanel.add(myRainFall, BorderLayout.SOUTH);
		
		GridBagLayout gbl = new GridBagLayout();
		dataPanel.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
        //gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(0, 0, 50, 0);
		gbc.gridx = 5;
		gbc.gridy = 0;
		dataPanel.add(myCloudIcon, gbc);
		gbc.gridx = 6;
		gbc.gridy = 0;
		dataPanel.add(myMoonIcon, gbc);
		gbc.gridx = 7;
		gbc.gridy = 0;
		dataPanel.add(myTime, gbc);
		gbc.gridx = 8;
		gbc.gridy = 0;
		dataPanel.add(myDate, gbc);
		
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 50, 30);
		gbc.gridx = 5;
		gbc.gridy = 1;
		dataPanel.add(toPanel, gbc);
		gbc.gridx = 6;
		gbc.gridy = 1;
		dataPanel.add(hoPanel, gbc);
		gbc.gridx = 7;
		gbc.gridy = 1;
		dataPanel.add(presPanel, gbc);
		
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 50, 70);
		gbc.gridx = 5;
		gbc.gridy = 2;
		dataPanel.add(tiPanel, gbc);
		gbc.gridx = 6;
		gbc.gridy = 2;
		dataPanel.add(hiPanel, gbc);
		gbc.gridx = 7;
		gbc.gridy = 2;
		dataPanel.add(wcPanel, gbc);
		
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 50, 30);
		gbc.gridx = 5;
		gbc.gridy = 3;
		dataPanel.add(rfPanel, gbc);
		gbc.gridx = 7;
		gbc.gridy = 3;
		dataPanel.add(rrPanel, gbc);

		compass.add(myCompass);
		myCompass.setVisible(true);
		myGraph.setVisible(true);

		left.setLayout(new BorderLayout());
		left.add(compass, BorderLayout.NORTH);
		left.add(myGraph, BorderLayout.CENTER);

		myDisplay.setLayout(new BorderLayout());
		myDisplay.add(dataPanel, BorderLayout.CENTER);
		myDisplay.add(left, BorderLayout.WEST);

		buttons.setLayout(new GridLayout(9, 2));
		buttons.add(new JLabel(" "));
		buttons.add(new JLabel(" "));
		buttons.add(temperature);
		buttons.add(rainRate);
		buttons.add(new JLabel(" "));
		buttons.add(new JLabel(" "));
		buttons.add(temperatureIn);
		buttons.add(rainFall);
		buttons.add(new JLabel(" "));
		buttons.add(new JLabel(" "));
		buttons.add(humidity);
		buttons.add(pressure);
		buttons.add(new JLabel(" "));
		buttons.add(new JLabel(" "));
		buttons.add(humidityIn);
		buttons.add(hilow);
		buttons.add(new JLabel(" "));
		buttons.add(new JLabel(" "));
		
		myTemp.setFont(dataFont);
		myRainRate.setFont(dataFont);
		myRainFall.setFont(dataFont);
		myHumid.setFont(dataFont);
		myTempIn.setFont(dataFont);
		myHumidIn.setFont(dataFont);
		myPressure.setFont(dataFont);
		myWindChill.setFont(dataFont);

		myFrame.setLayout(new BorderLayout());
		myFrame.add(myDisplay, BorderLayout.CENTER);
		myFrame.add(buttons, BorderLayout.EAST);
		myFrame.add(displayState, BorderLayout.SOUTH);
		myFrame.add(top, BorderLayout.NORTH);

		myFrame.setResizable(true);
		myFrame.setMinimumSize(new Dimension(1000, 600));
		myFrame.setVisible(true);
		myFrame.pack();

		buttonAction();
	}
	
	/**
	 * Takes the current weather data and tries to pick an appropriate weather icon.
	 */
	private void determineWeather() {
		
		boolean cloud = (myData.getCurrentHumOut() > 60);
		boolean rain = (myData.getCurrentRainRate() > .75);
		boolean cold = (myData.getCurrentTempOut() < 32);
		String weather = "clear";
				
		if (cold && rain) weather = "snow";
		if (cold && cloud && !rain) weather = "cloudy";
		if (!cold && cloud && !rain) weather = "partCloudy";
		if (!rain && !cloud) weather = "clear";
		if (rain && !cold) weather = "rain";
		
		myCloudIcon.setIcon(new ImageIcon(ConsoleGUI.class.getResource("/displayImgs/"+ weather +".png")));
		
	}

	/**
	 * Updates the GUI by gathering data from each sensor and displaying it graphically.
	 * @throws InterruptedException 
	 */
	public void update() {

		//Collect, update time
		
		String[] timeStr = java.time.LocalTime.now().toString().split(":");
		int hr = Integer.parseInt(timeStr[0]);
		String ampm;
		if (hr >= 12) {
			ampm = "pm";
			hr -= 12;
			if (hr == 0) hr = 12;
		}
		else ampm = "am";
		myTime.setText(hr + ":" + timeStr[1] + ampm );
		
		myData.update();
		
		//Update compass
		myCompass.update(myData.getCurrentWindDirection(), myData.getCurrentWindSpeed());
		
		
		
		//Calculate a sensible weather state to display and update weather icon
		determineWeather();
		updateVals();
		updateGraph();

	}
	/**
	 * update graph
	 */
	private void updateGraph() {
		//Update graph
				switch(currGraphing) {
				case HUMIN:
					myGraph.setLabel("Internal Humidity");
					myGraph.setData(myData.getHumInHistory());
					break;
				case HUMOUT:
					myGraph.setLabel("Humidity");
					myGraph.setData(myData.getHumOutHistory());
					break;
				case PRESSURE:
					myGraph.setLabel("Pressure");
					myGraph.setData(myData.getPressureHistory());
					break;
				case RAINFALL:
					myGraph.setLabel("RainFall");
					myGraph.setData(myData.getRainFallHistory());
					break;
				case RAINRATE:
					myGraph.setLabel("RainRate");
					myGraph.setData(myData.getRainRateHistory());
					break;
				case TEMPIN:
					myGraph.setLabel("Internal Temperature");
					myGraph.setData(myData.getTempInHistory());
					break;
				case TEMPOUT:
					myGraph.setLabel("Temperature") ;
					myGraph.setData(myData.getTempOutHistory());
					break;
				}
				//update();
		
	}
	
	/**
	 * Updates display values on all regular fields, depending on the display mode (current values, highest values, or lowest values).
	 */
	private void updateVals() {
		
		switch(myState) {
		case CURRENT:

			myTemp.setText(df.format(myData.getCurrentTempOut()));
			myRainRate.setText(df.format(myData.getCurrentRainRate()));
			myRainFall.setText(df.format(myData.getCurrentRainFall()));
			myHumid.setText(df.format(myData.getCurrentHumOut()));
			myTempIn.setText(df.format(myData.getCurrentTempIn()));
			myHumidIn.setText(df.format(myData.getCurrentHumIn()));
			myPressure.setText(df.format(myData.getCurrentPressure()));
			myWindChill.setText(df.format(myData.getCurrentWindChill()));

			displayState.setText("Displaying CURRENT");
			break;
		case MAX:
			myTemp.setText(df.format(myData.getMaxTempOut()));
			myRainRate.setText(df.format(myData.getMaxRainRate()));
			myRainFall.setText(df.format(myData.getMaxRainFall()));
			myHumid.setText(df.format(myData.getMaxHumOut()));
			myTempIn.setText(df.format(myData.getMaxTempIn()));
			myHumidIn.setText(df.format(myData.getMaxHumIn()));
			myPressure.setText(df.format(myData.getMaxPressure()));
			myWindChill.setText(df.format(myData.getMaxWindChill()));

			displayState.setText("Displaying HIGH");
			break;
		case MIN:

			myTemp.setText(df.format(myData.getMinTempOut()));
			myRainRate.setText(df.format(myData.getMinRainRate()));
			myRainFall.setText(df.format(myData.getMinRainFall()));
			myHumid.setText(df.format(myData.getMinHumOut()));
			myTempIn.setText(df.format(myData.getMinTempIn()));
			myHumidIn.setText(df.format(myData.getMinHumIn()));
			myPressure.setText(df.format(myData.getMinPressure()));
			myWindChill.setText(df.format(myData.getMinWindChill()));

			displayState.setText("Displaying LOW");
			break;

		}

		
	}

	/**
	 * Build action for buttons.
	 */
	public void buttonAction() {
		temperature.addActionListener(this);
		temperatureIn.addActionListener(this);
		humidity.addActionListener(this);
		humidityIn.addActionListener(this);
		rainRate.addActionListener(this);
		hilow.addActionListener(this);
		pressure.addActionListener(this);
		rainFall.addActionListener(this);
	}

	/**
	 * Event handler for button presses; gives functionality to graph buttons, as well as 
	 * value displays.
	 * @author Nam Hoang
	 * @author Maxfield England
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == temperature) {
			currGraphing = GraphData.TEMPOUT;
			updateGraph();
			
		}

		if (e.getSource() == temperatureIn) {
			currGraphing = GraphData.TEMPIN;
			updateGraph();
			}

		if (e.getSource() == humidity) {
			currGraphing = GraphData.HUMOUT;
			updateGraph();
		}

		if (e.getSource() == humidityIn) {
			currGraphing = GraphData.HUMIN;
			updateGraph();
		}

		if (e.getSource() == rainRate) {
			currGraphing = GraphData.RAINRATE;
			updateGraph();
		}

		if (e.getSource() == pressure) {
			currGraphing = GraphData.PRESSURE;
			updateGraph();
		}

		if (e.getSource() == rainFall) {
			currGraphing = GraphData.RAINFALL;
			updateGraph();
		}

		//Cycle between current, high, and low display values.
		if (e.getSource() == hilow) {
			
			switch(myState) {
			case CURRENT:
				myState = DisplayState.MAX;
				break;
			case MAX:
				myState = DisplayState.MIN;
				break;
			case MIN:
				myState = DisplayState.CURRENT;
				break;
			
			}
			updateVals();

		}
	}
}
