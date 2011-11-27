package mainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ReservationRectangle extends JPanel {

	private final Rectangle rectangle;

	public ReservationRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
		setBounds(0,0,200,200);
//		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(rectangle.x,rectangle.y, rectangle.width, rectangle.height);
		
	}
}
