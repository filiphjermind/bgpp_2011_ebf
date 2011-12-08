package model;

import java.sql.*;

public class SpecificVehicleDB extends DBConnection{
	
	VehicleDATA vehicleData;

	public SpecificVehicleDB() {
		vehicleData = null;
	}

	private void askDataBase(String licenceplate) throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT * FROM Vehicle WHERE licencePlate = licenceplate");
		
		// retrieve it from the resultSet and store it in a vehicleData object
		vehicleData = new VehicleDATA();
		while(result.next()) {
			vehicleData.setId(result.getInt("id"));
			vehicleData.setLicenceplate(result.getString("licencePlate"));
			vehicleData.setVehicleClass(result.getString("vehicleClass"));
			vehicleData.setAnnualCheck(result.getDate("annualCheck"));
			vehicleData.setMake(result.getString("make"));
			vehicleData.setModel(result.getString("model"));
			// history of services table, array, map
		}
	}
	
	public VehicleDATA getVehicleData(String licenceplate) {
		askDataBase(String licenceplate);
		return vehicleData;
	}
}
