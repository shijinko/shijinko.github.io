import LinkedListNode.LinkedListNode;
import java.util.*;

public class DeleteMiddleNode{
	
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
		
		
		System.out.println( "\n" );
		System.out.println( "Linked list before deleting middle node" );
		curnode = head;
		int element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
		
		curnode = head.getNext();
		
		LinkedListNode prev = curnode.getPrev();
		LinkedListNode next = curnode.getNext();
		prev.setNext(next);
		next.setPrev(prev);

		
		System.out.println( "\n" );
		System.out.println( "Linked list after deleting middle node" );
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