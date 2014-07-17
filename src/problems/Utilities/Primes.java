package problems.Utilities;

import java.util.ArrayList;

public class Primes {

	private static boolean[] numbers;
	
	private static void calculatePrimes(int limit) {
		numbers[0] = true;
		numbers[1] = true;
		for(int prime = 2; prime <= limit; prime++)
			if(!numbers[prime])
				for(int multiple = 2*prime; multiple <= limit; multiple += prime)
					numbers[multiple] = true;
	}
	
	private static boolean isPrime(int number) {
		return !numbers[number];
	}
	
	public static ArrayList<Integer> getPrimes(int limit) {
		numbers = new boolean[limit + 1];
		calculatePrimes(limit);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 1; i < limit; i++)
			if(isPrime(i))
				primes.add(i);
		return primes;
	}
}
