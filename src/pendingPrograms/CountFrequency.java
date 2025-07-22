package pendingPrograms;

//https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/
public class CountFrequency {

	public static void main(String[] args) {
		int[] arr = {2,3,3,2,5};
		
		int[] arr2 = arr.clone();
		findCounts(arr);
		findCounts2(arr2);
		
		
	}
	
	public static void findCounts(int[] arr)
	{
		int len = arr.length;
		int i=0;
		
		while(i<len) 
		{
			int element = arr[i];
			
			if(arr[i] < 0)
			{
				i++;
				continue;
			}	
			
			int index = element-1;
			
			if(arr[index] > 0)
			{
				arr[i] = arr[index];
				arr[index] = -1;
			   
			}
			else  //arr[element] < 0
			{
				// If this is NOT first occurrence of arr[i], 
                // then increment its count. 
				arr[index]--; 
				arr[i] = 0;  //means count of element i+1 is not found yet 
				i++;
			}	
						
		}
		
		System.out.println(" count of all elements --");
		for(int j=0; j<len; j++)
		{
			System.out.println(j+1 +" -> "+ Math.abs(arr[j]));
		}	
	}
	
	public static void findCounts2(int[] arr)
	{
		int len = arr.length;
		
		for(int i=0; i< len; i++)
			arr[i]--;
		
		for(int i=0; i<len; i++)
		{
			arr[arr[i] % len] += len; 
		}
		
		System.out.println("  count of elements ********");
		for(int i=0; i<len; i++)
		{
			System.out.println(i+1 +" -> "+arr[i]/len);
		}	
	}

}
