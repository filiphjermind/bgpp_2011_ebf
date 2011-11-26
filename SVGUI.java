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
	private JFrame frame;
	private Container contentPane;
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	public SVGUI()
	{
		makeFrame();
	}
	
	/**
	 * Builds the frame.
	 */
	private void makeFrame()
	{
		frame = new JFrame("Specific Vehicle");
		
		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// Creates the left panel, and adds it to the left side of the frame.
		JPanel leftPanel = new JPanel();
		frame.add(leftPanel, BorderLayout.WEST);
		
		// Creates a grid layout, and adds it to the left panel.
		JPanel leftGrid = new JPanel();
		leftGrid.setLayout(new GridLayout(0, 2));
		leftPanel.add(leftGrid);
		
		// Creates all the labels, text fields and other
		// components, and adds them to the grid.
		JLabel vehicleLabel = new JLabel("Vehicle");
		leftGrid.add(vehicleLabel);
		
		JTextField vehicleTF = new JTextField("TL 539 92");
		vehicleTF.setEditable(false);
		leftGrid.add(vehicleTF);
		
		JLabel modelLabel = new JLabel("Model");
		leftGrid.add(modelLabel);
		
		JTextField modelTF = new JTextField("Volvo");
		modelTF.setEditable(false);
		leftGrid.add(modelTF);
		
		JLabel vehicleTypeLabel = new JLabel("Vehicle Type");
		leftGrid.add(vehicleTypeLabel);
		
		JTextField vehicleTypeTF = new JTextField("Stationcar, 4 doors");
		vehicleTypeTF.setEditable(false);
		leftGrid.add(vehicleTypeTF);
		
		JLabel priceLabel = new JLabel("Rate pr. day");
		leftGrid.add(priceLabel);
		
		JTextField priceTF = new JTextField("600 kr");
		priceTF.setEditable(false);
		leftGrid.add(priceTF);
		
		JLabel nextCheckLabel = new JLabel("Next annual check");
		leftGrid.add(nextCheckLabel);
		
		JTextField nextCheckTF = new JTextField("22.01.2012");
		nextCheckTF.setEditable(false);
		leftGrid.add(nextCheckTF);
		
		JLabel emptyLabel = new JLabel("");
		leftGrid.add(emptyLabel);
		
		JLabel emptyLabel2 = new JLabel("");
		leftGrid.add(emptyLabel2);
		
		JSeparator separator = new JSeparator();
		leftGrid.add(separator);
		
		JSeparator separator2 = new JSeparator();
		leftGrid.add(separator2);
		
		/*JLabel emptyLabel3 = new JLabel("");
		leftGrid.add(emptyLabel3);
		
		JLabel emptyLabel4 = new JLabel("");
		leftGrid.add(emptyLabel4);*/
		
		JLabel sendToServiceLabel = new JLabel("Send to service");
		leftGrid.add(sendToServiceLabel);
		
		JLabel emptyLabel3 = new JLabel("");
		leftGrid.add(emptyLabel3);
		
		JLabel sDateLabel = new JLabel("Start date");
		leftGrid.add(sDateLabel);
		
		JTextField sDateTF = new JTextField("10.01.2012");
		sDateTF.setEditable(false);
		leftGrid.add(sDateTF);
		
		JLabel eDateLabel = new JLabel("End date");
		leftGrid.add(eDateLabel);
		
		JTextField eDateTF = new JTextField("13.01.2012");
		eDateTF.setEditable(false);
		leftGrid.add(eDateTF);
		
		JLabel reasonLabel = new JLabel("Reason");
		leftGrid.add(reasonLabel);
		
		JTextField reasonTF = new JTextField("Oil change");
		reasonTF.setEditable(false);
		leftGrid.add(reasonTF);
		
		JLabel emptyLabel4 = new JLabel("");
		leftGrid.add(emptyLabel4);
		
		JButton saveButton = new JButton("Save");
		leftGrid.add(saveButton);
		
		// Creates the right panel, and adds it to the center of the frame.
		JPanel rightPanel = new JPanel();
		frame.add(rightPanel, BorderLayout.CENTER);
		

		// Building is done, pack and show the window.
		frame.pack();
		frame.setVisible(true);
	}
	

}
