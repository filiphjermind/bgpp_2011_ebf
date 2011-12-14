package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.GetCurrentDateTime;
import controller.TodaysReturnsController;

/**
 * This class is responsible of showing the returns which happens today
 *
 */
public class TodaysReturnsGUI extends JPanel {
	GetCurrentDateTime currentDate = new GetCurrentDateTime();
	
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
		
		JTextField dateTF = new JTextField(currentDate.getDate());
		dateTF.setEditable(false);
		topPanel.add(dateTF);
		
		return topPanel;
	}
	
	/**
	 * Makes the main panel and the table for the returns
	 */
	public JPanel makeMainPanel() throws Exception
	{
		JPanel todaysReturnsPanel = new JPanel();
		add(todaysReturnsPanel);
		todaysReturnsPanel.setLayout(new FlowLayout());
		todaysReturnsPanel.setBorder(new TitledBorder("Todays Returns"));
		
		// Initialize the table.
		DefaultTableModel model = new DefaultTableModel() {
			// Makes the table non-editable.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Reservation number");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Vehicle");
		model.addColumn("Type");
		model.addColumn("Picked up");
		model.addColumn("Returned");
		
		// Make the table final in order to access it from the inner class.
		final JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();	
			}
		});
		
		// Create a TodaysReturnsController object in order to assign the ResultSet to a variable.
		TodaysReturnsController todaysReturnsData = new TodaysReturnsController();
		ResultSet result = todaysReturnsData.getTodaysReturns();
		
		// Loops through the ResultSet.
		// As long as the result set has a next value, add the value to a row in the table.
		int tableIndex = 0;
		while(result.next()) {
			Object[] rowData = {result.getString(1), result.getString(2),
								result.getString(3), result.getString(4),
								result.getString(5), result.getString(6),
								result.getString(7)
			};
			model.insertRow(tableIndex, rowData);
			tableIndex++;
		}
					
				
		table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		todaysReturnsPanel.add(scrollPane);
		
		return todaysReturnsPanel;
	}

}
