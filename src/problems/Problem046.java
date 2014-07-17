package problems;

import java.util.ArrayList;

import problems.Utilities.Primes;

// solved

public class Problem046 {

	static int limit = 100000;
	static ArrayList<Integer> oddComposites = new ArrayList<Integer>();
	static ArrayList<Integer> primes = Primes.getAllPrimes(limit);
	
	public static void main(String[] args) {
		fillOddComposites();
		for(int number : oddComposites)
			if(!isTrue(number))
				System.out.println(number);
	}

	private static boolean isTrue(int number) {
		int i = 1;
		int doubledSquare = 2;
		while(doubledSquare < number) {
			if(primes.contains(number - doubledSquare))
				return true;
			i++;
			doubledSquare = 2 * i * i;
		}
		return false;
	}

	private static void fillOddComposites() {
		for(int i = 3; i < limit; i+= 2)
			if(!primes.contains(i))
				oddComposites.add(i);
	}
	
}
