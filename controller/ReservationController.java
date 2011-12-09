package controller;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import model.ReservationDB;
import model.VehicleDATA;

public class ReservationController {

	private ReservationDB reservationDB;

	public ReservationController() {
		reservationDB = new ReservationDB();
	}
	// get reservation from database
	public void getReservaionFromDB(int reservationNr) {
		
	}
	
	// get reservationinfo from GUI
	public void getInfFromGUI() {
		
	}

	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		return reservationDB.getReservations(vehicleClasses, currentMonth);
	}
}
