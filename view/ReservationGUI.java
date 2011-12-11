package view;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.ReservationData;

import controller.AllVehiclesController;
import controller.ReservationController;
import controller.VehicleClassController;

public class ReservationGUI extends JPanel {
	
	Border emptyBorder = new EmptyBorder(5,5,5,5);
	
	private ReservationController resControl;
	private ReservationData res;
	
	// input
	private int resnr;
	private String start;
	private String end;
	private String carClass;
	private String car;
	private boolean pickedUp;
	private boolean returned;
	private String firstName;
	private String lastName;
	private String drivingLicence;
	private String telephone;
	private String email;
	private String address;
	private int price;
	private String cardType;
	private String cardNr;
	
	// input fields
	private JTextField resnrText;
	private JTextField startText;
	private JTextField endText;
	private JCheckBox pickedUpBox;
	private JCheckBox returnedBox;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField drivingLicenceText;
	private JTextField telephoneText;
	private JTextField emailText;
	private JTextField addressText;
	private JTextField priceText;
	private JTextField cardNrText;
	
	
	
		
	/**
	 * Makes a reservation page with 3 panels: reservation, person
	 * and payment.
	 * @throws SQLException 
	 */
	
	public ReservationGUI()
	{
		init();
	}
	
	public ReservationGUI(String start, String end, String carClass) {
		this.start = start;
		this.end = end;
		this.carClass = carClass;
		init();
	}
	
	public ReservationGUI(int resNumber) {
		resControl = new ReservationController();
				
		if(resNumber > 0) {
			//call db to request reservation with resnr as parameter
			ReservationData rData= resControl.getReservationFromDB(resNumber);
			
			// initialise all the fields
			this.resnr = rData.getId();
			this.start = "" + rData.getStartDateGreg();
			this.end = "" + rData.getEndDate();
			this.carClass = rData.getVehicleClass();
			this.car = rData.getVehicle();
			this.pickedUp = rData.isPickedUp();
			this.returned = rData.isReturned();
			this.firstName = rData.getFirstName();
			this.lastName = rData.getLastName();
			this.drivingLicence = rData.getDriversLicence();
			this.telephone = rData.getPhone();
			this.email = rData.getEmail();
			this.address = rData.getAdress();
			this.price = rData.getTotalPrice();
			this.cardType = rData.getCreditCardType();
			this.cardNr = rData.getCreditCardNr();
			
			// initialise the gui
			init();
		}
		/*else if(name != null && startdate != null) {
			//call db to request reservation with name and startdate as parameters
			resControl.getReservationFromDB(name, startdate);
		}
		else {
			// error message "You need to fill in either Reservation number or Name and Start date"
		}*/
		
	}
		
	private void init() {
			// set layout for the reservation page
			FlowLayout overallLayout = new FlowLayout();
			overallLayout.setAlignment(0);
			setLayout(overallLayout);
			
			// create the 3 panels
			makeReservationPanel();
			makePersonPanel();
			makePaymentPanel();
	}

	
	/**
	 * Makes a reservation panel and adds it to the reservation page
	 * @throws SQLException 
	 */
	
	private void makeReservationPanel()
	{
		JPanel reservationPanel = new JPanel();
		reservationPanel.setLayout(new BoxLayout(reservationPanel, BoxLayout.Y_AXIS));
		reservationPanel.setBorder(emptyBorder);
		add(reservationPanel);
		
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
		        
					JLabel classLabel = new JLabel("Vehicle class");
					reservationLabelPanel.add(classLabel);
		        
					JLabel vehicleLabel = new JLabel("Vehicle");
					reservationLabelPanel.add(vehicleLabel);
		
				// make text panel for top panel
		        JPanel reservationTextPanel = new JPanel();
		        reservationTextPanel.setLayout(new GridLayout(0,1));
		        reservationTopPanel.add(reservationTextPanel);
		        
		        	resnrText = new JTextField(10);
		        	reservationTextPanel.add(resnrText);
		        	if(resnr >= 0) resnrText.setText("" + resnr);
		        	
		        	startText = new JTextField(10);
		        	reservationTextPanel.add(startText);
		        	if(start!=null) startText.setText(start);
		        			        
		        	endText = new JTextField(10);
		        	reservationTextPanel.add(endText);
		        	if(end!=null) endText.setText(end);
		        	
		        	VehicleClassController vcc = new VehicleClassController();
		        	try {
		        		Object[] classes = vcc.getArray();
		        		JComboBox classCombo = new JComboBox(classes);
		        		if(carClass != null) classCombo.setSelectedItem(carClass);
		        		reservationTextPanel.add(classCombo);
						
					} catch (Exception e) {
						// TODO: if there is an error in db connection then show it in the gui
					}
		        	
		        	AllVehiclesController avc = new AllVehiclesController();
		        	try {
		        		Object[] vehicles = avc.getVehicles(carClass);
		        		JComboBox vehiclesCombo	= new JComboBox(vehicles);
		        		if(car != null) vehiclesCombo.setSelectedItem(car);
		        		reservationTextPanel.add(vehiclesCombo);
		        		
		        	} catch (Exception e) {
						// TODO: if there is an error in db connection then show it in the gui
					}
		        			
			// make bottom panel for reservation panel	
			JPanel reservationBottomPanel = new JPanel();
			reservationBottomPanel.setLayout(new GridLayout(0,1));
			reservationPanel.add(reservationBottomPanel);
				
				pickedUpBox = new JCheckBox("Picked up");
				reservationBottomPanel.add(pickedUpBox);
				//if(pickedUp != false) pickedUpBox.setPressedIcon(pressedIcon);
								
				returnedBox = new JCheckBox("Returned");
				reservationBottomPanel.add(returnedBox);
				//if(returned != false) returnedBox.setPressedIcon(pressedIcon);
	}
						
