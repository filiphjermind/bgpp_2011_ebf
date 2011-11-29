import java.awt.BorderLayout;
import mainWindow.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * This class contains the skeleton of the GUI.
 * 
 * This is the main GUI class. It is the main windows that holds all the
 * other windows, and navigates between them.
 * The class contains a tabbed pane, that contains the other windows.
 * It also contains the menu bar on the top of the window.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 27.11.2011
 *
 */

public class SkeletonGUI {
	private JTabbedPane tabbedPane;
	
	public SkeletonGUI()
	{	
		
		SVGUI svGui = new SVGUI();
		AllVehicles allVehicles = new AllVehicles();
		TodaysReservations todaysReservations = new TodaysReservations();
		TodaysReturns todaysReturns = new TodaysReturns();
		Test test = new Test();
		
		// Create the frame, and tabbed pane for the skeleton.
		JFrame frame = new JFrame("Skeleton");
		/*JTabbedPane*/ tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		
		// Adds the menubar to the frame.
		makeMenuBar(frame);
		
		// Create the individual tabs, and add them to the tabbedpane.
		// Home tab.
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new FlowLayout());
		homePanel.add(svGui.makeMainPanel());
		tabbedPane.addTab("Home", homePanel);
		
		// Vehicle tab.
		JPanel vehiclesPanel = new JPanel();
		vehiclesPanel.setLayout(new BorderLayout());
		vehiclesPanel.add(allVehicles.makePanel(), BorderLayout.NORTH);
		vehiclesPanel.add(allVehicles.makeMainPanel(), BorderLayout.CENTER);
		tabbedPane.addTab("Vehicles", vehiclesPanel);
		
		// Todays reservations tab.
		JPanel todaysReservationsPanel = new JPanel();
		todaysReservationsPanel.setLayout(new BorderLayout());
		todaysReservationsPanel.add(todaysReservations.makeTopPanel(), BorderLayout.NORTH);
		todaysReservationsPanel.add(todaysReservations.makePanel(), BorderLayout.CENTER);
		tabbedPane.addTab("Todays reservations", todaysReservationsPanel);
		
		// Todays returns tab.
		JPanel todaysReturnsPanel = new JPanel();
		todaysReturnsPanel.setLayout(new BorderLayout());
		todaysReturnsPanel.add(todaysReturns.makeTopPanel(), BorderLayout.NORTH);
		todaysReturnsPanel.add(todaysReturns.makePanel(), BorderLayout.CENTER);
		tabbedPane.addTab("Todays returns", todaysReturnsPanel);
		
		// Test tab.
		JPanel testPanel = new JPanel();
		testPanel.add(test.makeMainPanel());
		tabbedPane.addTab("TEST", testPanel);
		
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
			newReservationItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { newReservation(); }
			});
		fileMenu.add(newReservationItem);
		
		JMenuItem printItem = new JMenuItem("Print");
			printItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { print(); }
			});
		fileMenu.add(printItem);
		
		JMenuItem quitItem = new JMenuItem("Quit");
			quitItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { quit(); }
			});
		fileMenu.add(quitItem);
		
		// Create the edit menu.
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		
		JMenuItem undoItem = new JMenuItem("Undo");
			undoItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { undo(); }
			});
		editMenu.add(undoItem);
		
		JMenuItem redoItem = new JMenuItem("Redo");
			redoItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { redo(); }
			});
		editMenu.add(redoItem);
		
		JMenuItem copyItem = new JMenuItem("Copy");
			copyItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { copy(); }
			});
		editMenu.add(copyItem);
		
		JMenuItem cutItem = new JMenuItem("Cut");
			cutItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { cut(); }
			});
		editMenu.add(cutItem);
		
		JMenuItem pasteItem = new JMenuItem("Paste");
			pasteItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { paste(); }
			});
		editMenu.add(pasteItem);
		
		// Create the help menu.
		JMenu helpMenu = new JMenu("Help");
		menubar.add(helpMenu);
		
		JMenuItem aboutItem = new JMenuItem("About");
			aboutItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { about(); }
			});
		helpMenu.add(aboutItem);
		
	}
	
	/**
	 * The new reservation method.
	 * Creates a new reservations.
	 */
	private void newReservation()
	{
		JPanel reservationPanel = new Reservation();
		JLabel reservationLabel = new JLabel("Reservation");
		reservationPanel.add(reservationLabel);
		tabbedPane.addTab("Reservation", reservationPanel);
	}
	
	/**
	 * Print method.
	 * Prints out the information on the screen.
	 */
	private void print()
	{
		
	}
	
	/**
	 * Undo method.
	 * Undoes the last action.
	 */
	private void undo()
	{
		
	}
	
	/**
	 * Redo method.
	 * Redoes the last action.
	 */
	private void redo()
	{
		
	}
	
	/**
	 * Copy method.
	 * Copies the marked text.
	 */
	private void copy()
	{
		
	}
	
	/**
	 * Cut method.
	 * Cuts the marked text.
	 */
	private void cut()
	{
		
	}
	
	/**
	 * Paste method.
	 * Pastes information from the clipboard onto the screen.
	 */
	private void paste()
	{
		
	}
	
	/**
	 * About method.
	 * Shows information about the system.
	 */
	private void about()
	{
		
	}
	
	/**
	 * The quit method.
	 * Quits the program.
	 */
	private void quit()
	{
		System.exit(0);
	}
	

}
