package problems.until099;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;


public class Problem099NotYetSolved {

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		BigInteger bigPrime = new BigInteger("3870129");
		int exponent = 7830457;
		bigPrime = bigPrime.pow(exponent);
		System.out.println(bigPrime.toString());
		System.out.println(timer.timeElapsed() + "ms");
	}

}
