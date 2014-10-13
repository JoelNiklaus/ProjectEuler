package problems.until49;

import problems.Utilities.Timer;

// solved

public class Problem034 {

	static int exponent = 5;
	static int limit = 10000000;
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		long sum = 0;
		for(int i = 10; i < limit; i++)
			if(i == sumOfDigitsFactorial(""+i)) {
				System.out.println("i = " + i);
				sum+= i;
			}
		
		System.out.println(timer.timeElapsed() + "ms");
		System.out.println(sum);
	}

	private static long sumOfDigitsFactorial(String number) {
		long sum = 0;
		for(int i = 0; i < number.length(); i++)
			sum += factorial(Integer.parseInt(number.substring(i, i + 1)));
		
		return sum;
	}
	
	public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
