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
}
