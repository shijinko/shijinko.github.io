import java.util.*;
import java.util.Scanner;
import java.util.Stack;

public class StackofPlates{
	
	public static void main(String[] args){
	
		ArrayList<Stack<String>> platelist = new ArrayList<Stack<String>>();
		int max = 5;
		int platecounter = 0;
		int stackcounter = 0;
		String command = "";

	
		Scanner scanner = new Scanner( System.in );
		while(!command.equals("q")){
			System.out.println();
			System.out.print( "input  push, pop, or q: " );
			command = scanner.nextLine();
			if(command.equals("pop")){
				if(platelist.isEmpty()){
					System.out.println("there are no plates");
				}
				else if(platecounter <= 1){
					platelist.remove(stackcounter - 1);
					stackcounter = stackcounter - 1;
					platecounter = max;
					if(platelist.isEmpty()){
						platecounter = 0;
					}
					System.out.println("current stack has been removed");
					System.out.println("there are " + stackcounter + " stacks");
					System.out.println("the current stack  has " + platecounter + " plates");
				}
				else{
					platelist.get(stackcounter-1).pop();
					platecounter = platecounter - 1;
					System.out.println("there are " + stackcounter + " stacks");
					System.out.println("the current stack  has " + platecounter + " plates");
				}
			}
			
			
			else if(!command.equals("q")){
				if(platelist.isEmpty()){
					platelist.add(new Stack<String>());
					stackcounter++;
					platecounter = 0;
					platelist.get(stackcounter-1).push("plate");
					platecounter++;
					System.out.println("there are " + stackcounter + " stacks");
					System.out.println("the current stack  has " + platecounter + " plates");
				}
				else if(platecounter == max){
					platelist.add(new Stack<String>());
					stackcounter++;
					platecounter = 0;
					platelist.get(stackcounter-1).push("plate");
					platecounter++;
					System.out.println("there are " + stackcounter + " stacks");
					System.out.println("the current stack  has " + platecounter + " plates");
				}
				else{
					platelist.get(stackcounter-1).push("plate");
					platecounter++;
					System.out.println("there are " + stackcounter + " stacks");
					System.out.println("the current stack  has " + platecounter + " plates");
				}
			}
			
			
		}
		
	}
}