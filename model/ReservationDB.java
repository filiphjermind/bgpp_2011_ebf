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
			GregorianCalendar calendar = new GregorianCalendar(2011,11,1);
			getReservations(null, calendar);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<VehicleDATA> getReservations(List<String> vehicleClasses, GregorianCalendar currentMonth) throws SQLException {
		ResultSet resultSet = sendQuery("SELECT description, startDate, endDate FROM Reservation, Vehicle, VehicleClass " +
				"WHERE Reservation.vehicle = Vehicle.id AND Vehicle.vehicleType = VehicleClass.id");
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
