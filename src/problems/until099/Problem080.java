package problems.until099;

import java.math.BigDecimal;

import problems.Utilities.EulerUtility;

// solved

public class Problem080 {

	// static String regex = "(\\d+)\1{2,}";
	static int limit = 100;
	static int sum = 0;
	static int counter = 0;
	
	public static void main(String[] args) {
		for (int i = 1; i <= limit; i++)
			sum += getIrrationalSquareRootDecimalDigitsSum(new BigDecimal("" + i).setScale(100));
		System.out.println(sum);
		System.out.println(counter);
	}
	
	/**
	 * Gets the sum of the first hundred decimal digits of the irrational square root of the number
	 * if existing, returns 0 if the square root is rational
	 *
	 * @param number
	 * @return
	 */
	private static int getIrrationalSquareRootDecimalDigitsSum(BigDecimal number) {
		BigDecimal sqrt = EulerUtility.sqrt(number, 99);
		String decimalDigits = sqrt.unscaledValue().toString();
		if (decimalDigits.contains("00000"))
			return 0;

		System.out.println(decimalDigits);
		counter++;
		int sum = 0;
		for (int i = 0; i < decimalDigits.length(); i++)
			sum += Integer.parseInt(decimalDigits.substring(i, i + 1));
		System.out.println(sum);
		return sum;
	}
}
