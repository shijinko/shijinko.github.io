import java.util.Arrays;
import java.util.Scanner;

public class StringCompression{
	
	public static void main(String[] args){

		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input String: " );
		String input = scanner.nextLine();
		
		String output = "";
		char prev = input.charAt(0);
		int count = 1;
		
		char key = ' ';
		
		for(int i = 1; i< input.length(); i++){
			key = input.charAt(i);
			if(key == prev){
				count++;
			}
			else{
				output = output + prev + count;
				prev = key;
				count = 1;
			}
		} 
		output = output + prev + count;

		System.out.println( "Compression: "+output );
	}
}