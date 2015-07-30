package problems.until049;

import problems.Utilities.EulerTimer;

// solved

public class Problem010 {

	static int limit = 2000000;
	static long sum = 0;
	static boolean[] numbers = new boolean[limit + 1];
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		
		calculatePrimes();

		System.out.println(timer.timeElapsed() + "ms");
		System.out.println(sum);
	}
	
	private static void calculatePrimes() {
		for(int prime = 2; prime <= limit; prime++) {
			if(!numbers[prime]) {
				sum += prime;
				for(int multiple = 2*prime; multiple <= limit; multiple += prime)
					numbers[multiple] = true;
			}
		}
	}
	/* Old version -> very inefficient
	 * 
	 * 1256688ms = 20.9448 min 
	 * 1179908154
	 * 
	private static void calculatePrimes() {
		primes.add(2);
		for(int i = 3; i < limit; i += 2) {
			if(isPrime(i)) {
				primes.add(i);
				System.out.println(i);
			}
		}
	}
	
	private static boolean isPrime(int prime) {
		for(int divisor = prime / 2; divisor > 1; divisor--)
			if(prime % divisor == 0)
				return false;
		return true;
	}
	*/
}
