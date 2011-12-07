package view;
import model.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.TodaysReservationsData;
import model.TodaysReturnsData;


public class TodaysReturnsGUI extends JPanel {
	
	/**
	 * Construct new panel for Todays Returns
	 */
	public TodaysReturnsGUI() throws Exception
	{
		setLayout(new BorderLayout());
		add(makeTopPanel(), BorderLayout.NORTH);
		add(makeMainPanel(), BorderLayout.CENTER);		
	}
	
	/**
	 * Makes the top panel, with the date
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
	 * Makes the main overview panel.
	 */
	public JPanel makeMainPanel() throws Exception
	{
		JPanel todaysReturnsPanel = new JPanel();
		add(todaysReturnsPanel);
		todaysReturnsPanel.setLayout(new FlowLayout());
		
		// Initialize the table.
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Reservation number");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Vehicle");
		model.addColumn("Type");
		model.addColumn("Status");
				
		JTable table = new JTable(model);
		
		// Create a TodaysReturnsData object in order to assign the ResultSet to a variable.
		TodaysReturnsData reservationData = new TodaysReturnsData();
		ResultSet result = reservationData.selectReservations();
		
		// Loops through the ResultSet.
		// As long as the result set has a next value, add the value to a row in the table.
		int tableIndex = 0;
		while(result.next()) {
			Object[] rowData = {result.getString(1), result.getString(2),
								result.getString(3), result.getString(4),
								result.getString(5), result.getString(6)
			};
			model.insertRow(tableIndex, rowData);
			tableIndex++;
		}
					
				
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		todaysReturnsPanel.add(scrollPane);
		/*
		// Creates the sample table.
		
		JTable table;
		
		String[] columnNames = {"Reservation number", "Name", "Vehicle", "Type", "Status"};
		
		Object[][] data = {
				{"45321", "Little, Holly", "TL 578 25", "Car, 2 door", "Returned"},
				{"47925", "Hansen, Line", "FE 325 43", "Sportscar", "Not returned"},
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		todaysReturnsPanel.add(scrollPane);*/
		
		return todaysReturnsPanel;
	}

}
