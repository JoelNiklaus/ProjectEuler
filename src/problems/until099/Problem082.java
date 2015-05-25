package problems.until099;

import java.io.IOException;

import problems.Utilities.EulerUtility;

// solved

public class Problem082 {

	static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p082_matrix.txt";

	public static void main(String[] args) throws IOException {
		String matrixString = EulerUtility.readFile(filePath);
		// String matrixString =
		// "131,673,234,103,18\n201,96,342,965,150\n630,803,746,422,111\n537,699,497,121,956\n805,732,524,37,331";
		
		int[][] matrix = convertToMatrix(matrixString);
		printMatrix(matrix);
		int[][] summedMatrix = sumUpMatrix(matrix);
		printMatrix(summedMatrix);
		
		int currentBest = Integer.MAX_VALUE;
		int minimalPath = getMinimalPath(summedMatrix);
		if (minimalPath < currentBest)
			currentBest = minimalPath;
		System.out.println(currentBest);
	}
	
	private static int getMinimalPath(int[][] summedMatrix) {
		int currentBest = Integer.MAX_VALUE;
		for (int row = 0; row < summedMatrix.length; row++) {
			int currentValue = summedMatrix[row][summedMatrix[0].length - 1];
			if (currentValue < currentBest)
				currentBest = currentValue;
		}
		return currentBest;
	}

	private static int[][] sumUpMatrix(int[][] matrix) {
		int[][] summedMatrix = new int[matrix.length][matrix[0].length];
		
		for (int row = 0; row < matrix.length; row++)
			summedMatrix[row][0] = matrix[row][0];

		for (int col = 1; col < matrix[0].length; col++)
			for (int row = 0; row < matrix.length; row++) {
				int directLeft = summedMatrix[row][col - 1];
				int currentBest = directLeft;
				int temp = Integer.MAX_VALUE;
				int verticalPath = 0;
				for (int tempRow = row - 1; tempRow > 0; tempRow--) {
					verticalPath += matrix[tempRow][col];
					if (verticalPath > directLeft)
						break;
					temp = summedMatrix[tempRow][col - 1] + verticalPath;
					if (temp < currentBest)
						currentBest = temp;
				}
				temp = Integer.MAX_VALUE;
				verticalPath = 0;
				for (int tempRow = row + 1; tempRow < matrix.length; tempRow++) {
					verticalPath += matrix[tempRow][col];
					if (verticalPath > directLeft)
						break;
					temp = summedMatrix[tempRow][col - 1] + verticalPath;
					if (temp < currentBest)
						currentBest = temp;
				}
				summedMatrix[row][col] = currentBest + matrix[row][col];
			}
		
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
