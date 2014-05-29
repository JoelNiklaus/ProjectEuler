package problems;

import java.math.BigInteger;

// solved

public class Problem020 {

	static int limit = 2000000;
	static long sum = 0;
	static boolean[] numbers = new boolean[limit + 1];
	
	public static void main(String[] args) {
		BigInteger number = factorial(100);
		String string = number.toString();
		System.out.println(sumOfDigits(string));
	}
	
	public static BigInteger factorial(int i) {
		if(i == 1)
			return BigInteger.ONE;
		return factorial(i - 1).multiply(new BigInteger("" + i));
	}
	
	public static int sumOfDigits(String number) {
		int sum = 0;
		for(int i = 0; i < number.length(); i++)
			sum += Integer.parseInt(number.substring(i, i + 1));
		return sum;
	}
}
