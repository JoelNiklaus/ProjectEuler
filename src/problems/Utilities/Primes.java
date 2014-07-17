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
	
	public static ArrayList<Integer> getAllPrimes(int limit) {
		return getPrimes(2, limit);
	}

	public static ArrayList<Integer> getOddPrimes(int limit) {
		return getPrimes(3, limit);
	}
}
