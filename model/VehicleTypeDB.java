package model;


import java.sql.*;
import java.util.ArrayList;


public class VehicleTypeDB extends DBConnection {
	
	public VehicleTypeDB() {
		
	}
	
	public Object[] getVehicleList() throws SQLException {
		// get a resultset
		ResultSet result = sendQuery("SELECT description FROM VehicleType");
		
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
