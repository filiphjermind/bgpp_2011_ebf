package view.homeGui;

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

@SuppressWarnings("serial")
public class MiddlePanel extends JPanel {
	private static final int PANEL_WIDTH = 840;
	private static final int PANEL_HEIGHT = 400;
	private JLabel currentMonthLabel;
	private GregorianCalendar viewDate;
	private JPanel tablePanel;
	private final HomeWindow homeWindow;

	public MiddlePanel(HomeWindow homeWindow) {
		this.homeWindow = homeWindow;
		viewDate = new GregorianCalendar(2011, 10, 1);
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
		//TODO make the label show month in words, not in numbers
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
		homeWindow.updateVehiclesPane(null);

	}

	public void updateTable(List<VehicleData> vehicles,GregorianCalendar currentMonth) {
		tablePanel.removeAll();
		int numberOfDays = viewDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//loop that takes care of displaying the numbers in the month
		for (int i = 0; i < numberOfDays; i++) {
			JLabel label = new JLabel((i + 1) + "");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setBounds(i * 25 + 40, 10, 20, 10);
			tablePanel.add(label);
		}
		//loop that takes care of displaying reservation rows
		for (int i = 0; i < vehicles.size(); i++) {
			VehicleData vehicleData = vehicles.get(i);
			JLabel carLabel = new JLabel(vehicleData.getVehicleClass());
			carLabel.setVerticalAlignment(JLabel.CENTER);
			carLabel.setBounds(0, i * 20 + 34, 40, 15);
			tablePanel.add(carLabel);
			List<ReservationData> reservations = vehicleData.getReservations();
			for (int j = 0; j < reservations.size(); j++) {
				ReservationData reservationData = reservations.get(j);
				int x = 50 + reservationData.getStartDay() * 25;
				int width = reservationData.getDuration() * 25 - 2;
				int y = i * 20 + 40;
				int height = 4;
				System.out.println("MiddlePanel.updateTable()");
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
	private void onReservationClicked(ReservationData reservationData) {
		System.out.println("VehiclesPane.onReservationClicked()"+reservationData.getStartDay());
	}
}
