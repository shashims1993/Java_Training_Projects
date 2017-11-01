/*1. Write a Java method to Reverse the given input & Check if it is a Palindrome.*/

import java.util.Scanner;

public class W2_1 {

	/** Method to check whether the number is a palendrome or not */
	
	private static Boolean palendrome(int n)
	{
		int temp=n;  
		int r,sum=0;
		 while(n>0)
		 {    
		   r=n%10;  //getting remainder of the number  
		   sum=(sum*10)+r;    
		   n=n/10;  
		  } 
		 if(temp==sum)
			 return true;
		 else
			 return false;
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		int  inputNumber=in.nextInt();
		in.close();
		Boolean pal=palendrome(inputNumber);
		if(pal)
		{
			System.out.println(inputNumber+" is a Palendrome");
		}
		else
		{
			System.out.println(inputNumber+" is not a  Palendrome");
		}

	}

}
