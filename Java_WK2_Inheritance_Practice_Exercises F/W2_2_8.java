/*
8. Write a program that will generate exceptions of type NegativeArraySizeException, IndexOutOfBoundsException, NullPointerException. Record the catching of each exception by displaying the message stored in the exception object.*/
 
public class W2_2_8 {

	public static void main(String[] args) {


		try
		{
			/**For NegativeArraySizeException**/
			int [] a= new int[-2];
			
			/**For IndexOutOfBoundsException**/
			int [] b = new int[2];
			System.out.println(b[2]);
			
			/**For NullPointerException**/
		    String str=null;
		    System.out.println("Length :"+str.length());

		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("ArrayIndexOutOfBoundsException has occured");
			e.printStackTrace();
		}
		catch(NegativeArraySizeException e)
		{
			System.out.println("NegativeArraySizeException has occured");
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException has occured");
			e.printStackTrace();
		}

	}

}
