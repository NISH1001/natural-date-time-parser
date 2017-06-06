package com.codingparadox.core.datetime;

import org.joda.time.DateTime;

/**
 * It is the core engine that provides date and time values
 * based on :
 * 	year, month, week, day, hour, minute, second
 * 
 */
public class DateTimeEngine {

	/**
	 * Get the absolute date time based on following params
	 * 
	 * @param year
	 * @param monthOfYear
	 * @param dayOfMonth
	 * @param hourOfDay
	 * @param minuteOfHour
	 * @param secondOfMinute
	 * @return
	 * 		DateTime object
	 */
	public DateTime getDateTime(int year, 
			int monthOfYear, 
			int dayOfMonth, 
			int hourOfDay, 
			int minuteOfHour, 
			int secondOfMinute) {
		return new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute, 0);
	}
	
	/**
	 * Used for returning the DateTime some year ago from current datetime
	 * 
	 * @param yearDifference
	 * 		Difference of year (how many years ago?)
	 * @return
	 * 		Return the past datetime after subtracting from current time
	 */
	public DateTime getYearsBefore(int yearDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.minusYears(yearDifference);
		return now;
	}
	
	/**
	 * Get datetime before some months
	 * 
	 * @param monthDifference
	 * @return
	 */
	public DateTime getMonthsBefore(int monthDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.minusMonths(monthDifference);
		return now;
	}
	
	/**
	 * Get DateTime some weeks back
	 * 
	 * @param weekDifference
	 * @return
	 */
	public DateTime getWeeksBefore(int weekDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.minusWeeks(weekDifference);
		return now;
	}
	
	/**
	 * Get DateTime some days back
	 * 
	 * @param dayDifference
	 * @return
	 */
	public DateTime getDaysBefore(int dayDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.minusDays(dayDifference);
		return now;
	}
	
	/**
	 * Get DateTime after some years
	 * 
	 * @param yearDifference
	 * @return
	 */
	public DateTime getYearsAfter(int yearDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.plusYears(yearDifference);
		return now;
	}
	
	/**
	 * Get DateTime after some months
	 * 
	 * @param monthDifference
	 * @return
	 */
	public DateTime getMonthsAfter(int monthDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.plusMonths(monthDifference);
		return now;
	}
	
	/**
	 * Get DateTime after some weeks
	 * 
	 * @param weekDifferene
	 * @return
	 */
	public DateTime getWeeksAfter(int weekDifferene) {
		DateTime now = this.getCurrentDateTime();
		now = now.plusWeeks(weekDifferene);
		return now;
	}
	
	/**
	 * Get DateTime after some days
	 * 
	 * @param dayDifference
	 * @return
	 */
	public DateTime getDaysAfter(int dayDifference) {
		DateTime now = this.getCurrentDateTime();
		now = now.plusDays(dayDifference);
		return now;
	}

	public DateTime getCurrentDateTime() {
		return DateTime.now();
	}
}
