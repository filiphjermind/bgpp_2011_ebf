package view.homeGUI;

//import FilterPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.VehicleDATA;
import view.FrameGUI;
import controller.ReservationController;

@SuppressWarnings("serial")
public class HomeWindow extends JPanel{
	private FilterPanel filterPanel;
	private MiddlePanel middlePanel;
	private final FrameGUI frameGUI;
	private ReservationController reservationController;

	public HomeWindow(List<String> carClasses, FrameGUI frameGUI) throws SQLException {
		this.frameGUI = frameGUI;
		reservationController = new ReservationController();
		makeStructure();
		setVisible(true);
	}

	private void makeStructure() throws SQLException {
		setLayout(new BorderLayout());
		JPanel filterPaneContainer = new JPanel(new FlowLayout());
		middlePanel = new MiddlePanel(this);
		filterPanel = new FilterPanel(this);
		filterPaneContainer.add(filterPanel);
		filterPanel.setBorder(new TitledBorder("Vehicle Type"));
		add(filterPaneContainer, BorderLayout.WEST);
		middlePanel.setBorder(new TitledBorder("Overview"));
		add(middlePanel, BorderLayout.CENTER);
		add(new ReservationPane(this), BorderLayout.EAST);

	}

	public void onCheckBoxesUpdated(List<String> collectedVehicleClasses) {
		middlePanel.onCheckBoxesUpdated(collectedVehicleClasses);
	}

	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		return reservationController.getReservations(vehicleClasses,currentMonth);
	}

	public void updateTable(List<VehicleDATA> vehicles) {
		middlePanel.updateTable(vehicles);
	}

	public void onBookTabClicked(String start, String end, Object selectedItem) {
		frameGUI.openNewReservationTab(start,end, (String) selectedItem);
		
	}
	
	public void onSearchTabClicked(String resnr) {
		frameGUI.changeReservationTab(resnr);
	}

	public void onClickedEntryInTable(int id) {
		frameGUI.changeReservationTab(id+"");
	}
}
