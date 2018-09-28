import LinkedListNode.LinkedListNode;
import java.util.*;

public class ReturnKthtoLast{
	
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
		
		System.out.print( "Input k: " );
		finder = scanner.nextLine();
		int k = Integer.parseInt(finder);
		
		if(k>length){
			System.out.print( "Error: k input is too big" );
			return;
		}
		
		curnode = head;
		for(int i = 0; i < k-1; i++){
			curnode = curnode.getNext();
		}
		LinkedListNode findk = head;
		int element = 0;
		while(!(curnode.isTail())){
			findk = findk.getNext();
			curnode = curnode.getNext();
			element++;
		}
		System.out.println( "The kth to last element is Element " + element + " |" + findk.getPayload() + "|" );
		
		
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