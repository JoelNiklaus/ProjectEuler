package problems.until099;

import java.util.ArrayList;

import problems.Utilities.Primes;

public class Problem076NotYetSolved {

	static int limit = 100;
	static long sum = 0;
	static ArrayList<Integer> primes = Primes.getPrimesInRange(10, 99);
	
	public static void main(String[] args) {
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
