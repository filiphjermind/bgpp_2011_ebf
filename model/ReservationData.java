package model;

import java.util.GregorianCalendar;

public class ReservationData {
	private int id;
	private final GregorianCalendar start;
	private final GregorianCalendar end;
	private VehicleDATA vehicle;
	private boolean pickedUp;
	private boolean returned;
	private PersonDATA person;
		
	private final boolean beingServiced;
	
	public ReservationData(GregorianCalendar start, GregorianCalendar end, boolean beingServiced) {
		this.start = start;
		this.end = end;
		this.beingServiced = beingServiced;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * @return int the start day of the reservation. Given as 0 indexed.
	 */
	public int getStartDay() {
		return start.get(GregorianCalendar.DAY_OF_MONTH)-1;
	}
	
	/*public void setStart() {
		this.start = ?;
	}*/
	
	/**
	 * @return the end
	 */
	public GregorianCalendar getEnd() {
		return end;
	}
	
	/*public GregorianCalender setEnd() {
		this.end = ?;
	}*/
	
	/*
	 * @return the duration in days of a reservation
	 */
	public int getDuration() {
		return end.get(GregorianCalendar.DAY_OF_MONTH) - start.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	
	/**
	 * @return the vehicle
	 */
	public VehicleDATA getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(VehicleDATA vehicle) {
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
	public void setPickedUP(boolean pickedUp) {
		this.pickedUp = pickedUp;
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
	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	/**
	 * @return the person
	 */
	public PersonDATA getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(PersonDATA person) {
		this.person = person;
	}
	
	/**
	 * @return true if it is being serviced
	 */
	public boolean getBeingServiced() {
		return beingServiced;
	}
	
	/*public void setBeingServiced(boolean beingServiced) {
		this.beingServiced = beingServiced;
	}*/
	
	@Override
	public String toString() {
		return "start: "+ start.getTimeInMillis() + " end: "+ end.getTimeInMillis() + " beingServiced: " +beingServiced;
	}
}
