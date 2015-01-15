package problems.until049;

import java.math.BigInteger;

// solved

public class Problem016 {
	
	public static void main(String[] args) {
		BigInteger number = new BigInteger("2").pow(1000);
		String string = number.toString();
		System.out.println(string);
		long sum = 0;
		for(int i = 0; i < string.length(); i++)
			sum += Integer.parseInt(string.substring(i, i + 1));
		System.out.println(sum);
	}

}
