package problems.until049;

import java.math.BigInteger;
import java.util.ArrayList;

// solved

public class Problem025 {

	static ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
	static BigInteger startingNumber = BigInteger.ONE;
	static int digits  = 1000;
	
	public static void main(String[] args) {
		fibonacci();	
	}

	private static void fibonacci() {
		BigInteger currentNumber = BigInteger.ZERO;
		boolean notFoundYet = true;
		numbers.add(startingNumber);
		numbers.add(startingNumber);
		for(int i = 2; notFoundYet; i++) {
			currentNumber = numbers.get(i - 2).add(numbers.get(i - 1));
			numbers.add(i, currentNumber);
			if(numberOfDigits(currentNumber) == digits) {
				System.out.println(numbers.indexOf(currentNumber) + 1);
				break;
			}
		}
	}
	
	private static int numberOfDigits(BigInteger number) {
		return number.toString().length();
	}
}
