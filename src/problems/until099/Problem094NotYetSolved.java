package problems.until099;

import problems.Utilities.EulerTimer;

public class Problem094NotYetSolved {

	static long limit = 1000000000;
	static long sum = 0;

	public static void main(String[] args) {
		System.out.println(isAlmostEquilateral(5, 6));

		EulerTimer timer = new EulerTimer();
		for (long a = 2; 3 * a < limit + 1; a++) {
			if (isAlmostEquilateral(a, a + 1))
				sum += 3 * a + 1;
			if (isAlmostEquilateral(a, a - 1))
				sum += 3 * a - 1;
			if (a % 10000000 == 0)
				System.out.println("a = " + a + ", sum = " + sum);
		}
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + "ms");
	}
	
	private static boolean isAlmostEquilateral(long a, long b) {
		double bHalf = b / 2.0;
		double area = Math.sqrt(a * a - bHalf * bHalf) * bHalf;
		System.out.println(area);
		return isInteger(area);
	}
	
	private static boolean isInteger(double area) {
		return area % 1 < 0.000001;
	}
}
