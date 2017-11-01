

public class W2_7 {

	private static int factorialInt(int n)
	{
		int result=0;
		if(n==0)
		{
			return 1;
		}
		else
		{
			 result=n*factorialInt(n-1);
			
			return result;
		}
	}
	
	private static long factorialLong(int n)
	{
		long result=0;
		if(n==0)
		{
			return 1;
		}
		else
		{
			 result=n*factorialLong(n-1);
			
			return result;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(short  i=1;i<20;i++)
		{
			System.out.println(factorialInt(i));
		}
	}

}