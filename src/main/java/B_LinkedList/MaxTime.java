package B_LinkedList;
import java.util.Arrays;
import java.util.Random;

public class MaxTime {
	public static void main(String[] args)
	{
		//you'll get 4 nos, find the max time you can do with it
		//first number - max
		int a=0,b=0,c=0,d = 0;
		//h1 h2:m1 m2
		//the max hrs can be 24
		//max digit in h1 = 2
		//max dig h2 = 4(if h1=2
		Random r = new java.util.Random();
		r.nextInt();
		a =5;
		b =0;
		c =9;
		d =4;
		System.out.println("the 4 digits are "+a+","+b+","+c+","+d);
		//check if there are 1 or 2
		//find the maximum nos and arrange them in the decreasing order
		int[] timeArray = {a,b,c,d};
		Arrays.sort(timeArray);
		System.out.println(Arrays.toString(timeArray));
		//search for 1 or 2
		//if neither are present then check for 
		
		int h1=0,h2 = 0,m1 = 0,m2 = 0;
		int max = 0;
		
		
		
	}

}


