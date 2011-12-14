package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.SpecificVehicleDB;
import model.VehicleDATA;
import controller.AllVehiclesController;

/**
 * Creates the window which contains the "all vehicles" information.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 *
 */

public class AllVehiclesGUI extends JPanel {
	
	private final FrameGUI frameGUI;

	/**
	 * Makes a window to get an overview over all the vehicles
	 * @param frameGUI 
	 */
	public AllVehiclesGUI(FrameGUI frameGUI) throws Exception
	{
		this.frameGUI = frameGUI;
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
		
		// Set the textfield final in order to access it from the inner class.
		final JTextField licenceText = new JTextField(20);
		searchPanel.add(licenceText);
		
		JButton searchButton = new JButton("Search");
		searchPanel.add(searchButton);
			searchButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
						// Opens a new SVGUI tab with the specific license plate searched for.
						frameGUI. makeNewSVGUI(licenceText.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		
		// Initialize the table.
		DefaultTableModel model = new DefaultTableModel() {
			// Makes the table non-editable.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Makes the column names for the table.
		model.addColumn("License plate");
		model.addColumn("Vehicle type");
		model.addColumn("Annual check date");
		model.addColumn("Make");
		model.addColumn("Model");
		
		
		// Make the table final in order to access it from the inner class.
		final JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Gets the selected row and column number.
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				// Retrieves data from column number 0 (licensePlate) from the selected row.
				getData(table, row, 0);
				
				// Gets the license plate from the selected row, 
				// and converts it into a string.
				String title = getData(table, row, 0).toString();
				
				try {
					// Creates a new SVGUI tab with the selected vehicle.
					frameGUI.makeNewSVGUI(title);
				} catch (Exception exn0) {
					System.out.println("Error: " + exn0);
				}
				SpecificVehicleDB svd = new SpecificVehicleDB();
				try {
					svd.getVehicle(title);
					svd.vehicleService(title);
				} catch(Exception exn) {
					System.out.println("error" + exn);
				}
			}
		});
		
		// Create a AllVehiclesController object in order to assign the ResultSet to a variable.
		AllVehiclesController vehiclesData = new AllVehiclesController();
		ResultSet result = vehiclesData.getAllVehicles();
				
		// Loops through the ResultSet.
		// As long as the result set has a next value, add the value to a row in the table.
		int tableIndex = 0;
		while(result.next()) {
			Object[] rowData = {result.getString(1), result.getString(2), result.getString(3),
								result.getString(4), result.getString(5)};
			model.insertRow(tableIndex, rowData);
			tableIndex++;
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);		
	}
	
	/**
	 * Retrieves the data from the selected column in the JTable.
	 * @param table - Which table to select from.
	 * @param rowIndex - Which row to select from.
	 * @param colIndex - Which column to select from.
	 * @return Object data - The data which is selected.
	 */
	public Object getData(JTable table, int rowIndex, int colIndex)
	{
		Object data = table.getModel().getValueAt(rowIndex, colIndex);
				
		return data;
	}
}
	
	