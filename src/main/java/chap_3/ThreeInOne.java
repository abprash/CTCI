package chap_3;

public class ThreeInOne {

	//one array to implement 3 stacks
	int[] arr;
	int[] tops;//indicate the top positions, so we know where to insert and pop from
	
	public ThreeInOne(){
		arr = new int[90];
		tops = new int[3];
		tops[1] = arr.length/3;
		tops[2] = (arr.length/3) * 2;
		System.out.println(tops);
	}
	
	public Integer pop(int s){
		//check if the particular stack is valid
		if(s<1 || s>3)
			return null;
		s--;
		//ensure the stack is not empty
		if(tops[s] == s*(arr.length/3))
			return null;
		//go back one position
		tops[s]--;
		int popVal = arr[tops[s]];
		//reset it -- optional
		arr[tops[s]] = 0;
		return popVal;
	}
	
	public void push(int s, int num){
		//
		//check if the particular stack is full
		if(s<1 || s>3)
			return;
		s--;
		if(tops[s] > 29*(s+1))
			return;//stack is full
		
		arr[tops[s]] = num;//store it in the top pointer
		tops[s]++;//incr the top pointer
	}
	
	public int peek(int s){
		return arr[tops[s]];
	}
	
	public static void main(String[] args){
		ThreeInOne t = new ThreeInOne();
		
	}
}
