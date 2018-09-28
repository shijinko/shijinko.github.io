import LinkedListNode.LinkedListNode;
import java.util.*;

public class Palindrome{
	
	public static void main(String[] args){
		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input Linked List Length: " );
		String finder = scanner.nextLine();
		int length = Integer.parseInt(finder);
		String loader = "";
		
		if(length<3){
			System.out.print( "length is too small" );
			return;
		}
		
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
		
		LinkedListNode start = head;
		LinkedListNode end = curnode;
		boolean pal = true;
		int half = length/2;
		
		for(int i = 0; i < half; i++){
			if(!(start.getPayload().equals(end.getPayload()))){
				System.out.println();
				System.out.println( start.getPayload() + " != " + end.getPayload() );
				pal = false;
				i = half;
			}
			start = start.getNext();
			end = end.getPrev();
		}
		
		System.out.println();
		if(pal)
			System.out.println( "The list is a palindrome" );
		else
			System.out.println( "The list is not a palindrome" );
		
		System.out.println();
		curnode = head;
		int element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
	}
}