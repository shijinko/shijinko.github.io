import LinkedListNode.LinkedListNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class RemoveDups{
	
	public static void main(String[] args){
		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input Linked List Length: " );
		String finder = scanner.nextLine();
		int length = Integer.parseInt(finder);
		String loader = "";
		
		LinkedListNode head = new LinkedListNode();
		LinkedListNode curnode = head;
		LinkedListNode newnode;
		
		for(int i = 0; i < length; i++){
			System.out.print( "Input element " + i + " string: " );
			loader = scanner.nextLine();
			if(i == 0){
				head.setPayload(loader);
			}
			else{
				newnode = new LinkedListNode();
				newnode.setPayload(loader);
				newnode.setPrev(curnode);
				curnode.setNext(newnode);
				curnode = newnode;
			}
		}
		
		
		
		
		
		System.out.println( "Before removing duplicates" );
		curnode = head;
		int element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
		
		
		HashSet<String> set = new HashSet<String>();
		String s = "";
		curnode = head;
		LinkedListNode pr;
		while(!(curnode.isTail())){
			s = curnode.getPayload();
			if(!(set.contains(s))){
				set.add(s);
				curnode = curnode.getNext();
			}
			else{
				pr = curnode.getPrev();
				curnode = curnode.getNext();
				pr.setNext(curnode);
				curnode.setPrev(pr);				
			}
		}
		s = curnode.getPayload();
		if(set.contains(s)){
				curnode = curnode.getPrev();
				curnode.setNext(null);
		}
		
		System.out.println( "After removing duplicates" );
		curnode = head;
		element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
	}
}