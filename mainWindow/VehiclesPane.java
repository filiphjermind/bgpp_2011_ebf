package mainWindow;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VehiclesPane extends JPanel {
	public VehiclesPane() {
		JLabel filter = new JLabel("Vehicle");
		add(filter);
		setLayout(null);
		setPreferredSize(new Dimension(800,400));
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	public void updateDisplay(List<VehicleData> vehicles) {
		
		GregorianCalendar viewDate = new GregorianCalendar(2011,10,13);
		int numberOfDays = viewDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		for(int i = 0 ; i < numberOfDays ; i++){
			JLabel label = new JLabel(i+"");
//			label.setBorder(new LineBorder(null));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setBounds(i*25,10,20,10);
			label.repaint();
			add(label);
		}
		for (int i = 0 ; i < vehicles.size() ; i++) {
			int x = 0;
			int width = 40;
			int y = i*10+40;
			int height = 4;
			ReservationRectangle reservationRectangle = new ReservationRectangle(new Rectangle(x,y,width,height));
			add(reservationRectangle);
		}
		repaint();
	}
}
