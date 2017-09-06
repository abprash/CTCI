package stringsAndArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StringAndArrayLauncher {

	public static void main(String[] args) {
		// System.out.println(urlify1(new char[12]));
		String s1 = "mr john %20smith    ";
		char[] testWords = new char[s1.length()];
		for (int i = 0; i < s1.length(); i++) {
			testWords[i] = s1.charAt(i);
		}
		// urlify2(testWords);
		String temp = "cat";
		String temp2 = "";
		// System.out.println(palindromePermutation1(temp2));
		// System.out.println(oneAway1(temp, temp2));
		// System.out.println(basicStringDecompressor(basicStringCompressor("compressoroooooooooooooo")));
		//System.out.println(basicStringDecompressor("a1b1c5a3"));
		char[][] matrix = new char[][] {{'1','2','3','4'},{'4','5','6','7'},{'7','8','9','0'},{'1','3','5','7'}};
		rightRotateMatrixInPlace(matrix);
		int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
		//leftRotateMatrix(matrix2);
	}

	// Problem 1.1
	// page 90
	public static boolean isUnique(String t1) {
		// should check if the string has all unique characters
		// return true or false
		// Method 1: hashmap
		// method 2: xor operator?

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t1.length(); i++) {

			char c = t1.charAt(i);
			if (map.containsKey(c)) {
				return false;
			}
			map.put(c, 1);
		}
		return true;
	}

	public static boolean isUnique2(String t1) {
		// should check if the string has all unique characters
		// return true or false
		// Method 1: hashmap
		// method 2: xor operator?

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int result = 0;
		for (int i = 0; i < t1.length(); i++) {
			if (i == 0)
				result = t1.charAt(i);
			else
				result = result ^ ((int) t1.charAt(i));
			// System.out.println("char="+(int) t1.charAt(i)+","+""+result);
			/*
			 * char c = t1.charAt(i); if(map.containsKey(c)){ return false; }
			 * map.put(c, 1);
			 */
		}
		// return true;
		if (result == 0)
			return false;
		else
			return true;
	}

	public static void isUniqueDriver() {
		String t1 = "jsdhfbk";
		String t2 = "sdfsdf";
		System.out.println(isUnique2(t1));
		System.out.println(isUnique2(t2));
		// blah1();
	}

	public static boolean isUnique3(String s) {
		// assuming it contains (a-z) or (A-Z)
		if (s == null)
			return false;
		if (s == "")
			return false;
		// if it is only ascii characters then yeah there are only 128
		// characters
		// or if extended ascii then there are 256 characters
		if (s.length() > 128)
			return false;
		if (s.length() == 1)
			return true;
		int checker = 1;
		for (int i = 0; i < s.length(); i++) {
			int displacement = 1 << (s.charAt(i) - 'a');
			// check for duplicates

			if ((checker & (displacement)) > 0)
				return false;
			checker = checker | displacement;
			System.out.println("checker == " + checker);

			// checker = checker << (s.charAt(i) - 'a');
			// System.out.println(checker);

		}
		return true;
	}

	public static boolean checkPermutation(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				count++;
				map.put(c, count);
			} else
				map.put(c, 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				count--;
				map.put(c, count);
			} else
				return false;
		}

		// get the valueset
		Set<Entry<Character, Integer>> set = map.entrySet();
		int sum = 0;
		for (Entry<Character, Integer> e : set) {
			sum = sum + e.getValue();
		}

		if (sum == 0)
			return true;
		else
			return false;
	}

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

	public static boolean palindromePermutation1(String test) {

		//
		int[] countArray = new int[52];
		if (test == null)
			return false;
		if (test.length() == 0 || test.isEmpty())
			return false;
		if (test.length() == 1)
			return true;
		int oddNumberCounter = 0;
		for (int i = 0; i < test.length(); i++) {
			int pos = 0;
			char c = test.charAt(i);
			// store the count
			// get the ascii position

			// find if its a cap or small letter
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c))
					pos = c - 'A';
				else
					pos = c - 'a' + 26;
				// countArray - [ABCD...XYZabc...xyz]
				System.out.println(pos);
				countArray[pos]++;
			}
		}
		// checking phase
		for (int i = 0; i < countArray.length; i++) {
			if (countArray[i] % 2 != 0)
				oddNumberCounter++;
			if (oddNumberCounter > 1)
				return false;
		}
		return true;

	}

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

	public static String basicStringCompressor(String test) {
		// 1. hashtable
		// 2. or basic stringbuilders

		// aabccccccaaa -> a2b1c6a3
		// if the resultant string is smaller than the input string do it else
		// no
		if (test == null)
			return null;
		if (test.length() <= 2)
			return test;
		StringBuilder sb = new StringBuilder();
		char previousChar = test.charAt(0);
		int currentCount = 1;
		int previousCount = 0;
		for (int i = 1; i < test.length(); i++) {
			char currentChar = test.charAt(i);

			if (previousChar == currentChar)
				currentCount++;
			if (previousChar != currentChar) {
				sb.append(previousChar);
				sb.append(currentCount);
				currentCount = 1;
				previousChar = currentChar;
			}
			if (i == test.length() - 1) {
				sb.append(currentChar);
				sb.append(currentCount);
				currentCount = 0;
			}
		}
		// System.out.println(new String(sb));
		if (new String(sb).length() > test.length())
			return test;
		else
			return new String(sb);
	}

	public static String basicStringDecompressor(String test) {
		final String invalidString = "Invalid input String";
		// input string will basically be in the format of
		// <char><count>
		// char will always be single
		// but the count will be single, double or even triple digit
		if (test == null)
			return null;
		if (test.length() <= 1)
			return invalidString;
		
		StringBuilder ans = new StringBuilder();
		int letterPointer = 0;
		int digitPointer = 1;
		if (!Character.isLetter(test.charAt(letterPointer)))
			return invalidString;
		if (!Character.isDigit(test.charAt(digitPointer)))
			return invalidString;
		// int count = 0;
		// count =
		// Integer.parseInt(Character.toString(test.charAt(countPointer)));

		StringBuilder count = new StringBuilder();
		char currentChar = test.charAt(letterPointer);
		while (digitPointer < test.length()) {
			// keep parsing the number
			//System.out.println("LP "+letterPointer);
			//System.out.println("CountP "+countPointer);
			if (Character.isDigit(test.charAt(digitPointer))) {
				// if its 1
				count.append(Character.toString(test.charAt(digitPointer)));
				digitPointer++;
				currentChar = test.charAt(letterPointer);
				System.out.println("counts "+count);
			} else {
				int totalOccurences = Integer.parseInt(new String(count));
				System.out.println(totalOccurences);
				StringBuilder temp = new StringBuilder();
				for (int i = 0; i < totalOccurences; i++) {
					temp.append(currentChar);
				}
				ans.append(temp);
				System.out.println(ans);
				// change the pos of letter and count pointers
				//countPointer++;
				letterPointer = digitPointer;
				digitPointer = letterPointer + 1;
				count = new StringBuilder();
				/*if(letterPointer >= test.length())
					break;
				if(digitPointer >= test.length())
					break;*/
				currentChar = test.charAt(letterPointer);	
			}
			if(digitPointer == test.length()-1){
				count.append(Character.toString(test.charAt(digitPointer)));
				int totalOccurences = Integer.parseInt(new String(count));
				System.out.println(totalOccurences);
				StringBuilder temp = new StringBuilder();
				for (int i = 0; i < totalOccurences; i++) {
					temp.append(currentChar);
				}
				ans.append(temp);
			}
		}
		return new String(ans);
	}
	
	public static int rightRotateMatrix(char[][] matrix){
		//get the rows and columns number
		//it will be a square matrix
		//if not square return error
		//uses extra space
		if(matrix == null)
			return 1;
		if(matrix.length != matrix[0].length)
			return 2;
		int rows = matrix.length;
		int columns = matrix.length;
		char[][] ans = new char[rows][columns];
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				ans[j][rows - 1 - i] = matrix[i][j];
			}
		}
		System.out.println(Arrays.toString(matrix[0])+"\n"+Arrays.toString(matrix[1])+"\n"+Arrays.toString(matrix[2]));
		System.out.println("-----------");
		System.out.println(Arrays.toString(ans[0])+"\n"+Arrays.toString(ans[1])+"\n"+Arrays.toString(ans[2]));
		System.out.println("===========");
		return 3;
	}
	
	public static int rightRotateMatrixInPlace(char[][] matrix){
		//get the rows and columns number
		//it will be a square matrix
		//if not square return error
		//uses extra space
		if(matrix == null)
			return 1;
		if(matrix.length != matrix[0].length)
			return 2;
		int rows = matrix.length;
		int columns = matrix.length;
		boolean exit = false;
		char[][] ans = new char[rows][columns];
		int center = rows / 2 ;
		
		/*//the key (i think here is )
		//the directions
		//Right -> Down -> Left -> Up
		//we start at a point and keep going R,D,L and U in the same order (while always checking for validity)
		*/
		
		//Solution in the book
		
		//i understood this
		for(int layer=0; layer<rows/2; layer++){
			//layer = 0 -> the outermost layer
			
			//these variables control where to start and stop the layers
			int first = layer;
			int last = rows - 1 - layer;
			System.out.println("layer: "+layer);
			for(int i=first; i< last; i++){

				int offset = i - layer;
				System.out.println("offset: "+offset);
				System.out.println("first :"+first+"last: "+last);
				char top = matrix[first][i];
				//left to top
				matrix[first][i] = matrix[last - offset][first];
				//bottom to left
				matrix[last - offset][first] = matrix[last][last - offset];
				//right to bottom
				matrix[last][last - offset] = matrix[i][last];
				//top to right
				matrix[i][last] = top;
			}
		}
		for(int i=0; i<rows; i++)
			System.out.println(Arrays.toString(matrix[i])+"\n");
		System.out.println("-----------");
		return 3;
	}
	
	public static String leftRotateMatrix(int[][] matrix){
		if(matrix == null)
			return "NULL";
		if(matrix.length != matrix[0].length)
			return "NOT A SQUARE MATRIX";
		int rows = matrix.length;
		int columns = matrix.length;
		int[][] ans = new int[rows][columns];
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				ans[j][i] = matrix[i][j];
			}
		}
		System.out.println(Arrays.toString(matrix[0])+"\n"+Arrays.toString(matrix[1])+"\n"+Arrays.toString(matrix[2]));
		System.out.println("-----------");
		System.out.println(Arrays.toString(ans[0])+"\n"+Arrays.toString(ans[1])+"\n"+Arrays.toString(ans[2]));
		System.out.println("===========");
		return "OK";
	}

}
