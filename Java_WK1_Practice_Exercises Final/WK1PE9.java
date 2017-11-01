/*9.Write a program to reverse any string without using String Buffer.
Input : london
Output : nodnol
   */
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a String");
		String s=in.next();
		in.close();
	/* for(int i=0;i<=s.length()-1;i++)
	 {
	     System.out.print(s.charAt(i));
	 }*/
	 for(int i = s.length() - 1; i >= 0; --i)
	 {
	     System.out.print(s.charAt(i)); 
	 }
	}
}