import Treenode.Treenode;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.IntStream;



public class MinimalTree{
	
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
	
	public static void printtree(Treenode n, int level){
		if(n == null){
			return;
		}
		else{
			System.out.println( "level " + level + ": " + n.payload() );
			printtree(n.left(), level+1 );
			printtree(n.right(), level+1 );
		}
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
		
		printtree(root,0);
	}
}