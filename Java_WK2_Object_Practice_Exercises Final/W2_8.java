

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class W2_8 {
	public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file path of Folder:");
        String FileName=scan.nextLine();
        File directory = new File(FileName);
        System.out.println("Enter the file Extension too read in that folder:");
        String fileExt=scan.nextLine();
        File[] listOfFiles = directory.listFiles();//To get the list of file-names found at the "directoy"
        BufferedReader br = null;
        String words[] = null;
        String line;
        String files;
        for (File file : listOfFiles) { 
            if (file.isFile()) {
                files = file.getName();
                String filename=FileName+"//"+files;
//                System.out.println(files);
                try {
                    if (files.endsWith(fileExt)) {  //Checks whether an file is an text file 
                    	FileReader fileReader = new FileReader(filename);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        while((line = bufferedReader.readLine()) != null) {
                            System.out.println(line.toUpperCase());
                        }  
                    }
                   
                } catch (NullPointerException | IOException e) {
                    System.out.println("I could'nt read your files:" + e);
                }
            }
                                         
        }
    }
		 }
