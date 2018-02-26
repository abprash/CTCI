package a_stringsAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class A_StringAndArrayLauncher {

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
		//rightRotateMatrixInPlace(matrix);
		int[][] matrix2 = {{1,2,3},{4,-9,6},{7,8,0}};
		//leftRotateMatrix(matrix2);
		//zeroMatrix(matrix2);
		System.out.println(isRotation("waterbottle","erbottlewat"));
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
	
	//doLeftRotateMatrixInPlace
	public static void zeroMatrix(int[][] matrix){
		//have a 1D array equal to number of rows and cols
		//M length array and N length array where matrix - MxN
		//when we encounter a 0, mark the rows and cols with a 1
		//first iteration done
		
		//second iteration
		//make every row and column 0.
		// when we encounter a 1
		
		if(matrix == null)
			return;
		if(matrix.length == 0 || matrix[0].length == 0)
			return;
		int cols = matrix[0].length;
		int rows = matrix.length;
		int[] rowArray = new int[rows];
		int[] colArray = new int[cols];
		System.out.println("Print the original array");
		for(int i=0; i<matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(matrix[i][j] == 0){
					rowArray[i] = 1;
					colArray[j] = 1;
				}
			}
		}
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(rowArray[i] == 1)
					matrix[i][j] = 0;
				if(colArray[j] == 1)
					matrix[i][j] = 0;
			}
		}
		System.out.println("===========");
		for(int i=0; i<matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
	
	public static boolean isSubstring(String needle, String haystack){
		if(haystack.indexOf(needle) >= 0)
			return true;
		else
			return false;
	}
	
	public static boolean isRotation(String s1, String s2){
		//to verify is s1 or s2 is a rotation of the other
		if(s1 == null || s2 == null)
			return false;
		// start at the first char
		// 
		int l1 = s1.length();
		int l2 = s2.length();
		if(l1 != l2)
			return false;
		
		return isSubstring(s2,s1+s1);
	}
}
