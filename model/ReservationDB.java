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
			System.out.println("ReservationDB.ReservationDB()" + vehicles.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnection.close();
	}

	/*
	 * This method fetch reservation data from the database based on
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
		// converting date format from GregorianCalendar to sql
		String startMonth = "'" + currentMonth.get(GregorianCalendar.YEAR) + "-" + (currentMonth.get(GregorianCalendar.MONTH) + 1) + "-1'";
		String endMonth = "'" + currentMonth.get(GregorianCalendar.YEAR) + "-" + (currentMonth.get(GregorianCalendar.MONTH) + 1) + "-" + currentMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)
				+ "'";
		// converting vehicleClass list to a sql statement that specifies which
		// vehicles should be fetched
		String vehicleClassConditions = "(";
		for (int i = 0; i < vehicleClasses.size(); i++) {
			vehicleClassConditions += "VehicleClass.description = '" + vehicleClasses.get(i) + "'";
			if (i != vehicleClasses.size() - 1) {
				vehicleClassConditions += " OR ";
			} else {
				vehicleClassConditions += ")";

			}
		}
		ResultSet resultSet = sendQuery("SELECT description, startDate, endDate FROM Reservation, Vehicle, VehicleClass "
				+ "WHERE Reservation.vehicle = Vehicle.id AND Vehicle.id = VehicleClass.id AND Reservation.endDate >= " + startMonth + " AND" + " Reservation.startDate <= " + endMonth + " AND "
				+ vehicleClassConditions);
		List<VehicleDATA> vehicles = new ArrayList<VehicleDATA>();
		String description = "";
		List<ReservationData> reservationDatas = null;
		while (resultSet.next()) {
			if (!description.equals(resultSet.getString("description"))) {
				description = resultSet.getString("description");
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
			ReservationData reservationData = new ReservationData(calendarEnd, calendarStart, false);
			reservationDatas.add(reservationData);
		}
		return vehicles;
	}

	public static void main(String[] args) {
		new ReservationDB();
	}

}
