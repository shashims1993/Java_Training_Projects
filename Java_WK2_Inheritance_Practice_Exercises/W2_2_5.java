/*
5. Write a program to create a ChessBoard pattern with the help of multidimensional array, where WW represents white color and BB represents Black color.
Output:
My Chess Board
      WW|BB|WW|BB|WW|BB|WW|BB|
      BB|WW|BB|WW|BB|WW|BB|WW|
      WW|BB|WW|BB|WW|BB|WW|BB|
      BB|WW|BB|WW|BB|WW|BB|WW|
      WW|BB|WW|BB|WW|BB|WW|BB|
      BB|WW|BB|WW|BB|WW|BB|WW|
      WW|BB|WW|BB|WW|BB|WW|BB|
      BB|WW|BB|WW|BB|WW|BB|WW|
 */
public class W2_2_5 {

	public static void main(String[] args) {

		int dim=8;
		String[][] chessboard= new String[dim][dim];
		boolean isWhite=false;
		int i,j;
		for( i=0;i<chessboard.length;i++)
		{
			isWhite=!isWhite;
			for( j=0;j<chessboard[i].length;j++)
			{
				if(isWhite)
				{
					chessboard[i][j]="WW";
				}
				if(!isWhite)
				{
					chessboard[i][j]="BB";
				}
				isWhite=!isWhite;
			}
		}
		for(i=0;i<chessboard.length;i++)
		{
			for(j=0;j<chessboard[i].length;j++)
			{
				System.out.print(chessboard[i][j]+"|");
			}
			System.out.println();
		}

	}

}
