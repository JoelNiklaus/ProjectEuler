package problems.until099;

import java.util.ArrayList;

import problems.Utilities.Primes;

public class Problem051NotYetSolved {
	
	static int limit = 1000000;
	static int currentBestNumber = 0;
	static int currentBestCount = 0;
	static ArrayList<Integer> primes = Primes.getAllPrimes(limit);
	static int[] primesArray = Primes.getAllPrimesArray(limit);

	public static void main(String[] args) {
		int[] ending = { 1, 3, 7, 9 };
		for (int i = 0; i < ending.length; i++) {
			int counter = 0;
			int[] numbers = new int[10];
			for (int a = 0; a < 10; a++) {
				numbers[a] = 10 * a + ending[i];
				if (primes.contains(numbers[a]))
					counter++;
			}
			System.out.println("*" + ending[i] + " -> " + counter);
		}
		
		/*
		 * for (int prime : primes) for (int primeIndex = 0; primes.get(primeIndex) < prime;
		 * primeIndex++) checkConsecutivePrimesSum(prime, primeIndex); // System.out.println(prime);
		 * System.out.println(currentBestCount); System.out.println(currentBestNumber);
		 */
	}
	
	private static void checkConsecutivePrimesSum(int prime, int primeIndex) {
		
	}

}
