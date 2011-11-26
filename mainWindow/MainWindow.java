package mainWindow;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private FilterPane filterPane;
	private JPanel contentPane;
	private VehiclesPane vehiclesPane;

	public MainWindow(List<String> carClasses) {
		contentPane = (JPanel) getContentPane();
		makeStructure(carClasses);
		setVisible(true);
		pack();
	}

	private void makeStructure(List<String> carClasses) {
		contentPane.setLayout(new BorderLayout());
		JPanel filterPaneContainer = new JPanel(new FlowLayout());
		filterPane = new FilterPane(carClasses);
		filterPaneContainer.add(filterPane);
		filterPane.setBorder(new TitledBorder("Vehicle Type"));
		contentPane.add(filterPaneContainer, BorderLayout.WEST);
		vehiclesPane = new VehiclesPane();
		contentPane.add(vehiclesPane, BorderLayout.CENTER);
		contentPane.add(new ReservationPane(), BorderLayout.EAST);

	}

	public static void main(String[] args) {
		List<String> carClasses = new ArrayList<String>();
		carClasses.add("van");
		carClasses.add("sportscar");
		carClasses.add("car, 2 doors");
		carClasses.add("car, 4 doors");
		carClasses.add("segway");
		MainWindow mainWindow = new MainWindow(carClasses);
	}

	private void updateVehiclesPane(ArrayList<JCheckBox> collectedCheckBoxes) {
		// TODO call to database to achieve the vehicles in the right vehicle
		// class based on the collectedCheckboxes array
		// TODO temporary code to simulate data from database
		List<VehicleData> vehicles = new ArrayList<VehicleData>();
		ArrayList<ReservationData> reservations = new ArrayList<ReservationData>();
		reservations.add(new ReservationData(
				new GregorianCalendar(2011, 10, 1), new GregorianCalendar(2011,
						10, 3), false));
		reservations.add(new ReservationData(
				new GregorianCalendar(2011, 10, 5), new GregorianCalendar(2011,
						10, 7), false));
		reservations.add(new ReservationData(
				new GregorianCalendar(2011, 10, 10), new GregorianCalendar(
						2011, 10, 11), false));
		reservations.add(new ReservationData(
				new GregorianCalendar(2011, 10, 20), new GregorianCalendar(
						2011, 10, 30), false));
		vehicles.add(new VehicleData(1, "van", reservations));
		vehiclesPane.updateDisplay(vehicles);

	}

	public class FilterPane extends JPanel {
		private final List<String> carClasses;
		private ArrayList<JCheckBox> checkBoxes;

		public FilterPane(List<String> carClasses) {
			this.carClasses = carClasses;
			setLayout(new GridLayout(0, 1));
			checkBoxes = new ArrayList<JCheckBox>();
			for (String carClass : carClasses) {
				JCheckBox checkBox = new JCheckBox(carClass);
				add(checkBox);
				checkBoxes.add(checkBox);
				checkBox.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						collectAllSelectedCheckboxes();
					}
				});
			}
		}

		private void collectAllSelectedCheckboxes() {
			ArrayList<JCheckBox> collectedCheckBoxes = new ArrayList<JCheckBox>();
			for (JCheckBox checkBox : checkBoxes) {
				if (checkBox.isSelected()) {
					collectedCheckBoxes.add(checkBox);
				}
			}
			updateVehiclesPane(collectedCheckBoxes);
		}

	}

	public class VehiclesPane extends JPanel {
		public VehiclesPane() {
			JLabel filter = new JLabel("Vehicle");
			add(filter);
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
		}

		public void updateDisplay(List<VehicleData> vehicles) {

			for (VehicleData vehicleData : vehicles) {
			}
		}
	}

	public class ReservationPane extends JPanel {
		public ReservationPane() {
			JLabel test = new JLabel("reservationspane");
			add(test);
		}
	}
}
