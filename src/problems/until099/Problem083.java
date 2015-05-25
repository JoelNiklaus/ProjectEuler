package problems.until099;

import java.io.IOException;
import java.util.LinkedList;

import problems.Utilities.EulerUtility;

// solved

public class Problem083 {
	
	static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p083_matrix.txt";
	static LinkedList<Integer> usedSmallestValue = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		String matrixString = EulerUtility.readFile(filePath);
		// String matrixString =
		// "131,673,234,103,18\n201,96,342,965,150\n630,803,746,422,111\n537,699,497,121,956\n805,732,524,37,331";

		int[][] matrix = convertToMatrix(matrixString);
		printMatrix(matrix);
		int[][] summedMatrix = sumUpMatrix(matrix);
		printMatrix(summedMatrix);
	}
	
	private static int[][] sumUpMatrix(int[][] matrix) {
		int[][] summedMatrix = new int[matrix.length][matrix[0].length];

		summedMatrix[0][0] = matrix[0][0];
		
		while (true) {
			summedMatrix = setNeighborsOfSmallestValue(matrix, summedMatrix);
			int bottomRight = summedMatrix[summedMatrix.length - 1][summedMatrix[0].length - 1];
			if (bottomRight != 0) {
				System.out.println(bottomRight);
				break;
			}
		}
		
		return summedMatrix;
	}

	private static int[][] setNeighborsOfSmallestValue(int[][] matrix, int[][] summedMatrix) {
		int smallestValue = Integer.MAX_VALUE;
		int smallestValueRow = 0;
		int smallestValueCol = 0;
		for (int row = 0; row < summedMatrix.length; row++)
			for (int col = 0; col < summedMatrix[0].length; col++) {
				int tempValue = summedMatrix[row][col];
				if (tempValue != 0 && tempValue < smallestValue
						&& !usedSmallestValue.contains(tempValue)) {
					smallestValue = tempValue;
					smallestValueRow = row;
					smallestValueCol = col;
				}
			}
		usedSmallestValue.add(smallestValue);
		int tempRow, tempCol;

		// top neighbor
		tempRow = smallestValueRow - 1;
		tempCol = smallestValueCol;
		if (tempRow >= 0 && summedMatrix[tempRow][tempCol] == 0)
			summedMatrix[tempRow][tempCol] = smallestValue + matrix[tempRow][tempCol];

		// left neighbor
		tempRow = smallestValueRow;
		tempCol = smallestValueCol - 1;
		if (tempCol >= 0 && summedMatrix[tempRow][tempCol] == 0)
			summedMatrix[tempRow][tempCol] = smallestValue + matrix[tempRow][tempCol];

		// bottom neighbor
		tempRow = smallestValueRow + 1;
		tempCol = smallestValueCol;
		if (tempRow < summedMatrix.length && summedMatrix[tempRow][tempCol] == 0)
			summedMatrix[tempRow][tempCol] = smallestValue + matrix[tempRow][tempCol];
		
		// right neighbor
		tempRow = smallestValueRow;
		tempCol = smallestValueCol + 1;
		if (tempCol < summedMatrix[0].length && summedMatrix[tempRow][tempCol] == 0)
			summedMatrix[tempRow][tempCol] = smallestValue + matrix[tempRow][tempCol];

		return summedMatrix;
	}
	
	private static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++)
				System.out.print(matrix[row][col] + ", ");
			System.out.println();
		}
		System.out.println();
	}
	
	private static int[][] convertToMatrix(String string) {
		String[] rows = string.split(System.lineSeparator());
		int[][] matrix = new int[rows.length][rows[0].split(",").length];
		for (int row = 0; row < rows.length; row++) {
			String[] cols = rows[row].split(",");
			for (int col = 0; col < cols.length; col++)
				matrix[row][col] = Integer.parseInt(cols[col]);
		}
		return matrix;
	}
}
