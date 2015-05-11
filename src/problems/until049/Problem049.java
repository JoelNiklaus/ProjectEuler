package problems.until049;

import java.util.ArrayList;

import problems.Utilities.Primes;

// solved

public class Problem049 {

	static ArrayList<Integer> primes = Primes.getPrimesInRange(1000, 9999);
	private static ArrayList<String> permutations = null;
	static ArrayList<Integer> solution = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		for (int prime : primes) {
			permutation(prime);
			
			solution = new ArrayList<Integer>();
			int counter = -1;
			int perm = 0;
			ArrayList<Integer> matchingPerms = new ArrayList<Integer>();
			for (String permutation : permutations) {
				perm = Integer.parseInt(permutation);
				if (perm > prime && primes.contains(perm) && !matchingPerms.contains(perm)) {
					counter++;
					matchingPerms.add(perm);
				}
			}

			int sequenceIncrease = 0;
			for (int match : matchingPerms) {
				sequenceIncrease = match - prime;
				int matchCounter = 0;
				for (int nextMatch : matchingPerms)
					if (prime + sequenceIncrease == nextMatch
					|| prime + 2 * sequenceIncrease == nextMatch) {
						solution.add(nextMatch);
						matchCounter++;
					}
				if (matchCounter >= 2) {
					System.err.println(prime);
					String concatenatedNumber = "";
					for (int number : solution)
						concatenatedNumber += number;
					System.out.println(concatenatedNumber);
				}
			}
		}
	}
	
	public static void permutation(int number) {
		permutations = new ArrayList<String>();
		permutation("", number + "");
	}
	
	private static void permutation(String prefix, String number) {
		int n = number.length();
		if (n == 0)
			permutations.add(prefix);
		else
			for (int i = 0; i < n; i++)
				permutation(prefix + number.charAt(i),
						number.substring(0, i) + number.substring(i + 1, n));
	}

	// private static boolean isPermutation(int number, int compare) {
	// String numberString = number + "";
	// String compareString = compare + "";
	// for (char c : numberString.toCharArray())
	// if (compareString.contains(c + ""))
	// compareString.replace(c, ' ');
	// else
	// return false;
	// return true;
	// }

}
