package controller;

import java.sql.ResultSet;

import model.TodaysReturnsData;

public class TodaysReturnsController {
	TodaysReturnsData todaysReturns = new TodaysReturnsData();
	
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
