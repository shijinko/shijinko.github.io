package PosCount;

public class PosCount{
	
	int pos;
	int count;
	
	public PosCount(){
		pos = 0;
		count = 0;
	}
	
	public int getPos(){
		return pos;
	}
	
	public int getCount(){
		return count;
	}
	
	public void setPos(int p){
		pos = p;
	}
	
	public void plusCount(){
		count++;
	}
	
}