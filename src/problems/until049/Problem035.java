package problems.until049;

import java.util.ArrayList;

import problems.Utilities.Primes;
import problems.Utilities.Timer;

// solved

public class Problem035 {
	
	static int limit = 1000000;
	static long sum = 0;
	static ArrayList<Integer> primes = Primes.getAllPrimes(limit);

	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int p : primes)
			if (!("" + p).contains("0"))
				if (isCircularPrime(p)) {
					sum++;
					System.out.println(p);
				}
		
		System.out.println(timer.timeElapsed() + "ms");
		System.out.println(sum);
	}

	private static boolean isPrime(int number) {
		return primes.contains(number);
	}

	private static boolean isCircularPrime(int number) {
		for (int i = 0; i < ("" + number).length() - 1; i++) {
			number = rotate(number);
			if (!isPrime(number))
				return false;
		}
		return true;
	}

	private static int rotate(int number) {
		String string = "" + number;
		string += string.charAt(0);
		string = string.substring(1);
		return Integer.parseInt(string);
	}
}
