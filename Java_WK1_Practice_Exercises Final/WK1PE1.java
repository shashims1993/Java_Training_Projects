/*1. Write a program which accepts a number as input and check whether the given number is palindrome or not If it is a palindrome then
a. Add all the even numbers and check whether the sum is more than 25.    
b. Print success and failure messages for all 3 conditions
Input : 2468642
Output : 2468642 is palindrome and the sum of even numbers is greater than 25
Input: 12345
Output: 12345 is not palindrome
Input: 12345654321
Output : 12345654321 is palindrome and sum of even numbers is less than 25*/
import java.util.*;
public class Week1PracticeExercises {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		long n=in.nextLong();
		in.close();
		long r,sum=0,temp,sum1=0;
		temp=n;  
		String s;
		 while(n>0)
		 {    
		   r=n%10;  //getting remainder of the number  
		   sum=(sum*10)+r;    
		   n=n/10;  
//		   System.out.println(r);
		   if(r%2==0)
			  {
				  sum1+=r;
			  }
		  }   
//		  System.out.print(sum1);
		  if(sum1>25)
		  {
			  s="and the sum of even numbers is greater than 25";
		  }
		  else
		  {
			  s="and sum of even numbers is less than 25";
		  }
		  if(temp==sum)    
		   System.out.println("palindrome "+s);    
		  else    
		   System.out.println("not palindrome");    
		}  
	}