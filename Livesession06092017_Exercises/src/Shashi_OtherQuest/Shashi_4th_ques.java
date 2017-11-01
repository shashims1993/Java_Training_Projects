package Shashi_OtherQuest;

public class Shashi_4th_ques {

	public static void main(String[] args) {

		try
		{ 
			String str="shashi";
			System.out.println("value of string in integer is"+Integer.parseInt(str));
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
			
		}

	}

}
