package model;

import java.sql.ResultSet;
import java.sql.*;


public class TodaysReturnsData extends DBConnection
{
	// Query: Selects all from the Reservation table.
	private String query = "SELECT Reservation.id, Person.firstName, Person.lastName, Reservation.vehicle, " +
							"VehicleClass.description, Reservation.pickedUp, Reservation.returned FROM Person, " +
							"Reservation, VehicleClass";
	
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
