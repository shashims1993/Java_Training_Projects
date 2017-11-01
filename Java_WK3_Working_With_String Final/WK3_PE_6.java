
/*Write a program with the implementation of Regular Expression to find the presence of the name Harry in a string.
Input: This is Harry. 
Output: Is Harry here ? true 
Input : This is Henry. 
Output: Is Harry here ? false*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WK3_PE_6 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String inputString = input.nextLine();
		input.close();
		Pattern pattern = Pattern.compile("Harry"); 
		Matcher matcher = pattern.matcher(inputString); 
		Boolean flag=false;
		while (matcher.find()) {    
            flag=true;
        }
		System.out.println("Input: "+inputString);
		System.out.println("Is Harry here ? "+flag);
	}

}
