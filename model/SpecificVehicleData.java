//package model;
//
//import java.sql.*;
//
//public class SpecificVehicleData extends DBConnection {
//	
//	public SpecificVehicleData()
//	{
//		
//	}
//	
//	
//	/**
//	 * Gets all the data about a specific vehicle
//	 * from the database.
//	 * 
//	 * @param String licensePlate
//	 * @return ResultSet result
//	 */
//	public ResultSet getSpecificVehicleData(String licensePlate) throws Exception
//	{
//		// The query to be executed.
//		String query = "SELECT Vehicle.licensePlate, Vehicle.vehicleClass, Vehicle.annualCheck, Vehicle.model, " +
//						"VehicleClass.price, Service.vehicle, Service.startDate, Service.endDate, Service.reason, " +
//						"FROM Vehicle, VehicleClass, Service " +
//						"WHERE Vehicle.licensePlate = '" + licensePlate + "' AND " +
//						"Vehicle.vehicleClass = VehicleClass.vehicleClass AND Service.vehicle = '" + licensePlate + "'";
//		
//		// Sends the query to the database, and stores the data in a resultset.
//		ResultSet result = sendQuery(query);
//		
//		VehicleDATA vehicleData = new VehicleDATA();
//		
//		while(result.next()) {
//			vehicleData.setLicenseplate(result.getString(1));
//			vehicleData.setVehicleClass(result.getString(2));
//			vehicleData.setAnnualCheck(result.getDate(3));
//			vehicleData.setModel(result.getString(4));
//			
//		}
//		
//		return result;
//	}
//}
