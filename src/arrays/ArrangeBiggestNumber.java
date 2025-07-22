package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Arrange given numbers to form the biggest number
 * 
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value
 */
public class ArrangeBiggestNumber {

	public static void main(String[] arg)
	{
		int[] arr = {54, 546, 548, 60};
		//System.out.println(biggestNumber(arr));
		
		stringSort();
	}
	
	public static String biggestNumber(int[] arr)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i : arr)
			list.add(i);
		
		Comparator<Integer> comp = (Integer x, Integer y)->{
			
			String xy = "" + x + y;
			String yx = "" + y + x;
			
			return yx.compareTo(xy);
		};
		
		Collections.sort(list, comp);
		//Arrays.sort(arr, comp);
		
		String biggestNumber = "";
		
		for(Integer num : list)
			biggestNumber += num;
		
	    return biggestNumber;
	}
	
	public static void stringSort()
	{
		String[] arr = {"6","65","64","653"};
		
		Arrays.sort(arr);
		
		System.out.println("Array =="+Arrays.toString(arr));
	}
}




