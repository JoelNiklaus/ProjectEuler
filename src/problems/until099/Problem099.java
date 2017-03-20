package problems.until099;

import java.io.IOException;

import problems.Utilities.EulerUtility;

//solved

public class Problem099 {
	
	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p099_base_exp.txt";

	public static void main(String[] args) throws IOException {
		String base_exp = EulerUtility.readFile(filePath);

		double currentBest = 0;
		int lineNumber = 0;

		int lineCounter = 0;
		for (String line : base_exp.split(System.lineSeparator())) {
			String[] numbers = line.split(",");
			int base = Integer.parseInt(numbers[0]);
			int exponent = Integer.parseInt(numbers[1]);
			double result = exponent * Math.log(base);
			if (result > currentBest) {
				currentBest = result;
				lineNumber = lineCounter;
			}
			System.out.println(lineCounter + " -> " + result);
			lineCounter++;
		}
		System.out.println();
		System.out.println(base_exp);

		System.out.println(currentBest);
		System.out.println(lineNumber);
	}
}
