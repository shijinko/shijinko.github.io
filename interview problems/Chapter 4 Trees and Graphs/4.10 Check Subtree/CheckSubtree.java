import Treenode.Treenode;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Random;
import java.lang.Math;



public class CheckSubtree{
	
	public static boolean subtree(Treenode ta, Treenode tb){
		int level = getHeight(ta) - getHeight(tb);
		
		if(level == 0){
			return ta == tb;
		}
		
		ArrayList<Treenode> list = new ArrayList<Treenode>();
		list.add(ta);
		int counter = 0;
		
		while(counter < list.size()){
			if(!list.get(counter).leftnull())
				list.add(list.get(counter).left());
			if(!list.get(counter).rightnull())
				list.add(list.get(counter).right());
			counter++;
		}
		
		int search = (int)(Math.pow(2,level)-1);
		int end = (int)(search + Math.pow(2,level));
		
		while(search < list.size() && search < end){
			if(list.get(search) == tb)
				return true;
			search++;
		}
		return false;
	}
	
	public static Treenode findAncestor(Treenode ta, Treenode tb){
		if(ta == tb)
			return ta;
		
		Treenode parsea = ta;
		Treenode parseb = tb;
		int levela = 0;
		int levelb = 0;
		
		while(!parsea.parentnull()){
			parsea = parsea.parent();
			levela++;
		}
		while(!parseb.parentnull()){
			parseb = parseb.parent();
			levelb++;
		}
		parsea = ta;
		parseb = tb;
		
		if(levela > levelb){
			while( levela != levelb){
				parsea = parsea.parent();
				levela = levela - 1;
			}
		}
		
		else if(levelb > levela){
			while( levelb != levela){
				parseb = parseb.parent();
				levelb = levelb - 1;
			}
		}
		
		while(parsea != parseb && !parsea.parentnull() && !parseb.parentnull()){
			parsea = parsea.parent();
			parseb = parseb.parent();
		}
		return parsea;
	}
	
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

	public static boolean isBST(Treenode root){
		if(root == null)
			return true;
		else if((root.right() != null && root.payload() >= root.right().payload()) || (root.left() != null && root.payload() < root.left().payload()))
			return false;
		else
			return isBST(root.left()) && isBST(root.right());
	}

	public static Treenode findSuccessor(Treenode input){
		int curpayload = input.payload();
		Treenode output = input;
		
		if(!output.rightnull()){
			output = output.right();
			while(!output.leftnull()){
				output = output.left();
			}
			return output;
		}
		
		while(!output.parentnull()){
			output = output.parent();
			if(output.payload() > curpayload)
				return output;
		}
		return null;
	}
	
	public static boolean contains(int[] r, int key){
		for(int i = 0; i < r.length; i++){
			if(r[i] == key){
				return true;
			}
		}
		return false;
	}
	
	public static Treenode load(int[] arr, int start, int end, Treenode parent){
		if (end < start) { 
			return null; 
		}  
		int mid = (start + end) / 2;
		Treenode n = new Treenode();
		n.setParent(parent);
		n.setPayload(arr[mid]);
		n.setLeft(load(arr, start, mid - 1,n)); 
		n.setRight(load(arr, mid + 1, end,n)); 
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
		System.out.print( "input length of the array for the first tree: " );
		String command = scanner.nextLine();
		int length = Integer.parseInt(command); 
		
		int[] ar = new int[length];
		
		int count = 0;
		int load = 0;
		
		while(count<length){
			System.out.print( "input element " + count + " of the array for the first tree: " );
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
		
		Treenode root = load(ar,0,ar.length - 1,null);
		
		Treenode root2;
		
		System.out.print( "is second tree a subtree (y/n): " );
		command = scanner.nextLine();
		if(command.equals("n")){
			System.out.print( "input length of the array for the second tree: " );
			command = scanner.nextLine();
			length = Integer.parseInt(command); 
		
			int[] ar2 = new int[length];
		
			count = 0;
			load = 0;
		
			while(count<length){
				System.out.print( "input element " + count + " of the array: " );
				command = scanner.nextLine();
				try{
					load = Integer.parseInt(command);
				}
				catch(Exception e){
					load = 0;
				}
				if(contains(ar2, load)){
					System.out.println( "the array already has " + load + ", please input a different integer" );
				}
				else{
					ar2[count] = load;
					count++;
				}
			}
			root2 = load(ar,0,ar.length - 1,null);
		}
		else{
			Treenode pnode = root;   
			while(!pnode.leftnull()){
				pnode = pnode.left();
			}
			Treenode startnode = pnode;
			Random rand = new Random();
			int nodefind1 = rand.nextInt(length);
			Treenode rnode1 = startnode;
			count = 0;
			while(count != nodefind1){
				rnode1 = findSuccessor(rnode1);
				count++;
			}
			root2 = rnode1;
		}

		System.out.println();
		if(subtree(root,root2))
			System.out.println("The second tree is a subtree of the first");
		else
			System.out.println("The second tree not is a subtree of the first");

	}
}