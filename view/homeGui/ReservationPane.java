package view.homeGUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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
	
	public ReservationPane(HomeWindow homeWindow) throws SQLException {
		this.homeWindow = homeWindow;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		setLayout(new FlowLayout());
		makeNewReservation();
		makeChangeReservationPanel();
	}

	private void makeNewReservation() throws SQLException {
		// make newReservationPanel
		JPanel newReservationPanel = new JPanel();
		newReservationPanel.setLayout(new BoxLayout(newReservationPanel, BoxLayout.Y_AXIS));
//		newReservationPanel.setLayout(new GridLayout(0,2));
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

	protected void book() {
		homeWindow.onBookTabClicked(startText.getText(),endText.getText(),typeCombo.getSelectedItem());

	}

	private void makeChangeReservationPanel() {
		// make changeReservationPanel
		JPanel changeReservationPanel = new JPanel();
		changeReservationPanel.setLayout(new BoxLayout(changeReservationPanel, BoxLayout.Y_AXIS));
//		changeReservationPanel.setLayout(new GridLayout(0,2));
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

	protected void search() {
		homeWindow.onSearchTabClicked(resnrText.getText());
	}

}
