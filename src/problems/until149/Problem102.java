package problems.until149;

import java.io.IOException;

import problems.Utilities.EulerUtility;

// solved

public class Problem102 {
	
	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p102_triangles.txt";

	public static void main(String[] args) throws IOException {
		int sum = 1;
		String trianglesString = EulerUtility.readFile(filePath);
		for (String triangle : trianglesString.split(System.lineSeparator())) {
			String ordinates[] = triangle.split(",");
			int x1 = Integer.parseInt(ordinates[0]);
			int y1 = Integer.parseInt(ordinates[1]);
			int x2 = Integer.parseInt(ordinates[2]);
			int y2 = Integer.parseInt(ordinates[3]);
			int x3 = Integer.parseInt(ordinates[4]);
			int y3 = Integer.parseInt(ordinates[5]);

			double zeroX1 = 0;
			if (y1 * y2 < 0)
				if (x1 == x2)
					zeroX1 = x1;
				else {
					double m1 = ((double) y1 - y2) / (x1 - x2);
					zeroX1 = x1 - y1 / m1;
				}

			double zeroX2 = 0;
			if (y2 * y3 < 0)
				if (x2 == x3)
					zeroX2 = x2;
				else {
					double m2 = ((double) y2 - y3) / (x2 - x3);
					zeroX2 = x2 - y2 / m2;
				}

			double zeroX3 = 0;
			if (y3 * y1 < 0)
				if (x3 == x1)
					zeroX3 = x3;
				else {
					double m3 = ((double) y3 - y1) / (x3 - x1);
					zeroX3 = x3 - y3 / m3;
				}
			
			boolean flag = false;
			if (zeroX1 * zeroX2 < 0 || zeroX2 * zeroX3 < 0 || zeroX3 * zeroX1 < 0) {
				sum++;
				flag = true;
			}
			System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2 + ", " + x3 + ", " + y3
					+ ", " + zeroX1 + ", " + zeroX2 + ", " + zeroX3 + ", " + flag);
		}
		System.out.println(sum);
	}
}
