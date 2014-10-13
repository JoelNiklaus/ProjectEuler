package problems.until99;

import java.util.ArrayList;

import problems.Utilities.Primes;

//solved

public class Problem050 {

	static int limit = 1000000;
	static int currentBestNumber = 0;
	static int currentBestCount = 0;
	static ArrayList<Integer> primes = Primes.getAllPrimes(limit);
	
	public static void main(String[] args) {
		for(int prime : primes) {
			for(int primeIndex = 0; primes.get(primeIndex) < prime; primeIndex++)
				checkConsecutivePrimesSum(prime, primeIndex);
			//System.out.println(prime);
		}
		System.out.println(currentBestCount);
		System.out.println(currentBestNumber);
	}

	private static void checkConsecutivePrimesSum(int prime, int primeIndex) {
		int i = primeIndex;
		int sum = 0;
		int count = 0;
		while(sum < prime) {
			sum += primes.get(i);
			i++;
			count++;
			if(sum == prime && count > currentBestCount) {
				currentBestCount = count;
				currentBestNumber = sum;
			}		
		}
	}
	
}
