package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Handles all the communication with the database that is
 * related to the "allvehicles" window.
 * 
 * Extends the DBConnection class in order to access the connection to the database.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 *
 */

public class AllVehiclesDB extends DBConnection {
	
	public AllVehiclesDB() 
	{
		
	}
	
	/**
	 * Gets all the information about every vehicle in the database
	 * @return ResultSet vehicleList - List of all vehicles in the database.
	 * @throws SQLException
	 */
	public ResultSet getAllVehicles() throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT * FROM Vehicle");
		
		// return the resultset
		return result;
	}
	
	/**
	 * Retrieves all vehicles from the database that are of a specific vehicle class.
	 * @param carClass - The vehicle class.
	 * @return Object[] vehicleList - Array of all vehicles of the specific class.
	 */
	public Object[] getSelectedVehicles(String carClass) {
		// get a resultset
		ResultSet result = sendQuery("SELECT licensePlate FROM Vehicle WHERE vehicleClass = '" + carClass + "'");
		
		// Turn the resultset into an ArrayList
		ArrayList<String> arrList = new ArrayList<String>();
		try {
			while (result.next()) {
				arrList.add(result.getString("licensePlate"));
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
