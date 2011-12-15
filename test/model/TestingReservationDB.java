package test.model;

import static org.junit.Assert.*;

import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import model.DBConnection;
import model.ReservationDB;
import model.ReservationData;
import model.VehicleDATA;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.org.mozilla.javascript.internal.Undefined;

public class TestingReservationDB {

	private static ReservationDB reservationDB;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reservationDB = new ReservationDB();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DBConnection.close();
	}

	/**
	 * This method is taking care of testing whether it is possible to save a reservation, get the same reservation 
	 * and delete it again.
	 */
	@Test
	public void test() {
		try {
			int reservationID = 0;
			GregorianCalendar startDate = new GregorianCalendar(1990, 0, 1);
			GregorianCalendar endDate = new GregorianCalendar(1990, 0, 5);
			reservationID = testSaveReservation(startDate, endDate);
			testGetReservations(startDate, endDate, reservationID);
			testDeleteReservation(reservationID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is responsible of testing if it is posible to save a reservation. The method
	 * prepares a reservationData object and calls the saveReservation method in ReservationDB.
	 * If the method doesn't return -1 we asume that the operation went well.
	 * @param startDate the startDate of the reservation
	 * @param endDate the endDate of the reservation
	 * @return the reservation number
	 */
	private int testSaveReservation(GregorianCalendar startDate, GregorianCalendar endDate) {
		ReservationData newReservation = new ReservationData();
		newReservation.setAdress("H.C. Andersens Boulevard");
		newReservation.setCreditCardNr("3434343");
		newReservation.setCreditCardType("visa");
		newReservation.setDriversLicence("3434343434");
		newReservation.setEmail("larsjensen@gmail.com");
		newReservation.setStartDateGreg(startDate);
		newReservation.setEndDateGreg(endDate);
		newReservation.setFirstName("Lars");
		newReservation.setLastName("Jensen");
		newReservation.setPhone("34343434");
		newReservation.setPickedUp(false);
		newReservation.setReturned(false);
		newReservation.setVehicle("TL 900 72");
		newReservation.setVehicleClass("Van");
		newReservation.setVehiclePricePerDay(300);
		int reservationID = reservationDB.saveReservation(newReservation);
		assertNotSame(-1, reservationID);
		return reservationID;
	}

	/**
	 * This method is responsible of testing if the getReservations method works. We assume that it
	 * works if it returns a valid array and that we can find the reservation which we just saved.
	 * @param startDate the startDate of the reservation
	 * @param endDate the endDate of the reservation
	 * @param reservationID the reservationID of the reservation
	 */
	private void testGetReservations(GregorianCalendar startDate, GregorianCalendar endDate, int reservationID) {
		List<VehicleDATA> vehicleDatas = null;
		try {
			List<String> vehicleClasses = new ArrayList<String>();
			vehicleClasses.add("Van");
			GregorianCalendar currentMonth = new GregorianCalendar(1990, 0, 1);
			vehicleDatas = reservationDB.getReservations(vehicleClasses, currentMonth);
			assertNotNull(vehicleDatas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ReservationData reservationData = getSpecificReservation(vehicleDatas, reservationID);
		assertEquals(startDate.getTimeInMillis(), reservationData.getStartDateGreg().getTimeInMillis());
		assertEquals(endDate.getTimeInMillis(), reservationData.getEndDateGreg().getTimeInMillis());
	}

	/**
	 * This method is responsible to test if it is possible to delete a specific reservation. If we
	 * delete the reservation and we afterward can't find find the reservation by calling getReservations
	 * we assume that the reservation have been deleted
	 * 
	 * @param reservationID
	 */
	private void testDeleteReservation(int reservationID) {
		try {
			reservationDB.deleteReservation(reservationID);
			List<String> vehicleClasses = new ArrayList<String>();
			vehicleClasses.add("Van");
			GregorianCalendar currentMonth = new GregorianCalendar(1990, 0, 1);
			List<VehicleDATA> vehicleDatas = reservationDB.getReservations(vehicleClasses, currentMonth);
			if (vehicleDatas == null) {
				// we assume that the reservation have been deleted since the
				// return value is null
				return;
			}
			ReservationData reservationData = getSpecificReservation(vehicleDatas, reservationID);
			assertNull(reservationData);
			System.out.println("TestingReservationDB.testDeleteReservation()" + reservationData);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Helping method to return a specific reservation based on the parameters.
	 * @param vehicleDatas The vehicleDatas list which contains all the reservations
	 * @param reservationID The id for the reservation you wish to get returned
	 * @return
	 */
	private ReservationData getSpecificReservation(List<VehicleDATA> vehicleDatas, int reservationID) {
		ReservationData result = null;
		for (VehicleDATA vehicleDATA : vehicleDatas) {
			List<ReservationData> reservationDatas = vehicleDATA.getReservations();
			for (ReservationData reservationData : reservationDatas) {
				if (reservationData.getReservationID() == reservationID) {
					result = reservationData;
				}
			}
		}
		return result;

	}

}
