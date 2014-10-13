package problems.until99;

import problems.Utilities.Timer;

// solved

public class Problem092 {
	
	static int limit = 10000000;
	static int magicNumber = 89;
	static int sumOfChains = 0;
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		int newNumber;
		for (int i = 1; i < limit; i++) {
			newNumber = i;
			// String output = i + " -> ";
			while (true) {
				newNumber = sumOfSquareOfDigits(newNumber);
				if (newNumber == 1)
					break;
				if (newNumber == magicNumber) {
					sumOfChains++;
					break;
				}
				// output += newNumber + " -> ";
			}
			// System.out.println(output);
		}
		System.out.println(sumOfChains);
		System.out.println(timer.timeElapsed() + "ms");
	}
	
	private static int sumOfSquareOfDigits(int number) {
		int sum = 0;
		String[] digits = ("" + number).split("");
		for (String digit : digits)
			sum += (int) Math.pow(Integer.parseInt(digit), 2);
		return sum;
	}
	
}
