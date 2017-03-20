package problems.until249;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;

public class Problem243NotYetSolved {

	static double finalLimit = 15499.0 / 94744;
	static double limit = 4.0 / 10;
	static int splitter = (int) Math.pow(2, 7);

	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		System.out.println(finalLimit);
		double resilience;
		long base = splitter * 3 * 5 * 7 * 11 * 13 * 17 * 19;
		for (long denominator = base; true; denominator += base) {
			resilience = numberOfResilients(denominator) / (denominator - 1.0);
			System.out.println(denominator + " -> " + resilience);
			if (resilience < finalLimit) {
				System.out.println(denominator);
				break;
			}
		}
		System.out.println(timer.timeElapsed() + " ms");
		// 48 -> 0.3404255319148936
		// 5460 -> 0.21102766074372595
		// 6480 -> 0.26670782528167924
		// 6528 -> 0.3137735559981615
		// 7680 -> 0.26670139341060034
		// 38798760 -> 0.17102402682518789
		// 3103900800 -> 0.17102402247231097
	}

	private static long numberOfResilients(long denominator) {
		long counter = 1;
		BigInteger denom = new BigInteger("" + denominator);
		for (long i = 2; i < denominator / splitter; i++)
			if (denom.gcd(new BigInteger("" + i)).intValue() == 1)
				counter++;
		return counter * splitter;
	}

}
