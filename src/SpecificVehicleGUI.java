import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpecificVehicleGUI {
	private JFrame frame;
	private Container contentPane;
	
	public SpecificVehicleGUI() 
	{
		makeFrame();
	}
	
	private void makeFrame()
	{
		frame = new JFrame("Specific Vehicle");
		
		contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(2, 1));
		contentPane.add(panelLeft);
		
		JPanel panelRight = new JPanel();
		contentPane.add(panelRight);
		
		JPanel panelLeftTop = new JPanel();
		panelLeftTop.setLayout(new GridLayout(0, 2));
		panelLeft.add(panelLeftTop);
		
		JLabel vehicleLabel = new JLabel("Vehicle");
		panelLeftTop.add(vehicleLabel);
		
		JTextField vehicleTF = new JTextField("TK 329 82");
		vehicleTF.setEditable(false);
		panelLeftTop.add(vehicleTF);
		
		JLabel modelLabel = new JLabel("Model");
		panelLeftTop.add(modelLabel);
		
		JTextField modelTF = new JTextField("VW Golf");
		modelTF.setEditable(false);
		panelLeftTop.add(modelTF);
		
		JLabel vehicleTypeLabel = new JLabel("Vehicle type");
		panelLeftTop.add(vehicleTypeLabel);
		
		JTextField vehicleTypeTF = new JTextField("Car, 2 doors");
		vehicleTypeTF.setEditable(false);
		panelLeftTop.add(vehicleTypeTF);
		
		JLabel annualInspectionLabel = new JLabel("Next annual inspection");
		panelLeftTop.add(annualInspectionLabel);
		
		JTextField annualInspectionTF = new JTextField("22.03.2012");
		annualInspectionTF.setEditable(false);
		panelLeftTop.add(annualInspectionTF);
		
		JLabel priceLabel = new JLabel("Price");
		panelLeftTop.add(priceLabel);
		
		JTextField priceTF = new JTextField("600kr/day");
		priceTF.setEditable(false);
		panelLeftTop.add(priceTF);
		
		JSeparator separator = new JSeparator();
		panelLeftTop.add(separator);
		
		JSeparator separator2 = new JSeparator();
		panelLeftTop.add(separator2);
		
		JPanel panelLeftBottom = new JPanel();
		panelLeftBottom.setLayout(new GridLayout(0, 2));
		panelLeft.add(panelLeftBottom);
		
		JLabel sendToServiceLabel = new JLabel("Send to service");
		panelLeftBottom.add(sendToServiceLabel);
		
		JLabel emptyLabel = new JLabel("");
		panelLeftBottom.add(emptyLabel);
		
		JLabel sDateLabel = new JLabel("Start date");
		panelLeftBottom.add(sDateLabel);
		
		JTextField sDateTF = new JTextField("22.01.2012");
		sDateTF.setEditable(false);
		panelLeftBottom.add(sDateTF);
		
		JLabel eDateLabel = new JLabel("End date");
		panelLeftBottom.add(eDateLabel);
		
		JTextField eDateTF = new JTextField("28.01.2012");
		eDateTF.setEditable(false);
		panelLeftBottom.add(eDateTF);
		
		JLabel reasonLabel = new JLabel("Reason");
		panelLeftBottom.add(reasonLabel);
		
		JTextField reasonTF = new JTextField("Oil change");
		reasonTF.setEditable(false);
		panelLeftBottom.add(reasonTF);
		
		JLabel emptyLabel2 = new JLabel("");
		panelLeftBottom.add(emptyLabel2);
		
		JButton saveButton = new JButton("Save");
		panelLeftBottom.add(saveButton);
		
		
		frame.pack();
		frame.setVisible(true);
	}

}
