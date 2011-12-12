package test;

import static org.junit.Assert.*;

import model.SpecificVehicleDB;
import model.VehicleDATA;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingSpecificVehicleDB {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testingGetVehicle() {
		SpecificVehicleDB svdb = new SpecificVehicleDB();
		VehicleDATA vehicleData = svdb.getVehicle("DK 39 452");
		assertEquals("Porche", vehicleData.getMake());
	}

}
