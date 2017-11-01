
/*Write a program to transpose the given string.
Input String : a quick brown fox jumps over the lazy dog
Output String: a  kciuq  nworb  xof  spmuj  revo  eht  yzal  god*/

import java.util.Scanner;

public class WK3_PE_5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String");
		String inputString = input.nextLine();
		input.close();
		String[] splitInput = inputString.split("\\s");
		String outputString = "";
		for (String b : splitInput) {
			char[] try1 = b.toCharArray();

			for (int i = try1.length - 1; i >= 0; i--) {
				outputString += try1[i];
			}
			outputString += " ";
		}
		System.out.println("Input String : " + inputString);
		System.out.println("Output String : " + outputString);

	}

}
