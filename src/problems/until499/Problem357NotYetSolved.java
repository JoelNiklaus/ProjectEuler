package problems.until499;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;
import problems.Utilities.Primes;

public class Problem357NotYetSolved {
	
	static long finalLimit = 100000000;
	static long limit = 10000;
	static BigInteger sum = BigInteger.valueOf(1 + 2 + 6);
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		
		// ending digit has to be 0, 2 or 8
		int counter = 0;
		int inc = 2;
		for (long l = 10; l < limit; l += inc) {
			counter = ++counter % 3;
			// last digit is 2 -> secondlast digit has to be even
			if (counter == 2) {
				inc = 6;
				if (secondLastDigitIsEven(l))
					checkIfPrimeGenerating(l);
			}
			// last digit is 0 or 8 -> secondlast digit has to be uneven
			else {
				inc = 2;
				if (!secondLastDigitIsEven(l))
					checkIfPrimeGenerating(l);
			}
		}

		System.out.println("Sum = " + sum);

		System.out.println(timer.timeElapsed() + " ms");
	}
	
	private static boolean secondLastDigitIsEven(long number) {
		return (number / 10) % 2 == 0;
	}
	
	private static boolean checkIfPrimeGenerating(long number) {
		long upperLimit = number;
		// we only have to check half of the divisors. For the dividend it is analogical.
		for (long divisor = 1; divisor < upperLimit; divisor++)
			if (number % divisor == 0) {
				long dividend = number / divisor;
				upperLimit = dividend;
				if (!Primes.isPrime(divisor + dividend))
					return false;
			}
		System.out.println(number);
		sum = sum.add(BigInteger.valueOf(number));
		return true;
	}
	
}
