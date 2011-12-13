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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ReservationData;
import model.VehicleDATA;

@SuppressWarnings("serial")
public class MiddlePanel extends JPanel {
	private static final int PANEL_WIDTH = 900;
	private static final int PANEL_HEIGHT = 400;
	private static final int VEHICLE_LABEL_SPACE = 100;
	private JLabel currentMonthLabel;
	private GregorianCalendar viewDate;
	private JPanel tablePanel;
	private final HomeWindow homeWindow;
	private List<String> vehicleClasses;

	public MiddlePanel(HomeWindow homeWindow) {
		this.homeWindow = homeWindow;
		viewDate = new GregorianCalendar(2011, 11, 1);
		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setLayout(new BorderLayout());
		add(tablePanel,BorderLayout.CENTER);
		makeMonthPicker();
	}

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
	
	private void selectNextMonth() {
		viewDate.add(GregorianCalendar.MONTH,1);
		updateMonthLabel();
		requestReservations();
	}

	private void selectPreviousMonth() {
		viewDate.add(GregorianCalendar.MONTH,-1);
		updateMonthLabel();
		requestReservations();
	}
	
	private void updateMonthLabel() {
		String monthAndYear = "";
		monthAndYear = viewDate.getDisplayName(GregorianCalendar.MONTH, 1,new Locale(""));
		monthAndYear += " " + viewDate.get(GregorianCalendar.YEAR);
		currentMonthLabel.setText(monthAndYear);
	}
	private void requestReservations() {
		try {
			List<VehicleDATA> vehicles = homeWindow.getReservations(vehicleClasses,viewDate);
			updateTable(vehicles);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: if exception is about a problem in databaseconnection the user should be notified through the gui
		}
	}

	public void updateTable(List<VehicleDATA> vehicles) {
		tablePanel.removeAll();
		if(vehicles == null){
			tablePanel.repaint();
			return;
		}
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
			JLabel carLabel = new JLabel(vehicleData.getVehicleClass());
			carLabel.setVerticalAlignment(JLabel.CENTER);
			carLabel.setBounds(0, i * 20 + 34, VEHICLE_LABEL_SPACE, 15);
			tablePanel.add(carLabel);
			List<ReservationData> reservations = vehicleData.getReservations();
			for (int j = 0; j < reservations.size(); j++) {
				ReservationData reservationData = reservations.get(j);
				int x = 0;
				if(isBeforeCurrentMonth(reservationData.getStartDateGreg())){
					x = 0 + VEHICLE_LABEL_SPACE;
				}else{
					x = reservationData.getStartDayInt() * 25 + VEHICLE_LABEL_SPACE;
				}
				int width = 0;
				if(isAfterCurrentMonth(reservationData.getEndDateGreg())){
					width = (viewDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)-1) * 25+ VEHICLE_LABEL_SPACE -x;
				}else{
					width = reservationData.getEndDayInt()* 25 + VEHICLE_LABEL_SPACE - x;
				}
				//to make room between two adjacent reservations
				width -=2;
				int y = i * 20 + 40;
				int height = 4;
				ReservationRectangle reservationRectangle = new ReservationRectangle(new Rectangle(x, y, width, height),reservationData);
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
	private boolean isAfterCurrentMonth(GregorianCalendar end) {
		GregorianCalendar lastDayInMonth = (GregorianCalendar) viewDate.clone();
		lastDayInMonth.add(GregorianCalendar.MONTH, 1);
		lastDayInMonth.add(GregorianCalendar.DAY_OF_MONTH,-1);
		return lastDayInMonth.before(end);
		
	}

	private boolean isBeforeCurrentMonth(GregorianCalendar startDate) {
		return viewDate.after(startDate);
	}

	private void onReservationClicked(ReservationData reservationData) {
		System.out.println("VehiclesPane.onReservationClicked()"+reservationData.getReservationID());
	}

	public void onCheckBoxesUpdated(List<String> vehicleClasses) {
		this.vehicleClasses = vehicleClasses;
		requestReservations();
		
	}
}
