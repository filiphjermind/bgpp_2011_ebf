package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.GetCurrentDateTime;

public class TodaysReservationsDB extends DBConnection {
	
	GetCurrentDateTime date = new GetCurrentDateTime();
	String currentDate = date.getDate();
	
	// Query: Selects all from reservations.
	/*private String query = "SELECT Reservation.id, Person.firstName, Person.lastName, Reservation.vehicle, " +
							"VehicleClass.vehicleClass, Reservation.pickedUp, Reservation.returned, Reservation.startDate " +
							"FROM Person, Reservation, VehicleClass WHERE Reservation.startDate = '" + currentDate + "'";*/
	
	private String query = "SELECT Reservation.ID, Person.firstName, Person.lastName, Reservation.vehicle, " +
							"Vehicle.vehicleClass, Reservation.pickedUp, Reservation.Returned, " +
							"Reservation.person, Person.ID, Vehicle.licensePlate, Reservation.startDate " +
							"FROM Reservation, Person, Vehicle " +
							"WHERE Reservation.person = Person.ID AND Reservation.vehicle = Vehicle.licensePlate " +
							"AND Reservation.startDate = '" + currentDate + "'";
	
	public TodaysReservationsDB() throws Exception
	{
		
	}
	
	/**
	 * Selects from the database using the query.
	 * 
	 * @return ResultSet selection
	 */
	public ResultSet selectReservations()
	{
		// get a resultset
		ResultSet result = sendQuery(query);
				
		// return the resultset
		return result;
	}
}
