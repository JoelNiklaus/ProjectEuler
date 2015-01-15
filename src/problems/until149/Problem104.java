package problems.until149;

import static problems.Utilities.Utility.isPandigital;

import java.math.BigInteger;

import problems.Utilities.Timer;

// solved

public class Problem104 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		BigInteger last = BigInteger.ONE;
		BigInteger forelast = BigInteger.ONE;
		BigInteger current = null;
		BigInteger tailcut = new BigInteger("1000000000");

		for (int k = 3; true; k++) {
			timer.reset();

			current = last.add(forelast);
			forelast = last;
			last = current;

			long tail = current.mod(tailcut).longValue();
			if (isPandigital(tail)) {
				System.out.println(k);
				int digits = current.toString().length();
				if (digits > 8) {
					long head = current.divide(new BigInteger("10").pow(digits - 9)).longValue();
					if (isPandigital(head)) {
						System.out.println(k);
						break;
					}
				}
			}
			
			// if (current.toString().length() > 8) {
			// String number = current.toString();
			// long lastDigits = lastNDigits(9, number);
			// if (isPandigital(lastDigits)) {
			// System.out.println(k);
			// long firstDigits = firstNDigits(9, number);
			// if (isPandigital(firstDigits)) {
			// System.out.println(k);
			// break;
			// }
			// }
			
			// System.out.println("first 9 Digits: " + firstDigits + ", last 9 Digits: "
			// + lastDigits + ", " + k + ": " + timer.timeElapsed() + " ms");
		}
	}
	
	// private static long firstNDigits(int i, String number) {
	// return Long.parseLong(number.substring(0, i));
	// }
	//
	// private static long lastNDigits(int i, String number) {
	// int length = number.length();
	// return Long.parseLong(number.substring(length - i, length));
	// }
	
}
