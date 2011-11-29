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
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		
		// Set the default frame size to full screen.
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		int xSize = ((int) tk.getScreenSize().getWidth());
//		int ySize = ((int) tk.getScreenSize().getHeight());
//		frame.setSize(xSize, ySize);
//		tabbedPane.setSize(xSize, ySize);
		
		// Adds the menubar to the frame.
		makeMenuBar(frame);
		
		// Create the individual tabs, and add them to the tabbedpane.
		// Home tab.
		JLabel homeLabel = new JLabel("Home");
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout());
		homePanel.add(svGui.makeWestPanel(), BorderLayout.WEST);
		homePanel.add(svGui.makeCenterPanel(), BorderLayout.CENTER);
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
		frame.add(tabbedPane, BorderLayout.NORTH);
		
		// Building is done, pack and show the frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.resize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	/**
	 * Makes the menubar for the frame.
	 * 
	 * @param JFrame frame - The frame which the menu is to be added.
	 */
	private void makeMenuBar(JFrame frame)
	{
		// Create the menubar.
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		// Create the file menu.
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		JMenuItem newReservationItem = new JMenuItem("New reservation");
		fileMenu.add(newReservationItem);
		
		JMenuItem printItem = new JMenuItem("Print");
		fileMenu.add(printItem);
		
		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		
		// Create the edit menu.
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		
		JMenuItem undoItem = new JMenuItem("Undo");
		editMenu.add(undoItem);
		
		JMenuItem redoItem = new JMenuItem("Redo");
		editMenu.add(redoItem);
		
		JMenuItem copyItem = new JMenuItem("Copy");
		editMenu.add(copyItem);
		
		JMenuItem cutItem = new JMenuItem("Cut");
		editMenu.add(cutItem);
		
		JMenuItem pasteItem = new JMenuItem("Paste");
		editMenu.add(pasteItem);
		
		// Create the help menu.
		JMenu helpMenu = new JMenu("Help");
		menubar.add(helpMenu);
		
		JMenuItem aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		
	}
	

}
