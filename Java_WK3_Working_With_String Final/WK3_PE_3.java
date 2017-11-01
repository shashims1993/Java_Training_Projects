
/*
Write a program to replace all d with f and all l with t in the given String
Input: daily dry
Output:
Original string: daily dry
New String: faity fry*/
import java.util.Scanner;

public class WK3_PE_3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String inputString = input.nextLine();
		input.close();
		String outputString;
		outputString = inputString.replaceAll("[d]", "f");
		outputString = outputString.replaceAll("[l]", "t");
		System.out.println("Original String: "+inputString);
		System.out.println("New String: "+outputString);
	}

}
