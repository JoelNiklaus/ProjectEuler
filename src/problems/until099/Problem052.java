package problems.until099;

import java.util.ArrayList;

// solved

public class Problem052 {

	public static void main(String[] args) {
		for (long i = 1; true; i++) {
			System.out.println(i);
			if (isPermutedMultiple(i)) {
				System.out.println("Number found: " + i);
				break;
			}
		}
	}

	public static boolean isPermutedMultiple(long i) {
		ArrayList<Long> list = convertlongToArrayList(i);
		for (long factor = 2; factor <= 6; factor++)
			if (!containsSameNumbers((ArrayList<Long>) list.clone(), i * factor))
				return false;
		return true;
	}
	
	private static boolean containsSameNumbers(ArrayList<Long> list, long multiple) {
		while (multiple > 0) {
			long lastNumber = multiple % 10;
			multiple /= 10;
			if (list.contains(lastNumber))
				list.remove(list.indexOf(lastNumber));
			else
				return false;
		}
		return true;
	}
	
	private static ArrayList<Long> convertlongToArrayList(long i) {
		ArrayList<Long> list = new ArrayList<Long>();
		while (i > 0) {
			list.add(i % 10);
			i /= 10;
		}
		return list;
	}

}
