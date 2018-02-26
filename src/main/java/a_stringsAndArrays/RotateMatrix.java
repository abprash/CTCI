package a_stringsAndArrays;

import java.util.Arrays;

public class RotateMatrix {

	
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
	
}
