public class DateCounter {

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 400 == 0) {
			return true;

		} else if (year % 4 == 0 && year % 100 != 0) {
			return true;

		} else {
			return false;
		}
	}

	public static int daysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;

		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;

		} else if (month == 2) {
			return isLeapYear(year) ? 29 : 28;

		} else {
			return 0;
		}
	}

	public static boolean isValidDate(int year, int month, int day) {
		if (year < 0) {
			return false;

		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 31 || day < 1) {
				return false;	
			} else {
				return true;
			}

		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30 || day < 1) {
				return false;
			} else {
				return true;
			}

		} else if (month == 2) {
			if (isLeapYear(year) == true && day <= 29 && day >= 1) {
				return true;
			} else if (isLeapYear(year) == false && day <= 28 && day >= 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean dateCheck (int year0, int month0, int day0, int year1, int month1, int day1) {
		if (year0 < year1 || (year0 == year1 && month0 < month1) || (year0 == year1 && month0 == month1 && day0 < day1)) {
			return true;
		} else {
			return false;
		}

	}


	public static int daysBetween(int year0, int month0, int day0, int year1, int month1, int day1) {
		int counter = 0;
		if (dateCheck(year0, month0, day0, year1, month1, day1)) {
			while (year0 < year1 || month0 < month1 || day0 < day1) {
				counter++;
				day0++;

				if (day0 > daysInMonth(year0, month0)) {
					day0 = 1;
					month0++;
				}

				if (month0 == 13) {
					month0 = 1;
					year0++;
				}
			}
			return counter;
		}

		else {
			while (year1 < year0 || month1 < month0 || day1 < day0) {
				counter++;
				day1++;

				if (day1 > daysInMonth(year1, month1)) {
					day1 = 1;
					month1++;
				}

				if (month1 == 13) {
					month1 = 1;
					year1++;
				}
			}
			return counter;
		}
	}


	public static boolean hasLeapSecond(int year) {
		int[] leapSecondYears = {
			1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1981, 1982, 1983, 1985, 1987, 1989, 1990, 1992, 1993, 1994, 1995, 1997, 1998, 2005, 2008, 2012, 2015
		};

		for (int i = 0; i < leapSecondYears.length; i++) {
			if (year == leapSecondYears[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasLeapSecond(int year, int month, int day) {
		
		int[] juneLeapSecondYears = {
			1972, 1981, 1982, 1983, 1985, 1992, 1993, 1994, 1997, 2012, 2015
		};

		int[] decemberLeapSecondYears = {
			1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1987, 1989, 1990, 1995, 1998, 2005, 2008
		};

		for (int i = 0; i < juneLeapSecondYears.length; i++) {
			if (year == juneLeapSecondYears[i] && month == 6 && day == 30) {
				return true;
			}
		}

		for (int i = 0; i < decemberLeapSecondYears.length; i++) {
			if (year == decemberLeapSecondYears[i] && month == 12 && day == 31) {
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Usage: java DateCounter <year0> <month0> <day0> <year1> <month1> <day1>");
			return;
		}

		try {
			int year0 = Integer.parseInt(args[0]);
			int month0 = Integer.parseInt(args[1]);
			int day0 = Integer.parseInt(args[2]);
			int year1 = Integer.parseInt(args[3]);
			int month1 = Integer.parseInt(args[4]);
			int day1 = Integer.parseInt(args[5]);

			int absoluteDays = daysBetween(year0, month0, day0, year1, month1, day1);

			if (isValidDate(year0, month0, day0) == false || isValidDate(year1, month1, day1) == false) {
				System.out.println("One of the supplied dates is not valid.");
				return;
			}

			System.out.println(absoluteDays);

		}

		catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            System.out.println("One of the supplied dates is not valid.");
            return;  
		}
	}
}
