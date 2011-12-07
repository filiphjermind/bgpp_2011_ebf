package view.homeGUI;

//import FilterPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
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

	public HomeWindow(List<String> carClasses, FrameGUI frameGUI) throws SQLException {
		this.frameGUI = frameGUI;
		makeStructure();
		setVisible(true);
		// TODO following line is only for testing. The method should be called
		// from model
		//updateVehiclesPane(null);
	}

	private void makeStructure() throws SQLException {
		setLayout(new BorderLayout());
		JPanel filterPaneContainer = new JPanel(new FlowLayout());
		filterPanel = new FilterPanel(this);
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
//		HomeWindow homeWindow = new HomeWindow(carClasses,new FrameGUI());
		JFrame frame = new JFrame();
//		frame.add(homeWindow);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	public void onCheckBoxesUpdated(List<String> collectedVehicleClasses) {
		middlePanel.onCheckBoxesUpdated(collectedVehicleClasses);
	}

	public void updateVehiclesPanel(List<String> vehicleClasses, GregorianCalendar currentMonth) {
		
	}
	/*
	public void updateTable(List<VehicleData> vehicles) {
		middlePanel.updateTable(vehicles, null);
	}

	public void openNewReservationTab(String start, String end) {
		frameGUI.openNewReservationTab(start,end);
//		frameGUI.makeNewTab(title, panel)
	}
	}*/
}
