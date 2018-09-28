package MyQueue;

import java.util.*;



public class MyQueue{

	Stack<Integer> pushstack;
	Stack<Integer> popstack;
	
	public MyQueue(){
		pushstack = new Stack<Integer>();
		popstack = new Stack<Integer>();
	}
	
	private void load(){
		if(popstack.isEmpty()){
			while(!pushstack.isEmpty()){
				popstack.push(pushstack.pop());
			}
		}	
	}
	
	public int add(int i){
		return pushstack.push(i);
	}
	
	public int remove(){
		load();
		return popstack.pop();
	}
	
	public int peek(){
		load();
		return popstack.peek();
	}
	
	public boolean isEmpty(){
		if(popstack.isEmpty() && pushstack.isEmpty())
			return true;
		else
			return false;
	}
}