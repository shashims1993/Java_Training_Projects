import java.util.Scanner;


public class W2_2 {

	private static boolean powerOf4(int n){
		if(n == 0)
		    return false;
		  while(n != 1)
		  {    
		   if(n%4 != 0)
		      return false;
		    n = n/4;      
		  }
		  return true;
		 }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		int  inputNumber=in.nextInt();
		in.close();
		Boolean po4=powerOf4(inputNumber);
		if(po4)
		{
			System.out.println(inputNumber+" is a Power of 4 ");
		}
		else
		{
			System.out.println(inputNumber+" is not a Power of 4 ");
		}
	}
}
