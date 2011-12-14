package view.homeGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;

import model.ReservationData;

/**
 *	This class is responsible of drawing an rectangle that matches a given
 *	reservation 
 *
 */
@SuppressWarnings("serial")
public class ReservationRectangle extends JButton {

	private final Rectangle rectangle;
	private final ReservationData reservationData;

	/**
	 * This constructor takes the two arguments and assign them to two fields
	 * @param rectangle the rectangle that have the dimensions that matches a given
	 * reservations start and duration.
	 * @param reservationData the reserervationData associated with this reservation
	 */
	public ReservationRectangle(Rectangle rectangle, ReservationData reservationData) {
		this.rectangle = rectangle;
		this.reservationData = reservationData;
		setBounds(rectangle);
	}
	
	/**
	 * Is responsible of drawing the rectangle
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0, rectangle.width, rectangle.height);
	}
	
	/**
	 * Get the reservationData associated with this object
	 * @return
	 */
	public ReservationData getReservationData() {
		return reservationData;
	}
	
	@Override
	public String toString() {
		return rectangle.toString();
	}
}
