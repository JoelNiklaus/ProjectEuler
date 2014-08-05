package problems;

import java.util.ArrayList;

import problems.Utilities.Timer;

// solved

public class Problem074 {

	static int limit = 1000000;
	static int numberOfNonRepeatingTerms = 60;
	static int sumOfChains = 0;

	public static void main(String[] args) {
		Timer timer = new Timer();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		int newNumber;
		for (int i = 10; i < limit; i++) {
			newNumber = i;
			// String output = i + " -> ";
			while (true) {
				newNumber = sumOfFactorialOfDigits(newNumber);
				if (visited.contains(newNumber))
					break;
				else
					visited.add(newNumber);
				// output += newNumber + " -> ";
			}
			// System.out.println(output);
			if (visited.size() + 1 == numberOfNonRepeatingTerms)
				sumOfChains++;
			visited.clear();
		}
		System.out.println(sumOfChains);
		System.out.println(timer.timeElapsed() + "ms");
	}

	private static int sumOfFactorialOfDigits(int number) {
		int sum = 0;
		String[] digits = ("" + number).split("");
		for (String digit : digits)
			sum += factorial(Integer.parseInt(digit));
		return sum;
	}
	
	public static int factorial(int number) {
		if (number == 0 || number == 1)
			return 1;
		return factorial(number - 1) * number;
	}
}
