package problems.until049;

import java.util.ArrayList;

import problems.Utilities.EulerTimer;

public class Problem007 {

	static int limit = 10001;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		calculatePrimes();
		System.out.println(timer.timeElapsed() + "ms");
		System.out.println(primes.get(limit - 1));
	}
	
	private static void calculatePrimes() {
		int startingNumber = 0;
		primes.add(2);
		primes.add(3);
		for(int i = 1; i < limit; i++) {
			startingNumber = primes.get(i) + 2;
			boolean primeNotFound = true;
			for(int prime = startingNumber; primeNotFound; prime++) {
				if(isPrime(prime)) {
					primes.add(prime);
					primeNotFound = false;
				}
			}
		}
			
	}
	
	private static boolean isPrime(int prime) {
		for(int divisor = prime / 2; divisor > 1; divisor--)
			if(prime % divisor == 0)
				return false;
		return true;
	}
	
}
