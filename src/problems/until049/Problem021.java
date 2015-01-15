package problems.until049;

import java.util.ArrayList;

// solved

public class Problem021 {

	static int limit = 10000;
	static long sum = 0;
	static ArrayList<Integer> amicables = new ArrayList<Integer>();

	public static void main(String[] args) {
		for(int a = 1; a < limit; a++) {
			if(isAmicable(a)) {
				int b = sumOfDivisors(a);
				addToAmicables(a);
				addToAmicables(b);
			}
		}
		System.out.println(sum);
	}

	private static void addToAmicables(int number) {
		if(!amicables.contains(number)) {
			amicables.add(number);
			sum += number;
		}
	}

	private static boolean isAmicable(int a) {
		int b = sumOfDivisors(a);
		if(b == a)
			return false;
		return sumOfDivisors(b) == a;
	}

	private static int sumOfDivisors(int number) {
		int sumOfDivisors = 0;
		for(int i = 1; i <= number / 2; i++)
			if(number % i == 0)
				sumOfDivisors += i;
		return sumOfDivisors;
	}

}
