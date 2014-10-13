package problems.until49;

// solved

public class Problem006 {

	static int limit = 100;
	
	public static void main(String[] args) {
		System.out.println(squareOfSums() - sumOfSquares());
	}
	
	private static int sumOfSquares() {
		return (limit * (limit + 1) * (2 * limit + 1)) / 6;
	}
	
	private static int squareOfSums() {
		int sum = (limit * (limit + 1)) / 2;
		return sum * sum;
	}
	
}
