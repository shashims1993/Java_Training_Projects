
/*Write a method that accepts a Map object having two key-value pairs with the keys val1 and val2. Modify and return the given map as follows:
a. If the key `val1` has a value, set the key `val2` to have that value, and
b. Set the key `val1` to have the value `"  "` (empty string).

 Example 1: 
    The map {"val1": "java", "val2": "c++"} should return {"val1": " ", "val2": "java"}

 Example 2: 
    The map {"val1": "mars", "val2": "saturn"}  should return {"val1": " ", "val2": "mars"}*/

import java.util.Map;
import java.util.TreeMap;

public class WK3_PE_Collections_5 {

	public static void main(String[] args) {

		Map<String, String> map = new TreeMap<String, String>();
		Map<String, String> map1 = new TreeMap<String, String>();
		map.put("val1", "java");
		map.put("val2", "c++");
		map1 = mapModify(map);
		System.out.println("Input: " + map);
		System.out.println("Output:" + map1);

	}

	public static Map<String, String> mapModify(Map<String, String> m) {
		Map<String, String> modifiedMap = new TreeMap<String, String>();
		int count = 0;
		String value = null;
		for (Map.Entry element : m.entrySet()) {
			String key = (String) element.getKey();
			if (count == 0) {
				value = (String) element.getValue();
				modifiedMap.put(key, " ");
			} else {
				modifiedMap.put(key, value);
			}
			count++;
		}

		return modifiedMap;
	}

}
