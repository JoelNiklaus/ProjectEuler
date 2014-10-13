package problems.until49;

// solved

public class Problem015 {
	
	static int size = 21; // -> 2 x 2 grid

	public static void main(String[] args) {
		long[][] matrix = new long[size][size];
		init(matrix);
		int curY = 1;
		for(int x = 1; x < size; x++) {
			matrix[x][curY] = matrix[x - 1][curY] * 2;
			curY++;
			for(int y = curY; y < size; y++) {
				matrix[x][y] = matrix[x - 1][y] + matrix[x][y - 1];
			}
		}
		System.out.println(matrix[size - 1][size - 1]);
			
	}

	private static void init(long[][] matrix) {
		for(int y = 0; y < size; y++)
			matrix[0][y] = 1;
	}

}
