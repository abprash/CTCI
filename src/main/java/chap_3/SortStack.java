package chap_3;

import java.util.*;
public class SortStack {
	
	public Stack<Integer> s1, s2;
	public SortStack(){
		s1 = new Stack<Integer>();//keep s1 always filled
		s2 = new Stack<Integer>();//keep s2 always empty
	}
	
	public void push(int num){
		//check if the incoming num is lesser than or equal to the top
		if(num <= s1.peek()){
			//push it
			s1.push(num);
			return;
		}
		else{
			while(num <= s1.peek()){
				s2.push(s1.pop());
			}
			s1.push(num);
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
			return;
		}
	}
	
	public Integer pop(){
		return s1.pop();
	}
	
	public Integer peek(){
		return s1.peek();
	}
	
	public boolean isEmpty(){
		return s1.isEmpty();
	}

}
