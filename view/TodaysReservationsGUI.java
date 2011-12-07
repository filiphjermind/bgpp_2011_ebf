package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.GetCurrentDateTime;
import controller.TodaysReservationsController;


public class TodaysReservationsGUI extends JPanel{
	GetCurrentDateTime currentDate = new GetCurrentDateTime();
	
	/**
	 * Constructs new panel for todays reservations
	 */
	public TodaysReservationsGUI() throws Exception
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
		
		JTextField dateTF = new JTextField(currentDate.getDate());
		dateTF.setEditable(false);
		topPanel.add(dateTF);
		
		return topPanel;
	}
	
	/**
	 * Makes the panel.
	 */
	public JPanel makeMainPanel() throws Exception
	{
		JPanel todaysReservationsPanel = new JPanel();
		add(todaysReservationsPanel);
		todaysReservationsPanel.setLayout(new FlowLayout());
		todaysReservationsPanel.setBorder(new TitledBorder("Todays reservations"));
		
		// Initialize the table.
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Reservation number");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Vehicle");
		model.addColumn("Type");
		model.addColumn("Status");
				
		JTable table = new JTable(model);
		
		// Create a TodaysReservationsController object in order to assign the ResultSet to a variable.
		TodaysReservationsController todaysReservationsData = new TodaysReservationsController();
		ResultSet result = todaysReservationsData.getTodaysReservations();
		
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
			
		
		table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		todaysReservationsPanel.add(scrollPane);
		
		return todaysReservationsPanel;
	
	}

}

