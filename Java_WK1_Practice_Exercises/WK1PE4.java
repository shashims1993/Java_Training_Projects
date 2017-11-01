/*4. Write a program using a loop to print the following output. 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 6 6 6 6 6 6 . . . nth iteration.
Input: 5
 Output : 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5*/
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n=in.nextInt();
		in.close();
//		System.out.println(n);
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(i);
			}
		}
	}
}

