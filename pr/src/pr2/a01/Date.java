package pr2.a01;

import java.util.regex.Pattern;

import pr2.a02.exceptions.IllegalDateException;

public class Date {

	protected int day;
	protected int
	month;    
	protected int year;

	public Date(int day, int month, int year) throws IllegalDateException {
		checkDate(day, month, year);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	private static void checkDate(int day, int month, int year)
			throws IllegalDateException {
		// Check formatting
		boolean dayCheck = Pattern.matches("([1-2]?[1-9]?)|([3][0-1])",
				Integer.toString(day));
		boolean monthCheck = Pattern.matches("[1-9]|(1[1-2])",
				Integer.toString(month));
		boolean yearCheck = Pattern.matches("([0-2]?[0-9][0-9][0-9])|3000]",
				Integer.toString(year));
		if (!dayCheck)
			throw new IllegalDateException("Illegal day: " + day);
		if (!monthCheck)
			throw new IllegalDateException("Illegal month: " + month);
		if (!yearCheck)
			throw new IllegalDateException("Illegal year: " + year);
		// Check if days correspond to month
		int[] monthStructure = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean daysCorrect = day <= monthStructure[month - 1];
		// Check for leapyear
		boolean leapYear = ((year % 4 == 0) && !(year % 100 == 0))
				| (year % 400 == 0);
		if (leapYear && month == 2) {
			daysCorrect = day <= 29;
		}
		if (!daysCorrect)
			throw new IllegalDateException(
					"Number of days don't correspond to month.");
		if (!daysCorrect && leapYear)
			throw new IllegalDateException(
					"Leapyear: Number of days don't correspond to month.");
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return String.format("%1$td",(long)day) + '.' + String.format("%1$tm",(long)month) + '.'
				+ String.format("%1$tY",(long)year);
	}
}