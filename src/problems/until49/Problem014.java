package problems.until49;

// solved

public class Problem014 {
	
	static int limit = 1000000;

	public static void main(String[] args) {
		int currentBest = 1;
		int bestStartingNumber = 1;
		for(int startingNumber = 1; startingNumber < limit; startingNumber++) {
			int number = buildSequence(startingNumber);
			if(number > currentBest) {
				currentBest = number;
				bestStartingNumber = startingNumber;
			}
		}
		System.out.println(bestStartingNumber + " " + currentBest);
	}

	private static int buildSequence(int startingNumber) {
		long number = startingNumber;
		int counter = 1;
		while(number > 1) {
			//System.out.println(number);
			counter++;
			number = nextCollatzNumber(number);
		}
		//System.out.println(1);
		//System.out.println("StartingNumber " + startingNumber + ": " + counter);
		return counter;
	}

	private static long nextCollatzNumber(long number) {
		if(number % 2 == 0)
			return number / 2;
		if(number % 2 == 1)
			return 3 * number + 1;
		return 0;
	}
}
