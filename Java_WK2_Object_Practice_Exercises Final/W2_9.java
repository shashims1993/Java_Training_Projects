/*
9. Write a program to calculate the frequency of the words in a given file,
Example: Create a file named FileDemo.txt with the following content 
i am a man , 
i like to sleep , 
i have a home.
Output: i->3 times, 
am-1, 
like -1, 
have -1, 
a-2 etc.,*/
import java.util.*;
import java.io.*;

public class W2_9 {
    public static void main(String[] args) throws FileNotFoundException {
        // open the file
        String fileName = "//home//ubuntu//workspace//Java//Java Workspace//WK2_Object_Exercises//FInal//Java_WK2_Object_Practice_Exercises//input.txt";
        Scanner input = new Scanner(new File(fileName));
       
        // count occurrences
        Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
        while (input.hasNext()) {
     
            String next = input.next().toLowerCase();
       
            if (!wordCounts.containsKey(next)) {
                wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
        for (String word : wordCounts.keySet()) {
        	if(!word.equals(",") && !word.equals(",") )
        	{
            int count = wordCounts.get(word);
                System.out.println(word  + "\t" + count);
        	}
        }
    }
}