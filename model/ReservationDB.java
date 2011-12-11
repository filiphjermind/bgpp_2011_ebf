package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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

	/*
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
		ResultSet resultSet = sendQuery("SELECT VehicleClass.vehicleClass, startDate, endDate FROM Reservation, Vehicle, VehicleClass "
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
			ReservationData reservationData = new ReservationData(calendarStart,calendarEnd, false);
			reservationDatas.add(reservationData);
		}
		return vehicles;
	}
	
	/*
	public ReservationData getOneReservation(int reservationNr) {
		// get the details of the reservation
		ResultSet result = sendQuery("SELECT * Reservation WHERE ID = reservationNr");
				
		//retrieve it from the resultset and store it in a ReservationDATA object
		ReservationData reservationData = new ReservationData();
		try {
			while(result.next()) {
				reservationData.setID(result.getInt("ID"));
				//reservationData.setPerson(result.getString("person")); // need all the info
				reservationData.setStartDate(result.getDate("startDate"));
				reservationData.setEndDate(result.getDate("endDate"));
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
