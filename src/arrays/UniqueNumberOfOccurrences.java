package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/unique-number-of-occurrences/
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
    	//Count Map
    	Map<Integer, Long> countMap = Arrays.stream(arr)
    			.boxed()
    			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	
    	Set<Long> occurances = new HashSet<Long>();
    	for(Long freq : countMap.values()) {
    		if(!occurances.add(freq)) {
    			return false;
    		}
    	}
      return true;
    }
    
    public boolean uniqueOccurrences2(int[] arr) {
        
    	//Count Map
        Map<Integer, Long> countMap = Arrays.stream(arr)
    			.boxed()
    			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	
    	return countMap.values().size() == new HashSet<Long>(countMap.values()).size();
    }
    
	public static void main(String[] args) {

	}

}
