package Treenode;

public class Treenode{
	
	Treenode left;
	Treenode right;
	Treenode parent;
	
	int payload;
	
	public Treenode(){
		left = null;
		right = null;
		parent = null;
		payload = 0;
	}
	
	public Treenode left(){
		return left;
	}
	
	public Treenode right(){
		return right;
	}
	
	public Treenode parent(){
		return parent;
	}
		
	public int payload(){
		return payload;
	}
	
	public void setLeft(Treenode l){
		left = l;
	}
	
	public void setRight(Treenode r){
		right = r;
	}
	
	public void setParent(Treenode p){
		parent = p;
	}
	
	public void setPayload(int i){
		payload = i;
	}
	
	public boolean leftnull(){
		if(left == null)
			return true;
		else
			return false;
	}
	
	public boolean rightnull(){
		if(right == null)
			return true;
		else
			return false;
	}
	
	public boolean parentnull(){
		if(parent == null)
			return true;
		else
			return false;
	}
}