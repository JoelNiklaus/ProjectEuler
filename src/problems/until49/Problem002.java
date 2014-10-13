package problems.until49;

import java.util.ArrayList;

// solved

public class Problem002 {

	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int sum = 0;
	static int firstNumber = 1;
	static int secondNumber = 2;
	static int limit = 4000000;
	
	public static void main(String[] args) {
		fibonacci();
		
		for(int number : numbers)
			if(number % 2 == 0)
				sum += number;
		
		System.out.println(sum);
	}

	public static void fibonacci() {
		int currentNumber = 0;
		numbers.add(firstNumber);
		numbers.add(secondNumber);
		for(int i = 2; currentNumber <= limit; i++) {
			currentNumber = numbers.get(i - 2) + numbers.get(i - 1);
			numbers.add(i, currentNumber);
		}
	}
	
}
