import IntLinkedListNode.IntLinkedListNode;
import java.util.HashMap;
import java.util.*;

public class Partition{
	
	public static void main(String[] args){
		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input Linked List Length: " );
		String finder = scanner.nextLine();
		int length = Integer.parseInt(finder);
		String stringloader = "";
		
		IntLinkedListNode head = new IntLinkedListNode();
		IntLinkedListNode curnode = head;
		IntLinkedListNode newnode;
		
		int loader = 0;
		for(int i = 0; i < length; i++){
			System.out.print( "Input element " + i + " int: " );
			stringloader = scanner.nextLine();
			loader = Integer.parseInt(stringloader);
			if(i == 0){
				head.setPayload(loader);
			}
			else{
				newnode = new IntLinkedListNode();
				newnode.setPayload(loader);
				newnode.setPrev(curnode);
				curnode.setNext(newnode);
				curnode = newnode;
			}
		}
		
		System.out.print( "Input partition: " );
		finder = scanner.nextLine();
		int partition = Integer.parseInt(finder);
		int flag = 0;
		IntLinkedListNode newhead;
		IntLinkedListNode prev;
		
		System.out.println();
		System.out.println( "Before partition" );
		curnode = head;
		int element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
		
		
		curnode = head;
		while(!(curnode.isTail())){
			if(flag == 0){
				if(curnode.getPayload() >= partition){
					flag++;
				}
				curnode = curnode.getNext();
			}
			else{
				if(curnode.getPayload() < partition){
					curnode = curnode.getNext();
					newhead = curnode.getPrev();
					prev = newhead.getPrev();
					
					curnode.setPrev(prev);
					prev.setNext(curnode);
					
					newhead.setPrev(null);
					newhead.setNext(head);
					head = newhead;
				}
				else{
					curnode = curnode.getNext();
				}
			}
		}
		if(flag != 0 && curnode.getPayload() < partition){
			prev = curnode.getPrev();
			prev.setNext(null);
			curnode.setPrev(null);
			curnode.setNext(head);
			head = curnode;
		}
		
		System.out.println();
		System.out.println( "After partition" );
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