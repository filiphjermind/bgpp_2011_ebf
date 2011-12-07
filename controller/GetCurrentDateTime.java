package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
 
public class GetCurrentDateTime {
  
	
	/**
	 * Returns the current date.
	 * @return String currentDate - the current date.
	 */
	public String getDate()
	{
		DateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		return currentDate.format(date);
	}
	/**
	 * Returns the current year.
	 * @return String year - the current year.
	 */
	public String getYear()
	{
		DateFormat year = new SimpleDateFormat("yyyy");
		Date date = new Date();

		return year.format(date);
	}

	/**
	 * Returns the current month
	 * @return String month - the current month.
	 */
	public String getMonth()
	{
		DateFormat month = new SimpleDateFormat("MM");
		Date date = new Date();

		return month.format(date);
	}

	/**
	 * Returns the current day.
	 * @return String day - the current day.
	 */
	public String getDay()
	{
		DateFormat day = new SimpleDateFormat("dd");
		Date date = new Date();

		return day.format(date);
	}
}