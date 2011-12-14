package view.homeGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.VehicleClassController;

/**
 * This class is responsible of letting the user start a reservation and search for a reservation.
 */
public class ReservationPane extends JPanel {
	private final HomeWindow homeWindow;
	
	// to make a new reservation
	private JTextField startText;
	private JTextField endText;
	private JComboBox typeCombo;

	// to change an existing reservation
	private JTextField resnrText;
	private JTextField nameText;
	private JTextField changeStartText;
	
	/**
	 * This constructors is primarily responsible of initializing the GUI components
	 * @param homeWindow the homeWindow object which instantiated this object
	 * @throws SQLException
	 */
	public ReservationPane(HomeWindow homeWindow) throws SQLException {
		this.homeWindow = homeWindow;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		setLayout(new FlowLayout());
		makeNewReservation();
		makeChangeReservationPanel();
	}
	
	/**
	 * This method is responsible for setting up the GUI for the make new reservation components 
	 * @throws SQLException
	 */
	private void makeNewReservation() throws SQLException {
		// make newReservationPanel
		JPanel newReservationPanel = new JPanel();
		newReservationPanel.setLayout(new BoxLayout(newReservationPanel, BoxLayout.Y_AXIS));
		newReservationPanel.setBorder(new TitledBorder("New Reservation"));
		add(newReservationPanel);

		// make top panel of newReservationPanel
		JPanel newReservationTopPanel = new JPanel();
		newReservationTopPanel.setLayout(new GridLayout(1, 2));
		newReservationPanel.add(newReservationTopPanel);

		// make a label panel for newReservationPanel
		JPanel newReservationLabelPanel = new JPanel();
		newReservationLabelPanel.setLayout(new GridLayout(0, 1));
		newReservationTopPanel.add(newReservationLabelPanel);

		JLabel startLabel = new JLabel("Start date");
		newReservationLabelPanel.add(startLabel);

		JLabel endLabel = new JLabel("End date");
		newReservationLabelPanel.add(endLabel);

		// make a textField panel for newReservationPanel
		JPanel newReservationTextPanel = new JPanel();
		newReservationTextPanel.setLayout(new GridLayout(0, 1));
		newReservationTopPanel.add(newReservationTextPanel);

		startText = new JTextField();
		newReservationTextPanel.add(startText);
		startText.setText("dd-mm-yyyy");
		
		endText = new JTextField();
		newReservationTextPanel.add(endText);
		endText.setText("dd-mm-yyyy");

		// make bottom panel of newReservationPanel
		JPanel newReservationBottomPanel = new JPanel();
		BoxLayout myBox = new BoxLayout(newReservationBottomPanel, BoxLayout.Y_AXIS);
		newReservationBottomPanel.setLayout(myBox);
		newReservationPanel.add(newReservationBottomPanel);

		JLabel vehicleTypeLabel = new JLabel("Vehicle type");
		newReservationBottomPanel.add(vehicleTypeLabel);

		VehicleClassController vcc = new VehicleClassController();
		Object[] types = vcc.getArray();
		typeCombo = new JComboBox(types);
		newReservationBottomPanel.add(typeCombo);

		JButton bookButton = new JButton("Book");
		newReservationBottomPanel.add(bookButton);
		bookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				book();
			}
		});
	}
	
	/**
	 * Should be called when a user clicks on the book button. The method sends information to
	 * homewindow.
	 */
	protected void book() {
		homeWindow.onBookButtonClicked(startText.getText(),endText.getText(),typeCombo.getSelectedItem());
	}

	/**
	 * This method is responsible of making the change reservation GUI
	 */
	private void makeChangeReservationPanel() {
		// make changeReservationPanel
		JPanel changeReservationPanel = new JPanel();
		changeReservationPanel.setLayout(new BoxLayout(changeReservationPanel, BoxLayout.Y_AXIS));
		changeReservationPanel.setMaximumSize(changeReservationPanel.getPreferredSize());
		changeReservationPanel.setBorder(new TitledBorder("Change Reservation"));
		add(changeReservationPanel);

		JLabel resnrLabel = new JLabel("Reservation nr.");
		changeReservationPanel.add(resnrLabel);

		resnrText = new JTextField();
		changeReservationPanel.add(resnrText);

		JLabel orLabel = new JLabel("or");
		changeReservationPanel.add(orLabel);

		JLabel nameLabel = new JLabel("Name");
		changeReservationPanel.add(nameLabel);

		nameText = new JTextField();
		changeReservationPanel.add(nameText);

		JLabel startLabel = new JLabel("Start date");
		changeReservationPanel.add(startLabel);

		changeStartText = new JTextField();
		changeReservationPanel.add(changeStartText);
		changeStartText.setText("dd-mm-yyyy");

		JButton searchButton = new JButton("Search");
		changeReservationPanel.add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
	}

	/**
	 * Should be called when a user clicks the search button. The method sends the reservation
	 * number to the homeWindow
	 */
	protected void search() {
		homeWindow.onSearchButtonClicked(resnrText.getText());
	}
}
