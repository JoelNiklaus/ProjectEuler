package problems;

import problems.Utilities.Timer;

public class Problem094YetToCheck {

	static int limit = 1000000000;
	static long sum = 0;

	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int a = 2; 3 * a < limit; a++) {
			if (condition(a, a + 1))
				sum += 3 * a + 1;
			if (condition(a, a - 1))
				sum += 3 * a - 1;
			if (a % 100000 == 0)
				System.out.println("a = " + a + ", sum = " + sum);
		}
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + "ms");
	}
	
	private static boolean condition(int a, int b) {
		double bHalf = b / 2.0;
		double area = Math.sqrt(a * a - bHalf * bHalf) * bHalf;
		return isInteger(area);
	}
	
	private static boolean isInteger(double area) {
		return area % 1 == 0;
	}
}
