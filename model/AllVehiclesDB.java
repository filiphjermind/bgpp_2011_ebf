package model;

import java.sql.*;

public class AllVehiclesDB extends DBConnection {
	
	public AllVehiclesDB() {
		System.out.println("AllVehiclesDB.AllVehiclesDB()");
	}
	
	/**
	 * Gets all the information about every vehicle in the database
	 * @return 
	 * @throws SQLException
	 */
	public ResultSet getAllVehicles() throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT * FROM Vehicle");
		
		// return the resultset
		return result;
	}
}
