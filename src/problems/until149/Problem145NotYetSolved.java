package problems.until149;

import static problems.Utilities.Utility.firstDigit;
import static problems.Utilities.Utility.lastDigit;

import java.util.LinkedList;

import problems.Utilities.Timer;

public class Problem145NotYetSolved {
	
	static long limit = 1000;
	static LinkedList<Long> alreadyFound = new LinkedList<Long>();
	static long sum = 0;
	
	public static void main(String[] args) {
		System.out.println(getReversible(409));
		Timer timer = new Timer();
		for (long i = 1; i < limit; i++)
			if (evenFrontAndUnevenRearOrReversed(i))
				if (i % 10 != 0 && !alreadyFound.contains(i)) {
					long reversible = getReversible(i);
					if (reversible != 0) {
						sum += 2;
						alreadyFound.add(reversible);
						// System.out.println(i + " + " + reversible + " = " + (reversible + i));
					}
				}
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + " ms");
		
	}
	
	private static boolean evenFrontAndUnevenRearOrReversed(long number) {
		return firstDigit(number) % 2 == 0 && lastDigit(number) % 2 != 0
				|| firstDigit(number) % 2 != 0 && lastDigit(number) % 2 == 0;
	}

	private static long getReversible(long number) {
		long reverse = reverse(number);
		long sum = number + reverse;
		while (sum > 0) {
			if (sum % 10 % 2 == 0)
				return 0;
			sum /= 10;
		}
		return reverse;
	}
	
	private static long reverse(long number) {
		String newNumberString = "";
		while (number > 0) {
			newNumberString += number % 10;
			number /= 10;
		}
		return Long.parseLong(newNumberString);
	}
}
