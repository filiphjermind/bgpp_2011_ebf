package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.GetCurrentDateTime;


public class TodaysReturnsData extends DBConnection
{
	GetCurrentDateTime date = new GetCurrentDateTime();
	String currentDate = date.getDate();
	
	// Query: Selects all from the Reservation table.
	/*private String query = "SELECT Reservation.id, Person.firstName, Person.lastName, Reservation.vehicle, " +
							"VehicleClass.vehicleClass, Reservation.pickedUp, Reservation.returned, Reservation.endDate " +
							"FROM Person, Reservation, VehicleClass WHERE Reservation.endDate = '" + currentDate + "'";*/
	
	private String query = "SELECT Reservation.ID, Person.firstName, Person.lastName, Reservation.vehicle, " +
							"Vehicle.vehicleClass, Reservation.pickedUp, Reservation.Returned, " +
							"Reservation.person, Person.ID, Vehicle.licensePlate, Reservation.endDate " +
							"FROM Reservation, Person, Vehicle " +
							"WHERE Reservation.person = Person.ID AND Reservation.vehicle = Vehicle.licensePlate " +
							"AND Reservation.endDate = '" + currentDate + "'";
	
	public TodaysReturnsData() throws Exception
	{
		
	}
	
	/**
	 * Selects from the database using the query.
	 * 
	 * @return ResultSet result.
	 */
	public ResultSet selectReservations()
	{
		try {
			// Create the query.
			PreparedStatement statement = dbConnection.prepareStatement(query);
			
			// Execute the query.
			ResultSet result = statement.executeQuery();
			
			// Return the ResultSet.
			return result;
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

}
