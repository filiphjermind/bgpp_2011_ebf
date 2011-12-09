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
	private String annualCheck;
	private String make;
	private String model;
	private String price;
	private String serviceVehicle;
	private String serviceStartDate;
	private String serviceEndDate;
	private String serviceReason;
	
	public String getServiceVehicle() {
		return serviceVehicle;
	}

	public void setServiceVehicle(String serviceVehicle) {
		this.serviceVehicle = serviceVehicle;
	}

	public String getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public String getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getServiceReason() {
		return serviceReason;
	}

	public void setServiceReason(String serviceReason) {
		this.serviceReason = serviceReason;
	}

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
	
	public VehicleDATA() {
	}

	/**
	 * @return the licenseplate
	 */
	public String getLicenseplate() {
		return licenseplate;
	}



	/**
	 * @param licenceplate the licenseplate to set
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
	public String getAnnualCheck() {
		return annualCheck;
	}



	/**
	 * @param annualCheck the annualCheck to set
	 */
	public void setAnnualCheck(String annualCheck) {
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
