package model;

import java.sql.*;

public class AllVehiclesDB extends DBConnection {
	
	public AllVehiclesDB() {
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

	public Object[] getSelectedVehicles(String carClass) {
	// get a resultset
		ResultSet result = sendQuery("SELECT * FROM Vehicle WHERE vehicleClass = '" + carClass + "'");
		return null;
	}
}
