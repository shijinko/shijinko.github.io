import PosCount.PosCount;
import java.util.Arrays;
import java.util.Scanner;

public class StringCheck{
	public static void main(String[] args){
		
		PosCount[] la = new PosCount[26];
		for(int i = 0; i < 26; i++){
			la[i] = new PosCount();
		}
		
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Input String: " );
		String input = scanner.nextLine();
		
		int key;
		
		for(int i = 0; i< input.length(); i++){
			key = input.charAt(i) - 'a';
			if(key <= 25 && key >= 0){
				if(la[key].getCount() == 0)
					la[key].setPos(i);
				la[key].plusCount();
			}
		}

		
		int min = input.length();
		int charkey = -1;
		
		for(int i = 0; i < 26; i++){
			if(la[i].getCount() == 1 && la[i].getPos() < min){
				min = la[i].getPos();
				charkey = i;
			}
		}
		
		PosCount a = new PosCount();
		PosCount b = new PosCount();
		
		a.setPos(1);
		b.setPos(2);
		
		System.out.println("a pos = " + a.getPos());
		System.out.println("b pos = " + b.getPos());
		
		a = b;
		
		System.out.println("a pos = " + a.getPos());
		System.out.println("b pos = " + b.getPos());
		
		b.setPos(3);
		
		System.out.println("a pos = " + a.getPos());
		System.out.println("b pos = " + b.getPos());
		
		
		if(charkey >= 0){
			char ret = (char) (charkey + 'a');
			System.out.println("The first nonredundant character in the string is " + ret);
			return;
		}
		
		System.out.println("Error: either no nonredundant characters or no valid characters (lower case characters only)");
		return;
	}
}