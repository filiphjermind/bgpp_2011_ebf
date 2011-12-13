package controller;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JTextField;

import model.ReservationDB;
import model.ReservationData;
import model.VehicleDATA;

public class ReservationController {

	private ReservationDB reservationDB;

	public ReservationController() {
		reservationDB = new ReservationDB();
	}
	// get reservation from database with resnr as parameter
	public ReservationData getReservationFromDB(int reservationNr) {
		ReservationData reservationData = reservationDB.getOneReservation(reservationNr);
		return reservationData;
	}
	
	// get reservation from database with name and startdate as parameters
	/*public ReservationData getReservationFromDB(String name, String startdate) {
		ReservationData reservationData = reservationDB.getOneReservation(name, startdate);
		return reservationData;
	}*/
	
	//get reservations for a month from the database
	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		return reservationDB.getReservations(vehicleClasses, currentMonth);
	}
	public int saveReservation(ReservationData newReservation) {
		int resNr = reservationDB.saveReservation(newReservation);	
		return resNr;
	}
	public void deleteReservation(int resnr) {
		reservationDB.deleteReservation(resnr);
		
	}
	
}
