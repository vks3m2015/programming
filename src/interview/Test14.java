package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test14 {

	public static void main(String[] args) {

		int[] arr = {2,3,4,2,4,6,4};
		int target = 8;
		
		/*
		 * Map<Integer, Long> countMap = Arrays.stream(arr).mapToObj(num -> num)
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 * 
		 * countMap.forEach((key, value ) -> { if(countMap.containsKey(target - key)) {
		 * System.out.println(" PAIR = "+ key + ", "+(target - key)); } });
		 */
		
		
		Map<Integer, Integer> count = new HashMap<>();
		for(int i = 0; i< arr.length; i++) {
			int secNum = target - arr[i];
			
			if(count.containsKey(secNum) && count.get(secNum) > 0) {
				count.put(secNum, -1); 
				System.out.println(" PAIR = "+ arr[i] + ", "+secNum);
			}
			
			else count.put(arr[i], 1);
			
		}
				
				
		
		
		
	}

}
