import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 
Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

https://www.geeksforgeeks.org/sort-elements-by-frequency/
https://self-learning-java-tutorial.blogspot.com/2014/08/sort-elements-by-frequency.html
*/

public class SortByFrequency {
	
	/* METHOD 1 - Using HashMap
	 * 
	 */
	public static void usingHashMap(int[] inputArr, int[] outputArr)
	{
		Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();
		
		//Making Count HashMap
		for(int element : inputArr)
		{
			//System.out.println(" element ="+element);
			if(countMap.containsKey(element))
			{
				int frequency = countMap.get(element);
				countMap.put(element, ++frequency);
				//System.out.println("  present");
			}
			else
			{
				countMap.put(element, 1);
				//System.out.println("not present");
			}
				
				
		}
		
		//System.out.println("  map =="+countMap);
		
		List<Map.Entry<Integer, Integer>> countList = new LinkedList<Map.Entry<Integer, Integer>>(countMap.entrySet());
		
		Comparator<Map.Entry<Integer, Integer>> countComparator = (Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) -> {
			
			return (obj1.getValue() - obj2.getValue());
		};
		
		Collections.sort(countList, countComparator);
		
		//Making final array (outputArr) from sorted countList
		int index =0;
		for(Map.Entry<Integer, Integer> entry :countList)
		{
			int count = entry.getValue();
			
			//System.out.println(" countList  key="+entry.getKey()+ "   value ="+count);
			while(count>0)
			{
				outputArr[index++] = entry.getKey();
				count--;
			}	
			
		}	
		//printing output array
		for(int element : outputArr)
		{
			System.out.print(" "+element);
		}
		
		//System.out.println("  comapareTo ="+ "a".compareTo("b"));
		
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
		int[] outputArr = new int[8];		
		usingHashMap(arr,outputArr);

	}

}
