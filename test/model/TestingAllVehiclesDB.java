package test.model;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import model.AllVehiclesDB;
import model.DBConnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingAllVehiclesDB {

	private static AllVehiclesDB allVehiclesDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		allVehiclesDB = new AllVehiclesDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DBConnection.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This method is taking care of testing getAllVehicles and getSelectedVehicles
	 */
	@Test
	public void test() {
		testGetAllVehicles();
		testGetSelectedVehicles();
	}

	/**
	 * This method is testing if getSelectedVehicles will return the right number of vehicles.
	 * We know that the database contains two vehicles of class "Van". So if the loop runs
	 * two times then we assume that the method we are testing works.
	 */
	private void testGetSelectedVehicles() {
		try {
			Object[] licenseNumbers = allVehiclesDB.getSelectedVehicles("Van");
			assertEquals(2,licenseNumbers.length);
		} catch (Exception e) {
		}
	}

	/**
	 * This method is testing i getAllVehicles will return all the vehicles. We know
	 * that there is 10 vehicles in the database, so if the resultSet contains 10
	 * vehicles we assume that the method works as intended.
	 */
	private void testGetAllVehicles() {
		try {
			ResultSet resultSet = allVehiclesDB.getAllVehicles();
			int i = 0;
			while (resultSet.next()) {
				i++;
			}
			assertEquals(10, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
