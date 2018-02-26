package a_stringsAndArrays;

import java.util.Arrays;

public class ZeroMatrix {

	// algo with no extra space
	//AC ALGO:
	//1. Keep booleans for firstRow and firstCol in case they are 0
	//2. in first pass, set the top of the col and first of the row to 0 of that particular 0 element.
	//3. In the next pass, iterate again thro the matrix, from 1 to end, and 1 to end in both row and col. and check the particular top and first of the row
		//if it is 0. if so, change the curr element to 0.
	//finally check, if the firstRow and firstCol variables are true.
	//if they are true, set them to zeros.
	
	public static void zeroMatrix2(int[][] matrix) {
		//
		System.out.println("Print the original array");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		boolean fr = false, fc = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						fr = true;
					if (j == 0)
						fc = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (fr) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (fc) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		System.out.println("===========");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	public static void zeroMatrix(int[][] matrix) {
		// have a 1D array equal to number of rows and cols
		// M length array and N length array where matrix - MxN
		// when we encounter a 0, mark the rows and cols with a 1
		// first iteration done

		// second iteration
		// make every row and column 0.
		// when we encounter a 1

		if (matrix == null)
			return;
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		int cols = matrix[0].length;
		int rows = matrix.length;
		int[] rowArray = new int[rows];
		int[] colArray = new int[cols];
		System.out.println("Print the original array");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					rowArray[i] = 1;
					colArray[j] = 1;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rowArray[i] == 1)
					matrix[i][j] = 0;
				if (colArray[j] == 1)
					matrix[i][j] = 0;
			}
		}
		System.out.println("===========");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	public static void main(String[] args) {
		int[][] matrix2 = { { 0, 9, 1 }, { 4, 1, 1 }, { 0, 1, 1 } };
		zeroMatrix2(matrix2);
	}
}
