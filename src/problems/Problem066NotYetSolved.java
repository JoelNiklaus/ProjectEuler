package problems;

public class Problem066NotYetSolved {

	static int limit = 8;
	static int currentBestX = 0;
	static int currentBestD = 0;
	static int currentBestY = 0;
	
	public static void main(String[] args) {
		for (int D = 1; D < limit; D++)
			if (!isSquare(D))
				searchMinimum(D);
		System.out.println(currentBestX + "^2 - " + currentBestD + "x" + currentBestY + "^2 = 1");
	}
	
	// how search for minimal solutions?
	private static void searchMinimum(int D) {
		int bestX = 0, bestD = 0, bestY = 0;
		for (int x = 1; x < 20; x++)
			for (int y = 1; y < 20; y++)
				if (diophantine(x, D, y))
					if (x > bestX) {
						bestX = x;
						bestD = D;
						bestY = y;
					}
		if (bestX > currentBestX) {
			currentBestX = bestX;
			currentBestD = bestD;
			currentBestY = bestY;
		}
	}

	private static boolean diophantine(int x, int D, int y) {
		return x * x - D * y * y == 1;
	}
	
	private static boolean isSquare(int number) {
		return Math.sqrt(number) % 1 == 0;
	}
}
