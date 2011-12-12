package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecificVehicleDB extends DBConnection {
	
	private String licensePlate;
	
	private String serviceLicensePlate;
	private String serviceStartDate;
	private String serviceEndDate;
	private String serviceReason;
	
	public SpecificVehicleDB() {
		getVehicle(licensePlate);
	}

	public VehicleDATA getVehicle(String licenseplate) {
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
				vehicleData.setLicenseplate(result.getString("licensePlate"));
				vehicleData.setVehicleClass(result.getString("vehicleClass"));
				vehicleData.setAnnualCheck(result.getString("annualCheck"));
				vehicleData.setMake(result.getString("make"));
				vehicleData.setPrice(result.getString("price"));
				//vehicleData.setModel(result.getString("model"));
				// history of services table, array, map
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicleData;
	}
	
	public VehicleDATA getVehicleData()
	{
		VehicleDATA vd = getVehicle(licensePlate);
		return vd;
	}
	
	public ResultSet vehicleService(String licenseplate)
	{
		licensePlate = licenseplate;
		
		// The query to be executed.
		/*String query = "SELECT Service.vehicle, Service.startDate, Service.endDate, Service.reason " +
						"FROM Service WHERE Service.vehicle = '" + licensePlate + "'";*/
		
		String query = "SELECT * FROM Service WHERE vehicle = '" + licenseplate + "' ORDER BY startDate ASC";
		
		// Execute the query.
		ResultSet result = sendQuery(query);
				
		// Return the resultSet.
		return result;
	}
	
	public ResultSet getVehicleService()
	{
		ResultSet result = vehicleService(licensePlate);
		
		return result;
	}
	
	public void addService(String licensePlate, String startDate, String endDate, String reason)
	{
		serviceLicensePlate = licensePlate;
		serviceStartDate = startDate;
		serviceEndDate = endDate;
		serviceReason = reason;
		
		// Check to make sure the user has entered data into the fields.
		if(licensePlate.isEmpty()) {
			System.out.println("No license plate.");
		} else if(startDate.isEmpty()) {
			System.out.println("No start date");
		} else if(endDate.isEmpty()) {
			System.out.println("No end date");
		} else if(reason.isEmpty()) {
			System.out.println("No reason");
		} else {
		
			// Query to be executed.
			String query = "INSERT INTO Service (vehicle, startDate, endDate, reason) " +
							"VALUES ('" + serviceLicensePlate + "', '" + serviceStartDate + "', '" + serviceEndDate + "', '" + serviceReason + "')";	
			// Execute the query
			ResultSet result = sendQuery(query);
		}
	}
	
	
	

}
