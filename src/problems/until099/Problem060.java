package problems.until099;

import java.math.BigInteger;
import java.util.ArrayList;

import problems.Utilities.Primes;
import problems.Utilities.EulerTimer;

// solved

public class Problem060 {

	static int primeCertainity = 10;
	static int setSize = 5;
	static ArrayList<Integer> primes = Primes.getOddPrimes(10000);
	static int currentBest = Integer.MAX_VALUE;

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		testPrimes();
		System.out.println(currentBest);
		System.out.println(timer.timeElapsed() + " ms");
	}
	
	// too expensive: optimize here
	private static void testPrimes() {
		int[] numbers = new int[setSize];
		for (int a : primes)
			for (int b : primes) {
				if (!concatenationsArePrime(a, b))
					continue;
				for (int c : primes) {
					if (!concatenationsArePrime(a, c) || !concatenationsArePrime(b, c))
						continue;
					for (int d : primes) {
						if (!concatenationsArePrime(a, d) || !concatenationsArePrime(b, d)
								|| !concatenationsArePrime(c, d))
							continue;
						
						for (int e : primes) {
							if (!concatenationsArePrime(a, e) || !concatenationsArePrime(b, e)
									|| !concatenationsArePrime(c, e)
									|| !concatenationsArePrime(d, e))
								continue;
							
							numbers[0] = a;
							numbers[1] = b;
							numbers[2] = c;
							numbers[3] = d;
							numbers[4] = e;
							if (isRemarkableNumberSet(numbers)) {
								int sum = sumUp(numbers);
								if (sum < currentBest)
									currentBest = sum;
								return;
							}
							System.out.println(numbers[0] + ", " + numbers[1] + ", " + numbers[2]
									+ ", " + numbers[3]);
						}
					}
				}
			}
	}
	
	private static boolean isRemarkableNumberSet(int[] numbers) {
		for (int a = 1; a < numbers.length; a++)
			for (int b = 0; b < a; b++)
				if (!concatenationsArePrime(numbers[a], numbers[b]))
					return false;
		return true;
	}
	
	private static boolean concatenationsArePrime(int first, int second) {
		return new BigInteger(concatenate(first, second) + "").isProbablePrime(primeCertainity)
				&& new BigInteger(concatenate(second, first) + "").isProbablePrime(primeCertainity);
	}
	
	private static int concatenate(int first, int second) {
		return Integer.parseInt(first + "" + second);
	}
	
	private static int sumUp(int[] numbers) {
		int sum = 0;
		for (int number : numbers)
			sum += number;
		return sum;
	}
}
