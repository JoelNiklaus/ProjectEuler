package problems.until049;

import java.util.ArrayList;

// solved

public class Problem024 {
	
	// Combinatorics
	static int n = 10;
	static int remain = 1000000 - 1;
	static String result = "";

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			numbers.add(i);
		
		for (int i = 1; i < n; i++) {
			int j = remain / faculty(n - i);
			remain = remain % faculty(n - i);
			result += numbers.get(j);
			numbers.remove(j);
			if (remain == 0)
				break;
		}

		for (int i = 0; i < numbers.size(); i++)
			result += numbers.get(i);

		System.out.println(result);
	}

	public static int faculty(int number) {
		if (number == 0)
			return 0;
		else if (number == 1)
			return 1;
		return number * faculty(number - 1);
	}

	// Brute Force
	// static int maxNumber = 3;
	// static ArrayList<Integer> current = new ArrayList<Integer>(maxNumber + 1);
	// static ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
	//
	// public static void main(String[] args) {
	// initCurrentNumber();
	// // Add the first permutation to the list
	// permutations.add(current);
	// permutations.add(permute(current, 1));
	// }
	//
	// public static ArrayList<Integer> permute(ArrayList<Integer> current, int jump) {
	// int lastIndex = current.size() - 1;
	// int lastElement = current.get(lastIndex);
	// for (int i = 0; i < jump; i++)
	// current.set(lastIndex - i, current.get(lastIndex - i - 1));
	// current.set(lastIndex - jump, lastElement);
	//
	// // if not already in there set temp as current and save to list.
	// if (!permutations.contains(current))
	// return current;
	// else
	// permute(current, jump + 1);
	// return current;
	// }
	//
	// public static int faculty(int number) {
	// if (number == 1)
	// return 1;
	// return number * faculty(number - 1);
	// }
	//
	// public static void initCurrentNumber() {
	// for (int i = 0; i <= maxNumber; i++)
	// current.add(i, i);
	// }
	//
}
