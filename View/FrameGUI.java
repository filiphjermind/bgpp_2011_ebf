package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.DBConnection;
import view.homeGUI.HomeWindow;

/**
 * This class contains the frame of the GUI.
 * 
 * This is the main GUI class. It is the main windows that holds all the other
 * windows, and navigates between them. The class contains a tabbed pane, that
 * contains the other windows. It also contains the menu bar on the top of the
 * window.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 27.11.2011
 * 
 */

public class FrameGUI {
	//AllVehiclesGUI allVehiclesGUI = new AllVehiclesGUI();

	private JTabbedPane tabbedPane;

	/**
	 * Creates the frame for the booking system
	 */

	/*public FrameGUI() throws Exception
	public FrameGUI() throws Exception
	{	
		
		AllVehiclesGUI allVehiclesGUI = new AllVehiclesGUI(this);
		SVGUI svGui = new SVGUI("Something");
	}*/

	public FrameGUI() throws Exception {

		SVGUI svGui = new SVGUI();

		Test test = new Test();

		// Create the frame, and tabbed pane for the skeleton.
		tabbedPane = new JTabbedPane();
		JFrame frame = new JFrame("EBF BookingSystem");

		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);

		// Adds the menubar to the frame.
		makeMenuBar(frame);
		addCloseListener(frame);

		// Create the individual tabs, and add them to the tabbed pane.
		// Home tab.
		List<String> carClasses = new ArrayList<String>();
		carClasses.add("van");
		carClasses.add("sportscar");
		carClasses.add("car, 2 doors");
		carClasses.add("car, 4 doors");
		carClasses.add("segway");
		JPanel homePanel = new HomeWindow(carClasses, this);
		tabbedPane.addTab("Home", homePanel);

		// Vehicles tab.

		JPanel allVehiclesPanel = new AllVehiclesGUI(this); 
		tabbedPane.addTab("Vehicles", allVehiclesPanel);

		// Todays reservations tab.
		JPanel todaysReservationsPanel = new TodaysReservationsGUI();
		tabbedPane.addTab("Todays reservations", todaysReservationsPanel);

		// Todays returns tab.
		JPanel todaysReturnsPanel = new TodaysReturnsGUI();
		tabbedPane.addTab("Todays returns", todaysReturnsPanel);

		// Add the tabbed pane to the frame.
		frame.add(tabbedPane, BorderLayout.NORTH);

		// Building is done, pack and show the frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// frame.resize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	private void addCloseListener(JFrame frame) {
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void closeDBConnection() {
		DBConnection.close();
		
	}

	/**
	 * Makes the menubar for the frame.
	 * 
	 * @param JFrame
	 *            frame - The frame which the menu is to be added.
	 */
	private void makeMenuBar(JFrame frame) {
		// Create the menubar.
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		// Create the file menu.
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);

		JMenuItem newReservationItem = new JMenuItem("New reservation");
		newReservationItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newReservation();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fileMenu.add(newReservationItem);
		

		JMenuItem exampleVehicle = new JMenuItem("Example Vehicle");
		exampleVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//exampleVehicle();
			}
		});
		fileMenu.add(exampleVehicle);


		JMenuItem printItem = new JMenuItem("Print");
		printItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print();
			}
		});
		fileMenu.add(printItem);

		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quit();
			}
		});
		fileMenu.add(quitItem);

		// Create the edit menu.
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);

		JMenuItem undoItem = new JMenuItem("Undo");
		undoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});
		editMenu.add(undoItem);

		JMenuItem redoItem = new JMenuItem("Redo");
		redoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redo();
			}
		});
		editMenu.add(redoItem);

		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		editMenu.add(copyItem);

		JMenuItem cutItem = new JMenuItem("Cut");
		cutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cut();
			}
		});
		editMenu.add(cutItem);

		JMenuItem pasteItem = new JMenuItem("Paste");
		pasteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paste();
			}
		});
		editMenu.add(pasteItem);

		// Create the help menu.
		JMenu helpMenu = new JMenu("Help");
		menubar.add(helpMenu);

		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		helpMenu.add(aboutItem);

	}

	public void openNewReservationTab(String start, String end, String carClass) {
		ReservationGUI reservationGUI = new ReservationGUI(start, end, carClass);
		makeNewTab("Reservation", reservationGUI);
	}

	public void changeReservationTab(String resnr) {
		//convert resnr from String to int
		int resNumber = Integer.parseInt(resnr);		
		ReservationGUI reservationGUI = new ReservationGUI(resNumber);
		makeNewTab("Reservation", reservationGUI);
	}
	
	public void makeNewTab(String title, JPanel panel) {
		tabbedPane.addTab(title, panel);
		tabbedPane.setSelectedComponent(panel);
	}

	
	
	public void makeNewSVGUI(String licensePlate) throws Exception
	{
		String tabTitle = licensePlate;
		makeNewTab(tabTitle, new SVGUI(tabTitle));
	}

	/**
	 * The new reservation method. Creates a new reservations.
	 * 
	 * @throws SQLException
	 */
	private void newReservation() throws SQLException {
		makeNewTab("Reservation", new ReservationGUI());
	}

	// temporary
	private void exampleVehicle() throws Exception
	{
		makeNewTab("Vehicle DK 39 452", new SVGUI("DK 39 452"));
	}


	/**
	 * Print method. Prints out the information on the screen.
	 */
	private void print() {

	}

	/**
	 * Undo method. Undoes the last action.
	 */
	private void undo() {

	}

	/**
	 * Redo method. Redoes the last action.
	 */
	private void redo() {

	}

	/**
	 * Copy method. Copies the marked text.
	 */
	private void copy() {

	}

	/**
	 * Cut method. Cuts the marked text.
	 */
	private void cut() {

	}

	/**
	 * Paste method. Pastes information from the clipboard onto the screen.
	 */
	private void paste() {

	}

	/**
	 * About method. Shows information about the system.
	 */

	private void about() {

	}

	/**
	 * The quit method. Quits the program.
	 */
	private void quit() {
		closeDBConnection();
		System.exit(0);
	}
}
