package problems.Utilities;

public final class Utility {
	public static boolean isPandigital(long number) {
		String numberString = "" + number;
		if (numberString.length() > 9)
			return false;
		if (numberString.contains("0"))
			return false;
		boolean[] digits = new boolean[9];
		// add the digits
		while (number > 0) {
			long digit = number % 10 - 1;
			if (digits[(int) digit] == true)
				return false;
			digits[(int) digit] = true;
			number /= 10;
		}
		// check if there are all nine digits used
		for (int i = 0; i < digits.length; i++)
			if (digits[i] == false)
				return false;
		return true;
	}
	
	public static long lastDigit(long number) {
		return number % 10;
	}
	
	public static long firstDigit(long number) {
		while (number > 9)
			number /= 10;
		return number;
	}
	
}
