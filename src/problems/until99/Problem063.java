package problems.until99;

import java.math.BigInteger;

// solved

public class Problem063 {
	
	static int sum = 0;
	static int baseLimit = 100;
	static int exponentLimit = 100;
	
	public static void main(String[] args) {
		for(int base = 1; base <= baseLimit; base++)
			for(int exponent = 1; exponent <= exponentLimit; exponent++)
				if(condition(base, exponent)) {
					sum++;
					System.out.println(base + "^" + exponent + " = " + new BigInteger("" + base).pow(exponent).toString());
				}
		System.out.println(sum);
	}

	private static boolean condition(int base, int exponent) {		
		return new BigInteger("" + base).pow(exponent).toString().length() == exponent;
	}
}
