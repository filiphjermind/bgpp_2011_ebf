package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.*;

/**
 * This class contains all the graphical information related
 * to the specific vehicle window.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 25.11.2011
 *
 */
public class SVGUI extends JPanel {
	
	public SVGUI()
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
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(0, 2));
		
		JLabel vehicleLabel = new JLabel("Vehicle");
		westPanel.add(vehicleLabel);
		
		JTextField vehicleTF = new JTextField("TL 539 92");
		vehicleTF.setEditable(false);
		westPanel.add(vehicleTF);
		
		JLabel modelLabel = new JLabel("Model");
		westPanel.add(modelLabel);
		
		JTextField modelTF = new JTextField("Volvo");
		modelTF.setEditable(false);
		westPanel.add(modelTF);
		
		JLabel vehicleTypeLabel = new JLabel("Vehicle Type");
		westPanel.add(vehicleTypeLabel);
		
		JTextField vehicleTypeTF = new JTextField("Stationcar, 4 doors");
		vehicleTypeTF.setEditable(false);
		westPanel.add(vehicleTypeTF);
		
		JLabel priceLabel = new JLabel("Rate pr. day");
		westPanel.add(priceLabel);
		
		JTextField priceTF = new JTextField("600 kr");
		priceTF.setEditable(false);
		westPanel.add(priceTF);
		
		JLabel nextCheckLabel = new JLabel("Next annual check");
		westPanel.add(nextCheckLabel);
		
		JTextField nextCheckTF = new JTextField("22.01.2012");
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
		
		JTextField sDateTF = new JTextField("10.01.2012");
		sDateTF.setEditable(false);
		westPanel.add(sDateTF);
		
		JLabel eDateLabel = new JLabel("End date");
		westPanel.add(eDateLabel);
		
		JTextField eDateTF = new JTextField("13.01.2012");
		eDateTF.setEditable(false);
		westPanel.add(eDateTF);
		
		JLabel reasonLabel = new JLabel("Reason");
		westPanel.add(reasonLabel);
		
		JTextField reasonTF = new JTextField("Oil change");
		reasonTF.setEditable(false);
		westPanel.add(reasonTF);
		
		JLabel emptyLabel4 = new JLabel("");
		westPanel.add(emptyLabel4);
		
		JLabel emptyLabel5 = new JLabel("");
		westPanel.add(emptyLabel5);
		
		JLabel emptyLabel6 = new JLabel("");
		westPanel.add(emptyLabel6);
		
		JButton saveButton = new JButton("Save");
		westPanel.add(saveButton);
		
		JPanel westFlowPanel = new JPanel();
		westFlowPanel.setBorder(new EtchedBorder());
		westFlowPanel.setLayout(new FlowLayout());
		westFlowPanel.add(westPanel);
		
		return westFlowPanel;
	}
	
	/**
	 * Makes the center panel.
	 * 
	 * @return JPanel centerFlowPanel - the center panel.
	 */
	private JPanel makeCenterPanel()
	{
		JTable table;
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		// Creates the sample table.
		String[] columnNames = {"Start", "End", "Reason"};
		
		Object[][] data = {
			{"25.06.2011", "30.06.2011", "Changing brakes"},
			{"01.08.2011", "02.08.2011", "Annual check"},
			{"30.09.2011", "01.10.2011", "Oil change"},
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		centerPanel.add(scrollPane);
		
		JPanel centerFlowPanel = new JPanel();
		centerFlowPanel.setBorder(new EtchedBorder());
		centerFlowPanel.setLayout(new FlowLayout());
		centerFlowPanel.add(centerPanel);
		
		return centerFlowPanel;
	}
	
	

}
