package chap_3;

import java.util.Stack;

public class QueueViaStacks {

	//implement a queue using 2 stacks
	Stack<Integer> pushStack = new Stack<Integer>(), popStack = new Stack<Integer>();
	
	public QueueViaStacks(){}
	
	public void enqueue(int num){
		pushStack.push(num);
	}
	
	public Integer dequeue(){
		if(popStack.isEmpty()){
			//pop all contents from push stack into popstack and return
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
			return popStack.pop();
		}
		else{
			return popStack.pop();
		}
	}
	
	public static void main(String[] args){
		
	}
}
