package problems.until049;

import java.util.ArrayList;

import problems.Utilities.Primes;

// solved

public class Problem047 {

	static int limit = 10000;
	static int magicNumber = 4;
	static int firstNumber = 0;
	
	public static void main(String[] args) {
		ArrayList<Integer> primes = Primes.getAllPrimes(limit);
		int count = 0;
		for(int i = 1; true; i++) {
			if(Primes.getPrimeFactors(i, primes).size() == magicNumber) {
				count++;
				if(count == 1)
					firstNumber = i;
			}
			else
				count = 0;
			if(count == magicNumber)
				break;
		}
		System.out.println(firstNumber);
	}
	
}
