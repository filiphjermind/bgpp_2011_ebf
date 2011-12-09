package model;

import java.sql.*;

public class SpecificVehicleDB extends DBConnection{
	

	public SpecificVehicleDB() {
		
	}

	private VehicleDATA getVehicle(String licenseplate) {
		// get information on the vehicle
		ResultSet result = sendQuery("SELECT * FROM Vehicle WHERE licensePlate = licenseplate");
		
		// retrieve it from the resultSet and store it in a vehicleData object
		VehicleDATA vehicleData = new VehicleDATA();
		try {
			while(result.next()) {
				vehicleData.setLicenseplate(result.getString("licensePlate"));
				vehicleData.setVehicleClass(result.getString("vehicleClass"));
				vehicleData.setAnnualCheck(result.getDate("annualCheck"));
				vehicleData.setMake(result.getString("make"));
				vehicleData.setModel(result.getString("model"));
				// history of services table, array, map
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleData;
	}
	
}
