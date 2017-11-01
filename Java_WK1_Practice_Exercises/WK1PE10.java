/*10. Write a program for the following condition:
Given 2 inputs , where input1 is string and input 2 is integer value, the last n characters should repeat n number of times in the output String.
Input1:            Stackroute
Input2:            5
Output1:           Stackrouterouterouterouterouteroute

Input1:            Stackroute
Input2:            2
Output1:           Stackroutetete
   */
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string");
		String s=in.next();
		System.out.println("Enter a number");
		int n=in.nextInt();
		in.close();
//		System.out.println(s);
		String s1=s.substring(s.length()-n);
//		System.out.println(s1);
		String s2;
		s2=s;
		for(int i=1;i<=n;i++)
		{
			s2+=s1;
		}
		System.out.println(s2);
	}
}