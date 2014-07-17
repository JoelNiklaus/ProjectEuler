package problems;

import problems.Utilities.Timer;

// not yet solved

public class Problem035NotYetSolved {

	static int limit = 1000000;
	static long sum = 0;
	static boolean[] numbers = new boolean[limit + 1];
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		calculatePrimes();
		for(int i = 2; i < numbers.length; i++) {
			if(isPrime(i))
				if(isCircularPrime(i))
					sum++;
		}

		System.out.println(timer.timeElapsed() + "ms");
		System.out.println(sum);
	}
	
	private static void calculatePrimes() {
		for(int i = 2; i <= limit; i++) {
			if(isPrime(i)) {
				for(int multiple = 2*i; multiple <= limit; multiple += i)
					numbers[multiple] = true; // multiple is not prime!
			}
		}
	}
	
	private static boolean isPrime(int number) {
		return !numbers[number];
	}
	
	private static boolean isCircularPrime(int number) {
		if(containsIllegalNumber(number))
			return false;
		for(int i = 0; i < (""+number).length() - 1; i++) {
			number = rotate(number);
			if(!isPrime(number))
				return false;
		}
		return true;
	}
	
	private static boolean containsIllegalNumber(int number) {
		String string = ""+number;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '0'
				|| string.charAt(i) == '2'
				|| string.charAt(i) == '4'
				|| string.charAt(i) == '5'
				|| string.charAt(i) == '6'
				|| string.charAt(i) == '8')
				return false;
		}
		return true;
	}
	
	private static int rotate(int number) {
		String string = ""+number;
		string += string.charAt(0);
		string = string.substring(1);
		return Integer.parseInt(string);
	}
}
