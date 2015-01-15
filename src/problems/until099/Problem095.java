package problems.until099;

import java.util.Hashtable;
import java.util.LinkedList;

public class Problem095 {

	static int limit = 1000000;
	static Hashtable<Integer, LinkedList<Integer>> amicables = new Hashtable<Integer, LinkedList<Integer>>();

	public static void main(String[] args) {
		for (int a = 1; a < limit; a++)
			if (isAmicable(a)) {
				int b = sumOfDivisors(a);
				addToAmicables(a);
				addToAmicables(b);
			}
	}

	private static void addToAmicables(int number) {
		// if (!amicables.contains(number))
		// amicables.put(number, sumOfDivisors(number));
	}

	private static boolean isAmicable(int a) {
		int b = sumOfDivisors(a);
		if (b == a)
			return false;
		return sumOfDivisors(b) == a;
	}

	private static int sumOfDivisors(int number) {
		int sumOfDivisors = 0;
		for (int i = 1; i <= number / 2; i++)
			if (number % i == 0)
				sumOfDivisors += i;
		return sumOfDivisors;
	}

}
