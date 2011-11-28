package mainWindow;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class RectangleTest extends JButton {
	
	public RectangleTest() {
//		setPreferredSize(new Dimension(500, 500));
		setBounds(0,0,400,400);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out
						.println("RectangleTest.RectangleTest().new ActionListener() {...}.actionPerformed()");
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
//		g.fillRect(0, 0, 100, 100);
	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.add(new RectangleTest());
		JLabel label = new JLabel("test");
		label.setBounds(0, 0, 100, 100);
		label.setLocation(50, 50);
		label.setBorder(new LineBorder(null));
		panel.add(label);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
	}
	
	
}

