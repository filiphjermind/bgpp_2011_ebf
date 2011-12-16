package test.model;

import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.util.GregorianCalendar;

import model.ReservationDB;
import model.ReservationData;
import model.TodaysReturnsDB;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingTodaysReturns {

	private static TodaysReturnsDB todaysReturnsDB;
	private static ReservationDB reservationDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		todaysReturnsDB = new TodaysReturnsDB();
		reservationDB = new ReservationDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This method tests if a reservation to be returned today can be fetched by the method selectReservations.
	 * To be sure that the database contains a reservation that ends today the method creates one.
	 * The method also deletes the reservation created to keep the database clean.
	 */
	@Test
	public void test() {
		try {
			//to ensure that there is a reservation that ends today
			int reservationID = createReservation();
			ResultSet resultSet = todaysReturnsDB.selectReservations();
			//to check if the resultset contains any rows
			assertTrue(resultSet.isBeforeFirst());
			//delete reservation to clean up
			deleteReservation(reservationID);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteReservation(int reservationID) {
		reservationDB.deleteReservation(reservationID);
	}

	private int createReservation() {
		GregorianCalendar startDate = new GregorianCalendar();
		startDate.add(GregorianCalendar.DAY_OF_MONTH, -4);
		GregorianCalendar endDate = new GregorianCalendar();
		ReservationData newReservation = new ReservationData();
		newReservation.setStartDateGreg(startDate);
		newReservation.setEndDateGreg(endDate);
		newReservation.setVehicle("TL 900 72");
		
		return reservationDB.saveReservation(newReservation);
	}

}
