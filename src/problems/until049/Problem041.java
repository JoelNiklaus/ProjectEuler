package problems.until049;

import java.math.BigInteger;
import java.util.ArrayList;

// solved

public class Problem041 {

	private static ArrayList<Integer> pandigitals = new ArrayList<Integer>();

	public static void main(String[] args) {
		permutation(7654321);
		for (int pandigital : pandigitals)
			if (new BigInteger("" + pandigital).isProbablePrime(10)) {
				System.out.println(pandigital);
				break;
			}
	}

	public static void permutation(Integer integer) {
		permutation("", integer + "");
	}
	
	private static void permutation(String prefix, String number) {
		int n = number.length();
		if (n == 0)
			pandigitals.add(Integer.parseInt(prefix));
		else
			for (int i = 0; i < n; i++)
				permutation(prefix + number.charAt(i),
						number.substring(0, i) + number.substring(i + 1, n));
	}
}