
/*Write a program that sets up a String variable containing a paragraph of text of your choice.
a. Extract the words from the text and sort them into alphabetical order.    
b. Display the sorted list of words.*/

import java.util.Arrays;
import java.util.Scanner;

public class WK3_PE_4 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String paragraph = input.nextLine();
		input.close();
		paragraph=paragraph.toLowerCase();
		String [] splittData=paragraph.split("\\s");
		int n=splittData.length;
		String temp;
		for (int i = 0; i < n; i++) 
        {
            for (int j = i ; j < n; j++) 
            {
                if (splittData[i].compareTo(splittData[j])>0) 
                {
                    temp = splittData[i];
                    splittData[i] = splittData[j];
                    splittData[j] = temp;
                }
            }
        }
		System.out.println("Sorted list of words are as below");
		for(String word:splittData)
		{
			System.out.println(word);
		}
	}

}
