package view.homeGUI;

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

public class ReservationPane extends JPanel {
	private final HomeWindow homeWindow;
	private JTextField startText;
	private JTextField endText;

	public ReservationPane(HomeWindow homeWindow) throws SQLException {
		this.homeWindow = homeWindow;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		makeNewReservation();
		makeChangeReservationPanel();
	}

	private void makeNewReservation() throws SQLException {
		// TODO Auto-generated method stub
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
		endText = new JTextField();
		newReservationTextPanel.add(endText);

		// make bottom panel of newReservationPanel
		JPanel newReservationBottomPanel = new JPanel();
		BoxLayout myBox = new BoxLayout(newReservationBottomPanel, BoxLayout.Y_AXIS);
		newReservationBottomPanel.setLayout(myBox);
		newReservationPanel.add(newReservationBottomPanel);

		JLabel vehicleTypeLabel = new JLabel("Vehicle type");
		newReservationBottomPanel.add(vehicleTypeLabel);

		Object[] types = VehicleClassController.getArray();
		JComboBox typeCombo = new JComboBox(types);
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
//		homeWindow.openNewReservationTab(startText.getText(),endText.getText());

	}

	private void makeChangeReservationPanel() {
		// make changeReservationPanel
		JPanel changeReservationPanel = new JPanel();
		changeReservationPanel.setLayout(new BoxLayout(changeReservationPanel, BoxLayout.Y_AXIS));
		changeReservationPanel.setBorder(new TitledBorder("Change Reservation"));
		add(changeReservationPanel);

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
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

	}

	protected void search() {

	}

}
