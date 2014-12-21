package problems.until49;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Problem026NotYetSolved {
	
	static int precision = 10;
	static int security = precision / 50;
	static int limit = 1000;
	
	public static void main(String[] args) {
		BigDecimal fraction = unitFraction(6);
		
		System.out.println(fraction);
		System.out.println(recurringCycleDigits(fraction));

		int currentBest = 0;
		for (int i = 1; i < limit; i++) {
			int numberOfDigits = recurringCycleDigits(unitFraction(i));
			if (numberOfDigits > currentBest)
				currentBest = numberOfDigits;
		}
		System.out.println(currentBest);
	}
	
	private static int recurringCycleDigits(BigDecimal fraction) {
		String denominator = fraction.toString().substring(2);
		Stack<Character> stack = new Stack<Character>();
		
		int numberOfOccurrences = 0;

		numberOfOccurrences = searchForRecurringCycle(denominator, stack, numberOfOccurrences);
		
		if (numberOfOccurrences > security)
			return stack.size();
		return 0;
	}
	
	private static int searchForRecurringCycle(String searchString, Stack<Character> stack,
			int numberOfOccurrences) {
		if (searchString.length() <= 0)
			return numberOfOccurrences;

		char current = searchString.charAt(0);
		if (!stack.contains(current))
			stack.push(current);
		else if (stack.peek() == current)
			numberOfOccurrences++;
		// TODO Fix here

		return searchForRecurringCycle(searchString.substring(1), stack, numberOfOccurrences);
	}
	
	private static BigDecimal unitFraction(int denominator) {
		return BigDecimal.ONE.divide(new BigDecimal("" + denominator), precision,
				RoundingMode.HALF_UP);
	}
}
