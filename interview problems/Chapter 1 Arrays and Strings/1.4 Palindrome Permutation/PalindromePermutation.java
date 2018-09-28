import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation{
	
	public static void main(String[] args){

		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input String: " );
		String input = scanner.nextLine();
		
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		char key = ' ';
		
		int oddcount = 0;
	
		for(int i = 0; i< input.length(); i++){
			key = input.charAt(i);
			if(map.containsKey(key)){
				if(map.get(key)%2 == 0)
					oddcount++;
				else
					oddcount--;
				map.put(key, map.get(key) + 1);
			}
			else if(key != ' '){
					map.put(key, 1);
					oddcount++;
			}
		}
		

		
		if(oddcount <= 1)
			System.out.println("True");
		else
			System.out.println("False");
		
		return;
	}
}