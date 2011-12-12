package model;

import java.sql.*;
import java.util.ArrayList;

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
		ResultSet result = sendQuery("SELECT licensePlate FROM Vehicle WHERE vehicleClass = '" + carClass + "'");
		
		// turn it into an ArrayList
		ArrayList<String> arrList = new ArrayList<String>();
		try {
			while (result.next()) {
				arrList.add(result.getString("licensePlate "));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// turn the arraylist into an array
		Object[] vehicleList = arrList.toArray();
		
		return vehicleList;
	}
}
