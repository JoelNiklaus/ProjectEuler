package problems.until49;


public class Problem039NotYetSolvedPythagoreanTriples {

	static int limit = 1000;
	static int currentBest = 0;
	static int currentBestNumberOfPossibilities = 0;
	
	// noch nicht alle Tripel sind hier enthalten!
	public static void main(String[] args) {
		//for(int p = 1; p <= limit; p++) {
		int p = 120;
			int numberOfPossiblities = 0;
			int a = 0, b = 0, c = 0;
			for(int x = 2; x * x < p; x++)
				for(int y = 1; y < x; y ++) {
					a = x * x - y * y;
					b = 2 * x * y;
					c = x * x + y * y;
					System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", x = " + x + ", y = " + y);
					if((a + b + c) == p)
						numberOfPossiblities++;
				}
			if(numberOfPossiblities > currentBestNumberOfPossibilities) {
				currentBestNumberOfPossibilities = numberOfPossiblities;
				currentBest = p;
			}	
		//}
		System.out.println(currentBest);
		System.out.println(currentBestNumberOfPossibilities);
	}
}
