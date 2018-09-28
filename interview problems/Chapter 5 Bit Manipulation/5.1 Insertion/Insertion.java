import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Random;

public class Insertion{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner( System.in );
		System.out.print( "input first bit string n: " );
		String command = scanner.nextLine();
		int n = 0;
		try{
			n = Integer.valueOf(command,2);		
		}
		catch(Exception e){
			System.out.println( "Invalid input: input is not a bit string");
			return;
		}
		
		System.out.print( "input second bit string m: " );
		command = scanner.nextLine();
		int m = 0;
		try{
			m = Integer.valueOf(command,2); 
		}
		catch(Exception e){
			System.out.println( "Invalid input: input is not a bit string");
			return;
		}
		
		System.out.print( "input int representing start bit location 1: " );
		command = scanner.nextLine();
		int i = 0;
		try{
			i = Integer.parseInt(command); 
		}
		catch(Exception e){
			System.out.println( "Invalid input: input is not an integer");
			return;
		}
		
		System.out.print( "input int representing end bit loction j: " );
		command = scanner.nextLine();
		int j = 0;
		try{
			j = Integer.parseInt(command); 
		}
		catch(Exception e){
			System.out.println( "Invalid input: input is not an integer");
			return;
		}
		
		if(i > j){
			System.out.println( "Invalid input: start cannot be greater than end");
			return;
		}
		
		System.out.println();
		System.out.println( "n: " +  Integer.toBinaryString(n));		
		System.out.println( "m: " +  Integer.toBinaryString(m));
		System.out.println( "i: " +  i);
		System.out.println( "j: " +  j);
		
		
		int allone = ~0;
		int left = allone << (j + 1);
		int right = ((1 << i) - 1);
		int mask1 = left | right;
		int mask2 = ~mask1;
		
		int n_cleared = n & mask1;
		int m_cleared = m << i; 
		
		int output = n_cleared | m_cleared;
		
		System.out.println();
		System.out.println( "output: " +  Integer.toBinaryString(output));	
	}
}