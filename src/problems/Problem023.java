package problems;

import java.util.ArrayList;

// solved

public class Problem023 {
	
	static int definitiveLimit = 28123;
	static int trialLimit = 100;
	static int limit = definitiveLimit;
	static ArrayList<Integer> abundants = new ArrayList<Integer>();
	static long sum = 0;

	public static void main(String[] args) {
		calculateAbundants();
		System.out.println(abundants.size() * abundants.size());
		for(int number = 1; number <= limit; number++)
			if(!equalToSumOfTwoAbundants(number)) {
				sum += number;
				System.out.println(number);
			}
		System.out.println(sum);
	}
	
	private static boolean equalToSumOfTwoAbundants(int number) {
		// sum with the following: 4179871
		// sum without the following: 4179871
		if(number < 950 && number % 2 == 1)
			return false;
		if(number > 100 && number % 2 == 0)
			return true;
		for(int i = 0; i < abundants.size() && abundants.get(i) < number; i++)
			for(int j = 0; j < abundants.size() && abundants.get(j) < number; j++)
				if(number == abundants.get(i) + abundants.get(j))
					return true;
		return false;
	}

	private static void calculateAbundants() {
		for(int i = 1; i < limit; i++)
			if(isAbundant(i))
				abundants.add(i);
	}

	private static boolean isAbundant(int number) {
		return sumOfDivisors(number) > number;
	}

	private static int sumOfDivisors(int number) {
		int sum = 0;
		for(int i = 1; i <= number/2; i++)
			if(number % i == 0)
				sum += i;
		return sum;
	}
}
