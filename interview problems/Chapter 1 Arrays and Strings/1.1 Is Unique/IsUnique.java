import java.util.Arrays;
import java.util.Scanner;

public class IsUnique{
	
	public static void main(String[] args){

		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Input String: " );
		String input = scanner.nextLine();
	
		//converts input into an array and sorts it
		char tempArray[] = input.toCharArray();
		Arrays.sort(tempArray);
	
		//traverses array, checking if the character 
		//following the current one is the same as the current
		for(int i = 0; i < tempArray.length - 1; i++){
			if(tempArray[i] == tempArray[i+1]){
				System.out.println("Is not unique");
				return;
			}
		}
		System.out.println("Is unique");
		return;
	}
}