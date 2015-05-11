package problems.until049;

import java.util.ArrayList;

import problems.Utilities.Primes;

// solved

public class Problem027 {

	private static int currentBestProductOfCoefficients;
	private static int currentMostNumberOfConsecutivePrimes;

	public static void main(String[] args) {
		// b must be prime!
		ArrayList<Integer> possibleBs = Primes.getOddPrimes(1000);
		// if b == 2 -> a must be even
		for (int b : possibleBs) {
			checkPrimes(2, b);
			checkPrimes(2, -b);
		}
		// if b uneven -> a must be uneven
		for (int a = -999; a < 1000; a += 2)
			for (int b : possibleBs) {
				checkPrimes(a, b);
				checkPrimes(a, -b);
			}
		System.out.println(currentBestProductOfCoefficients);
		System.out.println(currentMostNumberOfConsecutivePrimes);
	}

	private static void checkPrimes(int a, int b) {
		int currentCounter = 0;
		for (int n = 0; true; n++) {
			int formula = n * n + a * n + b;
			if (Primes.isPrime(formula))
				currentCounter++;
			else {
				if (currentCounter > currentMostNumberOfConsecutivePrimes) {
					currentMostNumberOfConsecutivePrimes = currentCounter;
					currentBestProductOfCoefficients = a * b;
					System.out.println("n^2 + " + a + "*n + " + b + " -> " + currentCounter);
				}
				currentCounter = 0;
				break;
			}
		}
	}
}
