import java.awt.BorderLayout;
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


public class AllVehicles {
	
	private JFrame frame;
	private Container contentPane;
	
	public AllVehicles() 
	{
		//makeFrame();
	}

	private void makeFrame() 
	{
		
		frame = new JFrame();
		contentPane = frame.getContentPane();
		
		//make the panel for the allVehicles tab
		JPanel allVehiclesPanel = new JPanel();
		allVehiclesPanel.setLayout(new BorderLayout());
		contentPane.add(allVehiclesPanel);
		
		
		JPanel tablePanel = new JPanel();
		allVehiclesPanel.add(tablePanel, BorderLayout.CENTER);
	
		JPanel searchPanel = new JPanel();
		FlowLayout searchLayout = new FlowLayout();
		searchLayout.setAlignment(0);
		searchPanel.setLayout(searchLayout);
		allVehiclesPanel.add(searchPanel, BorderLayout.NORTH);
	
		JLabel licenseLabel = new JLabel("License nr.");
		searchPanel.add(licenseLabel);
		
		JTextField licenceText = new JTextField(20);
		searchPanel.add(licenceText);
		
		JButton searchButton = new JButton("Search");
		searchPanel.add(searchButton);
		
		// Display
		frame.pack();
		frame.setVisible(true);
	
	}
	
	/**
	 * Makes the panel.
	 * 
	 * @return JPanel panel - the "all vehicles" panel.
	 */
	public JPanel makePanel()
	{
		//make the panel for the allVehicles tab
		JPanel allVehiclesPanel = new JPanel();
		allVehiclesPanel.setLayout(new BorderLayout());
		//contentPane.add(allVehiclesPanel);
		
		
		JPanel tablePanel = new JPanel();
		allVehiclesPanel.add(tablePanel, BorderLayout.CENTER);
	
		JPanel searchPanel = new JPanel();
		FlowLayout searchLayout = new FlowLayout();
		searchLayout.setAlignment(0);
		searchPanel.setLayout(searchLayout);
		allVehiclesPanel.add(searchPanel, BorderLayout.NORTH);
	
		JLabel licenseLabel = new JLabel("License nr.");
		searchPanel.add(licenseLabel);
		
		JTextField licenceText = new JTextField(20);
		searchPanel.add(licenceText);
		
		JButton searchButton = new JButton("Search");
		searchPanel.add(searchButton);
		
		JPanel wrappingPanel = new JPanel();
		wrappingPanel.setLayout(new FlowLayout());
		wrappingPanel.add(allVehiclesPanel);
		
		return wrappingPanel;
	}
	
	/**
	 * Makes the main panel.
	 * 
	 * @return JPanel mainPanel - The main panel of "All Vehicles".
	 */
	public JPanel makeMainPanel()
	{
		JTable table;
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		// Creates the sample table.
		String[] columnNames = {"Vehicle type", "Vehicle", "Status"};
		
		Object[][] data = {
				{"Van, 3 doors", "TG 459 21", "Free"},
				{"Stationcar, 4 doors", "FK 928 98", "Booked"},
				{"Sportscar", "KJ 382 82", "Service"},
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		mainPanel.add(scrollPane);
		
		return mainPanel;
	}
}