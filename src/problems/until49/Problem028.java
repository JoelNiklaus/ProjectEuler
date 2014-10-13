package problems.until49;

// solved

public class Problem028 {
	
	static int edges = 4;
	static long sum = 1;
	static int spiral = 1001;

	public static void main(String[] args) {
		long currentNumber = 1;
		int increment = 2;
		int rings = (spiral - 1) / 2;
		for(int i = 0; i < rings; i++) {
			currentNumber = addRing(currentNumber, increment);
			increment += 2;
		}
		
		System.out.println(sum);
	}
	
	private static long addRing(long currentNumber, int increment) {
		for(int i = 0; i < edges; i++) {
			currentNumber += increment;
			sum += currentNumber;
		}
		return currentNumber;
	}
}
