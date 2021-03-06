package problems.until049;

import problems.Utilities.EulerTimer;

// solved

public class Problem030 {

	static int exponent = 5;
	static int limit = 10000000;
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		
		long sum = 0;
		for(int i = 10; i < limit; i++)
			if(i == sumOfDigitsPowers(""+i)) {
				System.out.println("i = " + i);
				sum+= i;
			}
		
		System.out.println(timer.timeElapsed() + "ms");
		System.out.println(sum);
	}

	private static long sumOfDigitsPowers(String number) {
		long sum = 0;
		for(int i = 0; i < number.length(); i++)
			sum += (long) Math.pow(Integer.parseInt(number.substring(i, i + 1)), exponent);
		return sum;
	}
}
