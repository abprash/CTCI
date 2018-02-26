package a_stringsAndArrays;

import java.util.Arrays;

public class URLify {
	
	public static char[] urlify2(char[] testWords) {
		// did not work yet
		// char[] temp = new char[20];
		// String s1 = "mr john %20smith ";
		// String s2 = "error stringy df ";
		String s1 = new String(testWords);
		for (int i = 0; i < s1.length(); i++) {
			testWords[i] = s1.charAt(i);
		}
		int lastLetterPosition = 0;
		int spaceCounter = 0;
		// find where the last word ends in the string
		for (int i = s1.length() - 1; i >= 0; i--) {
			if (s1.charAt(i) != ' ' && lastLetterPosition == 0) {
				lastLetterPosition = i;
			}
			if (lastLetterPosition > 0) {
				// start counting spaces
				if (s1.charAt(i) == ' ')
					spaceCounter++;
			}
		}
		System.out.println("LL " + lastLetterPosition);
		System.out.println("SC " + spaceCounter);
		int l = lastLetterPosition;
		int r = testWords.length - 1;
		while (spaceCounter > 0) {
			// should break out when spaceCounter = 0,
			if (testWords[l] == ' ')
				spaceCounter--;
			if (testWords[l] != ' ' && testWords[r] == ' ') {
				testWords[r] = testWords[l];
				testWords[l] = ' ';
				l--;
				r--;
			} else if (testWords[l] == ' ' && testWords[r] == ' ') {
				testWords[r] = '0';
				testWords[r - 1] = '2';
				testWords[r - 2] = '%';
				r = r - 3;
				l--;
			}
		}
		System.out.println("-->" + Arrays.toString(testWords));
		return testWords;
	}

}
