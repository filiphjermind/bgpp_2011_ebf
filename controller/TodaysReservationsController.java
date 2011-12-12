package controller;

import java.sql.ResultSet;

import model.TodaysReservationsDB;

public class TodaysReservationsController {
	TodaysReservationsDB todaysReservations = new TodaysReservationsDB();
	
	public TodaysReservationsController() throws Exception
	{
		
	}
	
	/**
	 * Gets todays reservations from TodaysReservationsData.
	 * 
	 * @return ResultSet result
	 */
	public ResultSet getTodaysReservations() throws Exception
	{
		ResultSet result = todaysReservations.selectReservations();
		
		return result;
	}

}
