/*2. Write a program which accepts an integer number as input from the user and perform the following conditional checks:
a. Print Tom if number is odd and exists between 20 to 30    
b. Print Jerry, if number is even and exists between 20 and 30*/
import java.util.*;
public class Week1PracticeExercises {
	 public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n=in.nextInt();
		in.close();
		if(n>=20 && n<=30)
		{
			if(n%2==0)
			{
				System.out.println("Jerry");
			}
			else
			{
				System.out.println("Tom");
			}
		}
		/***Below code added we will not get to know if it is not between 20 and 30*/
		else
		{
			System.out.println("Number is not between 20 and 30");
		}
}
}