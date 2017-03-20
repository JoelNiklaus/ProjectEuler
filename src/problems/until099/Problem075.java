package problems.until099;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;

// solved

public class Problem075 {

	public static int limit = 1500000;

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();

		int sum = 0;
		int[] counters = new int[limit + 1];

		for (int u = 2; 2 * u * u + 2 * u <= limit; u++)
			for (int v = 1; v < u; v++)
				// get all primitive triplets
				if ((u + v) % 2 == 1
						&& new BigInteger(u + "").gcd(new BigInteger(v + ""))
								.equals(BigInteger.ONE)) {
					int x = u * u - v * v;
					int y = 2 * u * v;
					int z = u * u + v * v;
					int perimeter = x + y + z;
					for (int k = 1; true; k++) {
						int nextPerimeter = perimeter * k;
						if (nextPerimeter > limit)
							break;
						// System.out.println("nextPerimeter = " + nextPerimeter + ", u = " + u
						// + ", v = " + v + ", x = " + x + ", y = " + y + ", z = " + z);
						counters[nextPerimeter]++;
					}
				}
		for (int i = 0; i <= limit; i++)
			// System.out.println(i + ", " + counters[i]);
			if (counters[i] == 1)
				sum++;
		
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + "ms");
	}
}
