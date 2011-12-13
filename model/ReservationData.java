package model;

import java.util.GregorianCalendar;

public class ReservationData {
	private int reservationID;
	private int personID;
	private GregorianCalendar start;
	private GregorianCalendar end;
	private String vehicle;
	private boolean pickedUp;
	private boolean returned;
		
	private int duration;
	private boolean beingServiced;
	
	private String vehicleClass;
	private int vehiclePricePerDay;
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String adress;
	private String driversLicence;
	private String creditCardType;
	private String creditCardNr;
	
	private int totalPrice;
	
	public ReservationData(GregorianCalendar start, GregorianCalendar end, boolean beingServiced, int reservationID) {
		this.start = start;
		this.end = end;
		this.beingServiced = beingServiced;
		this.setReservationID(reservationID);
		calculateDuration();
	}

	private void calculateDuration() {
		duration = end.get(GregorianCalendar.DAY_OF_MONTH) - start.get(GregorianCalendar.DAY_OF_MONTH);
		
	}

	public ReservationData() {
		
	}
	
	/**
	 * @return the reservationID
	 */
	public int getReservationID() {
		return reservationID;
	}

	/**
	 * @param reservationID the reservationID to set
	 */
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	/**
	 * @return the personID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	/*
	 * @return int the start day of the reservation. Given as 0 indexed.
	 */
	public int getStartDayInt() {
		return start.get(GregorianCalendar.DAY_OF_MONTH)-1;
	}

	public int getEndDayInt() {
		return end.get(GregorianCalendar.DAY_OF_MONTH)-1;
	}
	
	public GregorianCalendar getStartDateGreg() {
		return start;
	}
	public void setStartDateGreg(GregorianCalendar start) {
		this.start = start;
	}
	
	/**
	 * @return the end
	 */
	public GregorianCalendar getEndDateGreg() {
		return end;
	}
	
	public void setEndDateGreg(GregorianCalendar end) {
		this.end = end;
	}
	
	/*
	 * @return the duration in days of a reservation
	 */
	public int getDuration() {
		return duration;
	}
	
	
	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the pickedUP
	 */
	public boolean isPickedUp() {
		return pickedUp;
	}

	/**
	 * @param pickedUP the pickedUP to set
	 */
	public void setPickedUp(int pickedUp) {
		if(pickedUp == 0)
			this.pickedUp = false;
		if(pickedUp == 1)
			this.pickedUp = true;
	}

	/**
	 * @return the returned
	 */
	public boolean isReturned() {
		return returned;
	}

	/**
	 * @param returned the returned to set
	 */
	public void setReturned(int returned) {
		if(returned == 0)
			this.returned = false;
		if(returned == 1)
			this.returned = true;
	}

	/**
	 * @return true if it is being serviced
	 */
	public boolean getBeingServiced() {
		return beingServiced;
	}
	
	public void setBeingServiced(boolean beingServiced) {
		this.beingServiced = beingServiced;
	}
	
	
	
	@Override
	public String toString() {
		return "start: "+ (start.getTimeInMillis()/(60*60*24)) + " end: "+ (end.getTimeInMillis()/(60*60*24)) + " beingServiced: " +beingServiced;
	}

	

	/**
	 * @return the vehicleClass
	 */
	public String getVehicleClass() {
		return vehicleClass;
	}

	/**
	 * @param vehicleClass the vehicleClass to set
	 */
	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	/**
	 * @return the vehiclePricePerDay
	 */
	public int getVehiclePricePerDay() {
		return vehiclePricePerDay;
	}

	/**
	 * @param vehiclePricePerDay the vehiclePricePerDay to set
	 */
	public void setVehiclePricePerDay(int vehiclePricePerDay) {
		this.vehiclePricePerDay = vehiclePricePerDay;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param address the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return the driversLicence
	 */
	public String getDriversLicence() {
		return driversLicence;
	}

	/**
	 * @param driversLicence the driversLicence to set
	 */
	public void setDriversLicence(String driversLicence) {
		this.driversLicence = driversLicence;
	}

	/**
	 * @return the creditCardType
	 */
	public String getCreditCardType() {
		return creditCardType;
	}

	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	/**
	 * @return the creditCardNr
	 */
	public String getCreditCardNr() {
		return creditCardNr;
	}

	/**
	 * @param creditCardNr the creditCardNr to set
	 */
	public void setCreditCardNr(String creditCardNr) {
		this.creditCardNr = creditCardNr;
	}

	/**
	 * @return the totalPrice
	 */
	public int calculateTotalPrice() {
		calculateDuration();
		int days = getDuration();
		int totalPrice = days * vehiclePricePerDay;
		return totalPrice;
	}

	public void setPickedUp(boolean pickedUp2) {
		this.pickedUp = pickedUp2;
		
	}

	public void setReturned(boolean returned2) {
		this.returned = returned2;
		
	}


}
