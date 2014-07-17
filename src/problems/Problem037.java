package problems;

import java.util.ArrayList;

import problems.Utilities.Primes;

// solved

public class Problem037 {

	static int numberOfTruncatables = 11;
	static ArrayList<Integer> truncatables = new ArrayList<Integer>(numberOfTruncatables);
	static int limit = 10000000;
	static int sum;
	static ArrayList<Integer> primes = Primes.getAllPrimes(limit);

	public static void main(String[] args) {
		for(int prime : primes) {
			if(prime > 10 && isTruncatable(prime)) {
				truncatables.add(prime);
				System.out.println(prime);
				if(truncatables.size() >= numberOfTruncatables)
					break;
			}	
		}

		for(int truncatable : truncatables)
			sum += truncatable;
		System.out.println(sum);
	}

	private static boolean isTruncatable(int prime) {
		String primeString = "" + prime;
		if(Integer.parseInt(primeString.substring(0, 1)) == 1)
			return false;
		if(Integer.parseInt(primeString.substring(primeString.length() - 1, primeString.length())) == 1)
			return false;
		
		int newNumber = prime;
		while(newNumber > 10) {
			newNumber = leftTruncatedNumber(newNumber);
			if(!primes.contains(newNumber))
				return false;
		}		
		newNumber = prime;
		while(newNumber > 10) {
			newNumber = rightTruncatedNumber(newNumber);
			if(!primes.contains(newNumber))
				return false;
		}
		return true;
	}

	private static int rightTruncatedNumber(int number) {
		return number / 10;
	}

	private static int leftTruncatedNumber(int number) {
		return Integer.parseInt(("" + number).substring(1));
	}

}
