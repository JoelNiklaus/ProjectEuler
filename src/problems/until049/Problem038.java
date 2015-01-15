package problems.until049;

// solved

public class Problem038 {
	
	static long currentBest = 918273645;
	
	public static void main(String[] args) {
		for (int number = 9321; number <= 9876; number++)
			concatenateNumber(number);
		System.out.println();
		System.out.println(currentBest);
	}
	
	private static void concatenateNumber(int number) {
		String numberString = "";
		int n = 1;
		while (numberString.length() < 9) {
			numberString += "" + number * n;
			n++;
		}
		long numberToTest = Long.parseLong(numberString);
		System.out.println(numberToTest);
		if (isPandigital(numberToTest) && numberToTest > currentBest)
			currentBest = numberToTest;
	}
	
	private static boolean isPandigital(long number) {
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
	
}
