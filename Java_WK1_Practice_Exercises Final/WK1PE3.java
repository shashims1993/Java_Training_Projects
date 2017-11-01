/*3. Create a program that accepts a word as input and checks for each single character letter in the word whether it is a consonant or vowel.
 Condition:          
    a. Print an error message if the input is not a letter          
    b. If the input having more than one letter, print the required output 
          (Vowel or Consonant) for each letter

Input : p
Output : Consonant

Input : ap
Output : Vowel Consonant (should it be a - vowel, p - consonant)*/
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string");
		String s=in.next();
		in.close();
		char c;
		int asc_v;
		for(int i=0;i<s.length();i++)
		{
			c=s.charAt(i);
			asc_v=c;

				if(asc_v==65 || asc_v==97 || asc_v==69 || asc_v==101 || asc_v==73 || asc_v==105 || asc_v==79 || asc_v==111 || asc_v==85 || asc_v==117)
				{
					System.out.print(c+":Vowel");
				}
				else if(asc_v>=97 && asc_v<=122)
				{
					System.out.print(c+":Consonant");
				}
				else
				{
					System.out.print("Not a letter");
				}
				if(i!=(s.length()-1))
				System.out.print(" ,");
		}
		
	}
}
