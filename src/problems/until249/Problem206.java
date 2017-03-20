package problems.until249;

import java.math.BigInteger;

import problems.Utilities.EulerTimer;

public class Problem206 {

	static BigInteger start = new BigInteger("138902663"); // sqrt(19293949596979899)
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		
		String regex = "1\\d2\\d3\\d4\\d5\\d6\\d7\\d8[048]9";
		for (BigInteger i = start; true; i = i.subtract(new BigInteger("2"))) {
			BigInteger square = new BigInteger(i + "").pow(2);
			System.out.println(square);
			if (square.toString().matches(regex)) {
				System.out.println(i + "0");
				break;
			}
		}

		System.out.println(timer.timeElapsed());
	}
}
