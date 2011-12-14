package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles all the communication to the database that is related
 * to the specific vehicle window.
 * 
 * Extends DBConnection in order to access the connection to the database.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 *
 */
public class SpecificVehicleDB extends DBConnection {
	
	private String licensePlate;
	
	private String serviceLicensePlate;
	private String serviceStartDate;
	private String serviceEndDate;
	private String serviceReason;
	
	public SpecificVehicleDB() {
		getVehicle(licensePlate);
	}
	
	/**
	 * Retrieves information about a vehicle which has the
	 * specific license plate.
	 * 
	 * @param licenseplate - Which vehicle information to retrieve.
	 * 
	 * @return VehicleDATA - VehicleDATA object with the information about the vehicle.
	 */
	public VehicleDATA getVehicle(String licenseplate) {
		// The license plate of the vehicle we want the information of.
		licensePlate = licenseplate;
		
		// The query to be executed.
		String query = "SELECT Vehicle.licensePlate, Vehicle.vehicleClass, Vehicle.annualCheck, Vehicle.make, " +
						"VehicleClass.price " +
						"FROM Vehicle, VehicleClass " +
						"WHERE Vehicle.licensePlate = '" + licensePlate + "' AND Vehicle.vehicleClass = VehicleClass.vehicleClass";
		
		// get information on the vehicle
		ResultSet result = sendQuery(query);
		
		// retrieve it from the resultSet and store it in a vehicleData object
		VehicleDATA vehicleData = new VehicleDATA();
		try {
			while(result.next()) {
				/*
				 *  Insert the values from the databse into the fields 
				 * of the VehicleDATA object.
				 */
				vehicleData.setLicenseplate(result.getString("licensePlate"));
				vehicleData.setVehicleClass(result.getString("vehicleClass"));
				vehicleData.setAnnualCheck(result.getString("annualCheck"));
				vehicleData.setMake(result.getString("make"));
				vehicleData.setPrice(result.getString("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicleData;
	}
	
	/**
	 * Retrieves the information about a specific vehicle.
	 * NOTE: Without parameters.
	 * 
	 * @return vd - The information about the specific vehicle. 
	 */
	public VehicleDATA getVehicleData()
	{
		VehicleDATA vd = getVehicle(licensePlate);
		return vd;
	}
	
	/**
	 * Retrieve all the service information which is related to a specific 
	 * vehicle from the database.
	 * @param licenseplate - Which vehicle we want the service information of.
	 * 
	 * @return ResultSet result - The service information of the specific vehicle.
	 */
	public ResultSet vehicleService(String licenseplate)
	{
		licensePlate = licenseplate;
		
		// The query to be executed.
		String query = "SELECT * FROM Service WHERE vehicle = '" + licenseplate + "' ORDER BY startDate ASC";
		
		// Execute the query.
		ResultSet result = sendQuery(query);
				
		// Return the resultSet.
		return result;
	}
	
	/**
	 * Retrieves the service information about a specific vehicle.
	 * NOTE: Without parameters.
	 * 
	 * @return ResultSet result - The service information of the specific vehicle.
	 */
	public ResultSet getVehicleService()
	{
		ResultSet result = vehicleService(licensePlate);
		
		return result;
	}
	
	/**
	 * Inserts service information of a vehicle into the database.
	 * 
	 * @param licensePlate - The vehicle which the service information belongs to.
	 * @param startDate - The start date of the service.
	 * @param endDate - The end date of the service.
	 * @param reason - The reason of the service.
	 */
	public void addService(String licensePlate, String startDate, String endDate, String reason)
	{
		serviceLicensePlate = licensePlate;
		serviceStartDate = startDate;
		serviceEndDate = endDate;
		serviceReason = reason;
		
		// Query to be executed.
		String query = "INSERT INTO Service (vehicle, startDate, endDate, reason) " +
						"VALUES ('" + serviceLicensePlate + "', '" + serviceStartDate + "', '" + serviceEndDate + "', '" + serviceReason + "')";	
		// Execute the query
		ResultSet result = sendQuery(query);
	}	
}
