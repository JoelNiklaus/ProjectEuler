package problems.until099;

import java.util.ArrayList;

public class Problem062NotYetSolved {

	static int start = 345;
	static int count = 0;
	static int limit = 5;

	// the permute function is way too slow -> use HashSet
	public static void main(String[] args) {
		for (long i = start; true; i++) {
			long number = (long) Math.pow(i, 3);
			count = 0;
			for (ArrayList<Long> list : permute(toLongArray(number)))
				if (isCube(toLong(list)))
					count++;
			if (count == limit) {
				System.out.println(number);
				break;
			}
			System.out.println("i = " + i + ", number = " + number
					+ ", count = " + count);
		}
	}

	private static boolean isCube(long number) {
		if (number == 1)
			return false;
		return Math.cbrt(number) % 1 == 0;
	}

	private static long[] toLongArray(long number) {
		String[] digitsStrings = Long.toString(number).split("");
		long[] result = new long[digitsStrings.length];
		for (int i = 0; i < digitsStrings.length; i++)
			result[i] = Long.parseLong(digitsStrings[i]);
		return result;
	}

	private static long toLong(ArrayList<Long> list) {
		String result = "";
		for (long digit : list)
			result += digit + "";
		return Long.parseLong(result);
	}

	private static ArrayList<ArrayList<Long>> permute(long[] num) {
		ArrayList<ArrayList<Long>> result = new ArrayList<ArrayList<Long>>();

		// start from an empty list
		result.add(new ArrayList<Long>());

		for (int i = 0; i < num.length; i++) {
			// list of list in current iteration of the array num
			ArrayList<ArrayList<Long>> current = new ArrayList<ArrayList<Long>>();

			for (ArrayList<Long> l : result)
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size() + 1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);

					ArrayList<Long> temp = new ArrayList<Long>(l);
					// NO DUPLICATIONS ensured but VERY inefficient!
					// if(!current.contains(temp))
					current.add(temp);

					// - remove num[i] add
					l.remove(j);
				}

			result = new ArrayList<ArrayList<Long>>(current);

		}

		return result;
	}

}
