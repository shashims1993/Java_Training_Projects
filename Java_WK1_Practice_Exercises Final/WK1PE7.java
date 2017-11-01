/*7. Write a program which accepts a number as input from user and perform the following:
a. sort the number in non-increasing order    
b. after sorting sum all the even numbers, the sum should be greater than 15 .    
c. if sum is more than 15,then print output as true or false.

Input  : 234534
Output : Sorted number in non-increasing order : 544332
                 Sum of even numbers : 10
                 False*/
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		 System.out.println("Enter a number");
		    Scanner in = new Scanner(System.in);
		    int number=in.nextInt();
//		    System.out.println(number);
		    String s =Integer.toString(number);
//		    System.out.println(s.length());
		    int len=s.length();
		    int r=0,i=0,j=0;
		    int a[]=new int[len],temp=0,sum=0;
		    while(number>0){    
				   r=number%10;  //getting remainder  
//				   sum=(sum*10)+r;    
				   number=number/10;  
//				   System.out.println(r);
				   a[i]=r;
				   i++;
				  }  
		   /* for(i=0;i<len;i++)
		    {
		    	System.out.print(a[i]);
		    }*/
		    for ( i = 0; i < len; i++) 
	        {
	            for (j = i + 1; j < len; j++) 
	            {
	                if (a[i] < a[j]) 
	                {
	                    temp = a[i];
	                    a[i] = a[j];
	                    a[j] = temp;
	                }
	            }
	        }
		    System.out.print("Sorted number in non-increasing order : ");
		    for(i=0;i<len;i++)
		    {
		    	if(!(i==(len-1)))
		    		System.out.print(a[i]);
		    	else
		    	{
		    		System.out.println(a[i]);
		    	}
		    	if(a[i]%2==0)
		    	sum+=a[i];
		    }
		    System.out.println("Sum of even numbers : "+sum);
		    if(sum>15)
		    {
		    	System.out.println("True");
		    }
		    else
		    {
		    	System.out.println("False");
		    }
		    
	}
}