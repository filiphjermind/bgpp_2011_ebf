package model;

import java.sql.*;

/**
 * This class handles the connection to the database.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 28.11.2011
 *
 */
public class DBConnection {
	
	// Connection variable.
	protected Connection dbConnection;
	
	/**
	 * Creates a DBConnection object
	 */
	public DBConnection()
	{
		openDB();
	}
	
	
	/**
	 * Opens the connection to the database.
	 */
	private void openDB()
	{
		try {
			// access data-base driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			// create a connection
			dbConnection = DriverManager.getConnection("jdbc:mysql://mysql.itu.dk/ebfCarRental", "ebf", "bgpp");
		} 
		catch (SQLException exn) {
			System.out.println("Can't initialize the connection to the database: " + exn);
		} 
		catch (ClassNotFoundException exn) {
			System.out.println("Can't find database driver: " + exn);
		}
	}
	
	/**
	 * Sends a query to the database and returns a resultset
	 * @param query
	 * @return the resultSet
	 * @throws SQLException
	 */
	protected ResultSet sendQuery(String query) {
		ResultSet result = null;
		try {
			Statement dbStatement = dbConnection.createStatement();
			boolean ok = dbStatement.execute(query);
			if (ok) {
            result = dbStatement.getResultSet();             
			} // end of if
        } // end of try
		catch (SQLException exn) {
			System.out.println(" " + exn);
		} // end of catch
		return result;
	}

}
