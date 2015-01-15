package problems.until049;

import java.util.ArrayList;

// solved

public class Problem032 {
	
	static ArrayList<Integer> pandigitals = new ArrayList<Integer>();
	static int sum;

	public static void main(String[] args) {
		for (int multiplicand = 2; multiplicand < 9876; multiplicand++)
			for (int multiplier = 2; multiplier < 9876; multiplier++) {
				int product = multiplicand * multiplier;
				if (isPandigital(multiplicand, multiplier, product)
						&& !pandigitals.contains(product)) {
					System.out.println(multiplicand + " * " + multiplier + " = " + product);
					pandigitals.add(product);
				}
			}
		
		for (int pandigital : pandigitals)
			sum += pandigital;
		System.out.println(sum);
	}

	private static boolean isPandigital(int multiplicand, int multiplier, int product) {
		String numberString = multiplicand + "" + multiplier + "" + product;
		if (numberString.length() > 9)
			return false;
		if (numberString.contains("0"))
			return false;
		int number = Integer.parseInt(numberString);
		boolean[] digits = new boolean[9];
		// add the digits
		while (number > 0) {
			int digit = number % 10 - 1;
			if (digits[digit] == true)
				return false;
			digits[digit] = true;
			number /= 10;
		}
		// check if there are all nine digits used
		for (int i = 0; i < digits.length; i++)
			if (digits[i] == false)
				return false;
		return true;
	}
	
}
