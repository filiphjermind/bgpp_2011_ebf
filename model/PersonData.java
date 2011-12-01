package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonData {

	private String firstName;
	private Connection con;
	private Statement dbStatement;
	
	public PersonData() {
	
	}
	
	private void openDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://itu.dk/mysql/ovedatabase", "eeng", "spitfire");
		} catch (SQLException exn) {
			System.out.println("Can't initialize the connection to the database: " + exn);
		} catch (ClassNotFoundException exn) {
			System.out.println("Can't find database driver: " + exn);
			
		}
	}
	
	public String enterFirstName(String name) {
		
		String query = "INSERT INTO Person (firstName) VALUES (\"ellen\")";
		return query;
	}
	
	public void createStatement(Connection con) throws SQLException{
		dbStatement = con.createStatement();
	}
	
	public void inputDB(String query) {
		try {
			boolean ok = dbStatement.execute(query);
		}
		catch (SQLException exn) {
			System.out.println("Can't intput information into Table");
		}
	}
}
