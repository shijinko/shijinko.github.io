import java.util.*;
import java.util.Scanner;
import java.util.Stack;

public class StackMin{
	
	public static void main(String[] args){
	
		Stack<Integer> input = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		String command = "";
		int commandint = 0;
	
		Scanner scanner = new Scanner( System.in );
		while(!command.equals("q")){
			System.out.println();
			System.out.print( "input an int, pop, or q: " );
			command = scanner.nextLine();
			if(command.equals("pop")){
				if(input.isEmpty()){

				}
				else if(input.peek() == min.peek()){
					min.pop();
					input.pop();
				}
				else{
					input.pop();
				}
			}
			else if(!command.equals("q")){
				commandint = Integer.parseInt(command);
				input.push(commandint);
				if(min.isEmpty()){
					min.push(commandint);
				}
				else if(commandint <= min.peek()){
					min.push(commandint);
				}
			}
			
			
			if(!min.isEmpty()){
				System.out.println(Arrays.toString(input.toArray()));
				System.out.println( "Current min of user input stack is: " + min.peek() );
			}
			else{
				System.out.println( "The stack is empty" );
			}
		}
		
	}
}