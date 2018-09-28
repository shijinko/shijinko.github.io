package LinkedListNode;

public class LinkedListNode{
	
	LinkedListNode prev;
	LinkedListNode next;
	
	String payload;
	
	public LinkedListNode(){
		prev = null;
		next = null;
		payload = "";
	}
	
	public LinkedListNode getPrev(){
		return prev;
	}
	
	public LinkedListNode getNext(){
		return next;
	}
		
	public String getPayload(){
		return payload;
	}
	
	public void setPrev(LinkedListNode p){
		prev = p;
	}
	
	public void setNext(LinkedListNode n){
		next = n;
	}
	
	public void setPayload(String s){
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