import java.awt.*;
import javax.swing.*;


public class NewReservation {
	
	private JFrame frame;
	private Container contentPane;
	
	public NewReservation() {
		makeFrame();
	}

	public void makeFrame(){
		frame = new JFrame();
		contentPane = frame.getContentPane();
		
		// make newReservationPanel
		JPanel newReservationPanel = new JPanel();
		newReservationPanel.setLayout(new BoxLayout(newReservationPanel, BoxLayout.Y_AXIS));
		contentPane.add(newReservationPanel);
		
			// make top panel of newReservationPanel
			JPanel newReservationTopPanel = new JPanel();
			newReservationTopPanel.setLayout(new GridLayout(1,2));
			newReservationPanel.add(newReservationTopPanel);
			
				// make a label panel for newReservationPanel
				JPanel newReservationLabelPanel = new JPanel();
				newReservationLabelPanel.setLayout(new GridLayout(0,1));
				newReservationTopPanel.add(newReservationLabelPanel);
				
				JLabel startLabel = new JLabel("Start date");
				newReservationLabelPanel.add(startLabel);
				
				JLabel endLabel = new JLabel("End date");
				newReservationLabelPanel.add(endLabel);
			
				// make a textField panel for newReservationPanel
				JPanel newReservationTextPanel = new JPanel();
				newReservationTextPanel.setLayout(new GridLayout(0,1));
				newReservationTopPanel.add(newReservationTextPanel);
				
				JTextField startText = new JTextField();
				newReservationTextPanel.add(startText);
				JTextField endText = new JTextField();
				newReservationTextPanel.add(endText);
			
			
			// make bottom panel of newReservationPanel
			JPanel newReservationBottomPanel = new JPanel();
			BoxLayout myBox = new BoxLayout(newReservationBottomPanel, BoxLayout.Y_AXIS);
			newReservationBottomPanel.setLayout(myBox);
			newReservationPanel.add(newReservationBottomPanel);
			
			JLabel vehicleTypeLabel = new JLabel("Vehicle type");
			newReservationBottomPanel.add(vehicleTypeLabel);
			
			String[] types = {"Van", "Car, 2 door", "Car, 4 door", "Sportscar", "Stationcar", "Motorcycle", "Segway"};
        	JComboBox<String> typeCombo = new JComboBox<String>(types);
        	newReservationBottomPanel.add(typeCombo);
        	
        	JButton bookButton = new JButton("Book");
        	newReservationBottomPanel.add(bookButton);
        	
        	// Display
    		frame.pack();
    		frame.setVisible(true);
        	
	}
}
