/*1. Create a class called StudentMarks, which prompts user for the number of students, reads it from the keyboard, and saves it in an int variable called numOfStudents. It then prompts user for the grades of each of the students and saves them in an int array called stuGrades. Your program shall check that the grade is between 0 and 100 else has to trow an error message.*/
import java.util.Scanner;
public class StudentMarks {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of students");
		int noOfStud=input.nextInt();
		int [] grades=new int[noOfStud];
		for(int i=0;i<noOfStud;i++)
		{
			try{
			System.out.println("Enter the grade for the student "+(i+1));
			grades[i]=input.nextInt();
			if(grades[i]<0  ||  grades[i]>100 )
			{
				throw new Exception("Enter Value is not between 0 to 100");
			}
			}
			catch(Exception e)
			{
				input.nextLine();
				System.out.println("You passed invalid input so assiging 0 grade for "+(i+1)+" Student");
				
			}
		}
		input.close();
		/**Printing the Grades of the student*/
		for(int i=0;i<noOfStud;i++)
		{
			System.out.println("Grade of the student  "+(i+1)+"\t"+grades[i]);
		}

	}

}
