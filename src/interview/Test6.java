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

}