	/**
	 * Makes a person panel and adds it to the reservation page
	 */
	
	private void makePersonPanel()
	{
		JPanel personPanel = new JPanel();
		personPanel.setLayout(new BoxLayout(personPanel, BoxLayout.Y_AXIS));		
		personPanel.setBorder(emptyBorder);
		add(personPanel);
		
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
		        
		        firstNameText = new JTextField();
		        personTextPanel.add(firstNameText);
		        if(firstName != null) firstNameText.setText(firstName);
		        
		        lastNameText = new JTextField();
		        personTextPanel.add(lastNameText);
		        if(lastName != null) lastNameText.setText(lastName);
		        
		        drivingLicenceText = new JTextField();
		        personTextPanel.add(drivingLicenceText);
		        if(drivingLicence != null) drivingLicenceText.setText(drivingLicence);
		        
		        telephoneText = new JTextField();
		        personTextPanel.add(telephoneText);
		        if(telephone != null) telephoneText.setText(telephone);
		        
		        emailText = new JTextField();
		        personTextPanel.add(emailText);	
		        if(email != null) emailText.setText(email);
		
			// make middle panel for person panel
		    JPanel personMiddlePanel = new JPanel();
		    personMiddlePanel.setLayout(new GridLayout(0,1));
			personPanel.add(personMiddlePanel);
			
			JLabel addressLabel = new JLabel("Address");
			personMiddlePanel.add(addressLabel);
			
			addressText = new JTextField();
			personMiddlePanel.add(addressText);
			if(address != null) addressText.setText(address);
			
			// make bottom panel for person panel
			JPanel personBottomPanel = new JPanel();
			personBottomPanel.setLayout(new FlowLayout());
			personPanel.add(personBottomPanel);
			
			JButton findButton = new JButton("Find Customer");
			personBottomPanel.add(findButton);
			findButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		
	}
		
	/**
	 * Makes a payment panel and adds it to the reservation page
	 */
	
	private void makePaymentPanel()
	{
		JPanel paymentPanel = new JPanel();
		paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
		paymentPanel.setBorder(emptyBorder);
		add(paymentPanel);
		
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
				
				priceText = new JTextField();
		        paymentTextPanel.add(priceText);
		        if(price >= 0) priceText.setText("" + price);
		        
		        Object[] cards = {"Visa", "MasterCard", "AmEx"};
		        JComboBox cardTypeCombo = new JComboBox(cards);
		        if(cardType != null) cardTypeCombo.setSelectedItem(cardType);
		        paymentTextPanel.add(cardTypeCombo);
		        		        
		        cardNrText = new JTextField();
		        paymentTextPanel.add(cardNrText);
		        if(cardNr != null) cardNrText.setText(cardNr);
		
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
			paymentBottomPanel.setLayout(new FlowLayout());
			paymentPanel.add(paymentBottomPanel);
			
			JButton saveButton = new JButton("Save Reservation");
			paymentBottomPanel.add(saveButton);
			saveButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("Save");
					// pass ReservationData res to ReservationController to pass to ReservationDB to insert into DataBase
				}
			});
			
			JButton deleteButton = new JButton("Delete Reservation");
			paymentBottomPanel.add(deleteButton);
			deleteButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("deleted");
					// pass resnr to ReservationController to pass to ReservationDB to delete post in DataBase
				}
			});
	}
}
