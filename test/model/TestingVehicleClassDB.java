package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.DBConnection;
import model.VehicleClassDB;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingVehicleClassDB {

	private static VehicleClassDB vehicleClassDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		vehicleClassDB = new VehicleClassDB();
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
	 * This method checks if the method getVehicleClassListAsArray returns all 9 different 
	 * vehicle classes.
	 */
	@Test
	public void test() {
		try {
			ArrayList<String> vehicleClasses = vehicleClassDB.getVehicleClassListAsArrayList();
			assertEquals(9, vehicleClasses.size());
		} catch (Exception e) {
		}
	}

}
