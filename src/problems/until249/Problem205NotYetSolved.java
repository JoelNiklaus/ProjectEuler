package problems.until249;

import problems.Utilities.EulerTimer;

public class Problem205NotYetSolved {
	
	// simple solution: 0.5172414
	
	public static double limit = 10000000;
	
	public static void main(String[] args) {
		EulerTimer timer = new EulerTimer();
		
		int sum = 0;

		for (int i = 0; i < limit; i++) {
			int peter = 0;
			for (int p = 0; p < 9; p++)
				peter += (int) (Math.random() * 4 + 1);
			int colin = 0;
			for (int c = 0; c < 6; c++)
				colin += (int) (Math.random() * 6 + 1);

			if (peter > colin)
				sum++;
		}

		System.out.println(sum / limit);
		System.out.println(timer.timeElapsed() + "ms");
	}
}
