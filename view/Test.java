package view;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class Test {
	private JPanel panel;
	
	public Test()
	{
		
	}
	
	public JPanel makeMainPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(makeWestPanel(), BorderLayout.WEST);
		panel.add(makeCenterPanel(), BorderLayout.CENTER);
		
		return panel;
		
	}
	
	private JPanel makeWestPanel()
	{
		JPanel westPanel = new JPanel();
		
		JLabel westLabel = new JLabel("This is west");
		westPanel.add(westLabel);
		
		return westPanel;
	}
	
	private JPanel makeCenterPanel()
	{
		JPanel centerPanel = new JPanel();
		
		JLabel centerLabel = new JLabel("This is center");
		centerPanel.add(centerLabel);
		
		return centerPanel;
	}

}
