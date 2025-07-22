/*  Program that takes input an integer array 0-9 i.e. [2,4,5,0,8] and gives sorted strings regarding these integers.
 *  
 *   input - [2,4,5,0,8]
 *   output - [eight, five, four, two, zero]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNumberString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String[] numbers = {"zero", "one", "two","three", "four", "five", "six", "seven", "eight", "nine"};
		List<String> arrayList = new ArrayList<String>();
			
		System.out.println("Enter number of elements in array");
		int length = sc.nextInt();
		
		int[] intArr = new int[length];
		
		System.out.println(" Enter elements ");
		for(int i=0; i< length; i++)
			intArr[i] = sc.nextInt();
		
		for(int i=0; i<length; i++)
		{
			
			arrayList.add(numbers[intArr[i]]);	
		}	
		
		Collections.sort(arrayList);
		System.out.println("  arrayList = "+arrayList);

	}

}
