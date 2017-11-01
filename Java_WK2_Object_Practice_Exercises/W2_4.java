/*
 4.Write a program to read the content of a text file, convert the content in upper case and print the same in console along with the length of the file.
 */

import java.io.*;
public class W2_4 {

	public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "//home//ubuntu//workspace//Java//Java Workspace//WK2_Object_Exercises//FInal//Java_WK2_Object_Practice_Exercises//input.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line.toUpperCase());
            }   
            File f = new File(fileName);
            System.out.println("File length is "+f.length());
            bufferedReader.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"  + fileName + "'");                  
          
        }
    }
   }