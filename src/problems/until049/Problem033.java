package problems.until049;

import java.util.ArrayList;

import problems.Utilities.BigFraction;

// solved

public class Problem033 {
	
	public static void main(String[] args) {
		ArrayList<BigFraction> fractions = findNonTrivialDigitCancellingFractions();
		BigFraction product = new BigFraction(1);
		for (BigFraction fraction : fractions)
			product = fraction.multiply(product);
		System.out.println(product.getDenominator());
	}
	
	private static ArrayList<BigFraction> findNonTrivialDigitCancellingFractions() {
		ArrayList<BigFraction> fractions = new ArrayList<BigFraction>();
		for (int denominator = 10; denominator < 100; denominator++)
			for (int numerator = 10; numerator < denominator; numerator++)
				if (isNonTrivialDigitCancellingFraction(numerator, denominator))
					fractions.add(new BigFraction(numerator, denominator));
		return fractions;
	}
	
	private static boolean isNonTrivialDigitCancellingFraction(int numerator, int denominator) {
		int numeratorFirst = numerator / 10;
		int numeratorSecond = numerator % 10;
		int denominatorFirst = denominator / 10;
		int denominatorSecond = denominator % 10;

		if (numeratorSecond == 0 && denominatorSecond == 0)
			return false;
		
		if (numeratorSecond == denominatorFirst)
			if (denominatorSecond != 0) {
				BigFraction original = new BigFraction(numerator, denominator);
				BigFraction cancelled = new BigFraction(numeratorFirst, denominatorSecond);
				if (original.equals(cancelled)) {
					System.out.println(numerator + "/" + denominator);
					return true;
				}
			}
		
		return false;
	}
}
