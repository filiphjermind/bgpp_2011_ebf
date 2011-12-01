package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JCheckBox;

import view.homeGui.ReservationData;
import view.homeGui.VehicleData;





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
	private Connection con;
	
	
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
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:8888/CarRental", "root", "root");
		} catch (SQLException exn) {
			System.out.println("Can't initialize the connection to the database: " + exn);
		} catch (ClassNotFoundException exn) {
			System.out.println("Can't find database driver: " + exn);
		}
	}
	
	public List<VehicleData> getReservations(List<JCheckBox> sellectedCheckBoxes, GregorianCalendar currentMonth) {
		List<VehicleData> vehicles = new ArrayList<VehicleData>();
		ArrayList<ReservationData> reservations = new ArrayList<ReservationData>();
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 1), new GregorianCalendar(2011, 10, 3), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 5), new GregorianCalendar(2011, 10, 7), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 10), new GregorianCalendar(2011, 10, 11), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 20), new GregorianCalendar(2011, 10, 30), false));
		vehicles.add(new VehicleData(1, "van", reservations));
		reservations = new ArrayList<ReservationData>();
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 2), new GregorianCalendar(2011, 10, 7), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 7), new GregorianCalendar(2011, 10, 10), false));
		reservations.add(new ReservationData(new GregorianCalendar(2011, 10, 11), new GregorianCalendar(2011, 10, 23), false));
		vehicles.add(new VehicleData(1, "segway", reservations));
		return vehicles;
	}
}
