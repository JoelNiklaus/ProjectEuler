package problems.Utilities;

import java.util.ArrayList;

public class Primes {

	private static boolean[] numbers;
	
	private static boolean[] calculatePrimes(int limit) {
		boolean[] numbers = new boolean[limit + 1];
		numbers[0] = true;
		numbers[1] = true;
		for (int prime = 2; prime <= limit; prime++)
			if (!numbers[prime])
				for (int multiple = 2 * prime; multiple <= limit; multiple += prime)
					numbers[multiple] = true;
		return numbers;
	}
	
	// true means not prime. false means prime.
	private static boolean isPrime(int number) {
		return !numbers[number];
	}
	
	private static ArrayList<Integer> getPrimes(int start, int end) {
		numbers = calculatePrimes(end);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = start; i < end; i++)
			if (isPrime(i))
				primes.add(i);
		return primes;
	}

	public static int[] getPrimesArray(int start, int end) {
		numbers = calculatePrimes(end);
		int[] primes = new int[numbers.length];
		int i = 0;
		for (int prime = start; prime < end; prime++) {
			if (isPrime(prime))
				primes[i] = prime;
			i++;
		}
		return primes;
	}
	
	/**
	 * Returns all Primes smaller than the limit.
	 */
	public static int[] getAllPrimesArray(int limit) {
		ArrayList<Integer> primes = getAllPrimes(limit);
		int[] primesArray = new int[primes.size()];
		for (int i = 0; i < primes.size(); i++)
			primesArray[i] = primes.get(i);
		return primesArray;
	}
	
	/**
	 * Returns all Primes smaller than the limit.
	 */
	public static ArrayList<Integer> getAllPrimes(int limit) {
		return getPrimes(2, limit);
	}

	/**
	 * Returns all Primes smaller than the limit except 2.
	 */
	public static ArrayList<Integer> getOddPrimes(int limit) {
		return getPrimes(3, limit);
	}
	
	/**
	 * Returns all Primes between start and end.
	 */
	public static ArrayList<Integer> getPrimesInRange(int start, int end) {
		return getPrimes(start, end);
	}

	/**
	 * Generates a list with all the prime factors of the number.
	 *
	 * @param number
	 *            of which we want to know the prime factors
	 * @param primes
	 *            the prime factors we want to check for
	 * @return an ArrayList of Integers with the prime factors
	 */
	public static ArrayList<Integer> getPrimeFactors(int number, ArrayList<Integer> primes) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for (int prime : primes) {
			if (number == 1)
				break;
			number = divide(number, primeFactors, prime);
		}
		return primeFactors;
	}
	
	private static int divide(int number, ArrayList<Integer> primeFactors, int prime) {
		if (number % prime == 0) {
			number /= prime;
			if (!primeFactors.contains(prime))
				primeFactors.add(prime);
			return divide(number, primeFactors, prime);
		}
		return number;
	}
	
}
