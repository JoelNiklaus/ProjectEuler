package problems.until099;

import java.math.BigInteger;

import problems.Utilities.EulerUtility;

// solved

public class Problem055 {

	static int limit = 10000;
	static int sum = 0;

	public static void main(String[] args) {
		for (int i = 1; i < limit; i++)
			if (isLychrel(new BigInteger("" + i)))
				sum++;
		System.out.println(sum);
	}
	
	private static boolean isLychrel(BigInteger number) {
		for (int i = 1; i < 50; i++) {
			number = number.add(new BigInteger(EulerUtility.reverse(number.toString())));
			if (EulerUtility.isPalindrome(number + ""))
				return false;
		}
		return true;
	}
}
