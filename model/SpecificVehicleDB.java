package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecificVehicleDB extends DBConnection {
	 
	VehicleDATA vehicleData = new VehicleDATA();
	
	private String licensePlate;

	public SpecificVehicleDB() {
		
	}

	public ResultSet askDataBase(String licensePlate) throws SQLException {
		
		this.licensePlate = licensePlate;
		
		String query2 = "SELECT Vehicle.licensePlate, Vehicle.vehicleClass, Vehicle.annualCheck, Vehicle.model, " +
						"VehicleClass.price " +
						"FROM Vehicle, VehicleClass " +
						"WHERE Vehicle.licensePlate = '" + licensePlate + "'";
		
		
		String query = "SELECT Vehicle.licensePlate, Vehicle.vehicleClass, Vehicle.annualCheck, Vehicle.make, " +
						"VehicleClass.price, Service.vehicle, Service.startDate, Service.endDate, Service.reason " +
						"FROM Vehicle, VehicleClass, Service " +
						"WHERE Vehicle.licensePlate = '" + licensePlate + "' AND " +
						"Vehicle.vehicleClass = VehicleClass.vehicleClass AND Vehicle.licensePlate = Service.vehicle";

		// get a resultset
		ResultSet result = sendQuery(query2);
		
		while(result.next()) {
			String license = result.getString("Vehicle.licensePlate");
			vehicleData.setLicenseplate(license);
			System.out.println("SFADSDF: " + vehicleData.getLicenseplate());
			vehicleData.setVehicleClass(result.getString("Vehicle.vehicleClass"));
			vehicleData.setMake(result.getString("Vehicle.make"));
			vehicleData.setAnnualCheck(result.getDate("Vehicle.annualCheck"));
			vehicleData.setPrice(result.getString("VehicleClass.price"));
		}
		
		
		/*String licenseP;
		String vehicleClass;
		
		while(result.next()) {
			licenseP = result.getString("Vehicle.licensePlate");
			vehicleClass = result.getString("Vehicle.vehicleClass");
			vehicleData.setLicenseplate(result.getString("Vehicle.getLicensePlate"));
			vehicleData.setVehicleClass(result.getString("Vehicle.vehicleClass"));
			vehicleData.setMake(result.getString("Vehicle.make"));
			vehicleData.setAnnualCheck(result.getDate("Vehicle.annualCheck"));
			vehicleData.setPrice(result.getString("VehicleClass.price"));
			//System.out.println("License plate " + result.getString("Vehicle.licensePlate"));
			//System.out.println("Vehicle class: " + result.getString(2));
			//System.out.println("Annual check: " + result.getString(3));
			//System.out.println("model: " + result.getString(4));
			//System.out.println("Price: " + result.getString(5));
			//System.out.println("Service vehicle: " + result.getString(6));
			//System.out.println("Start date: " + result.getString(7));
			//System.out.println("End date: " + result.getString(8));
			//System.out.println("Reason: " + result.getString(9));
			System.out.println("LicenseP: " + licenseP);
			System.out.println("Vehicle Class: " + vehicleClass);
			
			vehicleData.setLicenseplate(licenseP);
			vehicleData.setVehicleClass(vehicleClass);
		}*/
		
		
		
		
		return result;
	}
	
	/*public VehicleDATA getVehicleData(String licenceplate) {
		askDataBase(String licensePlate);
		return vehicleData;
	}*/
}
