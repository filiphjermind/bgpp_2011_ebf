package view.homeGUI;


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

/**
 * The HomeWindow is the GUI class for the graphical representation of the reservations. 
 * It does not contain any textfields but contains other JPanel classes.  
 *
 */

@SuppressWarnings("serial")
public class HomeWindow extends JPanel{
	private FilterPanel filterPanel;
	private MiddlePanel middlePanel;
	private FrameGUI frameGUI;
	private ReservationController reservationController;

	/**
	 * Create a HomeWindow class to add in the JTabbedPane. It takes one parameter
	 * which should be the frameGUI object so that this class also know the class
	 * where it was instantiated. This is useful when userinputs happens. 
	 * @param frameGUI The frameGUI object
	 * @throws SQLException
	 */
	public HomeWindow(FrameGUI frameGUI) throws SQLException {
		this.frameGUI = frameGUI;
		reservationController = new ReservationController();
		makeStructure();
		setVisible(true);
	}
	
	/**
	 * This method takes care of adding the different JPanels to this class 
	 * @throws SQLException
	 */
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

	/**
	 * This method should be called when one of the checkboxes in the filterpanel have been clicked
	 * @param collectedVehicleClasses
	 */
	public void onCheckBoxesUpdated(List<String> collectedVehicleClasses) {
		middlePanel.onCheckBoxesUpdated(collectedVehicleClasses);
	}
	
	/**
	 * This method takes care of asking the controller class for data concerning the reservation
	 * overview based on a list of vehicle classes and the current month 
	 * 
	 * @param vehicleClasses the vehicle classes which should determine which reservations should be returned
	 * @param currentMonth the month that determines the timespan the reservations should be in
	 * @throws SQLException
	 */
	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		return reservationController.getReservations(vehicleClasses,currentMonth);
	}

	/**
	 * This method should be called from a controller class. I takes care of calling the
	 * updateTable on the middlePanel class
	 * @param vehicles the datastructure of the vehicles and reservations
	 */
	public void updateTable(List<VehicleDATA> vehicles) {
		middlePanel.updateTable(vehicles);
	}
	
	/**
	 * This method should be called when the book button have been clicked. I takes some 
	 * data concerning a new reservation as arguments and feeds the frameGUI, so that the
	 * frameGUI can make a new reservation tab 
	 * @param start the start day of the reservation
	 * @param end the end day of the reservation
	 * @param vehicleClass the vehicleClass for the reservation
	 */
	public void onBookButtonClicked(String start, String end, Object vehicleClass) {
		frameGUI.openNewReservationTab(start,end, (String) vehicleClass);
		
	}
	
	/**
	 * This method should be called when the search button have been clicked in the 
	 * ReservationPane. It tells the FrameGUI to open a new tab with a reservation
	 * matching the reservationnumber.
	 * @param resnr the reservation number that determines the reservation to be changed
	 */
	public void onSearchButtonClicked(String resnr) {
		frameGUI.changeReservationTab(resnr);
	}

	/**
	 * This method takes care of notifying the FrameGUI that a reservation tab should
	 * be displayed. The reservation should corspond to the id passed as argument.
	 * @param id the id for the reservation which is the licens plate number
	 */
	public void onClickedEntryInTable(int id) {
		frameGUI.changeReservationTab(id+"");
	}
}
