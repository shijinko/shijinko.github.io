import IntLinkedListNode.IntLinkedListNode;
import java.util.HashMap;
import java.util.*;

public class SumLists{
	
	public static void main(String[] args){
		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input Linked List 1 Length: " );
		String finder = scanner.nextLine();
		int length = Integer.parseInt(finder);
		String stringloader = "";
		
		IntLinkedListNode head = new IntLinkedListNode();
		IntLinkedListNode curnode = head;
		IntLinkedListNode newnode;
		
		int loader = 0;
		for(int i = 0; i < length; i++){
			System.out.print( "Input list 1 element " + i + " int: " );
			stringloader = scanner.nextLine();
			loader = Integer.parseInt(stringloader);
			if(i == 0){
				head.setPayload(loader%10);
			}
			else{
				newnode = new IntLinkedListNode();
				newnode.setPayload(loader%10);
				newnode.setPrev(curnode);
				curnode.setNext(newnode);
				curnode = newnode;
			}
		}
		
		System.out.print( "Input Linked List 2 Length: " );
		finder = scanner.nextLine();
		length = Integer.parseInt(finder);
		
		IntLinkedListNode head2 = new IntLinkedListNode();
		IntLinkedListNode curnode2 = head2;
		IntLinkedListNode newnode2;
		
		loader = 0;
		for(int i = 0; i < length; i++){
			System.out.print( "Input list 2 element " + i + " int: " );
			stringloader = scanner.nextLine();
			loader = Integer.parseInt(stringloader);
			if(i == 0){
				head2.setPayload(loader%10);
			}
			else{
				newnode2 = new IntLinkedListNode();
				newnode2.setPayload(loader%10);
				newnode2.setPrev(curnode2);
				curnode2.setNext(newnode2);
				curnode2 = newnode2;
			}
		}
		
		System.out.println();
		System.out.println( "input list 1" );
		curnode = head;
		int element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
		
		

		
		System.out.println();
		System.out.println( "input list 2" );
		curnode2 = head2;
		element = 0;
		while(!(curnode2.isTail())){
			System.out.print( "Element " + element + " |" + curnode2.getPayload() + "|;  " );
			element++;
			curnode2 = curnode2.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode2.getPayload() + "|" );
		
		
		IntLinkedListNode head3 = new IntLinkedListNode();
		IntLinkedListNode curnode3 = head3;
		IntLinkedListNode newnode3;
		int counter = 0;
		int sum = 0;
		int carry = 0;
		
		curnode = head;
		curnode2 = head2;
		while(!(curnode.isTail()) && !(curnode2.isTail())){
			if(counter == 0){
				sum = curnode.getPayload() + curnode2.getPayload() + carry;
				head3.setPayload(sum%10);
				carry = sum/10;
				counter++;
				curnode = curnode.getNext();
				curnode2 = curnode2.getNext();
			}
			else{
				sum = curnode.getPayload() + curnode2.getPayload() + carry;
				carry = sum/10;
				newnode3 = new IntLinkedListNode();
				newnode3.setPayload(sum%10);
				newnode3.setPrev(curnode3);
				curnode3.setNext(newnode3);
				curnode3 = newnode3;
				counter++;
				curnode = curnode.getNext();
				curnode2 = curnode2.getNext();
			}
		}
		sum = curnode.getPayload() + curnode2.getPayload() + carry;
		carry = sum/10;
		newnode3 = new IntLinkedListNode();
		newnode3.setPayload(sum%10);
		newnode3.setPrev(curnode3);
		curnode3.setNext(newnode3);
		curnode3 = newnode3;
		counter++;
		curnode = curnode.getNext();
		curnode2 = curnode2.getNext();
		
		IntLinkedListNode contcurnode = null;
		if(curnode != null)
			contcurnode = curnode;
		else if(curnode2 != null)
			contcurnode = curnode2;
		
		if(contcurnode != null){
			while(!(contcurnode.isTail())){
				sum = contcurnode.getPayload() + carry;
				carry = sum/10;
				newnode3 = new IntLinkedListNode();
				newnode3.setPayload(sum%10);
				newnode3.setPrev(curnode3);
				curnode3.setNext(newnode3);
				curnode3 = newnode3;
				contcurnode = contcurnode.getNext();
			}
			sum = contcurnode.getPayload() + carry;
			carry = sum/10;
			newnode3 = new IntLinkedListNode();
			newnode3.setPayload(sum%10);
			newnode3.setPrev(curnode3);
			curnode3.setNext(newnode3);
			curnode3 = newnode3;
		}
		
		if(carry > 0){
			newnode3 = new IntLinkedListNode();
			newnode3.setPayload(carry);
			newnode3.setPrev(curnode3);
			curnode3.setNext(newnode3);
			curnode3 = newnode3;
		}
		
		System.out.println();
		System.out.println( "output list" );
		curnode3 = head3;
		element = 0;
		while(!(curnode3.isTail())){
			System.out.print( "Element " + element + " |" + curnode3.getPayload() + "|;  " );
			element++;
			curnode3 = curnode3.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode3.getPayload() + "|" );
	}
}