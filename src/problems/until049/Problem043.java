package problems.until049;

import java.util.ArrayList;

import problems.Utilities.Primes;

// solved

public class Problem043 {
	
	static ArrayList<Integer> primes = Primes.getAllPrimes(18);
	private static ArrayList<String> pandigitals = new ArrayList<String>();
	
	public static void main(String[] args) {
		long sum = 0;
		permutation(9876543210L);
		for (String pandigital : pandigitals)
			if (isSubstringDivisible(pandigital)) {
				System.out.println(pandigital);
				sum += Long.parseLong(pandigital);
			}
		System.out.println(sum);
	}

	private static boolean isSubstringDivisible(String pandigital) {
		String partString = "";
		int partNumber = 0;
		for (int i = 1; i < 8; i++) {
			partString = (pandigital + "").substring(i, i + 3);
			partNumber = Integer.parseInt(partString);
			if (partNumber % primes.get(i - 1) != 0)
				return false;
		}
		return true;
	}

	public static void permutation(long number) {
		permutation("", number + "");
	}
	
	private static void permutation(String prefix, String number) {
		int n = number.length();
		if (n == 0)
			pandigitals.add(prefix);
		else
			for (int i = 0; i < n; i++)
				permutation(prefix + number.charAt(i),
						number.substring(0, i) + number.substring(i + 1, n));
	}
}
