package problems.until099;

import java.util.LinkedList;

public class Problem088NotYetSolved {
	
	static int start = 2;
	static int end = 12;
	static int sum = 0;
	static LinkedList<Integer> sums = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		for (int i = start; i <= end; i++) {
			int minimalProductSum = findMinimumProductSum(i);
			if (!sums.contains(minimalProductSum)) {
				sums.add(minimalProductSum);
				sum += minimalProductSum;
			}
		}
	}
	
	private static int findMinimumProductSum(int k) {
		int currentBest = Integer.MAX_VALUE;
		
		return currentBest;
	}
}
