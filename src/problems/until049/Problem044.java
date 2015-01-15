package problems.until049;

import java.util.ArrayList;

// solved

public class Problem044 {

	static int numberOfPentagonals = 4000;
	static ArrayList<Long> pentagonals = new ArrayList<Long>(numberOfPentagonals);
	static long currentBest = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		computePentagonals();
		checkSumAndDifference();
		System.out.println(currentBest);
	}

	private static void checkSumAndDifference() {
		for(int i = 0; i < numberOfPentagonals; i++) {
			for(int j = 0; j < i; j++) {
				long pi = pentagonals.get(i);
				long pj = pentagonals.get(j);
				long difference = Math.abs(pi - pj);
				long sum = pi + pj;
				if(pentagonals.contains(difference) && pentagonals.contains(sum))
					if(difference < currentBest && difference > 0) {
						currentBest = difference;
						System.out.println("Pi = " + pi + ", Pj = " + pj );
					}	
			}
		}
	}
	
	private static void computePentagonals() {
		for(int i = 1; i <= numberOfPentagonals; i++)
			pentagonals.add((long) i * (3 * i - 1) / 2);
	}
	
}
