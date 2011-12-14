package controller;

import java.sql.ResultSet;

import model.AllVehiclesDB;
import view.FrameGUI;

/**
 * Controller class for AllVehicles.
 * 
 * This class gets information from the allVehiclesDB class, and passes
 * them onto the AllVehiclesGUI.
 * The idea of this class is to link the GUI with the model.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 *
 */

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

	/**
	 * Get all vehicle from AllVehiclesDB that are of a specific class.
	 * 
	 * @param carClass - Which car class we want.
	 * @return Object[] selectedVehicles - All the vehicles of the specific class.
	 */
	public Object[] getVehicles(String carClass) {
		
		Object[] selectedVehicles = allVehicles.getSelectedVehicles(carClass);
		return selectedVehicles;
	}

}
