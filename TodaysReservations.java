import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;


public class TodaysReservations {
	
	public TodaysReservations()
	{
		
	}
	
	/**
	 * Makes the top panel.
	 * 
	 * @return JPanel topPanel - The top panel of todays reservations.
	 */
	public JPanel makeTopPanel()
	{
		JPanel topPanel = new JPanel();
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
	 * 
	 * @return JPanel todaysReservationsPanel - The todays reservations panel.
	 */
	public JPanel makePanel()
	{
		JTable table;
		
		JPanel todaysReservationsPanel = new JPanel();
		todaysReservationsPanel.setLayout(new FlowLayout());
		
		// Creates the sample table.
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
