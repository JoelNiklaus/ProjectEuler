package problems.until049;

// solved

public class Problem012 {
	
	static int firstNumber = 1;
	static int numberOfDivisors = 500;

	public static void main(String[] args) {
		
		boolean numberNotFound = true;
		long lastNumber = firstNumber;
		
		for (long i = 2; numberNotFound; i++) {
			lastNumber += i;
			if (i % 1000 == 0) {
				System.out.println(lastNumber);
				System.out.println(numberOfDivisors(lastNumber));
			}
			if (numberOfDivisors(lastNumber) > numberOfDivisors) {
				System.out.println(lastNumber);
				System.out.println(numberOfDivisors(lastNumber));
				numberNotFound = false;
			}
		}
	}
	
	// /*
	// * Too inefficient! Faster algorithm needed.
	// */
	// private static int numberOfDivisors(long number) {
	// int divisors = 2;
	// for (int i = 2; i <= number / 2; i++)
	// if (number % i == 0)
	// divisors++;
	// return divisors;
	// }
	
	/*
	 * More efficient!
	 */
	private static int numberOfDivisors(long number) {
		int divisors = 2;
		long upperBoundary = number;
		for (long i = 2; i < upperBoundary; i++)
			if (number % i == 0) {
				divisors += 2;
				upperBoundary = number / i;
			}
		return divisors;
	}

}
