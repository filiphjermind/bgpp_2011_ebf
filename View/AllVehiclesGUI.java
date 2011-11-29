package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class AllVehiclesGUI extends JPanel {
	
	/**
	 * Makes a page to get an overview over all the vehicles
	 */
	public AllVehiclesGUI() 
	{
		// make the page for the allVehicles tab
		setLayout(new BorderLayout());
		
		// create the two panels
		makeSearchPanel();
		makeTablePanel();
	}
	
	/**
	 * Makes a search panel and adds it the the allvehicles page
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
	
	private void makeTablePanel()
	{
		JPanel tablePanel = new JPanel();
		add(tablePanel, BorderLayout.CENTER);
		
		tablePanel.setLayout(new FlowLayout());
		
		// Creates the sample table.
		String[] columnNames = {"Vehicle type", "Vehicle", "Status"};
		
		Object[][] data = {
				{"Van, 3 doors", "TG 459 21", "Free"},
				{"Stationcar, 4 doors", "FK 928 98", "Booked"},
				{"Sportscar", "KJ 382 82", "Service"},
		};
		
		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);		
	}
}
	
	