package problems;

// solved

public class Problem009 {
	
	static int limit = 500;
		
	public static void main(String[] args) {
		int a = 1, b = 1, c = 1, solution;
		boolean resultNotFound = true;
		
		for(int i = 1; resultNotFound && i < limit; i++)
			for(int j = 1; resultNotFound && j < limit; j++) {
				if(resultingEquation(i, j)) {
					a = i;
					b = j;
					resultNotFound = false;
				}
				System.out.println("i = " + i + ", j = " + j);
			}
				
		c = 1000 - a - b;
		
		solution = a * b * c;
		System.out.println(solution);
	}
	
	private static boolean resultingEquation(int a, int b) {
		return 1000 == a + b + Math.sqrt(a * a + b * b);
	}
	
	/*
	private static boolean sumEquation(int a, int b, int c) {
		return 1000 == a + b + c;
	}
	
	private static boolean pythagoreanEquation(int a, int b, int c) {
		return a * a + b * b == c * c;
	}
	*/
}
