package a_stringsAndArrays;

import java.util.Arrays;

public class RotateMatrix {

	
	//rotate matrix in place
	public static void rotateMatrixInPlace(char[][] matrix){
		//algo
		//assuming its an nxn matrix
		//right rotate by 90 degrees
		
		System.out.println("Print the original array");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		
		//Step 1: transpose
		
		for(int i = 0; i< matrix.length; i++){
			for(int j = i; j< matrix[0].length; j++){
				char temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		System.out.println("Transposed ===============");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		
		int col2 = matrix[0].length-1;
		int col1 = 0; 
	
		//Step 2 :then keep swapping the extreme cols and keep coming in
		while(col1 < col2){
			//int col2 = matrix[0].length -1 - col1;
			if(col1 != col2){
				//swap col1 and col2 values
				for(int i=0; i<matrix.length; i++){
					char temp = matrix[i][col1];
					matrix[i][col1] = matrix[i][col2];
					matrix[i][col2] = temp;
				}
			}
			col1++;
			col2--;
		}
		
		System.out.println("Rotated ===============");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		
		
	}
	
	
	
	
	
	
	
	public static void leftRotateInPlace(char[][] matrix){

		if(matrix == null || matrix.length == 0)
			return;
		//transpose
		for(int i=0; i<matrix.length; i++){
			for(int j=i; j<matrix[0].length; j++){
				char temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		//now rotate row wise
		int row1 = 0, row2 = matrix.length-1;
		while(row1 < row2){
			//swap the row entries
			for(int i=0; i<matrix[0].length; i++){
				char temp = matrix[row1][i];
				matrix[row1][i] = matrix[row2][i];
				matrix[row2][i] = temp;
			}
			row1++;
			row2--;

		}	
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
	
	public static void main(String[] args){
		char[][] matrix = new char[][] {{'1','2','3','4'},{'4','5','6','7'},{'7','8','9','0'},{'1','3','5','7'}};
		rotateMatrixInPlace(matrix);
	}
}
