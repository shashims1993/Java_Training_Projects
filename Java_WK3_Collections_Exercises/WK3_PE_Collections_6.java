
/*Write a program to implement set interface which sorts the given randomly ordered names in ascending order. Convert the sorted set in to an array list
Input : Harry  Olive  Alice  Bluto  Eugene    
Output :           
           Sorted Set :  Alice  Bluto  Eugene  Harry  Olive           
           Array list from Set :  Alice Bluto Eugene Harry Olive*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WK3_PE_Collections_6 {

	public static void main(String[] args) {

		String nameString = "Harry Olive Alice Bluto Eugene";
		String[] nameArray = nameString.split("\\s");
		Set<String> set = new HashSet<String>();
		// System.out.println(Arrays.toString(nameArray));
		for (int i = 0; i < nameArray.length; i++) {
			set.add(nameArray[i]);
		}
		// System.out.println(set);
		TreeSet sortedSet = new TreeSet<String>(set);

		List<String> list = new ArrayList<String>(sortedSet);
		System.out.println("Input : " + nameString);
		System.out.println("Output:\nSorted Set :  " + sortedSet);
		System.out.println("Array list from Set :  " + list);
	}

}
