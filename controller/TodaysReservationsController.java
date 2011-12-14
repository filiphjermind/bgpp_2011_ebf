package controller;

import java.sql.ResultSet;

import model.TodaysReservationsDB;

/**
 * Transfers data between the GUI and the database, for use in the TodaysReservations tab
 */
public class TodaysReservationsController {
	TodaysReservationsDB todaysReservations = new TodaysReservationsDB();
	
	/**
	 * TodaysReservationsController constructor
	 * @throws Exception
	 */
	public TodaysReservationsController() throws Exception	{
		
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
