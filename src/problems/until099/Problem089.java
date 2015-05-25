package problems.until099;

import java.io.IOException;

import problems.Utilities.EulerUtility;

//solved

public class Problem089 {
	
	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p089_roman.txt";
	private static int sum;

	public static void main(String[] args) throws IOException {
		String roman = EulerUtility.readFile(filePath);
		
		// Solution 1: Regex
		String pattern = "DCCCC|LXXXX|VIIII|CCCC|XXXX|IIII";
		String replacement = "kk";
		int result = roman.length() - roman.replaceAll(pattern, replacement).length();
		System.out.println(result);

		// Solution 2: Loops
		String[] numbers = roman.split(System.lineSeparator());
		for (String number : numbers)
			reduceNumberOfCharacters(number);

		System.out.println(sum);
	}
	
	private static void reduceNumberOfCharacters(String number) {
		checkFourOccurences(number, 'I', 'V');
		checkFourOccurences(number, 'X', 'L');
		checkFourOccurences(number, 'C', 'D');
	}
	
	private static void checkFourOccurences(String number, char literal, char literalBefore) {
		int counter = 0;
		for (int i = 0; i < number.length(); i++)
			if (number.charAt(i) == literal) {
				counter++;
				if (counter == 4)
					if (i - 4 >= 0) {
						if (number.charAt(i - 4) == literalBefore)
							sum += 3;
					} else
						sum += 2;
			} else
				counter = 0;
	}
}
