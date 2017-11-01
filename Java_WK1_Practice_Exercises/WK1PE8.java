/*8.Write a program which accepts a number from user as input (set the limit say 1 - 50 or 1 - 100) User should guess until the the target number is guessed correctly.
Print separate messages for the following:      
    a. Number guessed is more than original number      
    b. Number guessed is less than original number      
    c. Number guessed matches the original number
   */
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		/** Target Number defined as 35 as below */
		int targNumber=99;
		System.out.println("Enter a number to guess the taget");
		int n=in.nextInt();
		for(;;)
		{
			
			if(n!=targNumber)
			{
				if(n<targNumber)
				{
					System.out.println("Number guessed is less than original number ");
				}
				else
				{
					System.out.println("Number guessed is more than original number ");
				}
				
			}
			else
			{
				System.out.println("Number guessed matches the original number");
				break;
			}
			n=in.nextInt();
		}
		in.close();
	}
}