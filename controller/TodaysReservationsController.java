package controller;

import java.sql.ResultSet;

import model.TodaysReservationsData;

public class TodaysReservationsController {
	TodaysReservationsData todaysReservations = new TodaysReservationsData();
	
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
