
/*Write a program where an array of strings is input and output is a Map<String,boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array
Input : String arr[] = {"a","b","c","d","a","c","c"}    
Output - {"a" : true,"b" :false ,"c" :true,"d" : false}*/

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class WK3_PE_Collections_3 {

	public static void main(String[] args) {

		String arr[] = { "a", "b", "c", "d", "a", "c", "c", "d" };
		Map<String, Boolean> map = new TreeMap<String, Boolean>();

		for (String temp : arr) {
			temp = temp.toLowerCase();

			if (!map.containsKey(temp)) {
				map.put(temp, false);
			} else {
				map.put(temp, true);
			}

		}
		System.out.println("Input: " + Arrays.toString(arr));
		System.out.println("Output: " + map);
	}

}
