/*5. Write a program that reads an unspecified number of integer arguments using Scanner Class and adds them together. The program should display total of the given input number and should only consider integer value.The program should display an error message if there are any non integer values
Input :  12 23 2 4
Output : 41*/
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		 System.out.println("Enter numbers ");
		    int sum;
		    Scanner s = new Scanner(System.in);
	        int score = 0;
	        sum = 0;
	        String line = s.nextLine();
	        s = new Scanner(line); //has to do this to make the s.hasNexInt() work.
//	        System.out.println(line.length());
	        int count=0;
	        while (s.hasNextInt()) {
	            score = s.nextInt();
	            sum += score;
	            count++;
	        }
	        String s1[]=line.split(" ");
//	        System.out.println(s1.length+""+count);
	        if(count<s1.length)
	        {
	        	System.out.println("Error occoured ,All entered  value is not a integer");
	        }
	        else
	        {
	        	System.out.println(sum);
	        }
//	        System.out.println(sum);
	}
}

