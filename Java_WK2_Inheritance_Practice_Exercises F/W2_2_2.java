/*2. Write a program to compute the addition of two matrix, Read the number of rows and columns as input, also the values of each matrix
Output:
     Input number of rows of matrix: 3
     Input number of columns of matrix: 2
     Input elements of first matrix: 1 2 3 4 5 6
     Input the elements of second matrix: 9 8 7 6 5 4
     Sum of the matrices:-
                    10        10       
                    10        10       
                    10        10
                    */
import java.util.Scanner;
public class W2_2_2 {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("Input number of rows of matrix:");
		int rows=input.nextInt();
		System.out.println("Input number of columns of matrix:");
		int columns=input.nextInt();
		int [][]inputmatrix= new int[rows][columns];
		int [][]inputmatrix1= new int[rows][columns];
		int [][]resultantmatrix= new int[rows][columns];
		System.out.println("Enter the Elements of the First matrix");
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				inputmatrix[i][j]=input.nextInt();
			}
		}
		System.out.println("Enter the Elements of the Second matrix");
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				inputmatrix1[i][j]=input.nextInt();
			}
		}
		input.close();
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				resultantmatrix[i][j]=inputmatrix[i][j]+inputmatrix1[i][j];
			}
		}
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.println(resultantmatrix[i][j]);
			}
		}
		

	}

}