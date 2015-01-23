package problems.until149;

import java.util.ArrayList;
import java.util.Comparator;

import problems.Utilities.Primes;

// solved

public class Problem124 {

	static int limit = 100000;
	static int index = 10000;
	static int primeLimit = limit;
	static ArrayList<Integer> primes = Primes.getAllPrimes(primeLimit);
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> radicals = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= limit; i++) {
			ArrayList<Integer> radical = new ArrayList<Integer>();
			radical.add(i);
			radical.add(radical(i));
			radicals.add(radical);
		}
		radicals.sort(new Comparator<ArrayList<Integer>>() {
			
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				int valueIndex = 1;
				return o1.get(valueIndex).compareTo(o2.get(valueIndex));
			}
		});
		System.out.println(radicals.get(index - 1).get(0));
	}
	
	private static int radical(int number) {
		int product = 1;
		ArrayList<Integer> primeFactors = Primes.getPrimeFactors(number, primes);
		for (int primeFactor : primeFactors)
			product *= primeFactor;
		return product;
	}
	
}
