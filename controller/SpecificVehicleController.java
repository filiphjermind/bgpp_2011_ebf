package controller;

import model.SpecificVehicleDB;

public class SpecificVehicleController {

		// get specific vehicle from database
		public void getVFromDB(String licenceplate) {
			SpecificVehicleDB svdb = new SpecificVehicleDB();
			svdb.getVehicleData(licenceplate);
		}
		
		// get specific vehicle from GUI (service start, end, and reason)
		public void getInfFromGUI() {
			
		}
}
