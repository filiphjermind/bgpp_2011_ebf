package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JCheckBox;

import view.homeGUI.ReservationData;
import view.homeGUI.VehicleData;


import java.sql.*;

/**
 * This class handles the connection to the database.
 * 
 * @author Bergar Simonsen - bsim@itu.dk
 * @version 28.11.2011
 *
 */
public class DBConnection
{
	// Connection variable.
	private Connection dbConnection;
	
	/**
	 * 
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
	
	private ResultSet sendQuery(String query) throws SQLException {
		openDB();
		Statement dbStatement = dbConnection.createStatement();
		ResultSet result = null;
		try {
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
