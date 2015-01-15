package problems.until049;

import java.util.ArrayList;

import problems.Utilities.Primes;

public class Problem049NotYetSolved {
	
	static ArrayList<Integer> primes = Primes.getPrimesInRange(1000, 9999);

	public static void main(String[] args) {
		for (int prime : primes)
			System.out.println(prime);
	}
	
	private static boolean isPermutation(int number, int compare) {
		String numberString = number + "";
		String compareString = compare + "";
		for (char c : numberString.toCharArray())
			if (compareString.contains(c + ""))
				compareString.replace(c, ' ');
			else
				return false;
		return true;
	}
}
