package mainWindow;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VehiclesPane extends JPanel {
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 400;

	public VehiclesPane() {
		setLayout(null);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}

	public void updateDisplay(List<VehicleData> vehicles,GregorianCalendar currentMonth) {
		GregorianCalendar viewDate = new GregorianCalendar(2011, 10, 13);
		int numberOfDays = viewDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//loop that takes care of displaying the numbers in the month
		for (int i = 0; i < numberOfDays; i++) {
			JLabel label = new JLabel((i + 1) + "");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setBounds(i * 25 + 40, 10, 20, 10);
			add(label);
		}
		for (int i = 0; i < vehicles.size(); i++) {
			VehicleData vehicleData = vehicles.get(i);
			JLabel carLabel = new JLabel(vehicleData.getVehicleClass());
			carLabel.setVerticalAlignment(JLabel.CENTER);
			carLabel.setBounds(0, i * 20 + 34, 40, 15);
			add(carLabel);
			List<ReservationData> reservations = vehicleData.getReservations();
			for (int j = 0; j < reservations.size(); j++) {
				ReservationData reservationData = reservations.get(j);
				int x = 50 + reservationData.getStartDay() * 25;
				int width = reservationData.getDuration() * 25 - 2;
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
				add(reservationRectangle);
			}
		}
		repaint();
	}
	private void onReservationClicked(ReservationData reservationData) {
		System.out.println("VehiclesPane.onReservationClicked()"+reservationData.getStartDay());
	}
}
