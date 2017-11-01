
/*Write a program to find the number of counts in the following String. Store the output in Map<String,Integer> as key value pair.
Input :  String str = “one one -one___two,,three,one @three*one?two”;    
Output : {"one":5 , "two":2, "three" :2}*/

import java.util.Map;
import java.util.TreeMap;

public class WK3_PE_Collections_2 {

	public static void main(String[] args) {

		String input = "one one -one___two,,three,one @three*one?two";
		Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
		String[] inputArray = input.split("\\W|_");
		String next;
		for (int i = 0; i < inputArray.length; i++) {
			next = inputArray[i].toLowerCase();

			if (!next.equals("")) {
				if (!wordCounts.containsKey(next)) {
					wordCounts.put(next, 1);
				} else {
					wordCounts.put(next, wordCounts.get(next) + 1);
				}
			}
		}
		System.out.println(wordCounts);
	}

}
