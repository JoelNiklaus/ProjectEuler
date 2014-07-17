package problems;

import java.util.ArrayList;

// solved

public class Problem045 {

	static ArrayList<Long> triangles = new ArrayList<Long>();
	static ArrayList<Long> pentagonals = new ArrayList<Long>();
	static ArrayList<Long> hexagonals = new ArrayList<Long>();
	static long limit = 2000000000;
	
	public static void main(String[] args) {
		computeTriangles();
		computePentagonals();
		computeHexagonals();
		for(long triangle : triangles)
			if(pentagonals.contains(triangle) && hexagonals.contains(triangle))
				System.out.println(triangle);
	}

	private static void computeTriangles() {
		long n = 1, triangle = 0;
		while(triangle < limit) {
			triangle = n * (n + 1) / 2;
			triangles.add(triangle);
			n++;
		}
	}
	
	private static void computePentagonals() {
		long n = 1, pentagonal = 0;
		while(pentagonal < limit) {
			pentagonal = n * (3 * n - 1) / 2;
			pentagonals.add(pentagonal);
			n++;
		}
	}
	
	private static void computeHexagonals() {
		long n = 1, hexagonal = 0;
		while(hexagonal < limit) {
			hexagonal = n * (2 * n - 1);
			hexagonals.add(hexagonal);
			n++;
		}
	}
}
