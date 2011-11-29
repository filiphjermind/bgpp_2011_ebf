package mainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ReservationRectangle extends JButton {

	private final Rectangle rectangle;
	private final ReservationData reservationData;

	public ReservationRectangle(Rectangle rectangle, ReservationData reservationData) {
		this.rectangle = rectangle;
		this.reservationData = reservationData;
		setBounds(rectangle);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0, rectangle.width, rectangle.height);
		
	}
	@Override
	public void addActionListener(ActionListener actionListener) {
		super.addActionListener(actionListener);
	}
	
	public ReservationData getReservationData() {
		return reservationData;
	}
}
