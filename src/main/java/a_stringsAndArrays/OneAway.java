package a_stringsAndArrays;

public class OneAway {

	//
	/*
	 * AC method 
	 * 1. Have a char array for each chars in the string and find the difference
	 * 
	 */
	public static boolean oneAway1(String s1, String s2) {
		// validate s1 and s2
		if (s1 == null || s2 == null)
			return false;
		if (Math.abs(s1.length() - s2.length()) > 1)
			return false;
		int[] countArray = new int[52];
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			int pos = 0;
			if (Character.isLetter(ch)) {
				if (Character.isUpperCase(ch))
					pos = ch - 'A';
				else
					pos = ch - 'a' + 26;
				if ((pos > countArray.length - 1) || (pos < 0))
					return false;// unidentified char
				countArray[pos]++;
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			int pos = 0;
			if (Character.isLetter(ch)) {
				if (Character.isUpperCase(ch))
					pos = ch - 'A';
				else
					pos = ch - 'a' + 26;
				if ((pos > countArray.length - 1) || (pos < 0))
					return false;// unidentified char
				countArray[pos]--;
			}
		}
		int sum = 0;
		for (int i = 0; i < countArray.length; i++) {
			sum += countArray[i];
		}
		if (sum > 1 || sum < -1)
			return false;
		return true;
	}

}
