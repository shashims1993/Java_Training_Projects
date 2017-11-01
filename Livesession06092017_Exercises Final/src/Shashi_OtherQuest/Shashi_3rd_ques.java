package Shashi_OtherQuest;

public class Shashi_3rd_ques {

	public static void main(String[] args) {
		
		
		try
		{ 
			String str=null;
			System.out.println("Length :"+str.length());
		}
		catch(NullPointerException e)
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
			
		}
	}
	
}
