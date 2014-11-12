package problems.until49;

import java.math.BigInteger;

import problems.Utilities.Timer;

// solved

public class Problem048 {
	
	static int limit = 1000;
	static BigInteger sum = BigInteger.ZERO;

	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int i = 1; i <= limit; i++)
			sum = sum.add(new BigInteger(i + "").pow(i));
		System.out.println(sum);
		System.out.println(timer.timeElapsed() + "ms");
	}
}
