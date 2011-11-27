package wip;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Reservation {
	
	private JFrame frame;
	private Container contentPane;
	
	public Reservation()
	{
		makeFrame();
	}
	
	private void makeFrame()
	{
		frame = new JFrame();
		contentPane = frame.getContentPane();
		FlowLayout overallLayout = new FlowLayout();
		overallLayout.setAlignment(0);
		contentPane.setLayout(overallLayout);
		
		Border emptyBorder = new EmptyBorder(5,5,5,5);
		
		// make reservation panel
		JPanel reservationPanel = new JPanel();
		reservationPanel.setLayout(new BoxLayout(reservationPanel, BoxLayout.Y_AXIS));
		reservationPanel.setBorder(emptyBorder);
		contentPane.add(reservationPanel);
		
			// make top panel for reservation panel
			JPanel reservationTopPanel = new JPanel();
			reservationTopPanel.setLayout(new GridLayout(1,2));
			reservationPanel.add(reservationTopPanel);
		
				// make label panel for top panel
				JPanel reservationLabelPanel = new JPanel();
				reservationLabelPanel.setLayout(new GridLayout(0,1));
				reservationTopPanel.add(reservationLabelPanel);
				
					JLabel resnrLabel = new JLabel("Reservation Nr");
					reservationLabelPanel.add(resnrLabel);
		        
					JLabel startLabel = new JLabel("Start date");
					reservationLabelPanel.add(startLabel);
		        
					JLabel endLabel = new JLabel("End date");
					reservationLabelPanel.add(endLabel);
		        
					JLabel typeLabel = new JLabel("Vehicle type");
					reservationLabelPanel.add(typeLabel);
		        
					JLabel vehicleLabel = new JLabel("Vehicle");
					reservationLabelPanel.add(vehicleLabel);
		
				// make text panel for top panel
		        JPanel reservationTextPanel = new JPanel();
		        reservationTextPanel.setLayout(new GridLayout(0,1));
		        reservationTopPanel.add(reservationTextPanel);
		        
		        	JTextField resnrText = new JTextField(10);
		        	reservationTextPanel.add(resnrText);
		        
		        	JTextField startText = new JTextField(10);
		        	reservationTextPanel.add(startText);
		        
		        	JTextField endText = new JTextField(10);
		        	reservationTextPanel.add(endText);
		        	
		        	String[] types = {"Van", "Car, 2 door", "Car, 4 door", "Sportscar", "Stationcar", "Motorcycle", "Segway"};
		        	JComboBox<String> typeCombo= new JComboBox<String>(types);
		        	reservationTextPanel.add(typeCombo);
		        	
		        	// combobox
		        	JTextField vehicleText = new JTextField(10);
		        	reservationTextPanel.add(vehicleText);
		        
		        			
			// make bottom panel for reservation panel	
			JPanel reservationBottomPanel = new JPanel();
			reservationBottomPanel.setLayout(new GridLayout(0,1));
			reservationPanel.add(reservationBottomPanel);
				
				JCheckBox pickedUpBox = new JCheckBox("Picked up");
				reservationBottomPanel.add(pickedUpBox);
								
				JCheckBox returnedBox = new JCheckBox("Returned");
				reservationBottomPanel.add(returnedBox);
						
		//make a vertical separator
		JSeparator sep1 = new JSeparator();
		contentPane.add(sep1);
						
		// make person panel
		JPanel personPanel = new JPanel();
		personPanel.setLayout(new BoxLayout(personPanel, BoxLayout.Y_AXIS));		
		personPanel.setBorder(emptyBorder);
		contentPane.add(personPanel);
		
			// make top panel for person panel
			JPanel personTopPanel = new JPanel();
			personTopPanel.setLayout(new GridLayout(1,2));
			personPanel.add(personTopPanel);
			
				// make label panel for person panel
				JPanel personLabelPanel = new JPanel();
				personLabelPanel.setLayout(new GridLayout(0,1));
				personTopPanel.add(personLabelPanel);
				
				JLabel firstNameLabel = new JLabel("First name");
				personLabelPanel.add(firstNameLabel);
		        
		        JLabel lastNameLabel = new JLabel("Last name");
		        personLabelPanel.add(lastNameLabel);
		        
		        JLabel drivingLicenceLabel = new JLabel("Driving Licence Nr");
		        personLabelPanel.add(drivingLicenceLabel);
		        
		        JLabel telephoneLabel = new JLabel("Telephone");
		        personLabelPanel.add(telephoneLabel);
		        
		        JLabel emailLabel = new JLabel("E-mail");
		        personLabelPanel.add(emailLabel);
		   		
				// make text panel for person panel
		        JPanel personTextPanel = new JPanel();
		        personTextPanel.setLayout(new GridLayout(0,1));
		        personTopPanel.add(personTextPanel);
		        
		        JTextField firstNameText = new JTextField("Holly");
		        personTextPanel.add(firstNameText);
		        
		        JTextField lastNameText = new JTextField();
		        personTextPanel.add(lastNameText);
		        
		        JTextField drivingLicenceText = new JTextField();
		        personTextPanel.add(drivingLicenceText);
		        
		        JTextField telephoneText = new JTextField();
		        personTextPanel.add(telephoneText);
		        
		        JTextField emailText = new JTextField();
		        personTextPanel.add(emailText);		
		
			// make middle panel for person panel
		    JPanel personMiddlePanel = new JPanel();
		    personMiddlePanel.setLayout(new GridLayout(0,1));
			personPanel.add(personMiddlePanel);
			
			JLabel addressLabel = new JLabel("Address");
			personMiddlePanel.add(addressLabel);
			JTextField addressText = new JTextField();
			personMiddlePanel.add(addressText);
			
			// make bottom panel for person panel
			JPanel personBottomPanel = new JPanel();
			personBottomPanel.setLayout(new FlowLayout());
			personPanel.add(personBottomPanel);
			
			JButton findButton = new JButton("Find Customer");
			personBottomPanel.add(findButton);
		
		//make a vertical separator
		JSeparator sep2 = new JSeparator();
		contentPane.add(sep2);
		
		// make payment panel
		JPanel paymentPanel = new JPanel();
		paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
		paymentPanel.setBorder(emptyBorder);
		contentPane.add(paymentPanel);
		
			// make top panel for payment panel
			JPanel paymentTopPanel = new JPanel();
			paymentTopPanel.setLayout(new GridLayout(1,2));
			paymentPanel.add(paymentTopPanel);
		
				// make label panel for payment panel
				JPanel paymentLabelPanel = new JPanel();
				paymentLabelPanel.setLayout(new GridLayout(0,1));
				paymentTopPanel.add(paymentLabelPanel);
				
				JLabel priceLabel = new JLabel("Price");
			    paymentLabelPanel.add(priceLabel);
			        
			    JLabel cardTypeLabel = new JLabel("Credit card type");
			    paymentLabelPanel.add(cardTypeLabel);
			        
			    JLabel cardNrLabel = new JLabel("Credit card nr");
			    paymentLabelPanel.add(cardNrLabel);
		
				// make text panel for payment panel
				JPanel paymentTextPanel = new JPanel();
				paymentTextPanel.setLayout(new GridLayout(0,1));
				paymentTopPanel.add(paymentTextPanel);
				
				JTextField priceText = new JTextField();
		        paymentTextPanel.add(priceText);
		        
		        String[] cards = {"Visa", "MasterCard", "AmEx"};
		        JComboBox<String> cardTypeCombo = new JComboBox<String>(cards);
		        paymentTextPanel.add(cardTypeCombo);
		        
		        JTextField cardNrText = new JTextField();
		        paymentTextPanel.add(cardNrText);
		
			// make middle panel for payment panel
			JPanel paymentMiddlePanel = new JPanel();
			paymentMiddlePanel.setLayout(new GridLayout(0,1));
			paymentPanel.add(paymentMiddlePanel);
			
			JLabel bAddressLabel = new JLabel("Billing address (if different)");
			paymentMiddlePanel.add(bAddressLabel);
			
			JTextField bAddressText = new JTextField();
			paymentMiddlePanel.add(bAddressText);
			
			// make bottom panel for payment panel
			JPanel paymentBottomPanel = new JPanel();
			paymentPanel.setLayout(new FlowLayout());
			paymentPanel.add(paymentBottomPanel);
			
			JButton saveButton = new JButton("Save Reservation");
			paymentBottomPanel.add(saveButton);
			
			JButton deleteButton = new JButton("Delete Reservation");
			paymentBottomPanel.add(deleteButton);
		
		// Display
		frame.pack();
		frame.setVisible(true);
	}

}
