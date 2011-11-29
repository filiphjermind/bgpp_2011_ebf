import java.awt.*;
import javax.swing.*;


public class ChangeReservation {
	
	private JFrame frame;
	private Container contentPane;
	
	public ChangeReservation() {
		makeFrame();
	}

	public void makeFrame(){
		frame = new JFrame();
		contentPane = frame.getContentPane();
		
		// make changeReservationPanel
		JPanel changeReservationPanel = new JPanel();
		changeReservationPanel.setLayout(new BoxLayout(changeReservationPanel, BoxLayout.Y_AXIS));
		contentPane.add(changeReservationPanel);
		
		JLabel resnrLabel = new JLabel("Reservation nr.");
		changeReservationPanel.add(resnrLabel);
		
		JTextField resnrText = new JTextField();
		changeReservationPanel.add(resnrText);
		
		JLabel orLabel = new JLabel("or");
		changeReservationPanel.add(orLabel);
		
		JLabel nameLabel = new JLabel("Name");
		changeReservationPanel.add(nameLabel);
		
		JTextField nameText = new JTextField();
		changeReservationPanel.add(nameText);
		
		JLabel startLabel = new JLabel("Start date");
		changeReservationPanel.add(startLabel);
		
		JTextField startText = new JTextField();
		changeReservationPanel.add(startText);
		
		JButton searchButton = new JButton("Search");
		changeReservationPanel.add(searchButton);
        	
       	// Display
    	frame.pack();
    	frame.setVisible(true);
	}
}
        	
