package problems.until099;

import java.math.BigInteger;

// solved

public class Problem058 {

	public static void main(String[] args) {
		int increment = 2;
		int currentNumber = 1;
		int primeCounter = 0;
		int allNumbersCounter = 1;
		double percent = 1;
		boolean notFound = true;
		while (notFound) {
			for (int i = 0; i < 4; i++) {
				currentNumber += increment;
				allNumbersCounter++;
				if (new BigInteger(currentNumber + "").isProbablePrime(10))
					primeCounter++;
				percent = (double) primeCounter / allNumbersCounter;
				if (percent < 0.1) {
					System.out.println(increment + 1);
					notFound = false;
				}
			}
			increment += 2;
		}
	}
	
}
