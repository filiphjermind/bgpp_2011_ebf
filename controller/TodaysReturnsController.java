package controller;

import java.sql.ResultSet;

import model.TodaysReturnsDB;

/**
 * Transfers data between the GUI and the database, for use in the TodaysReturns tab
 */
public class TodaysReturnsController {
	TodaysReturnsDB todaysReturns = new TodaysReturnsDB();
	
	/**
	 * TodaysReturnsController constructor
	 * @throws Exception
	 */
	public TodaysReturnsController() throws Exception
	{
		
	}
	
	/**
	 * Gets todays returns from TodaysReturnsData.
	 * 
	 * @return ResultSet result.
	 */
	public ResultSet getTodaysReturns() throws Exception
	{
		ResultSet result = todaysReturns.selectReservations();
		
		return result;
	}
}
