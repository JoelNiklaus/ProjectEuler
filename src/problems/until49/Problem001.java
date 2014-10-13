package problems.until49;

import java.util.ArrayList;

// solved

public class Problem001 {
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int sum = 0;
	static int firstNumber = 3;
	static int secondNumber = 5;
	static int limit = 1000;
	

	public static void main(String[] args) {
		addNumbers();
		
		for(int number : numbers)
			sum += number;
		
		System.out.println(sum);
	}

	private static void addNumbers() {
		for(int i = 0; i < limit; i++) {
			if(i % firstNumber == 0)
				numbers.add(i);
			if(!numbers.contains(i))
				if(i % secondNumber == 0)
					numbers.add(i);
		}
	}

}
