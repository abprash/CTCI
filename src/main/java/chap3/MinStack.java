package chap3;

import java.util.*;

public class MinStack {

	int min = Integer.MIN_VALUE;
	public Stack<Integer> stack;
	public MinStack(){
		stack = new Stack<Integer>();
	}
	
	public void pop(){
		if(stack.pop() == min)
			min = stack.pop();
	}
	
	public int top(){
		return stack.peek();
	}
	
	public int getMin(){
		return min;
	}
	
	public void push(int x){
		//lets push
		if(x <= min){
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}
	
}
