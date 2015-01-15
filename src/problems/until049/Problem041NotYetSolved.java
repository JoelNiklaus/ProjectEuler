package problems.until049;

import java.math.BigInteger;

import problems.Utilities.Timer;

public class Problem041NotYetSolved {
	
	// TODO idea: make list of all permuted pandigital numbers

	static int start = 987654321;
	// static int[] primes = Primes.getPrimesArray(start, end);
	static int sum;

	public static void main(String[] args) {
		Timer timer = new Timer();
		for (long i = start; true; i -= 2) {
			System.out.println(i);
			if (i % 10 != 5)
				if (isPandigital(i))
					if (new BigInteger("" + i).isProbablePrime(10)) {
						System.out.println(i);
						System.out.println(timer.timeElapsed() + "ms");
						break;
					}
		}
	}

	private static boolean isPandigital(long number) {
		String numberString = "" + number;
		if (numberString.contains("0"))
			return false;
		boolean[] digits = new boolean[9];
		// add the digits
		while (number > 0) {
			int digit = (int) number % 10 - 1;
			if (digits[digit] == true)
				return false;
			digits[digit] = true;
			number = number / 10;
		}
		// check if there are all nine digits used
		// for (int i = 0; i < digits.length; i++)
		// if (digits[i] == false)
		// return false;
		return true;
	}
}