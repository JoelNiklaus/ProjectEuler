package problems.until49;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

// solved

public class Problem026 {

	static int precision = 5000;
	static int security = 2;
	static int limit = 1000;
	static LinkedList<Character> queue = new LinkedList<Character>();

	public static void main(String[] args) {
		// BigDecimal testFraction = unitFraction(19);
		// System.out.println(testFraction);
		// System.out.println(recurringCycleDigits(testFraction));
		
		int maxNumberOfDigits = 0, tempSolution = 0;
		for (int i = 1; i < limit; i++) {
			BigDecimal fraction = unitFraction(i);
			int numberOfDigits = recurringCycleDigits(fraction);
			System.out.println("Recurring Cycle Digits = " + numberOfDigits + " -> 1 / " + i
					+ " = " + fraction);
			if (numberOfDigits > maxNumberOfDigits) {
				tempSolution = i;
				maxNumberOfDigits = numberOfDigits;
			}
		}
		System.out.println(maxNumberOfDigits);
		System.out.println(tempSolution);
	}

	private static int recurringCycleDigits(BigDecimal fraction) {
		String searchString = fraction.toString().substring(2);

		if (searchString.contains("00000"))
			return 0;
		if (searchString.contains("11111") || searchString.contains("22222")
				|| searchString.contains("33333") || searchString.contains("44444")
				|| searchString.contains("55555") || searchString.contains("66666")
				|| searchString.contains("77777") || searchString.contains("88888")
				|| searchString.contains("99999"))
			return 1;

		queue = new LinkedList<Character>();
		int numberOfOccurrences = 0;

		for (int i = 0; i < searchString.length(); i++) {
			char current = searchString.charAt(i);
			if (!queue.contains(current))
				queue.add(current);
			else if (foundCycle(i, searchString)) {
				i += queue.size() - 1;
				numberOfOccurrences++;
			} else
				queue.add(current);
			if (numberOfOccurrences > security)
				return queue.size();
		}
		return 0;
	}
	
	private static boolean foundCycle(int searchIndex, String searchString) {
		LinkedList<Character> copy = new LinkedList<Character>();
		copy.addAll(queue);
		if (!copy.contains(searchString.charAt(searchIndex)))
			return false;
		char nextChar;
		while (copy.size() > 0) {
			LinkedList<Character> newQueue = new LinkedList<Character>();
			newQueue.addAll(copy);
			if (searchString.charAt(searchIndex) == copy.poll()) {
				for (int increment = 1; copy.size() > 0; increment++) {
					nextChar = searchString.charAt(searchIndex + increment);
					if (nextChar != copy.poll())
						return false;
				}
				queue = newQueue;
				return true;
			}
		}
		return false;
	}
	
	private static BigDecimal unitFraction(int denominator) {
		return BigDecimal.ONE.divide(new BigDecimal("" + denominator), precision,
				RoundingMode.HALF_UP);
	}
}
