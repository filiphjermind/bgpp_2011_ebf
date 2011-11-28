import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI {
	private JFrame frame;
	private Container contentPane;
	
	public TestGUI()
	{
		makeFrame();
	}
	
	/**
	 * Makes the frame.
	 */
	private void makeFrame()
	{
		frame = new JFrame("TEST GUI");
		
		contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// Build the left panel.
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0, 2));
		contentPane.add(leftPanel);
		
		// Insert data into left panel.
		JLabel vehicleLabel = new JLabel("Vehicle");
		leftPanel.add(vehicleLabel);
		
		JTextField vehicleTF = new JTextField("XY 423 32");
		vehicleTF.setEditable(false);
		leftPanel.add(vehicleTF);
		
		JLabel modelLabel = new JLabel("Model");
		leftPanel.add(modelLabel);
		
		JTextField modelTF = new JTextField("Volvo");
		modelTF.setEditable(false);
		leftPanel.add(modelTF);
		
		// Build the right panel.
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(0, 2));
		contentPane.add(rightPanel);
		
		// Insert data into right panel.
		JLabel vehicleTypeLabel = new JLabel("Vehicle Type");
		rightPanel.add(vehicleTypeLabel);
		
		JTextField vehicleTypeTF = new JTextField("Stationcar, 4 doors");
		vehicleTypeTF.setEditable(false);
		rightPanel.add(vehicleTypeTF);
		
		JLabel annualCheckLabel = new JLabel("Next annual check");
		rightPanel.add(annualCheckLabel);
		
		JTextField annualCheckTF = new JTextField("23.01.2012");
		annualCheckTF.setEditable(false);
		rightPanel.add(annualCheckTF);
		
		frame.pack();
		frame.setVisible(true);
	}

}
