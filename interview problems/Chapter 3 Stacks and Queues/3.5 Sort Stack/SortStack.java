import java.util.*;
import java.util.Scanner;
import java.util.Stack;

public class SortStack{
	
	public static void main(String[] args){
	
		Stack<Integer> input = new Stack<Integer>();
		Stack<Integer> holder = new Stack<Integer>();
		String command = "";
		int commandint = 0;
		int save = 0;
		int pushed = 0;
	
		Scanner scanner = new Scanner( System.in );
		while(!command.equals("q")){
			System.out.println();
			System.out.print( "input an int, pop, or q: " );
			command = scanner.nextLine();
			if(command.equals("pop")){
				if(!input.isEmpty()){
					save = input.pop();
					System.out.println( "pop " + save );
				}
				else{
					input.pop();
					System.out.println( "there is nothing to pop" );
				}
			}
			else if(!command.equals("q")){
				commandint = Integer.parseInt(command);
				if(input.isEmpty() || commandint <= input.peek()){
					input.push(commandint);
				}
				else{
					pushed = 0;
					while(!input.isEmpty()){
						if(pushed == 0 && commandint <= input.peek()){
							pushed++;
							holder.push(commandint);
						}
						else{
							holder.push(input.pop());
						}
					}
					if(pushed == 0){
						holder.push(commandint);
					}
					while(!holder.isEmpty()){
						input.push(holder.pop());
					}
				}
				System.out.println( "push " + commandint );
			}
			
			
			if(!input.isEmpty()){
				System.out.println(Arrays.toString(input.toArray()));
			}
			else{
				System.out.println( "The stack is empty" );
			}
		}
		
	}
}