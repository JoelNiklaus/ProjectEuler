package problems.until149;

// do it using math ;)
public class Problem120NotYetSolved {

	static int limit = 1000;
	
	public static void main(String[] args) {
		long sum = 0;
		for (long a = 3; a <= limit; a++)
			sum += maxRemainder(a);
		System.out.println(sum);
	}
	
	private static long maxRemainder(long a) {
		long currentBest = 0;
		// TODO find better end of loop
		for (long n = 1; n < 4 * a; n++) {
			long remainder = remainder(a, n);
			if (remainder > currentBest)
				currentBest = remainder;
		}
		System.out.println("a = " + a + ", max r = " + currentBest);
		return currentBest;
	}
	
	private static long remainder(long a, long n) {
		return (long) ((Math.pow(a - 1, n) + Math.pow(a + 1, n)) % Math.pow(a, 2));
	}
	
}
