package problems.until099;

import java.io.IOException;
import java.util.ArrayList;

import problems.Utilities.EulerUtility;

// solved

public class Problem059 {
	
	private static String filePath = "/Users/joelniklaus/Google Drive/Privat/Informatik/Java/ProjectEuler/src/problems/Files/p059_cipher.txt";
	private static boolean valid = true;
	private static int[] password = new int[3];
	private static int asciiLowerCaseA = 97;
	private static int asciiLowerCaseZ = 122;
	private static ArrayList<Integer> encrypted = new ArrayList<Integer>();
	private static ArrayList<Integer> decrypted = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		String cipherString = EulerUtility.readFile(filePath);
		
		for (String code : cipherString.split(","))
			encrypted.add(Integer.parseInt(code.trim()));

		int sum = 0;
		for (int a = asciiLowerCaseA; a <= asciiLowerCaseZ; a++)
			for (int b = asciiLowerCaseA; b <= asciiLowerCaseZ; b++)
				for (int c = asciiLowerCaseA; c <= asciiLowerCaseZ; c++) {
					decrypt(a, b, c);
					if (valid)
						sum++;
				}
		System.out.println(sum);
	}

	private static void decrypt(int a, int b, int c) {
		valid = true;
		decrypted = new ArrayList<Integer>();
		password[0] = a;
		password[1] = b;
		password[2] = c;
		for (int i = 0; i < encrypted.size(); i++) {
			int xor = password[i % 3] ^ encrypted.get(i);
			if (!isValidEnglishWordCharacterCode(xor)) {
				valid = false;
				return;
			}
			decrypted.add(xor);
		}
		System.out.println(decrypted.toString());
		System.out.println(convertToString(decrypted));
		sumUpAsciiCodes();
	}

	private static void sumUpAsciiCodes() {
		int sum = 0;
		for (int code : decrypted)
			sum += code;
		System.out.println("Sum: " + sum);
	}
	
	private static boolean isValidEnglishWordCharacterCode(int code) {
		// return code >= 32 && code <= 126 && code != 35 && code != 37 && code != 43 && code != 47;
		return (code >= 48 && code <= 57) || (code >= 65 && code <= 90)
				|| (code >= 97 && code <= 122) || code == 32 || code == 33 || code == 34
				|| code == 39 || code == 40 || code == 41 || code == 44 || code == 46 || code == 58
				|| code == 59 || code == 63 || code == 96 || code == 174 || code == 175;
	}

	private static String convertToString(ArrayList<Integer> codes) {
		String result = "";
		for (int code : codes)
			result += Character.toString((char) code);
		return result;
	}
}
