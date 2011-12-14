package view.homeGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ReservationData;
import model.VehicleDATA;

/**
 * This class is responsible of showing the graphical repressentation of the reservations 
 * and of making it possible for the user to chose a month.
 *
 */

@SuppressWarnings("serial")
public class MiddlePanel extends JPanel {
	private static final int PANEL_WIDTH = 900;
	private static final int PANEL_HEIGHT = 400;
	//following variable determines the horizontal space in pixel there should be for the vehicle label
	private static final int VEHICLE_LABEL_SPACE = 140;
	private JLabel currentMonthLabel;
	private GregorianCalendar viewDate;
	private JPanel tablePanel;
	private final HomeWindow homeWindow;
	private List<String> vehicleClasses;

	/**
	 * Creates a new object and builds the month picker and the table panel and also
	 * determine the current month.
	 * @param homeWindow
	 */
	public MiddlePanel(HomeWindow homeWindow) {
		this.homeWindow = homeWindow;
		viewDate = new GregorianCalendar(2011, 11, 1);
		makeTablePanel();
		makeMonthPicker();
	}

	/**
	 * This method builds the table panel
	 */
	private void makeTablePanel() {
		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setLayout(new BorderLayout());
		add(tablePanel,BorderLayout.CENTER);
	}

	/**
	 * This method builds the month picker
	 */
	private void makeMonthPicker() {
		JPanel monthPicker = new JPanel();
		monthPicker.setLayout(new FlowLayout());
		add(monthPicker,BorderLayout.NORTH);
		monthPicker.setBounds(0,0,800,100);
		JButton previous = new JButton("Previous");
		monthPicker.add(previous);
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPreviousMonth();
			}
		});
		currentMonthLabel = new JLabel("");
		updateMonthLabel();
		monthPicker.add(currentMonthLabel);
		JButton next = new JButton("Next");
		monthPicker.add(next);
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectNextMonth();
			}
		});
		
	}
	
	/**
	 * This method should be called when a button is pushed to select the next month
	 */
	private void selectNextMonth() {
		viewDate.add(GregorianCalendar.MONTH,1);
		updateMonthLabel();
		requestReservations();
	}

	/**
	 * This method should be called when a button is pushed to select the previous month
	 */
	private void selectPreviousMonth() {
		viewDate.add(GregorianCalendar.MONTH,-1);
		updateMonthLabel();
		requestReservations();
	}
	
	/**
	 * This method takes care of updating the monthlabel and should be called
	 * when the next or the previous month have been selected.
	 */
	private void updateMonthLabel() {
		String monthAndYear = "";
		monthAndYear = viewDate.getDisplayName(GregorianCalendar.MONTH, 1,new Locale(""));
		monthAndYear += " " + viewDate.get(GregorianCalendar.YEAR);
		currentMonthLabel.setText(monthAndYear);
	}
	
	/**
	 * This method sends a request to the homeWindow which will end in the model.
	 * When the request have been answered it will call the updateTable method. 
	 * If an exception happens in the database the user should be notified, but
	 * this feature is not implemented jet 
	 */
	private void requestReservations() {
		try {
			List<VehicleDATA> vehicles = homeWindow.getReservations(vehicleClasses,viewDate);
			updateTable(vehicles);
		} catch (Exception e) {
			e.printStackTrace();
			//if exception is about a problem in the database connection the user should be notified through the gui
		}
	}

	/**
	 * This method is responsible of updating the table with the reservations.
	 * It does so by running a for loop to display the numbers for the days of the current month
	 * and by running a nested for loop to display the different vehicles and their associated
	 * reservations.
	 * @param vehicles the data structure with the vehicles and their reservations. 
	 */
	public void updateTable(List<VehicleDATA> vehicles) {
		tablePanel.removeAll();
		//following statement is in the case that there are no reservations to show
		if(vehicles == null){
			JLabel introText = new JLabel("Please select a vehicle type in the left menu or go to another month");
			introText.setHorizontalAlignment(JLabel.CENTER);
			introText.setBounds(0, 0, PANEL_WIDTH, (int) (PANEL_HEIGHT*0.4));
			tablePanel.add(introText);
			tablePanel.repaint();
			return;
		}
		//the number of days in the current month
		int numberOfDays = viewDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//loop that takes care of displaying the numbers in the month
		for (int i = 0; i < numberOfDays; i++) {
			JLabel label = new JLabel((i + 1) + "");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setBounds(i * 25 + VEHICLE_LABEL_SPACE-10, 10, 20, 10);
			tablePanel.add(label);
		}
		//loop that takes care of displaying reservation rows
		for (int i = 0; i < vehicles.size(); i++) {
			VehicleDATA vehicleData = vehicles.get(i);
			JLabel carLabel = new JLabel(vehicleData.getLicenseplate()+ ", "+vehicleData.getVehicleClass());
			carLabel.setVerticalAlignment(JLabel.CENTER);
			//following line takes care of positioning the car label in the right row and
			//setting the bounds so that it is big enough to show the label. It is the i
			//varible that determine the row
			carLabel.setBounds(0, i * 20 + 34, VEHICLE_LABEL_SPACE, 15);
			tablePanel.add(carLabel);
			List<ReservationData> reservations = vehicleData.getReservations();
			//this nested loop takes care of showing all the reservations in one row
			for (int j = 0; j < reservations.size(); j++) {
				ReservationData reservationData = reservations.get(j);
				//the x value for the rectangle
				int x = 0;
				//checks whether or not the start day is in the current month
				if(isBeforeCurrentMonth(reservationData.getStartDateGreg())){
					x = 0 + VEHICLE_LABEL_SPACE;
				}else{
					x = reservationData.getStartDayInt() * 25 + VEHICLE_LABEL_SPACE;
				}
				//the widht for the rectangle
				int width = 0;
				//checks whether or not the end day is in the current month
				if(isAfterCurrentMonth(reservationData.getEndDateGreg())){
					width = (viewDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)-1) * 25+ VEHICLE_LABEL_SPACE -x;
				}else{
					width = reservationData.getEndDayInt()* 25 + VEHICLE_LABEL_SPACE - x;
				}
				//to make a little room between two adjacent reservations so the user can
				//that it is two different reservations
				width -=2;
				int y = i * 20 + 40;
				int height = 4;
				ReservationRectangle reservationRectangle = new ReservationRectangle(new Rectangle(x, y, width, height),reservationData);
				//Adds an action listener so that when a user clicks on a rectangle a new tab will be shown
				reservationRectangle.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ReservationRectangle rectangle = (ReservationRectangle)e.getSource();
						onReservationClicked(rectangle.getReservationData());
					}
				});
				tablePanel.add(reservationRectangle);
			}
		}
		tablePanel.repaint();
	}

	/**
	 * This method checks whether or not a specific calendar object is before the current month
	 * @param startDate
	 * @return
	 */
	private boolean isBeforeCurrentMonth(GregorianCalendar startDate) {
		return viewDate.after(startDate);
	}
	
	/**
	 * This method checks whether or not a specific calendar object is after the current month
	 * @param end
	 * @return
	 */
	private boolean isAfterCurrentMonth(GregorianCalendar end) {
		//the following lines makes a calendar object and modifies it to be the last day in the month
		//by adding a month and subtracting a day
		GregorianCalendar lastDayInMonth = (GregorianCalendar) viewDate.clone();
		lastDayInMonth.add(GregorianCalendar.MONTH, 1);
		lastDayInMonth.add(GregorianCalendar.DAY_OF_MONTH,-1);
		return lastDayInMonth.before(end);
		
	}

	/**
	 * When a reservation rectangle is clicked this method should be called.
	 * It tells the homeWindow to tell the frameGUI to make a new reservation tab.
	 * @param reservationData
	 */

	private void onReservationClicked(ReservationData reservationData) {
		homeWindow.onClickedEntryInTable(reservationData.getReservationID());
	}

	/**
	 * This method should be called when a check box is clicked. This method then sends
	 * a request for a new data structure of reservations
	 * @param vehicleClasses
	 */
	public void onCheckBoxesUpdated(List<String> vehicleClasses) {
		this.vehicleClasses = vehicleClasses;
		requestReservations();
		
	}
}
