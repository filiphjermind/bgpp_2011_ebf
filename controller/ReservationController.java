package controller;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JTextField;

import model.ReservationDB;
import model.ReservationData;
import model.VehicleDATA;

/**
 * Transfers reservation data between the GUI and the database
 */
public class ReservationController {

	private ReservationDB reservationDB;

	/**
	 * Creates a new ReservationController object, with no arguments
	 * Initialises a ReservationDB object.
	 */
	public ReservationController() {
		reservationDB = new ReservationDB();
	}
	
	
	/**
	 * Makes a call to ReservationDB, to get information about a reservation 
	 * out of the database.
	 * @param reservationNr
	 * @return the reservationData object with the reservation info
	 */
	public ReservationData getReservationFromDB(int reservationNr) {
		ReservationData reservationData = reservationDB.getOneReservation(reservationNr);
		return reservationData;
	}
	
	/**
	 * Makes a call to ReservationDB, to get information about a reservation 
	 * out of the database.
	 * @param vehicleClasses
	 * @param currentMonth
	 * @return the reservationData object with the reservation info
	 * @throws SQLException
	 */
	/*public ReservationData getReservationFromDB(String name, String startdate) {
		ReservationData reservationData = reservationDB.getOneReservation(name, startdate);
		return reservationData;
	}*/
	
	/**
	 * Makes a call to ReservationDB, to get reservations for a specific month 
	 * from the database
	 */
	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		return reservationDB.getReservations(vehicleClasses, currentMonth);
	}
	
	/**
	 * Makes a call to ReservationDB, to save a reservation in the database
	 * @param newReservation
	 * @return the reservation number
	 */
	public int saveReservation(ReservationData newReservation) {
		int resNr = reservationDB.saveReservation(newReservation);	
		return resNr;
	}
	
	/**
	 * Makes a call to ReservationDB, to delete a reservation from the database
	 * @param resnr
	 */
	public void deleteReservation(int resnr) {
		reservationDB.deleteReservation(resnr);		
	}	
}
