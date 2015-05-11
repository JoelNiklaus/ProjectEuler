package problems.until099;

import java.io.IOException;
import java.util.ArrayList;

import problems.Utilities.Utility;

//solved

public class Problem079 {

	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p079_keylog.txt";
	
	public static void main(String[] args) throws IOException {
		String keylog = Utility.readFile(filePath);
		String[] keys = keylog.split(System.lineSeparator());
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int[] ratings = new int[10];
		int[] counter = new int[10];
		for (String key : keys) {
			nums.add(Integer.parseInt(key));
			ratings[Integer.parseInt(key.substring(0, 1))] += 3;
			counter[Integer.parseInt(key.substring(0, 1))] += 1;

			ratings[Integer.parseInt(key.substring(1, 2))] += 2;
			counter[Integer.parseInt(key.substring(1, 2))] += 1;

			ratings[Integer.parseInt(key.substring(2, 3))] += 1;
			counter[Integer.parseInt(key.substring(2, 3))] += 1;
		}
		for (int i = 0; i < ratings.length; i++)
			if (i != 4 && i != 5)
				System.out.println(i + ": " + (double) ratings[i] / counter[i]);
	}
}
