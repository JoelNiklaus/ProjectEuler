package problems.until99;

import java.util.ArrayList;

import problems.Utilities.Primes;

public class Problem069YetToCheck {

	static int limit = 1000000;
	static int primeFactorsLimit = 1000;
	static double currentBest = 0;
	static int currentBestNumber = 0;
	static ArrayList<Integer> primes = Primes.getAllPrimes(primeFactorsLimit);

	public static void main(String[] args) {
		int numberOfRelativelyPrimes;
		double eulerNumber;
		for (int number = 2; number < limit; number++) {
			numberOfRelativelyPrimes = numberOfRelativelyPrimes(number);
			eulerNumber = (double) number / numberOfRelativelyPrimes;
			// System.out.println(number + ", " + eulerNumber);
			if (eulerNumber > currentBest) {
				currentBest = eulerNumber;
				currentBestNumber = number;
			}
		}
		System.out.println(currentBestNumber + ", " + currentBest);
	}
	
	private static int numberOfRelativelyPrimes(int number) {
		ArrayList<Integer> primeFactors = Primes.getPrimeFactors(number, primes);
		boolean[] relativelyPrimes = new boolean[number];
		relativelyPrimes[0] = true;
		for (int primeFactor : primeFactors)
			for (int multiple = primeFactor; multiple < number; multiple += primeFactor)
				relativelyPrimes[multiple] = true;
		int sum = 0;
		for (boolean relativelyPrime : relativelyPrimes)
			if (!relativelyPrime)
				sum++;
		return sum;
	}
}
