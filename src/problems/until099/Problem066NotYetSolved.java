package problems.until099;

import problems.Utilities.EulerTimer;

public class Problem066NotYetSolved {

	static long limit = 1000;
	static long currentBestX = 0;
	static long currentBestD = 0;
	static long currentBestY = 0;
	
	public static void main(String[] args) {
		System.out.println(isInteger(3.000700));
		EulerTimer timer = new EulerTimer();
		for (int D = 1; D <= limit; D++)
			if (!isSquare(D))
				searchMinimum(D);
		System.out.println(currentBestX + "^2 - " + currentBestD + "x" + currentBestY + "^2 = 1");
		System.out.println(timer.timeElapsed() + "ms");
	}
	
	private static void searchMinimum(int D) {
		for (int x = 2; true; x++)
			if (isInteger(getDiophantineY(x, D))) {
				int y = (int) getDiophantineY(x, D);
				if (x > currentBestX) {
					currentBestX = x;
					currentBestD = D;
					currentBestY = y;
				}
				System.out.println(x + "^2 - " + D + "x" + y + "^2 = 1");
				return;
			}
	}
	
	private static boolean isInteger(double number) {
		return number - (int) number < 0.00000001;
	}
	
	private static double getDiophantineY(int x, long D) {
		return Math.sqrt((x * x - 1.0) / D);
	}
	
	private static boolean isSquare(int number) {
		return Math.sqrt(number) % 1 == 0;
	}
}
