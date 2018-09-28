package LinkedListNode;

public class LinkedListNode{
	
	LinkedListNode next;
	
	String payload;
	
	public LinkedListNode(){
		next = null;
		payload = "";
	}
		
	public LinkedListNode getNext(){
		return next;
	}
		
	public String getPayload(){
		return payload;
	}
	
	
	public void setNext(LinkedListNode n){
		next = n;
	}
	
	public void setPayload(String s){
		payload = s;
	}
	
	
	public boolean isTail(){
		if(next == null)
			return true;
		else
			return false;
	}
}