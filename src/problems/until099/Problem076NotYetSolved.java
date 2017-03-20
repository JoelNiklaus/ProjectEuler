package problems.until099;

import java.math.BigInteger;
import java.util.ArrayList;

import problems.Utilities.Primes;

public class Problem076NotYetSolved {

	static int limit = 100;
	static ArrayList<Integer> primes = Primes.getPrimesInRange(10, 99);

	public static void main(String[] args) {
		ArrayList<Long> partitionNumbers = new ArrayList<>();
		System.out.println(partitionNumber(limit));

		//bruteForce();
	}

	private static BigInteger partitionNumber(int n) {
		BigInteger sum = BigInteger.ZERO;
		for (int k = 1; k < n; k++) {
			int firstIndex =(int) (n - 0.5 * k * (3 * k - 1));
			int secondIndex = (int) (n - 0.5 * k * (3 * k + 1));
			sum.add(partitionNumber(firstIndex).add(partitionNumber(secondIndex)).multiply(new BigInteger(""+Math.pow(-1, k + 1))));
		}
		return sum;
	}

	private static void bruteForce() {
		int numberOfPossibilities = 4;
		int increment = 2;
		int incrementsIncrement = 2;
		for (int i = 4; i <= 100; i++) {
			System.out.println("i: " + i + ", p: " + numberOfPossibilities + ", inc: " + increment
					+ ", incsInc: " + incrementsIncrement);

			numberOfPossibilities += increment;

			increment += incrementsIncrement;
			if (i % 2 == 0)
				incrementsIncrement -= 2;
			else
				incrementsIncrement += 3;

		}
	}
}
