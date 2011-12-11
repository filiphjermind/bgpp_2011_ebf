package controller;

import java.sql.ResultSet;

import model.AllVehiclesDB;
import view.FrameGUI;

public class AllVehiclesController {
	AllVehiclesDB allVehicles = new AllVehiclesDB();

	
	/**
	 * Get all vehicles from AllVehiclesDB.
	 * 
	 * @return ResultSet result.
	 */
	public ResultSet getAllVehicles() throws Exception
	{
		ResultSet result = allVehicles.getAllVehicles();
		
		return result;
	}


	public Object[] getVehicles(String carClass) {
		Object[] selectedVehicles = allVehicles.getSelectedVehicles(carClass);
		return selectedVehicles;
	}

}
