package problems.until099;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;
import problems.Utilities.EulerUtility;

// solved

public class Problem053 {
	
	static long limit = 100;
	static BigInteger boundary = new BigInteger("1000000");
	static long sum = 0;

	public static void main(String[] args) {
		System.out.println(selectRFromN(new BigInteger("10"), new BigInteger("23")));
		for (long n = 20; n <= limit; n++)
			for (long r = 2; r < n - 1; r++) {
				EulerTimer timer = new EulerTimer();
				BigInteger result = selectRFromN(new BigInteger(r + ""), new BigInteger(n + ""));
				System.out.println("n = " + n + ", r = " + r + ", result = " + result + ", time: "
						+ timer.timeElapsed() + " ms");
				if (result.compareTo(boundary) == 1)
					sum++;
			}
		System.out.println(sum);
	}
	
	private static BigInteger selectRFromN(BigInteger r, BigInteger n) {
		return EulerUtility.factorial(n).divide(
				EulerUtility.factorial(r).multiply(EulerUtility.factorial(n.subtract(r))));
	}
}
