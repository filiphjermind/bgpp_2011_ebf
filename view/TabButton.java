package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class builds the close button on the TabbedPane.
 * It also handles the method that closes the tab when the button is pressed.
 * @author Bergar Simonsen - bsim@itu.dk
 * 
 * @version 13.12.2011
 *
 */

public class TabButton extends JPanel implements ActionListener {
	
	// Variables to save the two images used for the close button.
	private ImageIcon reg = null;
	private ImageIcon over = null;
	
	public TabButton(String label)
	{
		super(new FlowLayout(FlowLayout.LEFT, 0,0));
		add(new JLabel(label));
		
		// Reg = the standard close button.
		// Over = the close button when the mouse hovers.
		reg = new ImageIcon(getClass().getResource("Close_regular.gif"));
		over = new ImageIcon(getClass().getResource("Close_rollover.gif"));
		
		setOpaque(false);
		final TabButton self = this;
		final JButton button = new JButton(reg);
		button.setOpaque(false);
		button.setRolloverIcon(over);
		button.setPressedIcon(over);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.addActionListener(this);
		add(button);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		// Close the tab which was clicked.
		//tabbedPane.remove(tabbedPane.indexOfTabComponent(this));
	}

}
