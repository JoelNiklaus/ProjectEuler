package problems.until099;

import java.io.IOException;
import java.util.ArrayList;

import problems.Utilities.EulerUtility;

//solved

public class Problem081 {
	
	static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p081_matrix.txt";
	
	public static void main(String[] args) throws IOException {
		String matrixString = EulerUtility.readFile(filePath);
		// matrixString =
		// "131,673,234,103,18\n201,96,342,965,150\n630,803,746,422,111\n537,699,497,121,956\n805,732,524,37,331";
		ArrayList<ArrayList<Integer>> matrix = convertToMatrix(matrixString);
		printMatrix(matrix);
		ArrayList<ArrayList<Integer>> summedMatrix = sumUpMatrix(matrix);
		printMatrix(summedMatrix);
	}
	
	private static ArrayList<ArrayList<Integer>> sumUpMatrix(ArrayList<ArrayList<Integer>> matrix) {
		ArrayList<ArrayList<Integer>> summedMatrix = new ArrayList<ArrayList<Integer>>();
		summedMatrix.add(new ArrayList<Integer>());
		summedMatrix.get(0).add(matrix.get(0).get(0));
		for (int col = 1; col < matrix.get(0).size(); col++)
			summedMatrix.get(0).add(summedMatrix.get(0).get(col - 1) + matrix.get(0).get(col));
		for (int row = 1; row < matrix.size(); row++) {
			summedMatrix.add(new ArrayList<Integer>());
			summedMatrix.get(row).add(summedMatrix.get(row - 1).get(0) + matrix.get(row).get(0));
		}
		
		for (int row = 1; row < matrix.size(); row++)
			for (int col = 1; col < matrix.get(0).size(); col++) {
				int top = summedMatrix.get(row - 1).get(col);
				int left = summedMatrix.get(row).get(col - 1);
				if (top < left)
					summedMatrix.get(row).add(top + matrix.get(row).get(col));
				else
					summedMatrix.get(row).add(left + matrix.get(row).get(col));
			}
		return summedMatrix;
	}
	
	private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
		for (int row = 0; row < matrix.size(); row++) {
			for (int col = 0; col < matrix.get(0).size(); col++)
				System.out.print(matrix.get(row).get(col) + ", ");
			System.out.println();
		}
	}
	
	private static ArrayList<ArrayList<Integer>> convertToMatrix(String string) {
		String[] lines = string.split(System.lineSeparator());
		String[] numbers = null;
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lineList = new ArrayList<Integer>();
		for (String line : lines) {
			numbers = line.split(",");
			for (String number : numbers)
				lineList.add(Integer.parseInt(number));
			matrix.add(lineList);
			lineList = new ArrayList<Integer>();
		}
		return matrix;
	}
}
