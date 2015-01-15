package problems.until049;

// solved

public class Problem003 {

	static long num = 600851475143L;
	
	public static void main(String[] args) {		
		long num = 600851475143L;
		long i = 2;
		while (num % i < num) {
			if (num % i == 0) {
				num = num / i;
				if (isPrime(num))
					System.out.println(num);
			}
			else
				i++;
		}
	}
	
	private static boolean isPrime(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
}
