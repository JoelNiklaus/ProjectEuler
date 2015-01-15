package problems.until049;

// solved

public class Problem040 {

	static int limit = 1000000;
	static String number = "";
	
	public static void main(String[] args) {
		int counter = 1;
		for (int i = 1; number.length() <= limit; i++) {
			number += i;
			// System.out.println(number);
			if (number.length() >= counter) {
				System.out.println(number.charAt(counter - 1));
				counter *= 10;
			}
		}

	}
}