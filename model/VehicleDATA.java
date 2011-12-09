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
	private String licenseplate;
	private String vehicleClass;
	private Date annualCheck;
	private String make;
	private String model;
	private String price;
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	private  List<ReservationData> reservations;

	public VehicleDATA(String vehicleClass, List<ReservationData> reservations) {
		this.vehicleClass = vehicleClass;
		this.reservations = reservations;
		
	}
	
	public VehicleDATA() 
	{
		
	}

	/**
	 * @return the licenseplate
	 */
	public String getLicenseplate() {
		return licenseplate;
	}



	/**
	 * @param licenseplate the licenseplate to set
	 */
	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}



	/**
	 * @return the vehicleClass
	 */
	public String getVehicleClass() {
		return vehicleClass;
	}



	/**
	 * @param vehicleType the vehicleClass to set
	 */
	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
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
	
	@Override
	public String toString() {
		return getVehicleClass();
	}

}
