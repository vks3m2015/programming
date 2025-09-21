package string;

import java.util.Scanner;

//Return maximum occurring character in an input string

public class MaxOccuringChar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println(" Enter string");
		String str = sc.nextLine();
		
		if(str.equals("q"))
			break;
		System.out.println(" max occuring char = "+maxChar(str));
		}
		
		System.out.println(" exit ");
		sc.close();

	}
	
	public static char maxChar(String str) {
		 final int ASCII_SIZE = 256;
		 int[] count = new int[ASCII_SIZE];
		 
		 for(int i=0; i< str.length(); i++) {
			 count[str.charAt(i)]++;
		 }	 
		 
		 int max = -1;
		 char result = ' ';
		 
		 for(int i=0; i< str.length(); i++) {
			 if(count[str.charAt(i)] > max) {
				 max = count[str.charAt(i)];
				 result = str.charAt(i);
			 
			 }
		 }	 
		 return result;
	}
}
