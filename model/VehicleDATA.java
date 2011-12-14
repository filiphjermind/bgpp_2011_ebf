package model;

import java.sql.Date;
import java.util.List;
import model.ReservationData;

/**
 * This class stores information about an individual vehicle.
 */
public class VehicleDATA {
	private String vehicleClass;
	private String annualCheck;
	private String make;
	private String model;
	private String price;
	private String serviceVehicle;
	private String serviceStartDate;
	private String serviceEndDate;
	private String serviceReason;
	private  List<ReservationData> reservations;
	private String licensePlate;
	
	/**
	 * VehicleDATA constructor
	 * @param vehicleClass
	 * @param licensePlate
	 * @param reservations
	 */
	public VehicleDATA(String vehicleClass, String licensePlate, List<ReservationData> reservations) {
		this.vehicleClass = vehicleClass;
		this.licensePlate = licensePlate;
		this.reservations = reservations;		
	}
	
	/**
	 * VehicleDATA constructor
	 */
	public VehicleDATA() {
		
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
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * @return serviceVehicle the serviceVehicle the vehicle to to be serviced
	 */
	public String getServiceVehicle() {
		return serviceVehicle;
	}

	/**
	 * @param serviceVehicle the vehicle to to be serviced
	 */
	public void setServiceVehicle(String serviceVehicle) {
		this.serviceVehicle = serviceVehicle;
	}

	/**
	 * @return serviceStartDate
	 */
	public String getServiceStartDate() {
		return serviceStartDate;
	}

	/**
	 * @param serviceStartDate to set
	 */
	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	/**
	 * @return serviceEndDate
	 */
	public String getServiceEndDate() {
		return serviceEndDate;
	}

	/**
	 * @param serviceEndDate the endDate to set
	 */
	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	/**
	 * @return serviceReason
	 */
	public String getServiceReason() {
		return serviceReason;
	}

	/**
	 * @param serviceReason the serviceReason to set
	 */
	public void setServiceReason(String serviceReason) {
		this.serviceReason = serviceReason;
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

	/**
	 * @return the licenseplate
	 */
	public String getLicenseplate() {
		return licensePlate;
	}

	/**
	 * @param licenceplate the licenseplate to set
	 */
	public void setLicenseplate(String licenseplate) {
		licensePlate = licenseplate;
	}
	
	@Override
	public String toString() {
		return getVehicleClass();
	}
}
