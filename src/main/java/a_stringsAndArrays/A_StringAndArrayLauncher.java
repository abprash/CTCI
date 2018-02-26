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
		//System.out.println(isRotation("waterbottle","erbottlewat"));
	}

	



	

	

	
	
	
	
	
	
}
