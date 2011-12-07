package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.AllVehiclesController;

public class AllVehiclesGUI extends JPanel {
	
	/**
	 * Makes a page to get an overview over all the vehicles
	 */
	public AllVehiclesGUI() throws Exception
	{
		// make the page for the allVehicles tab
		setLayout(new BorderLayout());
		
		// create the two panels
		makeSearchPanel();
		makeTablePanel();
	}
	
	/**
	 * Makes a search panel and adds it the the allVehicles page
	 */
	
	private void makeSearchPanel() 
	{
		JPanel searchPanel = new JPanel();
		add(searchPanel, BorderLayout.NORTH);
		
		// set the layout
		FlowLayout searchLayout = new FlowLayout();
		searchLayout.setAlignment(0);
		searchPanel.setLayout(searchLayout);
	
		// add the components
		JLabel licenseLabel = new JLabel("License nr.");
		searchPanel.add(licenseLabel);
		
		JTextField licenceText = new JTextField(20);
		searchPanel.add(licenceText);
		
		JButton searchButton = new JButton("Search");
		searchPanel.add(searchButton);
			searchButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new SVGUI();
				}
			});
	}
	
	/**
	 * Makes a table panel and adds it to the allvehicles page		
	 */
	
	private void makeTablePanel() throws Exception
	{
		JPanel tablePanel = new JPanel();
		add(tablePanel, BorderLayout.CENTER);
		tablePanel.setBorder(new TitledBorder("All vehicles"));
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Vehicle ID");
		model.addColumn("License plate");
		model.addColumn("Vehicle type");
		model.addColumn("Annual check date");
		model.addColumn("Make");
		
		JTable table = new JTable(model);
		
		// Create a AllVehiclesController object in order to assign the ResultSet to a variable.
		AllVehiclesController vehiclesData = new AllVehiclesController();
		ResultSet result = vehiclesData.getAllVehicles();
				
		// Loops through the ResultSet.
		// As long as the result set has a next value, add the value to a row in the table.
		int tableIndex = 0;
		while(result.next()) {
			Object[] rowData = {result.getString(1), result.getString(2), result.getString(3),
								result.getString(4), result.getString(5), result.getString(6)};
			model.insertRow(tableIndex, rowData);
			tableIndex++;
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);		
	}
}
	
	