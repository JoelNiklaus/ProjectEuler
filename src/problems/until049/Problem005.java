package problems.until049;

import java.util.ArrayList;

// solved

public class Problem005 {

	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int limit = 20;
	
	public static void main(String[] args) {
		for(int i = 1; i <= limit; i++)
			numbers.add(i);

		int result = 0;
		int counter = 1;
		for(int i = 1; counter <= limit; i++) {
			for(int number : numbers) {
				if(i % number == 0)
					counter++;
				else {
					counter = 1;
					break;
				}
			}
			result = i;
		}
		
		System.out.println(result);
	}
	
}
