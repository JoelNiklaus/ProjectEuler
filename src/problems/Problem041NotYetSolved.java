package problems;

import java.util.ArrayList;

import problems.Utilities.Primes;

public class Problem041NotYetSolved {
	
	static int start = 123456789, end = 987654321;
	static ArrayList<Integer> primes = Primes.getPrimesInRange(start, end);
	static int sum;

	public static void main(String[] args) {
		for (int prime : primes)
			if (isPandigital(prime))
				System.out.println(prime);

	}

	private static boolean isPandigital(int number) {
		String numberString = "" + number;
		if (numberString.contains("0"))
			return false;
		boolean[] digits = new boolean[9];
		// add the digits
		while (number > 0) {
			int digit = number % 10 - 1;
			if (digits[digit] == true)
				return false;
			digits[digit] = true;
			number = number / 10;
		}
		// check if there are all nine digits used
		for (int i = 0; i < digits.length; i++)
			if (digits[i] == false)
				return false;
		return true;
	}
}