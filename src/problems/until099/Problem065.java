package problems.until099;

import java.math.BigInteger;

import problems.Utilities.BigFraction;

// solved

public class Problem065 {
	
	static int start = 2;
	static int limit = 100;
	static int[] sequence = new int[limit];

	public static void main(String[] args) {
		computeSequence();
		BigFraction fraction = convergent(100);
		System.out.println(fraction);
		System.out.println(sumOfDigits(fraction.getNumerator()));
	}
	
	private static int sumOfDigits(BigInteger number) {
		int sum = 0;
		String numberString = number.toString();
		for (int i = 0; i < numberString.length(); i++)
			sum += Integer.parseInt(numberString.substring(i, i + 1));
		return sum;
	}

	private static BigFraction convergent(int n) {
		BigFraction fraction = new BigFraction(0);
		for (int i = n - 2; i >= 0; i--)
			fraction = BigFraction.ONE.divide(fraction.add(new BigFraction(sequence[i])));
		fraction = fraction.add(start);
		
		return fraction;
	}
	
	private static void computeSequence() {
		for (int i = 0; i < limit - 3; i += 3) {
			sequence[i] = 1;
			sequence[i + 1] = (i / 3 + 1) * 2;
			sequence[i + 2] = 1;
		}
		sequence[99] = 1;
	}
}
