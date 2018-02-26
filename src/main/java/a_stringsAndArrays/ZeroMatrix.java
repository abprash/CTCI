package a_stringsAndArrays;

import java.util.Arrays;

public class ZeroMatrix {

	
	
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

	// algo with no extra space
	public static void zeroMatrix2(int[][] matrix) {
		System.out.println("Print the original array");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		if (matrix == null || matrix.length == 0)
			return;
		boolean firstRow = false, firstCol = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					// set the top most cell in that col to be 0,
					// set the left most cell in that row to be 0
					
					//for the non zero rows and cols
					if(j != 0)
						matrix[0][j] = 0;
					if(i != 0)
						matrix[i][0] = 0;
					
					//now for the zero rows and cols
					if(i == 0 || j == 0){
						if(i == 0 && j == 0){
							firstRow = true;
							firstCol = true;
						}
						if(i == 0)
							firstRow = true;
						if(j == 0)
							firstCol = true;
					}
				}
				
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((i == 0 || j == 0) && matrix[i][j] == 0) {
					if(j == 0)
						makeRowZero(matrix, i);
					if(i == 0)
						makeColZero(matrix, j);
					
				}
			}
		}
		
		//now if firstRow or firstCol is true
		//make them zero
		if(firstRow){
			for(int i=0; i<matrix[0].length; i++)
				matrix[0][i] = 0;
		}
		
		//similarly for first col
		if(firstCol){
			for(int j=0; j<matrix.length; j++)
				matrix[j][0] = 0;
		}
		
		System.out.println("===========");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	public static void makeRowZero(int[][] matrix, int row) {
		for(int i=0; i<matrix[0].length; i++)
			matrix[row][i] = 0;
	}

	public static void makeColZero(int[][] matrix, int col) {
		for(int i=0; i<matrix.length; i++)
			matrix[i][col] = 0;
	}
	
	public static void main(String[] args){
		int[][] matrix2 = {{0,9,1},{4,1,1},{0,1,1}};
		zeroMatrix2(matrix2);
	}
}
