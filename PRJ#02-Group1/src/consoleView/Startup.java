package consoleView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import consoleDataCollectors.DataType;
import sensorData.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * This class is responsible for creating the GUI for the Startup menu.
 * @author Ali Iftakhar
 * @version 5/16/2020
 */
public class Startup {

	private JFrame frame;
	private JTextField txtSelectTheCombination;
	private ImageIcon image1;
	

	
	/**
	 * Create the application.
	 */
	public Startup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		image1 = new ImageIcon(getClass().getResource("Davis.jpg")); //Create an image.
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1024, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtSelectTheCombination = new JTextField();
		txtSelectTheCombination.setEditable(false);
		txtSelectTheCombination.setFont(new Font("Verdana", Font.BOLD, 16));
		txtSelectTheCombination.setText
		("                                      Select the Combination of the ISS Systems that you wish to run");
		txtSelectTheCombination.setBounds(0, 0, 1008, 20);
		txtSelectTheCombination.setForeground(Color.BLACK);
		frame.getContentPane().add(txtSelectTheCombination);
		txtSelectTheCombination.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(48, 398, 119, 28);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("None");
		comboBox.addItem("ISS2");
		comboBox.addItem("ISS4");
		comboBox.addItem("ISS6");
		comboBox.addItem("ISS7");
		comboBox.addItem("ISS8");
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(290, 398, 118, 28);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("None");
		comboBox_1.addItem("ISS2");
		comboBox_1.addItem("ISS4");
		comboBox_1.addItem("ISS6");
		comboBox_1.addItem("ISS7");
		comboBox_1.addItem("ISS8");
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		btnNewButton.setBounds(870, 552, 96, 28);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(539, 396, 119, 33);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem("None");
		comboBox_2.addItem("ISS2");
		comboBox_2.addItem("ISS4");
		comboBox_2.addItem("ISS6");
		comboBox_2.addItem("ISS7");
		comboBox_2.addItem("ISS8");
		
		JComboBox<String> comboBox_3 = new JComboBox<>();
		comboBox_3.setBounds(758, 396, 119, 33);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addItem("None");
		comboBox_3.addItem("ISS2");
		comboBox_3.addItem("ISS4");
		comboBox_3.addItem("ISS6");
		comboBox_3.addItem("ISS7");
		comboBox_3.addItem("ISS8");
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(48, 492, 118, 28);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addItem("None");
		comboBox_4.addItem("ISS2");
		comboBox_4.addItem("ISS4");
		comboBox_4.addItem("ISS6");
		comboBox_4.addItem("ISS7");
		comboBox_4.addItem("ISS8");
		
		JComboBox<String> comboBox_5 = new JComboBox<>();
		comboBox_5.setBounds(290, 492, 118, 28);
		frame.getContentPane().add(comboBox_5);
		comboBox_5.addItem("None");
		comboBox_5.addItem("ISS2");
		comboBox_5.addItem("ISS4");
		comboBox_5.addItem("ISS6");
		comboBox_5.addItem("ISS7");
		comboBox_5.addItem("ISS8");
		
		JComboBox<String> comboBox_6 = new JComboBox<>();
		comboBox_6.setBounds(539, 490, 119, 33);
		frame.getContentPane().add(comboBox_6);
		comboBox_6.addItem("None");
		comboBox_6.addItem("ISS2");
		comboBox_6.addItem("ISS4");
		comboBox_6.addItem("ISS6");
		comboBox_6.addItem("ISS7");
		comboBox_6.addItem("ISS8");
		
		JComboBox<String> comboBox_7 = new JComboBox<>();
		comboBox_7.setBounds(759, 490, 118, 33);
		frame.getContentPane().add(comboBox_7);
		comboBox_7.addItem("None");
		comboBox_7.addItem("ISS2");
		comboBox_7.addItem("ISS4");
		comboBox_7.addItem("ISS6");
		comboBox_7.addItem("ISS7");
		comboBox_7.addItem("ISS8");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Startup.class.getResource("/consoleView/Davis.jpg")));
		lblNewLabel.setBounds(99, 31, 800, 265);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<JComboBox<String>> boxes = new ArrayList<>();
				boxes.add(comboBox);
				boxes.add(comboBox_1);
				boxes.add(comboBox_2);
				boxes.add(comboBox_3);
				boxes.add(comboBox_4);
				boxes.add(comboBox_5);
				boxes.add(comboBox_6);
				boxes.add(comboBox_7);
				ArrayList<ConsoleSensor> sensors = new ArrayList<>();
				for(int i = 0; i < 8; i++) {
					if(boxes.get(i).getSelectedItem().equals("ISS2")) {
						sensors.add(new Sensors2());
					} else if(boxes.get(i).getSelectedItem().equals("ISS4")) {
						sensors.add(new Sensors4());
					} else if(boxes.get(i).getSelectedItem().equals("ISS6")) {
						sensors.add(new Sensors6());
					} else if(boxes.get(i).getSelectedItem().equals("ISS7")) {
						sensors.add(new Sensors7());
					} else if(boxes.get(i).getSelectedItem().equals("ISS8")) {
						sensors.add(new Sensors8());
					}
				}
				
				System.out.println("Sensor Suite List:");
				System.out.println(sensors);
				
				DataType type = new DataType(sensors);
				ConsoleGUI gui = new ConsoleGUI(type);
				
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
	}
}
