package problems.until099;

import java.io.IOException;

public class Problem085NotYetSolved {
	
	private static int goal = 2000000;
	private static int currentBest = Integer.MAX_VALUE;
	private static int currentBestArea = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		for (int i = 2; i < 100; i++)
			findNearestValueForStart(i);
		
		System.out.println(currentBest);
		System.out.println(currentBestArea);
	}

	public static void findNearestValueForStart(int start) {
		int sum = sum(start);
		int increment = sum + 0;
		int currentValue = sum + 0;
		int endLength = 0;
		
		for (int i = start; currentValue < goal; i++) {
			increment += sum;
			currentValue += increment;
			// System.out.println(start + " * " + i + " -> " + currentValue);
			endLength = i;
		}
		int valueAbove = currentValue - goal;
		int valueBelow = goal - (currentValue - increment);

		if (valueAbove < currentBest) {
			currentBest = valueAbove;
			currentBestArea = start * endLength;
		}
		if (valueBelow < currentBest) {
			currentBest = valueBelow;
			currentBestArea = start * (endLength - 1);
		}
		System.out.println("Start: " + start + ", Area: " + currentBestArea);
	}

	public static int sum(int number) {
		int sum = 1;
		for (int i = 2; i <= number; i++)
			sum += i;
		return sum;
	}
}
