package problems;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

// solved

public class Problem022 {

	static long sum = 0;
	static String[] names;

	public static void main(String[] args) throws IOException {
		String nameString = readFile("/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/names.txt", Charset.defaultCharset());
		splitWordString(nameString);
		names = sort(names);
		
		for(int i = 0; i < names.length; i++)
			sum += score(i);
		System.out.println(sum);
	}

	private static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	private static void splitWordString(String nameString) {
		names = nameString.split(",");
		for(int i = 0; i < names.length; i++)
			names[i] = names[i].substring(1, names[i].length() - 1);
	}

	private static int score(int index) {
		int score = 0;
		for(char character : names[index].toCharArray())
			score += (int) character - 64;
		score *= index + 1;
		return score;
	}

	private static String[] sort(String[] array) {
		String tmp;
		for (int i = 0;i < array.length;i++) {
			tmp = array[i];
			for (int j = 0;j < array.length;j++) {
				if (i == j) continue;
				int x = tmp.compareTo(array[j]);
				if (x < 0) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		return array;
	}
}
