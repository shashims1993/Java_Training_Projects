import java.util.Scanner;

/*Write a boolean method called isEven() in a class called EvenNumTest, which takes an int as input and returns true if the input is even. The signature of the method is as follows: public static boolean isEven(int number)*/
public class W2_5 {

	public static boolean isEven(int number)
	{
		if(number%2==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		int  inputNumber=in.nextInt();
		in.close();
		Boolean checkEven=isEven(inputNumber);
		if(checkEven)
		{
			System.out.println(inputNumber+" is Even");
		}
		else
		{
			System.out.println(inputNumber+" is Odd");
		}
}
}
