package problems.until099;

import java.math.BigInteger;
import java.util.ArrayList;

import problems.Utilities.EulerTimer;
import problems.Utilities.Primes;

public class Problem072NotYetSolved {
	
	static int limit = 100000;
	static long sum = 0;
	static ArrayList<Integer> primes = Primes.getAllPrimes(limit / 2);

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		for (int i = 1; i <= limit; i++)
			sum += numberOfReducedProperFractions(i);
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + " ms");
	}

	private static int numberOfReducedProperFractions(int denominator) {
		// primes
		if (new BigInteger("" + denominator).isProbablePrime(10))
			return denominator - 1;
		// divisible numbers
		boolean[] possibleNumerators = new boolean[denominator - 1];
		// set all multiples of the primefactors to true
		for (int primeFactor : Primes.getPrimeFactors(denominator, primes))
			for (int multiple = primeFactor; multiple < possibleNumerators.length; multiple += primeFactor)
				possibleNumerators[multiple] = true;
		int sum = 0;
		// sum up false values
		for (int i = 0; i < possibleNumerators.length; i++)
			if (!possibleNumerators[i])
				sum++;
		return sum;
	}
}
