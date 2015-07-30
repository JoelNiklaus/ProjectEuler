package problems.until099;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;

// solved

public class Problem097 {

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		BigInteger bigPrime = new BigInteger("2");
		int exponent = 7830457;
		int factor = 28433;
		bigPrime = bigPrime.pow(exponent);
		bigPrime = bigPrime.multiply(new BigInteger(factor + ""));
		bigPrime = bigPrime.add(BigInteger.ONE);
		bigPrime = bigPrime.mod(new BigInteger("10000000000"));
		System.out.println(bigPrime.toString());
		System.out.println(timer.timeElapsed() + "ms");
	}

}
