package model;


import java.sql.*;
import java.util.ArrayList;


public class VehicleClassDB extends DBConnection {
	
		
	public VehicleClassDB() {
		
	}
		
	/**
	 * Get the list of vehicle classes from the database as an array
	 * @return Object[]
	 * @throws SQLException
	 */
	public Object[] getVehicleClassListAsArray() throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT description FROM VehicleClass");
		
		// turn it into an ArrayList
		ArrayList<String> arrList = new ArrayList<String>();
        while(result.next()) {
            arrList.add(result.getString("description"));
        }
        
        // turn the arraylist into an array
        Object [] vehicleList = arrList.toArray();
		
        // return the array
		return vehicleList;
	}
	
	/**
	 * Get the list of vehicle classes from the database as an arrayList
	 * @return ArrayList<String>
	 * @throws SQLException
	 */
	public ArrayList<String> getVehicleClassListAsArrayList() throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT description FROM VehicleClass");
		
		// turn it into an ArrayList
		ArrayList<String> arrList = new ArrayList<String>();
        while(result.next()) {
            arrList.add(result.getString("description"));
        }
        	
        // return the arrayList
		return arrList;
	}
			
}
