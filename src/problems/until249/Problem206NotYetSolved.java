package problems.until249;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;

public class Problem206NotYetSolved {

	static BigInteger start = new BigInteger("1020304050607080900");
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		BigInteger sqrtCeil = sqrtCeil(start);
		
		System.out.println(sqrtCeil.pow(2));
		System.out.println(sqrtCeil.add(BigInteger.ONE).pow(2).subtract(sqrtCeil.pow(2)));
		
		String regex = "1\\d2\\d3\\d4\\d5\\d6\\d7\\d8[048]900";
		for (int i = 0; true; i++) {
			BigInteger square = sqrtCeil.add(new BigInteger(i + "")).pow(2);
			if (square.toString().matches(regex)) {
				System.out.println(square);
				break;
			}
		}

		System.out.println(timer.timeElapsed());
	}

	public static BigInteger sqrtFloor(BigInteger x) throws IllegalArgumentException {
		if (x.compareTo(BigInteger.ZERO) < 0)
			throw new IllegalArgumentException("Negative argument.");
		// square roots of 0 and 1 are trivial and
		// y == 0 will cause a divide-by-zero exception
		if (x.equals(BigInteger.ZERO) || x.equals(BigInteger.ONE))
			return x;
		BigInteger two = BigInteger.valueOf(2L);
		BigInteger y;
		// starting with y = x / 2 avoids magnitude issues with x squared
		for (y = x.divide(two); y.compareTo(x.divide(y)) > 0; y = x.divide(y).add(y).divide(two))
			;
		return y;
	}
	
	public static BigInteger sqrtCeil(BigInteger x) throws IllegalArgumentException {
		if (x.compareTo(BigInteger.ZERO) < 0)
			throw new IllegalArgumentException("Negative argument.");
		// square roots of 0 and 1 are trivial and
		// y == 0 will cause a divide-by-zero exception
		if (x == BigInteger.ZERO || x == BigInteger.ONE)
			return x;
		BigInteger two = BigInteger.valueOf(2L);
		BigInteger y;
		// starting with y = x / 2 avoids magnitude issues with x squared
		for (y = x.divide(two); y.compareTo(x.divide(y)) > 0; y = x.divide(y).add(y).divide(two))
			;
		if (x.compareTo(y.multiply(y)) == 0)
			return y;
		else
			return y.add(BigInteger.ONE);
	}
}
