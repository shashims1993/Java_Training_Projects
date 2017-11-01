/**
 6. Write a program, which reads number of students and n grades as input (of int between 0 and 100, inclusive) and displays the average, minimum and maximum.Your program shall check for valid input. You should keep all the grades in an int[] and use a method for each of the computations.
Output:    
    Enter the number of students: 4    
    Enter the grade for student 1: 86    
    Enter the grade for student 2: 65    
    Enter the grade for student 3: 98    
    Enter the grade for student 4: 77    
    The average is 81.50    
    The minimum is 65    
    The maximum is 98
    **/

   import java.util.Scanner;

public class W2_6 {
	
	public static void main(String[] args) {
	 
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter the number of students");
	    int number=in.nextInt();
	    int a[]=new int[number];
	    int i=0,j=0,temp;
	    for( i=0;i<number;i++)
	    {
	    	System.out.println("Enter the Grade of student "+(i+1));
	    	a[i]=in.nextInt();
	    }
	    in.close();
	    for ( i = 0; i < number; i++) 
        {
            for (j = i + 1; j < number; j++) 
            {
                if (a[i] < a[j]) 
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
	    double sum=0;
	    for( i=0;i<number;i++)
	    {
	    	sum+=a[i];
	    }
	    double avg=sum/number;
	    System.out.println("The average is " +avg+"\n"+"The minimum is "+a[number-1]+"\n"+"The maximum is "+a[0]);
	}
}