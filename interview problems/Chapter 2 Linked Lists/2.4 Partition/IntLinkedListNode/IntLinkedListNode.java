package IntLinkedListNode;

public class IntLinkedListNode{
	
	IntLinkedListNode prev;
	IntLinkedListNode next;
	
	int payload;
	
	public IntLinkedListNode(){
		prev = null;
		next = null;
		payload = 0;
	}
	
	public IntLinkedListNode getPrev(){
		return prev;
	}
	
	public IntLinkedListNode getNext(){
		return next;
	}
		
	public int getPayload(){
		return payload;
	}
	
	public void setPrev(IntLinkedListNode p){
		prev = p;
	}
	
	public void setNext(IntLinkedListNode n){
		next = n;
	}
	
	public void setPayload(int s){
		payload = s;
	}
	
	public boolean isHead(){
		if(prev == null)
			return true;
		else
			return false;
	}
	
	public boolean isTail(){
		if(next == null)
			return true;
		else
			return false;
	}
}