import Treenode.Treenode;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.IntStream;



public class CheckBalanced{
	
	public static int getHeight(Treenode root){
		if (root == null) 
			return -1;
		return Math.max(getHeight(root.left()), getHeight(root.right())) + 1; 
	}
	
	public static boolean isBalanced(Treenode root){  
		if (root == null)
			return true;
		int heightDiff = getHeight(root.left()) - getHeight(root.right());
		if (Math.abs(heightDiff) > 1){ 
			return false; 
		} 
		else{ 
			return isBalanced(root.left()) && isBalanced(root.right()); 
		}
	} 
	
	public static boolean contains(int[] r, int key){
		for(int i = 0; i < r.length; i++){
			if(r[i] == key){
				return true;
			}
		}
		return false;
	}
	
	public static Treenode load(int[] arr, int start, int end){
		if (end < start) { 
			return null; 
		}  
		int mid = (start + end) / 2;
		Treenode n = new Treenode();
		n.setPayload(arr[mid]);
		n.setLeft(load(arr, start, mid - 1)); 
		n.setRight(load(arr, mid + 1, end)); 
		return n;
	}
	
	public static void printtree(Treenode n){
		ArrayList<Treenode> list = new ArrayList<Treenode>();
		list.add(n);
		int counter = 0;
		
		while(counter < list.size()){
			if(!list.get(counter).leftnull())
				list.add(list.get(counter).left());
			if(!list.get(counter).rightnull())
				list.add(list.get(counter).right());
			counter++;
		}
		
		counter = 0;
		int level = 0;
		int levelcounter = 0;
		int levellimit = 1;
		while(counter < list.size()){
			System.out.println();
			System.out.print( "Level " + level + " :" );
			while(counter < list.size() && levelcounter < levellimit){
				System.out.print( " " + list.get(counter).payload() + "," );
				counter++;
				levelcounter++;;
			}
			level++;
			levelcounter = 0;
			levellimit = levellimit * 2;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner( System.in );
		System.out.print( "input length of the array: " );
		String command = scanner.nextLine();
		int length = Integer.parseInt(command); 
		
		int[] ar = new int[length];
		
		int count = 0;
		int load = 0;
		
		while(count<length){
			System.out.print( "input element " + count + " of the array: " );
			command = scanner.nextLine();
			try{
				load = Integer.parseInt(command);
			}
			catch(Exception e){
				load = 0;
			}
			if(contains(ar, load)){
				System.out.println( "the array already has " + load + ", please input a different integer" );
			}
			else{
				ar[count] = load;
				count++;
			}
		}
		
		Arrays.sort(ar);
		
		Treenode root = load(ar,0,ar.length - 1);
		
		printtree(root);
		
		if(isBalanced(root))
			System.out.println( "the tree is balanced" );
		else
			System.out.println( "the tree is not balanced" );
	}
}