package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.SpecificVehicleDB;
import model.VehicleDATA;

/**
 * This class contains all the graphical information related
 * to the specific vehicle window.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 25.11.2011
 *
 */
public class SVGUI extends JPanel {
	private String licensePlate;
	private JPanel westFlowPanel;
	private JPanel centerPanel;
	private JPanel centerFlowPanel;
	
	private final String noStartDate = "Please fill out the Start date.";
	private final String noendDate = "Please fill out the end date.";
	private final String noReason = "Please specify a reason.";
	
	public SVGUI(String licensePlate) throws Exception
	{
		this.licensePlate = licensePlate;
		setLayout(new BorderLayout());
		add(makeWestPanel(), BorderLayout.WEST);
		add(makeCenterPanel(), BorderLayout.CENTER);
	}
	
	public SVGUI(/*String licencePlate*/) throws Exception
	{
		setLayout(new BorderLayout());
		add(makeWestPanel(), BorderLayout.WEST);
		add(makeCenterPanel(), BorderLayout.CENTER);
	}
	
	/**
	 * Makes the west panel.
	 * 
	 * @return JPanel westFlowPanel - The west panel.
	 */
	private JPanel makeWestPanel()
	{
		final VehicleDATA vd = new SpecificVehicleDB().getVehicle(licensePlate);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(0, 2));
		
		JLabel vehicleLabel = new JLabel("Vehicle");
		westPanel.add(vehicleLabel);
		
		//SpecificVehicleController svc = new SpecificVehicleController();
		
		JTextField vehicleTF = new JTextField(vd.getLicenseplate());
		vehicleTF.setEditable(false);
		westPanel.add(vehicleTF);
		
		JLabel makeLabel = new JLabel("Make");
		westPanel.add(makeLabel);
		
		JTextField makeTF = new JTextField(vd.getMake());
		makeTF.setEditable(false);
		westPanel.add(makeTF);
		
		JLabel vehicleTypeLabel = new JLabel("Vehicle Type");
		westPanel.add(vehicleTypeLabel);
		
		JTextField vehicleTypeTF = new JTextField(vd.getVehicleClass());
		vehicleTypeTF.setEditable(false);
		westPanel.add(vehicleTypeTF);
		
		JLabel priceLabel = new JLabel("Rate pr. day");
		westPanel.add(priceLabel);
		
		JTextField priceTF = new JTextField(vd.getPrice());
		priceTF.setEditable(false);
		westPanel.add(priceTF);
		
		JLabel nextCheckLabel = new JLabel("Next annual check");
		westPanel.add(nextCheckLabel);
		
		JTextField nextCheckTF = new JTextField(vd.getAnnualCheck());
		nextCheckTF.setEditable(false);
		westPanel.add(nextCheckTF);
		
		JLabel emptyLabel = new JLabel("");
		westPanel.add(emptyLabel);
		
		JLabel emptyLabel2 = new JLabel("");
		westPanel.add(emptyLabel2);
		
		JSeparator separator = new JSeparator();
		westPanel.add(separator);
		
		JSeparator separator2 = new JSeparator();
		westPanel.add(separator2);
		
		JLabel sendToServiceLabel = new JLabel("Send to service");
		westPanel.add(sendToServiceLabel);
		
		JLabel emptyLabel3 = new JLabel("");
		westPanel.add(emptyLabel3);
		
		JLabel sDateLabel = new JLabel("Start date");
		westPanel.add(sDateLabel);
		
		final JTextField sDateTF = new JTextField("");
		westPanel.add(sDateTF);
		
		JLabel eDateLabel = new JLabel("End date");
		westPanel.add(eDateLabel);
		
		final JTextField eDateTF = new JTextField("");
		westPanel.add(eDateTF);
		
		JLabel reasonLabel = new JLabel("Reason");
		westPanel.add(reasonLabel);
		
		final JTextField reasonTF = new JTextField("");
		westPanel.add(reasonTF);
		
		JLabel emptyLabel4 = new JLabel("");
		westPanel.add(emptyLabel4);
		
		JLabel emptyLabel5 = new JLabel("");
		westPanel.add(emptyLabel5);
		
		JLabel emptyLabel6 = new JLabel("");
		westPanel.add(emptyLabel6);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the text from the text fields.
				String startDate = sDateTF.getText();
				String endDate = eDateTF.getText();
				String reason = reasonTF.getText();
				
				// Check to make sure the text fields aren't empty.
				if(startDate.isEmpty()) {
					saveError(noStartDate);
				} else if (endDate.isEmpty()) {
					saveError(noendDate);
				} else if (reason.isEmpty()) {
					saveError(noReason);
				} else {
					// Send data from text field to SpecificVehicleDB, to send to database.
					SpecificVehicleDB svd = new SpecificVehicleDB();
					svd.addService(vd.getLicenseplate(), startDate, endDate, reason);
				
					// Pop-up window to say that the service reservation was made correctly.
					saveSuccesful();
					
					// Set the text fields back to empty.
					sDateTF.setText("");
					eDateTF.setText("");
					reasonTF.setText("");
				}
			}
		});
		westPanel.add(saveButton);
		
		westFlowPanel = new JPanel();
		westFlowPanel.setBorder(new TitledBorder("Vehicle information"));
		westFlowPanel.setLayout(new FlowLayout());
		westFlowPanel.add(westPanel);
		
		return westFlowPanel;
	}
	
	/**
	 * Makes the center panel.
	 * 
	 * @return JPanel centerFlowPanel - the center panel.
	 */
	private JPanel makeCenterPanel() throws Exception
	{
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());

		// Initialize the table.
		DefaultTableModel model = new DefaultTableModel() {
			// Makes the table non-editable.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Vehicle");
		model.addColumn("Start date");
		model.addColumn("End date");
		model.addColumn("Reason");
				
		// Make the table final in order to access it from the inner class.
		final JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
			}
		});
				
		// Create a SpecificVehicleDB object in order to assign the ResultSet to a variable.
		SpecificVehicleDB svd = new SpecificVehicleDB();
		ResultSet result = svd.vehicleService(licensePlate);
				
		// Loops through the ResultSet.
		// As long as the result set has a next value, add the value to a row in the table.
		int tableIndex = 0;
		while(result.next()) {
			Object[] rowData = {result.getString("vehicle"), result.getString("startDate"),
								result.getString("endDate"), result.getString("reason")
			};
			model.insertRow(tableIndex, rowData);
			tableIndex++;
		}
					
				
		table.setPreferredScrollableViewportSize(new Dimension(800, 400));
		table.setFillsViewportHeight(true);
				
		JScrollPane scrollPane = new JScrollPane(table);
		centerPanel.add(scrollPane);
		
		centerFlowPanel = new JPanel();
		centerFlowPanel.setBorder(new TitledBorder("Service information"));
		centerFlowPanel.setLayout(new FlowLayout());
		centerFlowPanel.add(centerPanel);
		
		return centerFlowPanel;
	}
	
	/**
	 * Pop-up window to say that the save was successful.
	 */
	private void saveSuccesful()
    {
        JOptionPane.showMessageDialog(centerPanel, 
                    "Service reservation for vehicle: " + licensePlate + "\nwas saved succesfully.",
                    "Save succesfull.", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
	
	/**
	 * Pop-up window to say there was an error when saving the reservation.
	 * @param status
	 */
	private void saveError(String status)
    {
        JOptionPane.showMessageDialog(centerPanel, 
                    "Service reservation for vehicle: " + licensePlate + "\nCould not be saved.\n" + status,
                    "Error", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
}
