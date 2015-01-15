package problems.until099;

import java.math.BigInteger;

// solved

public class Problem056 {
	
	static int limit = 100;
	static int currentBest = 0;
	
	public static void main(String[] args) {
		BigInteger number = null;
		for(int a = 1; a < limit; a++)
			for(int b = 1; b < limit; b++) {
				number = new BigInteger(a + "").pow(b);
				int sum = digitSum(number);
				if(sum > currentBest)
					currentBest = sum;
			}
		System.out.println(currentBest);
	}

	private static int digitSum(BigInteger number) {
		String string = number.toString();
		int sum = 0;
		for(int i = 0; i < string.length(); i++)
			sum += Integer.parseInt(string.substring(i, i + 1));
		return sum;
	}

}
