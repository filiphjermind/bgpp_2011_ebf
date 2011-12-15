package test.model;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import model.DBConnection;
import model.SpecificVehicleDB;
import model.VehicleDATA;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingSpecificVehicleDB {

	private static SpecificVehicleDB specificVehicleDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		specificVehicleDB = new SpecificVehicleDB();
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

	@Test
	public void test() {
		testGetVehicle();
		testVehicleService();
		testAddService();
	}

	/**
	 * There is no implementation of this method because there is no way you can delete a 
	 * service visit and we don't wont to add to the database every time we run the tests
	 */
	private void testAddService() {
		
	}

	/**
	 * This method is responsible of testing if the method vehicleService works. The method
	 * being tested gets a parameter consisting of a licensePlate string and it is checked
	 * that the resultset contains minimum one row.
	 * 
	 */
	private void testVehicleService() {
		try {
			String licensePlate = "TL 900 72";
			ResultSet resultSet = specificVehicleDB.vehicleService(licensePlate);
			assertTrue(resultSet.isBeforeFirst());
		} catch (Exception e) {
		}
	}

	/**
	 * This method is taking care of testing getVehicle by calling the method with a specific licensplate number
	 * and checking that the vehicleData object being returned contains the same number.
	 */
	private void testGetVehicle() {
		try {
			String licensePlate = "TL 900 72";
			VehicleDATA vehicleData = specificVehicleDB.getVehicle(licensePlate);
			System.out.println("TestingSpecificVehicleDB.testGetVehicle()"+vehicleData.getModel());
			assertTrue(licensePlate.equals(vehicleData.getLicenseplate()));
		} catch (Exception e) {
		}
	}

}
