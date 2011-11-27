import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class contains all the graphical information related
 * to the specific vehicle window.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 25.11.2011
 *
 */
public class SVGUI {
	
	public SVGUI()
	{
		//makeFrame();
	}
	

	
	/**
	 * Makes the west panel.
	 * 
	 * @return JPanel panel - The west panel.
	 */
	public JPanel makeWestPanel()
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
		
		JButton saveButton = new JButton("Save");
		westPanel.add(saveButton);
		
		JPanel westFLowPanel = new JPanel();
		westFLowPanel.setLayout(new FlowLayout());
		westFLowPanel.add(westPanel);
		
		return westFLowPanel;
	}
	
	

}