import java.util.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Random;

public class BinarytoString{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner( System.in );
		double i = 0;
		
		while(i <= 0 || i >=1){
			System.out.print( "input a decimal number between 0 and 1: " );
			String command = scanner.nextLine();
		
			try{
				i = Double.parseDouble(command); 
			}
			catch(Exception e){
				System.out.println( "Invalid input: input is not a number");
			}		
			
			if(i <= 0 || i >= 1){
				System.out.println( "input must be between 0 and 1");
			}
			System.out.println();
		}
		
		String output = "0.";
		double remainder = i;
		double bitcheck = 0.5;
		
		while(remainder > 0){
			if(output.length() > 34){
				//System.out.println( "Error: bit string is too long");
				//return;
				remainder = -1;
			}
			
			if(remainder >= bitcheck){
				output = output + "1";
				remainder = remainder - bitcheck;
			}
			else{
				output = output + "0";
			}
			
			bitcheck = bitcheck / 2;
		}
		
		System.out.println( "Decimal input converted to bit string: " + output);
	}
}