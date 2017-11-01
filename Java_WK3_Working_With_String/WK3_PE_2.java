
/*Write a java program to count the total number of occurrences of a given character in a string without using any loop?
For Example- Java is java again java again count number of occurrence of a in the given string*/
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WK3_PE_2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String inputString = input.nextLine();
		System.out.println("Enter a charecter");
		char c = input.next().charAt(0);
		input.close();
		Pattern pattern = Pattern.compile(Character.toString(c));
		Matcher matcher = pattern.matcher(inputString);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		System.out.println("Total number of occurences of Character '"+c+"' in the String is "+count);
	}

}
