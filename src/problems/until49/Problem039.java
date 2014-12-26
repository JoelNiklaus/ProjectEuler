package problems.until49;

// solved

public class Problem039 {

	static int limit = 1000;
	static int currentBest = 0;
	static int currentBestNumberOfPossibilities = 0;
	static int numberOfPossibilities;
	
	public static void main(String[] args) {
		for (int p = 1; p <= limit; p++) {
			// int p = 120;
			numberOfPossibilities = 0;
			int a = 0, b = 0, c = 0;
			for (int u = 2; u * u < p; u++)
				for (int v = 1; v < u; v++)
					if ((u + v) % 2 == 1) {
						// find all primitive triples
						a = u * u - v * v;
						b = 2 * u * v;
						c = u * u + v * v;
						// System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", u = " +
						// u +
						// ", v = " + v);
						if (a + b + c == p) {
							numberOfPossibilities++;
							System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", u = "
									+ u + ", v = " + v);
						}
						// find all nonprimitive triples with sum < p
						int sum = 0;
						for (int i = 2; sum <= p; i++)
							sum = checkMultiple(a, b, c, p, i);
					}
			if (numberOfPossibilities > currentBestNumberOfPossibilities) {
				currentBestNumberOfPossibilities = numberOfPossibilities;
				currentBest = p;
			}
		}
		System.out.println(currentBest);
		System.out.println(currentBestNumberOfPossibilities);
	}

	public static int checkMultiple(int a, int b, int c, int p, int i) {
		a *= i;
		b *= i;
		c *= i;
		int sum = a + b + c;
		// System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		if (sum == p) {
			numberOfPossibilities++;
			System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		}
		return sum;
	}
	
}
