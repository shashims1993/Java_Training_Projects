/**6. Write a program to find out if a series of 7 digits are consecutive numbers. To make this easier, assume the digits are a string and use split()
Input: 98,96,95,94,93
Output: 98,96,95,94,93 non consecutive numbers

Input: 54,53,52,51,50,49,48
Output : 54,53,52,51,50,49,48 are consecutive numbers

Input: 1,2,3,4,5,6,6
Output: 1,2,3,4,5,6,6 non consecutive numbers
*/
import java.util.Scanner;

public class W2_2_6 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numbers in string with delimied comma");
		String inputString=input.next();
		input.close();
		String [] inputArray= inputString.split(",");
		int [] intArray= new int[inputArray.length];
		int count=0;
		for(String a:inputArray)
		{
			intArray[count]=Integer.parseInt(a);
			count++;
		}
		
		int check=intArray[1]-intArray[0];
		int flag=1;
		for(int i=1;i<intArray.length;i++)
		{
			if(flag==1)
			{
				if(intArray[i]-intArray[i-1]==check)
				{
					flag=1;
				}
				else
				{
					flag=0;
					break;
				}
			}
		}
		if(flag==1)
		{
			System.out.println("Consecutive numbers");
		}
		else
		{
			System.out.println("Non Consecutive numbers");
		}
	}

}