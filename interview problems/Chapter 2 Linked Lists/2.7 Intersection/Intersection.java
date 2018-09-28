import LinkedListNode.LinkedListNode;
import java.util.HashMap;
import java.util.*;

public class Intersection{
	
	public static void main(String[] args){
		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		LinkedListNode head = new LinkedListNode();	
		LinkedListNode curnode = head;
		LinkedListNode head2 = new LinkedListNode();
		LinkedListNode curnode2 = head2;
		LinkedListNode head3 = new LinkedListNode();
		LinkedListNode curnode3 = head3;
		
		System.out.print( "Are the two input lists intersecting(y/n): " );
		String answer = scanner.nextLine();
		if(answer.equals("y")){
		
			System.out.print( "Input Length of the non intersecting portion of List 1: " );
			String finder = scanner.nextLine();
			int length = Integer.parseInt(finder);
			String stringloader = "";		
			LinkedListNode newnode;	
			for(int i = 0; i < length; i++){
				System.out.print( "Input list 1 element " + i + " string: " );
				stringloader = scanner.nextLine();
				if(i == 0){
					head.setPayload(stringloader);
				}
				else{
					newnode = new LinkedListNode();
					newnode.setPayload(stringloader);
					curnode.setNext(newnode);
					curnode = newnode;
				}
			}
		
			System.out.print( "Input Length of the non intersecting portion of List 2: " );
			finder = scanner.nextLine();
			length = Integer.parseInt(finder);	
			LinkedListNode newnode2;
			for(int i = 0; i < length; i++){
				System.out.print( "Input list 2 element " + i + " string: " );
				stringloader = scanner.nextLine();
				if(i == 0){
					head2.setPayload(stringloader);
				}
				else{
					newnode2 = new LinkedListNode();
					newnode2.setPayload(stringloader);
					curnode2.setNext(newnode2);
					curnode2 = newnode2;
				}
			}
			
			System.out.print( "Input Length of the intersecting portion of both lists: " );
			finder = scanner.nextLine();
			length = Integer.parseInt(finder);	
			LinkedListNode newnode3;
			for(int i = 0; i < length; i++){
				System.out.print( "Input intersecting element " + i + " string: " );
				stringloader = scanner.nextLine();
				if(i == 0){
					head3.setPayload(stringloader);
				}
				else{
					newnode3 = new LinkedListNode();
					newnode3.setPayload(stringloader);
					curnode3.setNext(newnode3);
					curnode3 = newnode3;
				}
			}
			
			curnode.setNext(head3);
			curnode2.setNext(head3);
		}
		
		else{
		
			System.out.print( "Input Linked List 1 Length: " );
			String finder = scanner.nextLine();
			int length = Integer.parseInt(finder);
			String stringloader = "";		
			LinkedListNode newnode;	
			for(int i = 0; i < length; i++){
				System.out.print( "Input list 1 element " + i + " string: " );
				stringloader = scanner.nextLine();
				if(i == 0){
					head.setPayload(stringloader);
				}
				else{
					newnode = new LinkedListNode();
					newnode.setPayload(stringloader);
					curnode.setNext(newnode);
					curnode = newnode;
				}
			}
		
			System.out.print( "Input Linked List 2 Length: " );
			finder = scanner.nextLine();
			length = Integer.parseInt(finder);	
			LinkedListNode newnode2;
			for(int i = 0; i < length; i++){
				System.out.print( "Input list 2 element " + i + " string: " );
				stringloader = scanner.nextLine();
				if(i == 0){
					head2.setPayload(stringloader);
				}
				else{
					newnode2 = new LinkedListNode();
					newnode2.setPayload(stringloader);
					curnode2.setNext(newnode2);
					curnode2 = newnode2;
				}
			}
		}
		
		HashMap<LinkedListNode,Integer> map = new HashMap<LinkedListNode,Integer>();
		curnode = head;
		int counter = 0;
		while(!curnode.isTail()){
			map.put(curnode,counter);
			curnode = curnode.getNext();
			counter++;
		}
		map.put(curnode,counter);
		
		boolean linked = false;
		
		curnode2 = head2;
		int counter2 = 0;
		while(!curnode2.isTail()){
			if(map.containsKey(curnode2)){
				linked = true;
				break;
			}
			curnode2 = curnode2.getNext();
			counter2++;
		}
		
		if(curnode == curnode2){
			linked = true;
		}
		
		System.out.println();
		if(linked){
			System.out.println( "Intersects at element " + map.get(curnode2) + " of List 1 and element " + counter2 + " of List 2" );
			System.out.println( "Intersecting node contains the following string:" + curnode2.getPayload() );
		}
		else{
			System.out.println( "Not Intersecting" );
		}
		
		System.out.println();
		System.out.println( "List 1" );
		curnode = head;
		int element = 0;
		while(!(curnode.isTail())){
			System.out.print( "Element " + element + " |" + curnode.getPayload() + "|;  " );
			element++;
			curnode = curnode.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode.getPayload() + "|" );
		
		
		
		System.out.println();
		System.out.println( "List 2" );
		curnode2 = head2;
		element = 0;
		while(!(curnode2.isTail())){
			System.out.print( "Element " + element + " |" + curnode2.getPayload() + "|;  " );
			element++;
			curnode2 = curnode2.getNext();
		}
		System.out.println( "Element " + element + " |" + curnode2.getPayload() + "|" );
		
		
	}	
}