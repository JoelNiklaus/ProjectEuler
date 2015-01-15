package problems.until049;

import java.util.Stack;

// solved

public class Problem036 {

	static int sum = 0;
	static int limit = 1000000;
	
	public static void main(String[] args) {
		for(int i = 0; i < limit; i++)
			if(isPalindrome(i + ""))
				if(isPalindrome(Integer.toBinaryString(i)))
					sum += i;
		System.out.println(sum);
	}
	
	private static boolean isPalindrome(String number) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < number.length() / 2; i++)
			stack.push(number.charAt(i));
		for(int i = (number.length() + 1) / 2; i < number.length(); i++)
			if(!stack.pop().equals(number.charAt(i)))
				return false;
		return true;
	}
}
