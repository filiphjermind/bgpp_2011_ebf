package model;

import java.sql.ResultSet;

import controller.GetCurrentDateTime;

/**
 *	This class i responsible of sending the right query for todays returns to the database 
 *
 */
public class TodaysReturnsDB extends DBConnection
{
	GetCurrentDateTime date = new GetCurrentDateTime();
	String currentDate = date.getDate();
	
	private String query = "SELECT Reservation.ID, Person.firstName, Person.lastName, Reservation.vehicle, " +
							"Vehicle.vehicleClass, Reservation.pickedUp, Reservation.Returned, " +
							"Reservation.person, Person.ID, Vehicle.licensePlate, Reservation.endDate " +
							"FROM Reservation, Person, Vehicle " +
							"WHERE Reservation.person = Person.ID AND Reservation.vehicle = Vehicle.licensePlate " +
							"AND Reservation.endDate = '" + currentDate + "'";
	
	/**
	 * Selects from the database using the query.
	 * 
	 * @return ResultSet result.
	 */
	public ResultSet selectReservations()
	{
		// get a resultset
		ResultSet result = sendQuery(query);
						
		// return the resultset
		return result;
	}

}
