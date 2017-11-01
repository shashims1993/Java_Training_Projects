
/*Write a program to find out the multiple occurrences of the given word in a string using Matcher methods.
Input : She sells seashells by the seashore    
Given word: se
Output :  
       Found at: 4 - 6          
       Found at: 10 - 12          
       Found at: 27 - 29*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WK3_PE_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String inputString = input.nextLine();
		System.out.println("Enter a word to find in a String");
		String word = input.nextLine();
		input.close();
		Pattern pattern = Pattern.compile(word);
		Matcher matcher = pattern.matcher(inputString);
		while (matcher.find()) {
			System.out.println(matcher.start() + " - " + matcher.end());
		}
	}

}
