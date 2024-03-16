package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

//https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class FrequencySort {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> fmap = new HashMap<>();
        
		/*
		 * for(Integer num : nums) { fmap.put(num, fmap.getOrDefault(num, 0)+1); }
		 */
        
        Arrays.stream(nums).forEach(num -> fmap.put(num, fmap.getOrDefault(num, 0)+1));
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(fmap.entrySet());
        
        Collections.sort(list, (e1, e2) -> {
        	  if (e1.getValue() == e2.getValue())
                  return e2.getKey() - e1.getKey();
              else 
                  return e1.getValue() - e2.getValue();
        });
        
        int curr = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
        	int num = entry.getKey();
        	int count = entry.getValue();
        	
        	while(count > 0) {
        		nums[curr++] = num;
        		count--;
        	}
        }
        return nums;    	
    }
    
    //Reduced line of code using java8
    public int[] frequencySort2(int[] nums) {
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

    	return Arrays.stream(nums).boxed()
    			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
    			.mapToInt(n -> n)
    			.toArray();
    }

	public static void main(String[] args) {

		int[] nums = {1,1,2,2,2,3}; //[3,1,1,2,2,2]
		int[] sortedNums = frequencySort(nums);
		System.out.println(Arrays.toString(sortedNums));
		
		int[] nums2 = {-1,1,-6,4,5,-6,1,4,1}; //[5,-1,4,4,-6,-6,1,1,1]
		System.out.println(Arrays.toString(frequencySort(nums2)));
		
	}

}
