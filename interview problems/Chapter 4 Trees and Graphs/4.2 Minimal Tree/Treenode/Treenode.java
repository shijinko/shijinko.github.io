package Treenode;

public class Treenode{
	
	Treenode left;
	Treenode right;
	
	int payload;
	
	public Treenode(){
		left = null;
		right = null;
		payload = 0;
	}
	
	public Treenode left(){
		return left;
	}
	
	public Treenode right(){
		return right;
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
	
	public void setPayload(int i){
		payload = i;
	}
}