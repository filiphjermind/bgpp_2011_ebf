package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;


public class TodaysReservationsGUI extends JPanel{
	
	/**
	 * Constructs new panel for todays reservations
	 */
	public TodaysReservationsGUI()
	{
		setLayout(new BorderLayout());
		add(makeTopPanel(), BorderLayout.NORTH);
		add(makeMainPanel(), BorderLayout.CENTER);		
	}
	
	/**
	 * Makes the top panel.
	 */
	public JPanel makeTopPanel()
	{
		JPanel topPanel = new JPanel();
		add(topPanel);
		topPanel.setLayout(new FlowLayout());
		
		JLabel dateLabel = new JLabel("Date: ");
		topPanel.add(dateLabel);
		
		JTextField dateTF = new JTextField("29.11.2011");
		dateTF.setEditable(false);
		topPanel.add(dateTF);
		
		return topPanel;
	}
	
	/**
	 * Makes the panel.
	 */
	public JPanel makeMainPanel()
	{
		JPanel todaysReservationsPanel = new JPanel();
		add(todaysReservationsPanel);
		todaysReservationsPanel.setLayout(new FlowLayout());
		
		// Creates the sample table.
		
		JTable table;
		
		String[] columnNames = {"Reservation number", "Name", "Vehicle", "Type", "Status"};
		
		Object[][] data = {
				{"45321", "Little, Holly", "TL 578 25", "Car, 2 door", "Picked up"},
				{"47925", "Hansen, Line", "FE 325 43", "Sportscar", "Not picked up"},
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		todaysReservationsPanel.add(scrollPane);
		
		return todaysReservationsPanel;
	}

}
