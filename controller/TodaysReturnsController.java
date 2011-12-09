package controller;

import java.sql.ResultSet;

import model.TodaysReturnsDB;

public class TodaysReturnsController {
	TodaysReturnsDB todaysReturns = new TodaysReturnsDB();
	
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
