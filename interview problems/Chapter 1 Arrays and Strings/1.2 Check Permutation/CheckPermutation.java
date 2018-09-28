import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation{
	
	public static void main(String[] args){

		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input First String: " );
		String input1 = scanner.nextLine();
		
		System.out.print( "Input Second String: " );
		String input2 = scanner.nextLine();
		
		HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();
		
		HashMap<Character,Integer> map2 = new HashMap<Character,Integer>();
	
		char key = ' ';
	
		for(int i = 0; i< input1.length(); i++){
			key = input1.charAt(i);
			if(map1.containsKey(key))
				map1.put(key, map1.get(key) + 1);
			else
				map1.put(key, 1);
		}
		
		for(int i = 0; i< input2.length(); i++){
			key = input2.charAt(i);
			if(map2.containsKey(key))
				map2.put(key, map2.get(key) + 1);
			else
				map2.put(key, 1);	
		}
		
		if(map1.equals(map2))
			System.out.println(input2 + " is a permutation of " +input1);
		else
			System.out.println(input2 + " is not a permutation of " +input1);
		
		return;
	}
}