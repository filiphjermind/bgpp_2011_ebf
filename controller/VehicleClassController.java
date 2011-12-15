package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import model.VehicleClassDB;
import view.homeGUI.FilterPanel;

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
	
	/**
	 * Get the user selected vehicle classes from the GUI and pass it to 
	 * the database
	 */
	public ArrayList<String> getSelectedClasses() {
	FilterPanel filter = new FilterPanel();
	checkBox.addActionListener(new ActionListener) {
		public void actionPerformed(ActionEvent e) {
			collectAllSelectedCheckboxes();
		}
	});
	}
}
