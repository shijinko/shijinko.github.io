import java.util.Arrays;
import java.util.Scanner;

public class URLify{
	
	public static void main(String[] args){

		//get input and store in String variable input 
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "Input String: " );
		String input = scanner.nextLine();
		
		String output = "";
		int space = 0;
		char key = ' ';
		
		for(int i = 0; i< input.length(); i++){
			key = input.charAt(i);
			if(key == ' '){
				space = 1;
			}
			else if(space == 0){
				output += key;
			}
			else{
				space = 0;
				output += "%20" + key;
			}
		}
		System.out.println( "URL: "+output );
	}
}