import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Random;

public class FlipBittoWin{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner( System.in );
		int i = 0;
		
		while(i <= 0){
			System.out.print( "input an int greater than 0: " );
			String command = scanner.nextLine();
		
			try{
				i = Integer.parseInt(command); 
			}
			catch(Exception e){
				System.out.println( "Invalid input: input is not a number");
			}		
			
			if(i < 0){
				System.out.println( "Invalid input: input must be greater than 0");
			}
			System.out.println();
		}
		
		int remainder = i;
		
		int before = 0;
		int after = 0;
		int flip = 0;
		
		int curmax = 0;
		
		while(remainder != 0){
			if(remainder%2 == 0){
				flip = before + 1 + after;
				if(flip > curmax)
					curmax = flip;
				before = after;
				after = 0;
			}
			else if(remainder%2 == 1){
				after++;
			}
			remainder = remainder/2;
		}
		flip = before + 1 + after;
		if(flip > curmax)
			curmax = flip;
		
		
		System.out.println( "Input in binary: " +  Integer.toBinaryString(i));
		System.out.println( "Max string of 1's possible by flipping a single bit: " +  curmax);
	}
}