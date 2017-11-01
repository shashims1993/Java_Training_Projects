
/*Write a Java program to update specific array element by given element and empty the array list.
Input: [Apple, Grape, Melon, Berry]    
Output: [Kiwi, Grape, Mango, Berry]    
Array list after removing all elements []*/

import java.util.ArrayList;

public class WK3_PE_Collections_1 {

	public static void main(String[] args) {

		ArrayList<String> List = new ArrayList<String>();
		List.add("Apple");
		List.add("Grape");
		List.add("Melon");
		List.add("Berry");
		System.out.println("Input: " + List);

		String specifyElement = "Apple";
		String givenElement = "Kiwi";
		int index = List.indexOf(specifyElement);
		List.remove(index);
		List.add(index, givenElement);
		System.out.println("Output: " + List);

		List.removeAll(List);
		System.out.println("Array list after removing all elements " + List);
	}

}
