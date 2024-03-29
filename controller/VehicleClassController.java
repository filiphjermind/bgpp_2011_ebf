package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.VehicleClassDB;

/**
 * VehicleClass retrieves the list of vehicles from the database
 * and if one or more classes are selected it passes it as 
 * parameters to other methods.
 * @author Ellen
 *
 */
public class VehicleClassController {

	/**
	 * VehicleClassController constructor
	 */
	public VehicleClassController() {
		
	}
	
	/**
	 * Get the list of vehicle classes from the database as an array
	 * @return the list of vehicle classes
	 * @throws SQLException
	 */
	public Object[] getArray() throws SQLException {
		VehicleClassDB vcdb = new VehicleClassDB();
		Object [] vehicleClassList = vcdb.getVehicleClassListAsArray();
		return vehicleClassList;
	}
	
	/**
	 * Get the list of vehicle classes from the database as an arrayList
	 * @return ArrayList<String>
	 * @throws SQLException
	 */
	public ArrayList<String> getArrayList() throws SQLException {
		VehicleClassDB vcdb = new VehicleClassDB();
		ArrayList<String> vehicleClassList = vcdb.getVehicleClassListAsArrayList();
		return vehicleClassList;
	}
}
