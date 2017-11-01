/*6. Write a program that takes a character from the user as input and determines whether the character entered is a capital letter, a small case letter, a digit or a special symbol and display appropriately.
Input:  A
Output:  Capital letter*/
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Charecter");
		char c = in.next().charAt(0);
		in.close();
//		System.out.print(c);
		int ascii_value=c;
//		System.out.println(ascii_value);
		if(ascii_value>=65 && ascii_value<=90)
		{
			System.out.println("Capital Letter");
		}
		else if(ascii_value>=97 && ascii_value<=122)
		{
			System.out.println("Small case letter");
		}
		else if(ascii_value>=48 && ascii_value<=57)
		{
			System.out.println("Digit");
		}
		else
		{
			System.out.println("Special Symbol");
		}
		
	}
		
}

