package problems.until099;

import java.util.ArrayList;

import problems.Utilities.Primes;
import problems.Utilities.Timer;

public class Problem087TooInefficient {

	static int limit = 5000;
	static int sum = 0;
	static ArrayList<Integer> primes = Primes.getAllPrimes(100);
	static int[] primesArray = Primes.getAllPrimesArray(100);
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int i = 1; i < limit; i++)
			if (isPrimePowerTriple(i))
				sum++;
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + "ms");
	}
	
	private static boolean isPrimePowerTriple(int number) {
		int length = primes.size();
		for (int x = 0; x < length; x++)
			for (int y = 0; y < length; y++)
				for (int z = 0; z < length; z++)
					if ((int) (Math.pow(primes.get(x), 2) + Math.pow(primes.get(y), 3) + Math.pow(
							primes.get(z), 4)) == number)
						// System.out.println(number + " = " + primes.get(x) + "^2 + " +
						// primes.get(y) + "^3 + " + primes.get(z) + "^4");
						return true;
		
		return false;
	}
	/*
	 * private static boolean isPrimePowerTripleWithArray(int number) { int length =
	 * primesArray.length; for (int x = 0; x < length; x++) for (int y = 0; y < length; y++) for
	 * (int z = 0; z < length; z++) if ((int) (Math.pow(primesArray[x], 2) +
	 * Math.pow(primesArray[y], 3) + Math .pow(primesArray[z], 4)) == number) //
	 * System.out.println(number + " = " + primes.get(x) + "^2 + " + // primes.get(y) + "^3 + " +
	 * primes.get(z) + "^4"); return true;
	 * 
	 * return false; }
	 */
}
