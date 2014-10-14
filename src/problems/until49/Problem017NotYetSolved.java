package problems.until49;

public class Problem017NotYetSolved {
	
	static int limit = 1001;
	// contains length of numbers
	static int[] numbers = new int[limit];
	static int and = 3;
	static int hundred = 7;

	public static void main(String[] args) {
		init();
		buildNumbers();
		int sum = 0;
		for (int number : numbers)
			sum += number;
		System.out.println(sum);
	}
	
	private static void buildNumbers() {
		// fill all numbers 21 - 100
		for (int i = 21; i < 100; i++)
			numbers[i] = numbers[getTener(i)] + numbers[getOner(i)];
		// fill even hundreds
		for (int i = 100; i < 1000; i += 100)
			numbers[i] = numbers[i / 100] + hundred;
		// fill all numbers 100 - 1000
		for (int i = 101; i < 1000; i++)
			numbers[i] = numbers[getHundreder(i)] + and + numbers[getTener(i)]
					+ numbers[getOner(i)];
	}
	
	private static int getOner(int number) {
		String string = "" + number;
		return Integer.parseInt(string.substring(string.length() - 1, string.length()));
	}

	private static int getTener(int number) {
		String string = "" + number;
		return Integer.parseInt(string.substring(string.length() - 2, string.length() - 1) + "0");
	}
	
	private static int getHundreder(int number) {
		String string = "" + number;
		return Integer.parseInt(string.substring(string.length() - 3, string.length() - 2) + "00");
	}
	
	private static void init() {
		numbers[0] = 0;
		numbers[1] = 3;
		numbers[2] = 3;
		numbers[3] = 5;
		numbers[4] = 4;
		numbers[5] = 4;
		numbers[6] = 3;
		numbers[7] = 5;
		numbers[8] = 5;
		numbers[9] = 4;
		numbers[10] = 3;
		numbers[11] = 6;
		numbers[12] = 6;
		numbers[13] = 8;
		numbers[14] = 8;
		numbers[15] = 7;
		numbers[16] = 7;
		numbers[17] = 9;
		numbers[18] = 9;
		numbers[19] = 8;
		numbers[20] = 6;
		numbers[30] = 6;
		numbers[40] = 6;
		numbers[50] = 5;
		numbers[60] = 5;
		numbers[70] = 7;
		numbers[80] = 7;
		numbers[90] = 6;
		numbers[1000] = 11;
	}

}
