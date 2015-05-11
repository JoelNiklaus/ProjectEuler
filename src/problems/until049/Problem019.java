package problems.until049;

// solved

public class Problem019 {
	
	private static int numberOfSundaysOnFirstOfMonth = 0;
	// day % 7 = day: 1 = Monday, 2 = Tuesday, 7 = Sunday
	private static int day = 2;
	
	public static void main(String[] args) {

		for (int year = 1901; year <= 2000; year++) {
			checkIfSunday(31); // January
			if (year % 4 == 0 || year == 2000) // is leap year
				checkIfSunday(29); // February
			else
				// is not a leap year
				checkIfSunday(28); // February
			checkIfSunday(31); // March
			checkIfSunday(30); // April
			checkIfSunday(31); // May
			checkIfSunday(30); // June
			checkIfSunday(31); // July
			checkIfSunday(31); // August
			checkIfSunday(30); // September
			checkIfSunday(31); // October
			checkIfSunday(30); // November
			checkIfSunday(31); // December
		}

		System.out.println(numberOfSundaysOnFirstOfMonth);
	}
	
	private static void checkIfSunday(int dayDifference) {
		day += dayDifference;
		if (isSunday(day))
			numberOfSundaysOnFirstOfMonth++;
	}
	
	private static boolean isSunday(int day) {
		return day % 7 == 0;
	}
	
}
