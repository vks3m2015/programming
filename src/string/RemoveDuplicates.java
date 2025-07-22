/*
 * 
 * 
 */
package string;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicates {
	
	//there are many other ways also
	
	public String removeDuplicatesFromString(String inputStr)
	{
		//char[] charArray = inputStr.toCharArray();
		StringBuilder sb = new StringBuilder();
		LinkedHashSet<Character> hs = new LinkedHashSet<Character>();
		
		for(int i =0; i< inputStr.length(); i++)
		{
           hs.add(inputStr.charAt(i));
		}	
		
		for(Character ch : hs)
		{
			sb.append(ch);
		}
		
		return String.valueOf(sb);
			
	}
   
	public static void main(String[] arg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the string");
		String inputStr = sc.nextLine();
		
		String str = new RemoveDuplicates().removeDuplicatesFromString(inputStr);
		
		System.out.println("  after removing =="+str);
		sc.close();
		
	}
}
