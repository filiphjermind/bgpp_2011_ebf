package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.ReservationData;

public class ReservationDB extends DBConnection {

	/**
	 * @param args
	 */
	public ReservationDB() {
		// TODO only for testing
		try {
			GregorianCalendar calendar = new GregorianCalendar(2011, 11, 1);
			List<String> vehicleClasses = new ArrayList<String>();
			vehicleClasses.add("Sportscar");
			vehicleClasses.add("Car 4-door");
			List<VehicleDATA> vehicles = getReservations(vehicleClasses, calendar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method fetches reservation data from the database based on
	 * vehicleClasses and a specific month
	 * 
	 * @parameter vehicleClasses the vehicleClasses which should be fetched from
	 *            the database
	 * 
	 * @parameter currentMonth the month in which the reservations should be
	 * 
	 * @return the list of vehicles. Each vehicle contains a list of
	 *         reservations
	 */
	public List<VehicleDATA> getReservations(List<String> vehicleClasses,
			GregorianCalendar currentMonth) throws SQLException {
		if (vehicleClasses.size() == 0)
			return null;
		// converting date format from GregorianCalendar to sql
		String startMonth = "'" + currentMonth.get(GregorianCalendar.YEAR) + "-"
				+ (currentMonth.get(GregorianCalendar.MONTH) + 1) + "-1'";
		String endMonth = "'" + currentMonth.get(GregorianCalendar.YEAR) + "-"
				+ (currentMonth.get(GregorianCalendar.MONTH) + 1) + "-"
				+ currentMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) + "'";
		// converting vehicleClass list to a sql statement that specifies which
		// vehicles should be fetched
		String vehicleClassConditions = "(";
		for (int i = 0; i < vehicleClasses.size(); i++) {
			vehicleClassConditions += "VehicleClass.vehicleClass = '" + vehicleClasses.get(i) + "'";
			if (i != vehicleClasses.size() - 1) {
				vehicleClassConditions += " OR ";
			} else {
				vehicleClassConditions += ")";

			}
		}
		ResultSet resultSet = sendQuery("SELECT Vehicle.licensePlate, VehicleClass.vehicleClass, Reservation.startDate, Reservation.endDate, Reservation.id "
				+ "FROM Reservation, Vehicle, VehicleClass "
				+ "WHERE Reservation.vehicle = Vehicle.licensePlate "
				+ "AND Vehicle.vehicleClass = VehicleClass.vehicleClass "
				+ "AND Reservation.endDate >= "
				+ startMonth
				+ " AND"
				+ " Reservation.startDate <= "
				+ endMonth
				+ " AND "
				+ vehicleClassConditions
				+ "ORDER BY Vehicle.licensePlate");
		// checks if the resultSet is empty
		if (!resultSet.isBeforeFirst())
			return null;
		List<VehicleDATA> vehicles = new ArrayList<VehicleDATA>();
		String vehicleClass = "";
		String licensePlate = "";
		List<ReservationData> reservationDatas = null;
		while (resultSet.next()) {
			if (!licensePlate.equals(resultSet.getString("licensePlate"))) {
				licensePlate = resultSet.getString("licensePlate");
				reservationDatas = new ArrayList<ReservationData>();
				vehicleClass = resultSet.getString("vehicleClass");
				VehicleDATA vehicleData = new VehicleDATA(vehicleClass, licensePlate,
						reservationDatas);
				vehicles.add(vehicleData);
			}
			Date startDate = resultSet.getDate("startDate", new GregorianCalendar());
			GregorianCalendar calendarStart = new GregorianCalendar();
			calendarStart.setTime(startDate);
			Date endDate = resultSet.getDate("endDate", new GregorianCalendar());
			GregorianCalendar calendarEnd = new GregorianCalendar();
			calendarEnd.setTime(endDate);
			int reservationID = resultSet.getInt("id");
			ReservationData reservationData = new ReservationData(calendarStart, calendarEnd,
					false, reservationID);
			reservationDatas.add(reservationData);
		}
		return vehicles;
	}

	public ReservationData getOneReservation(int reservationNr) {
		// create a ReservationData object to store all the information in
		ReservationData reservationData = new ReservationData();

		// get the details of the reservation
		ResultSet reservationResult = sendQuery("SELECT * FROM Reservation WHERE ID = '"
				+ reservationNr + "'");

		// retrieve it from the resultset and store it in a ReservationData
		// object
		try {
			while (reservationResult.next()) {
				reservationData.setReservationID(reservationResult.getInt("ID"));
				reservationData.setPersonID(reservationResult.getInt("person"));

				// convert from sql.Date to GregorianCalender
				Date sdate = reservationResult.getDate("startDate");
				GregorianCalendar gCal1 = new GregorianCalendar();
				gCal1.setTime(sdate);
				reservationData.setStartDateGreg(gCal1);

				// convert from sql.Date to GregorianCalender
				Date edate = reservationResult.getDate("endDate");
				GregorianCalendar gCal2 = new GregorianCalendar();
				gCal2.setTime(edate);
				reservationData.setEndDateGreg(gCal2);

				reservationData.setVehicle(reservationResult.getString("vehicle"));
				reservationData.setPickedUp(reservationResult.getInt("pickedUp"));
				reservationData.setReturned(reservationResult.getInt("returned"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reservationData.setBeingServiced(false); // because it isn't a service
													// reservation

		// get vehicle class
		String vehicle = reservationData.getVehicle();
		ResultSet vehicleResult = sendQuery("SELECT vehicleClass FROM Vehicle WHERE licensePlate = '"
				+ vehicle + "'");

		// retrieve it from the resultset and store it in a ReservationData
		// object
		try {
			while (vehicleResult.next()) {
				reservationData.setVehicleClass(vehicleResult.getString("vehicleClass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get the price pr day
		String vClass = reservationData.getVehicleClass();
		ResultSet vehicleClassResult = sendQuery("SELECT price FROM VehicleClass WHERE vehicleClass = '"
				+ vClass + "'");

		// retrieve it from the resultset and store it in a ReservationData
		// object
		try {
			while (vehicleClassResult.next()) {
				// convert String to int
				int ppd = Integer.parseInt(vehicleClassResult.getString("price"));
				reservationData.setVehiclePricePerDay(ppd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get details about the person
		int personId = reservationData.getPersonID();
		ResultSet personResult = sendQuery("SELECT * FROM Person WHERE ID = '" + personId + "'");

		// retrieve it from the resultset and store it in a ReservationData
		// object
		try {
			while (personResult.next()) {
				reservationData.setFirstName(personResult.getString("firstName"));
				reservationData.setLastName(personResult.getString("lastName"));
				reservationData.setDriversLicence(personResult.getString("driversLicence"));
				reservationData.setPhone(personResult.getString("phone"));
				reservationData.setEmail(personResult.getString("email"));
				reservationData.setAdress(personResult.getString("adress"));
				reservationData.setCreditCardType(personResult.getString("creditCardType"));
				reservationData.setCreditCardNr(personResult.getString("creditCardNr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservationData;
	}

	/*
	 * public ReservationData getOneReservation(String name, String startdate)
	 * {}
	 */

	public int saveReservation(ReservationData newReservation) {

		// extract data for the Person Table
		String firstName = newReservation.getFirstName();
		String lastName = newReservation.getLastName();
		String phone = newReservation.getPhone();
		String email = newReservation.getEmail();
		String adress = newReservation.getAdress();
		String driversLicence = newReservation.getDriversLicence();
		String creditCardType = newReservation.getCreditCardType();
		String creditCardNr = newReservation.getCreditCardNr();

		// send firstName, LastName, phone, email, adress, driversLicence,
		// creditCardType, and creditCardNr to PersonTable, get ID returned
		sendData("INSERT INTO Person(firstName, LastName, phone, email, adress, driversLicence, creditCardType, creditCardNr) VALUES ('"
				+ firstName
				+ "', '"
				+ lastName
				+ "','"
				+ phone
				+ "','"
				+ email
				+ "', '"
				+ adress
				+ "', '" + driversLicence + "', '" + creditCardType + "', '" + creditCardNr + "')");
		ResultSet result1 = sendQuery("SELECT ID FROM Person WHERE driversLicence = '"
				+ driversLicence + "'");

		int personId = -1;
		try {
			while (result1.next()) {
				personId = result1.getInt("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// extract and convert data for the Reservation Table
		int person;
		if (personId > 0)
			person = personId;
		else
			person = -1;

		// convert GregorianCalendar to sql.Date
		Calendar sDate = newReservation.getStartDateGreg();
		java.sql.Date startDate = new java.sql.Date(sDate.getTimeInMillis());
		Calendar eDate = newReservation.getEndDateGreg();
		java.sql.Date endDate = new java.sql.Date(eDate.getTimeInMillis());

		String vehicle = newReservation.getVehicle();

		// convert boolean to int
		int pickedUp;
		if (newReservation.isPickedUp() == true)
			pickedUp = 1;
		else
			pickedUp = 0;
		int returned;
		if (newReservation.isReturned() == true)
			returned = 1;
		else
			returned = 0;

		// send person, startDate, endDate, vehicle, pickedUp, and returned to
		// Reservation Table, get reservationNr returned
		sendData("INSERT INTO Reservation(person, startDate, endDate, vehicle, pickedUp, returned) VALUES('"
				+ personId
				+ "', '"
				+ startDate
				+ "', '"
				+ endDate
				+ "', '"
				+ vehicle
				+ "', '"
				+ pickedUp + "', '" + returned + "')");

		ResultSet result2 = sendQuery("SELECT * FROM Reservation WHERE person = '" + personId
				+ "' AND startDate = '" + startDate + "'");
		int resId = -1;
		try {
			while (result2.next()) {
				resId = result2.getInt("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resId;
	}

	public void deleteReservation(int resnr) {
		sendData("DELETE FROM Reservation WHERE ID ='" + resnr + "'");
	}

}
