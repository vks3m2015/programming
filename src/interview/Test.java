package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
	
		int a[] = {1,4,5,6,32,50,60,70,80,90};   //O(n)  
		int k = 33;
		
		
		int start = 0, end = a.length-1;
		int mid =0;
		int result = -1;  
		while(start < end) {
			mid = start + (end - start)/2;
			//System.out.println("start ="+start + " end = "+end + " mid = "+mid);
			if(k == a[mid]) {
				result = a[mid];
				break;
			}
			else if(k >a[mid]) {
				start = mid+1;
			}else {
				end = mid -1;
			}	
		}
		if(result == -1) {
		System.out.println("start ="+start);
		int diff1 =   Math.abs(a[start-1] -k );
		int diff2 =  Math.abs(a[start + 1] -k );
		result =  (diff1 > diff2)? a[start +1] : a[start]; 
		System.out.println(result);
		}else {
			System.out.println(result);
		}
			
		
		
}

}
 
 







  

















