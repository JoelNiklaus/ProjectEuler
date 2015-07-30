package problems.until099;

import problems.Utilities.BigFraction;

// solved

public class Problem057 {
	
	static int limit = 1000;
	static int sum = 0;
	
	public static void main(String[] args) {
		for (int i = 1; i < limit; i++) {
			BigFraction fraction = convergent(i);
			if (fraction.getNumerator().toString().length() > fraction.getDenominator().toString()
					.length())
				sum++;
			System.out.println(fraction);
		}
		System.out.println(sum);

	}

	private static BigFraction convergent(int n) {
		BigFraction fraction = new BigFraction(0);
		for (int i = n - 2; i >= 0; i--)
			fraction = BigFraction.ONE.divide(fraction.add(new BigFraction(2)));
		fraction = fraction.add(1);
		return fraction;
	}
}
