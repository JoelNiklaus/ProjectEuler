package problems.until049;

// solved

public class Problem031 {

	public static void main(String[] args) {
		int limit = 200, result, counter = 0;
		for (int a = 0; a <= limit; a++)
			for (int b = 0; b <= limit / 2; b++)
				for (int c = 0; c <= limit / 5; c++)
					for (int d = 0; d <= limit / 10; d++)
						for (int e = 0; e <= limit / 20; e++)
							for (int f = 0; f <= limit / 50; f++)
								for (int g = 0; g <= limit / 100; g++)
									for (int h = 0; h <= limit / 200; h++) {
										result = a * 1 + b * 2 + c * 5 + d * 10 + e * 20 + f * 50
												+ g * 100 + h * 200;
										if (result == 200)
											counter++;
									}
		System.out.println(counter);
	}
}
