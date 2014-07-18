package problems.Utilities;

import java.util.ArrayList;

public class Primes {

	private static boolean[] numbers;
	
	private static void calculatePrimes(int limit) {
		numbers = new boolean[limit + 1];
		numbers[0] = true;
		numbers[1] = true;
		for(int prime = 2; prime <= limit; prime++)
			if(!numbers[prime])
				for(int multiple = 2*prime; multiple <= limit; multiple += prime)
					numbers[multiple] = true;
	}
	
	/**
	 * true means not prime. false means prime.
	 */
	private static boolean isPrime(int number) {
		return !numbers[number];
	}
	
	private static ArrayList<Integer> getPrimes(int start, int limit) {
		calculatePrimes(limit);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = start; i < limit; i++)
			if(isPrime(i))
				primes.add(i);
		return primes;
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
	 * Generates a list with all the prime factors of the number.
	 * 
	 * @param number	of which we want to know the prime factors
	 * @param primes	the prime factors we want to check for
	 * @return			an ArrayList of Integers with the prime factors
	 */
	public static ArrayList<Integer> getPrimeFactors(int number, ArrayList<Integer> primes) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for(int prime : primes) {
			if(number == 1)
				break;
			number = divide(number, primeFactors, prime);
		}
		return primeFactors;	
	}

	private static int divide(int number, ArrayList<Integer> primeFactors, int prime) {
		if(number % prime == 0) {
			number /= prime;
			if(!primeFactors.contains(prime))
				primeFactors.add(prime);
			return divide(number, primeFactors, prime);
		}
		return number;
	}
}
