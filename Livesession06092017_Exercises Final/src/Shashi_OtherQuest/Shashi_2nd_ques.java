package Shashi_OtherQuest;

public class Shashi_2nd_ques {

	public static void main(String[] args) {
	
		int [] a= new int[5];
		try
		{
			System.out.println("Value at the 6th index is "+a[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
			
		}
	}
}
