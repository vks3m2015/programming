package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test6 {

	public static void main(String[] args) {

		//List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		  List<Integer> list = Arrays.stream(arr).filter(num -> num % 2 == 0)
				             .mapToObj( num -> num ).collect(Collectors.toList());
		  
		  System.out.println(list);
		  
		  //IntStream.of(arr).filter(null)
		  
		  		  
		
	}

    public static List<int[]> mergeIntervals(int[][] arr){

        Arrays.sort(arr, (a,b) -> a[0]-b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(arr[0]);

        for(int i=1; i< arr.length; i++){
            //int[] last = result.getLast();
            int[] last = result.get(result.size() - 1);
            int[] current = arr[i];

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                result.add(current);
            }

        }
        return result;
    }

}
