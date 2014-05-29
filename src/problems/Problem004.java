package problems;

import java.util.Stack;

// solved

public class Problem004 {

	static int product = 0;
	static int limitNumber = 999;
	
	public static void main(String[] args) {
		int currentBest = 0;
		for(int i = 0; i < limitNumber; i++) {
			for(int j = 0; j < limitNumber; j++) {
				product = (limitNumber - i) * (limitNumber - j);
				if(isPalindrome(""+product))
					if(product > currentBest)
						currentBest = product;
			}
		}
		System.out.println(currentBest);
	}
	
	private static boolean isPalindrome(String number) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < number.length() / 2; i++) {
			stack.push(number.charAt(i));
		}
		
		for(int i = (number.length() + 1) / 2; i < number.length(); i++) {
			if(!stack.pop().equals(number.charAt(i)))
				return false;
		}
		
		return true;
	}
}
