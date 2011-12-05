package model;


import java.sql.*;
import java.util.ArrayList;


public class VehicleClassDB extends DBConnection {
	
	public VehicleClassDB() {
		
	}
	
	public Object[] getVehicleList() throws SQLException {
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
	
}
