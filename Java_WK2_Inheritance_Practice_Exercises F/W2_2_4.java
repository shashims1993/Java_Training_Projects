/*
 4. Write a program to set up an array of places, Loop round and remove the vowels. Display the new words in console
Input:
    India
    United States
    Germany
    Egypt
    czechoslovakia

Output:
   Place Name without Vowels:0 Ind
   Place Name without Vowels:1 Untd Stts
   Place Name without Vowels:2 Grmny
   Place Name without Vowels:3 Egypt
   Place Name without Vowels:4 czchslv
 */
import java.util.Scanner;
public class W2_2_4 {

	public static void main(String[] args) {

		System.out.println("Enter the place names with space in between cities");
		Scanner input = new Scanner(System.in);
		String inputPlaces= input.nextLine();
		String [] places=inputPlaces.split(" ");
		input.close();
		String [] placesAfterChange= new String[places.length];
		int i=0;
		for(String a:places)
		{
			placesAfterChange[i]=a.replaceAll("[aeiou]","");
			i++;
		}
		for( i=0;i<placesAfterChange.length;i++)
		{
			System.out.println("Place Name without Vowels:"+i+" "+placesAfterChange[i]);
		}
		

	}

}
