package problems.until49;

import java.math.BigInteger;
import java.util.ArrayList;

// solved

public class Problem029 {
	
	static BigInteger lowerBound = new BigInteger("2");
	static BigInteger upperBound = new BigInteger("101"); // 100
	static ArrayList<BigInteger> list = new ArrayList<BigInteger>();

	public static void main(String[] args) {
		for(BigInteger i = lowerBound; i.compareTo(upperBound) == -1; i = i.add(BigInteger.ONE))
			for(BigInteger j = lowerBound; j.compareTo(upperBound) == -1; j = j.add(BigInteger.ONE)) {
				BigInteger power = i.pow(j.intValue());
				if(!list.contains(power))
					list.add(power);
			}
		System.out.println(list.size());
	}
}
