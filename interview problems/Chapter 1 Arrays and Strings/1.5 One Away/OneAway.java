import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class OneAway{
	
	public static void main(String[] args){

		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input First String: " );
		String input1 = scanner.nextLine();
		
		System.out.print( "Input Second String: " );
		String input2 = scanner.nextLine();
		
		int discrep = 0;
		char dis1 = ' ';
		char dis2 = ' ';
		int j = 0;
		
		//replace
		if(input1.length() == input2.length()){
			for(int i = 0; i< input1.length(); i++){
				if(input1.charAt(i) != input2.charAt(i)){
					discrep++;
					dis1 = input1.charAt(i);
					dis2 = input2.charAt(i);
				}
			}
			if(discrep == 1)
				System.out.println( "True: " + dis1 + " was replaced with " + dis2 );
			else
				System.out.println( "False" );
			return;
		}
		
		//insert
		if((input2.length() - input1.length()) == 1){
			for(int i = 0; i< input1.length(); i++){
				if(input1.charAt(i) != input2.charAt(j)){
					discrep++;
					dis1 = input2.charAt(j);
					j++;
				}
				j++;
			}
			if(discrep == 0)
				System.out.println( "True: " + input2.charAt(input2.length()-1) + " was inserted");
			else if(discrep == 1)
				System.out.println( "True: " + dis1 + " was inserted");
			else
				System.out.println( "False" );
			return;
		}
		
		//remove
		if((input1.length() - input2.length()) == 1){
			for(int i = 0; i< input2.length(); i++){
				if(input1.charAt(j) != input2.charAt(i)){
					discrep++;
					dis1 = input1.charAt(j);
					j++;
				}
				j++;
			}
			if(discrep == 0)
				System.out.println( "True: " + input1.charAt(input1.length()-1) + " was inserted");
			else if(discrep == 1)
				System.out.println( "True: " + dis1 + " was removed" );
			else
				System.out.println( "False" );
			return;
		}
		
		System.out.println( "False" );
		return;
	}
}