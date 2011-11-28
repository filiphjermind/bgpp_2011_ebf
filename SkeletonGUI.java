import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class contains the skeleton of the GUI.
 * 
 * It contains a tabbed pane, that controls all the other windows.
 * It also contains the menu bar on the top of the window.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 27.11.2011
 *
 */

public class SkeletonGUI {
	
	public SkeletonGUI()
	{	
		
		SVGUI svGui = new SVGUI();
		
		// Create the frame, and tabbed pane for the skeleton.
		JFrame frame = new JFrame("Skeleton");
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// Create the individual tabs, and add them to the tabbedpane.
		
		// Home tab.
		JLabel homeLabel = new JLabel("Home");
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout());
		homePanel.add(svGui.makeWestPanel(), BorderLayout.WEST);
		tabbedPane.addTab("Home", homePanel);
		
		// Vehicle tab.
		JLabel vehiclesLabel = new JLabel("Vehicles");
		JPanel vehiclesPanel = new JPanel();
		vehiclesPanel.add(vehiclesLabel);
		tabbedPane.addTab("Vehicles", vehiclesPanel);
		
		// Todays reservations tab.
		JLabel todaysReservationsLabel = new JLabel("Todays reservations");
		JPanel todaysReservationsPanel = new JPanel();
		todaysReservationsPanel.add(todaysReservationsLabel);
		tabbedPane.addTab("Todays reservations", todaysReservationsPanel);
		
		// Todays returns tab.
		JLabel todaysReturnsLabel = new JLabel("Todays returns");
		JPanel todaysReturnsPanel = new JPanel();
		todaysReturnsPanel.add(todaysReturnsLabel);
		tabbedPane.addTab("Todays returns", todaysReturnsPanel);
		
		// Add the tabbed pane to the frame.
		frame.add(tabbedPane);
		
		// Building is done, pack and show the frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	

}
