package problems.until099;

import java.io.IOException;
import java.util.ArrayList;

import problems.Utilities.Utility;

// solved

public class Problem067 {
	
	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p067_triangle.txt";
	private static ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		String triangleString = Utility.readFile(filePath);
		
		buildTriangle(triangleString);
		int nodeValue, leftParentValue, rightParentValue;
		// skip first row
		for (int row = 1; row < triangle.size(); row++)
			for (int col = 0; col < triangle.get(row).size(); col++)
				if (row - 1 >= 0) {
					nodeValue = triangle.get(row).get(col);
					// if left Parent does not exist: value + right Parent
					if (col - 1 < 0) {
						rightParentValue = triangle.get(row - 1).get(col);
						triangle.get(row).set(col, nodeValue + rightParentValue);
					}
					// if right Parent does not exist: value + left Parent
					else if (col > triangle.get(row - 1).size() - 1) {
						leftParentValue = triangle.get(row - 1).get(col - 1);
						triangle.get(row).set(col, nodeValue + leftParentValue);
					}
					// if both Parents exist: choose greater Parent value: value + greater Parent
					else {
						leftParentValue = triangle.get(row - 1).get(col - 1);
						rightParentValue = triangle.get(row - 1).get(col);
						if (rightParentValue > leftParentValue)
							triangle.get(row).set(col, nodeValue + rightParentValue);
						else
							triangle.get(row).set(col, nodeValue + leftParentValue);
					}
				}

		int currentBest = 0, currentValue;
		int lastRow = triangle.size() - 1;
		// find greatest node
		for (int col = 0; col < triangle.get(lastRow).size(); col++) {
			currentValue = triangle.get(lastRow).get(col);
			if (currentValue > currentBest)
				currentBest = currentValue;
		}

		System.out.println(triangleString);
		System.out.println(currentBest);
	}
	
	private static void buildTriangle(String triangleString) {
		String[] lines = triangleString.split(System.lineSeparator());
		String[] values;
		int row = 0;
		for (String line : lines) {
			values = line.split(" ");
			triangle.add(new ArrayList<Integer>());
			for (String value : values)
				triangle.get(row).add(Integer.parseInt(value));
			row++;
		}
	}

}
