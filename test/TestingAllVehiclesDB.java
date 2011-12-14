package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.AllVehiclesDB;

public class TestingAllVehiclesDB {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testingGetAllVehicles() {
		AllVehiclesDB avdb = new AllVehiclesDB();
		try {
			ResultSet result = avdb.getAllVehicles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals();
	}

}
