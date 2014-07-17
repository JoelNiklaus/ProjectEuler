package problems;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

// solved

public class Problem042 {

	static int numberOfTriangles = 100;
	static int[] triangles = new int[numberOfTriangles];
	static int sum = 0;
	static String[] words = new String[4];
	
	public static void main(String[] args) throws IOException {
		computeTriangles();
		for(int triangle : triangles)
			System.out.println(triangle);
		String wordString = readFile("/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/words.txt", Charset.defaultCharset());
		splitWordString(wordString);
		for(String word : words) {
			System.out.println(word);
			if(isTriangleWord(word))
				sum++;
		}
		System.out.println(sum);
	}
	
	private static void computeTriangles() {
		for(int i = 1; i <= numberOfTriangles; i++)
			triangles[i - 1] = i * (i + 1) / 2;
	}
	
	private static void splitWordString(String wordString) {
		words = wordString.split(",");
		for(int i = 0; i < words.length; i++)
			words[i] = words[i].substring(1, words[i].length() - 1);
	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	private static boolean isTriangleWord(String word) {
		int score = 0;
		for(char character : word.toCharArray())
			score += (int) character - 64;
		for(int triangle : triangles)
			if(score == triangle)
				return true;
		return false;
	}
}
