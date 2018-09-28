import MyQueue.MyQueue;
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

public class QueueviaStack{
	
	public static void main(String[] args){
	
		MyQueue q = new MyQueue();
		String command = "";
		int commandint = 0;
		int save = 0;
	
		Scanner scanner = new Scanner( System.in );
		while(!command.equals("q")){
			System.out.println();
			System.out.print( "input an int, remove, peek, empty or q: " );
			command = scanner.nextLine();
			if(command.equals("remove")){
				if(!q.isEmpty()){
					save = q.remove();
					System.out.println("removed " +save);
				}
				else{
					System.out.println("queue is empty");
				}
			}
			else if(command.equals("empty")){
				if(q.isEmpty()){
					System.out.println( "queue is empty" );
				}
				else{
					System.out.println( "queue is not empty" );
				}
			}
			else if(command.equals("peek")){
				if(!q.isEmpty()){
					save = q.peek();
					System.out.println("peek " +save);
				}
				else{
					System.out.println("queue is empty");
				}
			}
			else if(!command.equals("q")){
				commandint = Integer.parseInt(command);
				save = q.add(commandint);
				System.out.println("push " +save);
			}
		}
		
	}
}