package problems.Utilities;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public final class EulerUtility {

	public static boolean isPandigital(long number) {
		String numberString = "" + number;
		if (numberString.length() > 9)
			return false;
		if (numberString.contains("0"))
			return false;
		boolean[] digits = new boolean[9];
		// add the digits
		while (number > 0) {
			long digit = number % 10 - 1;
			if (digits[(int) digit] == true)
				return false;
			digits[(int) digit] = true;
			number /= 10;
		}
		// check if there are all nine digits used
		for (int i = 0; i < digits.length; i++)
			if (digits[i] == false)
				return false;
		return true;
	}
	
	public static long lastDigit(long number) {
		return number % 10;
	}
	
	public static long firstDigit(long number) {
		while (number > 9)
			number /= 10;
		return number;
	}
	
	public static long factorial(long number) {
		if (number == 0)
			return 1;
		else
			return factorial(number - 1) * number;
	}
	
	public static BigInteger factorial(BigInteger number) {
		if (number.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else
			return factorial(number.subtract(BigInteger.ONE)).multiply(number);
	}
	
	public static boolean isPalindrome(String number) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < number.length() / 2; i++)
			stack.push(number.charAt(i));
		
		for (int i = (number.length() + 1) / 2; i < number.length(); i++)
			if (!stack.pop().equals(number.charAt(i)))
				return false;
		
		return true;
	}

	public static long reverse(long number) {
		String newNumberString = "";
		while (number > 0) {
			newNumberString += number % 10;
			number /= 10;
		}
		return Long.parseLong(newNumberString);
	}

	public static String reverse(String number) {
		String newNumberString = "";
		int length = number.length();
		for (int i = 0; i < length; i++)
			newNumberString += number.substring(length - i - 1, length - i);
		return newNumberString;
	}
	
	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, Charset.defaultCharset());
	}
	
	public static BigDecimal sqrt(BigDecimal in, int scale) {
		BigDecimal sqrt = new BigDecimal(1);
		sqrt.setScale(scale + 3, RoundingMode.FLOOR);
		BigDecimal store = new BigDecimal(in.toString());
		boolean first = true;
		do {
			if (!first)
				store = new BigDecimal(sqrt.toString());
			else
				first = false;
			store.setScale(scale + 3, RoundingMode.FLOOR);
			sqrt = in.divide(store, scale + 3, RoundingMode.FLOOR).add(store)
					.divide(BigDecimal.valueOf(2), scale + 3, RoundingMode.FLOOR);
		} while (!store.equals(sqrt));
		return sqrt.setScale(scale, RoundingMode.FLOOR);
	}

}
