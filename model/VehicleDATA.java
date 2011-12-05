package model;

import java.sql.Date;
import java.util.List;
import model.ReservationData;

/**
 * This class stores information about an 
 * individual vehicle.
 * All the methods are simply getters and setters.
 * @author Ellen Engdahl
 *
 */
public class VehicleDATA {
	private int id;
	private String licenceplate;
	private String vehicleType;
	private Date annualCheck;
	private String make;
	private String model;
	private  List<ReservationData> reservations;

	public VehicleDATA() {
		
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



	/**
	 * @return the licenceplate
	 */
	public String getLicenceplate() {
		return licenceplate;
	}



	/**
	 * @param licenceplate the licenceplate to set
	 */
	public void setLicenceplate(String licenceplate) {
		this.licenceplate = licenceplate;
	}



	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}



	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	/**
	 * @return the annualCheck
	 */
	public Date getAnnualCheck() {
		return annualCheck;
	}



	/**
	 * @param annualCheck the annualCheck to set
	 */
	public void setAnnualCheck(Date annualCheck) {
		this.annualCheck = annualCheck;
	}



	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}



	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}



	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}



	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}



	/**
	 * @return the reservations
	 */
	public List<ReservationData> getReservations() {
		return reservations;
	}



	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<ReservationData> reservations) {
		this.reservations = reservations;
	}

}
