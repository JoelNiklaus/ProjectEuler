package problems;

import java.util.ArrayList;

import problems.Utilities.Primes;


public class Problem060NotYetSolved {
	
	static int count = 4;
	static int[] numbers = new int[count];
	static int numberOfPrimes = 680000;
	static ArrayList<Integer> primes = Primes.getOddPrimes(numberOfPrimes);
	static int currentBest = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		testPrimes();
		System.out.println(currentBest);
	}

	// too expensive: optimize here
	private static void testPrimes() {
		for(int a = count - 1; a < numberOfPrimes - 1; a++)
			for(int b = count - 2; b < a; b++)
				for(int c = count - 3; c < b; c++)
					for(int d = count - 4; d < c; d++) {
						numbers[0] = primes.get(a);
						numbers[1] = primes.get(b);
						numbers[2] = primes.get(c);
						numbers[3] = primes.get(d);
						checkForRemarkableNumbers();
						System.out.println(numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3]);
					}
	}

	private static void checkForRemarkableNumbers() {
		boolean stillPossible = true;
		for(int a = 1; a < numbers.length; a++)
			for(int b = 0; b < a; b++)
				if(!concatenationsArePrime(numbers[a], numbers[b]))
					stillPossible = false;
		int sum = sum(numbers);
		if(stillPossible && sum < currentBest)
			currentBest = sum;
	}
	
	private static int sum(int[] numbers) {
		int sum = 0;
		for(int number : numbers)
			sum += number;
		return sum;
	}
	
	private static boolean concatenationsArePrime(int first, int second) {
		return primes.contains(concatenate(first, second)) && primes.contains(concatenate(second, first));
	}

	private static int concatenate(int first, int second) {
		return Integer.parseInt(first + "" + second);
	}
}
