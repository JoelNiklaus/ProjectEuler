package problems.until099;

import java.util.ArrayList;

import problems.Utilities.Primes;
import problems.Utilities.EulerTimer;

// solved

public class Problem069 {
	
	static int limit = 1000000;
	static int primeFactorsLimit = 1000;
	static double currentBest = 0;
	static int currentBestNumber = 0;
	static ArrayList<Integer> possiblePrimeFactors = Primes.getAllPrimes(primeFactorsLimit);
	
	public static void main(String[] args) {
		System.out.println(Math.log10(limit));
		EulerTimer timer = new EulerTimer();
		for (int number = 2; number < limit; number++)
			checkRelativelyPrimes(number);
		System.out.println(currentBestNumber + ", " + currentBest + ": " + timer.timeElapsed()
				+ " ms");
	}

	private static void checkRelativelyPrimes(int number) {
		int numberOfRelativelyPrimes = numberOfRelativelyPrimes(number);
		double eulerNumber = (double) number / numberOfRelativelyPrimes;
		// System.out.println(number + ", " + eulerNumber);
		if (eulerNumber > currentBest) {
			currentBest = eulerNumber;
			currentBestNumber = number;
		}
	}

	private static int numberOfRelativelyPrimes(int number) {
		ArrayList<Integer> primeFactors = Primes.getPrimeFactors(number, possiblePrimeFactors);
		// System.out.print(number + ": ");
		// for (int primeFactor : primeFactors)
		// System.out.print(primeFactor + ", ");
		// System.out.println();
		// Only numbers with many primeFactors have few relatively Prime numbers -> return number so
		// that quotient returns 1
		if (primeFactors.size() < Math.log10(limit))
			return number;
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
