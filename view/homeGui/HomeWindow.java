package view.homeGUI;

//import FilterPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import view.FrameGUI;
import model.ReservationData;
import model.VehicleDATA;

@SuppressWarnings("serial")
public class HomeWindow extends JPanel{
	private FilterPanel filterPanel;
	private MiddlePanel middlePanel;
	private final FrameGUI frameGUI;

	public HomeWindow(List<String> carClasses, FrameGUI frameGUI) {
		this.frameGUI = frameGUI;
		makeStructure(carClasses);
		setVisible(true);
		// TODO following line is only for testing. The method should be called
		// from model
		//updateVehiclesPane(null);
	}

	private void makeStructure(List<String> carClasses) {
		setLayout(new BorderLayout());
		JPanel filterPaneContainer = new JPanel(new FlowLayout());
		filterPanel = new FilterPanel(carClasses, this);
		filterPaneContainer.add(filterPanel);
		filterPanel.setBorder(new TitledBorder("Vehicle Type"));
		add(filterPaneContainer, BorderLayout.WEST);
		middlePanel = new MiddlePanel(this);
		middlePanel.setBorder(new TitledBorder("Overview"));
		add(middlePanel, BorderLayout.CENTER);
		add(new ReservationPane(this), BorderLayout.EAST);

	}

	public static void main(String[] args) {
		List<String> carClasses = new ArrayList<String>();
		carClasses.add("van");
		carClasses.add("sportscar");
		carClasses.add("car, 2 doors");
		carClasses.add("car, 4 doors");
		carClasses.add("segway");
		HomeWindow homeWindow = new HomeWindow(carClasses,new FrameGUI());
		JFrame frame = new JFrame();
		frame.add(homeWindow);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	/*public void updateVehiclesPane(ArrayList<JCheckBox> collectedCheckBoxes) {
		// TODO temporary code to simulate data from database
		List<VehicleData> vehicles = new ArrayList<VehicleData>();
		ArrayList<ReservationData> reservations = new ArrayList<ReservationData>();
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 1), new GregorianCalendar(2011, 10, 3), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 5), new GregorianCalendar(2011, 10, 7), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 10), new GregorianCalendar(2011, 10, 11), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 20), new GregorianCalendar(2011, 10, 30), false));
		vehicles.add(new VehicleData(1, "van", reservations));
		reservations = new ArrayList<ReservationData>();
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 2), new GregorianCalendar(2011, 10, 7), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 7), new GregorianCalendar(2011, 10, 10), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 11), new GregorianCalendar(2011, 10, 23), false));
		vehicles.add(new VehicleData(1, "segway", reservations));
		middlePanel.updateTable(vehicles, null);
	}
	
	public void updateTable(List<VehicleData> vehicles) {
		middlePanel.updateTable(vehicles, null);
	}

	public void openNewReservationTab(String start, String end) {
		frameGUI.openNewReservationTab(start,end);
//		frameGUI.makeNewTab(title, panel)
	}
	}*/
}
