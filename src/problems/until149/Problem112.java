package problems.until149;

// solved

public class Problem112 {

	public static void main(String[] args) {
		int bouncies = 0;
		boolean foundSolution = false;
		double goalPercentage = 0.99;
		double realPercentage;
		for (int i = 1; !foundSolution; i++) {
			if (isBouncyInefficient(i))
				bouncies++;
			realPercentage = (double) bouncies / i;
			// System.out.println(i + ", " + realPercentage);
			if (realPercentage >= goalPercentage) {
				System.out.println(i);
				foundSolution = true;
			}
		}
		// System.out.println(bouncies);
	}
	
	private static boolean isBouncyInefficient(int number) {
		return !isDecreasing(number) && !isIncreasing(number);
	}

	private static boolean isDecreasing(int number) {
		int lastDigit;
		while (number > 9) {
			lastDigit = number % 10;
			number /= 10;
			if (number % 10 < lastDigit)
				return false;
		}
		return true;
	}

	private static boolean isIncreasing(int number) {
		int lastDigit;
		while (number > 9) {
			lastDigit = number % 10;
			number /= 10;
			if (number % 10 > lastDigit)
				return false;
		}
		return true;
	}
	
}
