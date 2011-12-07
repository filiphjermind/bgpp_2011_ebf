package model;

import java.sql.*;

public class AllVehiclesDB extends DBConnection {
	
	public AllVehiclesDB() {
		System.out.println("AllVehiclesDB.AllVehiclesDB()");
	}

	public ResultSet getAllVehicles() throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT * FROM Vehicle");
		
		// return the resultset
		return result;
	}
}
