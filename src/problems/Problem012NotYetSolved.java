package problems;



public class Problem012NotYetSolved {
	
	static int firstNumber = 1;	
	static int numberOfDivisors = 500;

	public static void main(String[] args) {
		
		boolean numberNotFound = true;
		long lastNumber = firstNumber;
		
		for(int i = 2; numberNotFound; i++) {
			lastNumber += i;
			if(numberOfDivisors(lastNumber) >= numberOfDivisors) {
				System.out.println(lastNumber);
				numberNotFound = false;
			}
			System.out.println(lastNumber);
			System.out.println(numberOfDivisors(lastNumber));
		}	
	}
	
	/*
	 * Too inefficient! Faster algorithm needed.
	 */
	private static int numberOfDivisors(long number) {
		int divisors = 2;
		for(int i = 2; i <= number / 2; i++)
			if(number % i == 0)
				divisors++;
		return divisors;
	}

}
