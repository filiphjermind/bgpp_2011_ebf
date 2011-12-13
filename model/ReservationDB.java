package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	 * the database
	 * 
	 * @parameter currentMonth the month in which the reservations should be
	 * 
	 * @return the list of vehicles. Each vehicle contains a list of
	 * reservations
	 */
	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		if(vehicleClasses.size()==0)return null;
		// converting date format from GregorianCalendar to sql
		String startMonth = "'" + currentMonth.get(GregorianCalendar.YEAR) + "-" + (currentMonth.get(GregorianCalendar.MONTH) + 1) + "-1'";
		String endMonth = "'" + currentMonth.get(GregorianCalendar.YEAR) + "-" + (currentMonth.get(GregorianCalendar.MONTH) + 1) + "-" + currentMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)
				+ "'";
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
		ResultSet resultSet = sendQuery("SELECT VehicleClass.vehicleClass, startDate, Reservation.id, endDate FROM Reservation, Vehicle, VehicleClass "
				+ "WHERE Reservation.vehicle = Vehicle.licensePlate AND Vehicle.vehicleClass = VehicleClass.vehicleClass AND Reservation.endDate >= " + startMonth + " AND" + " Reservation.startDate <= " + endMonth + " AND "
				+ vehicleClassConditions);
		//checks if the resultSet is empty
		if(!resultSet.isBeforeFirst()) return null;
		List<VehicleDATA> vehicles = new ArrayList<VehicleDATA>();
		String description = "";
		List<ReservationData> reservationDatas = null;
		while (resultSet.next()) {
			if (!description.equals(resultSet.getString("vehicleClass"))) {
				description = resultSet.getString("vehicleClass");
				reservationDatas = new ArrayList<ReservationData>();
				VehicleDATA vehicleData = new VehicleDATA(description, reservationDatas);
				vehicles.add(vehicleData);
			}
			Date startDate = resultSet.getDate("startDate", new GregorianCalendar());
			GregorianCalendar calendarStart = new GregorianCalendar();
			calendarStart.setTime(startDate);
			Date endDate = resultSet.getDate("endDate", new GregorianCalendar());
			GregorianCalendar calendarEnd = new GregorianCalendar();
			calendarEnd.setTime(endDate);
			int reservationID = resultSet.getInt("id");
			ReservationData reservationData = new ReservationData(calendarStart,calendarEnd, false,reservationID);
			reservationDatas.add(reservationData);
		}
		return vehicles;
	}
	
	
	
	public ReservationData getOneReservation(int reservationNr) {
		// create a ReservationData object to store all the information in
		ReservationData reservationData = new ReservationData();
		
		// get the details of the reservation
		ResultSet reservationResult = sendQuery("SELECT * FROM Reservation WHERE ID = '" + reservationNr + "'");
				
		//retrieve it from the resultset and store it in a ReservationData object
		try {
			while(reservationResult.next()) {
				reservationData.setId(reservationResult.getInt("ID"));
				reservationData.setPersonID(reservationResult.getInt("person"));
				// convert to gregorianCalender
				Date sdate = reservationResult.getDate("startDate");
				GregorianCalendar gCal1 = (GregorianCalendar) GregorianCalendar.getInstance();
				gCal1.setTime(sdate);				
				reservationData.setStartDateGreg(gCal1);
				// convert to gregorianCalender
				Date edate = reservationResult.getDate("endDate");
				GregorianCalendar gCal2 = (GregorianCalendar) GregorianCalendar.getInstance();
				gCal2.setTime(edate);				
				reservationData.setStartDateGreg(gCal2);				
				reservationData.setVehicle(reservationResult.getString("vehicle")); 
				reservationData.setPickedUP(reservationResult.getInt("pickedUp")); 
				reservationData.setReturned(reservationResult.getInt("returned")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reservationData.setBeingServiced(false); // because it isn't a service reservation
		
		// get vehicle class
		String vehicle = reservationData.getVehicle();
		ResultSet vehicleResult = sendQuery("SELECT vehicleClass FROM Vehicle WHERE licensePlate = '" + vehicle + "'");
		
		//retrieve it from the resultset and store it in a ReservationData object
		try {
			while(vehicleResult.next()) {
				reservationData.setVehicleClass(vehicleResult.getString("vehicleClass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// get the price pr day
		String vClass = reservationData.getVehicleClass();
		ResultSet vehicleClassResult = sendQuery("SELECT price FROM VehicleClass WHERE vehicleClass = '" + vClass + "'");
		
		//retrieve it from the resultset and store it in a ReservationData object
		try {
			while(vehicleClassResult.next()) {
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
		
		//retrieve it from the resultset and store it in a ReservationData object
		try {
			while(personResult.next()) {
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
	
	/*public ReservationData getOneReservation(String name, String startdate) {
		// get person object first
		ResultSet resultP = sendQuery("SELECT * FROM Person WHERE lastName = name");
		
		//retrieve it from the resultset and store it in a PersonDATA object
		PersonDATA personData = new PersonDATA();
		try {
			while(resultP.next()) {
				personData.setId(resultP.getInt("ID"));
				personData.setFirstName(resultP.getString("firstName"));
				personData.setLastName(resultP.getString("lastName"));
				personData.setPhone(resultP.getString("phone"));
				personData.setEmail(resultP.getString("email"));
				personData.setAddress(resultP.getString("adress"));
				personData.setDriversLicence(resultP.getString("driversLicence "));
				personData.setCreditCardType(resultP.getString("creditCardType"));
				personData.setCreditCardNr(resultP.getString("creditCardNr"));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// use the personId to search for the reservation
		int personId = personData.getId();
		// get the details of the reservation
		ResultSet result = sendQuery("SELECT * FROM Reservation WHERE person = personId AND startDate = startdate");
				
		//retrieve it from the resultset and store it in a ReservationDATA object
		ReservationData reservationData = new ReservationData();
		try {
			while(result.next()) {
				reservationData.setId(result.getInt("ID"));
				//reservationData.setPerson(result.getString("person")); // need all the info
				//reservationData.setStartDateGreg(result.getDate("startDate", new GregorianCalendar()));
				//reservationData.setEndDate(result.getDate("endDate"));
				//reservationData.setVehicle(result.getString("vehicle")); // only need the license plate
				//reservationData.setPickedUp(result.getInt("pickedUp")); // if 0 true, if 1 false or whatever
				//reservationData.setReturned(result.getInt("returned")); // if 0 true, if 1 false or whatever
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// how to store Person and Vehicle information?
		return reservationData;
	}*/
	
}
