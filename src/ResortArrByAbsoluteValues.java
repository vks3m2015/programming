import java.util.Arrays;

/*You are given a sorted array containing both negative and positive values. Resort the array taking absolute value of negative numbers. Your complexity should be O(n)

Ex. A = {-8,-5,-3,-1,3,6,9}
Output: {-1,-3,3,-5,6,-8,9} 

*/
public class ResortArrByAbsoluteValues {
	
	public static void main(String[] arg)
	{
	  
		int[] arr = {-14, -8,-5,-3, -3, -3, -1,3,6,9, 12}; 
		int[] arr2 = new int[arr.length];
		
		int positive =0, negative =0;
		
		//getting the boundary of positive and negative. 
		//where negative numbers ends and positive numbers starts
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] > 0)
			{
				positive =i;
				negative = i-1;
				break;
			}	
		}
		
		int i=0;
		//Merging the two sub arrays into one i.e. in arr2
		while(negative > -1 && positive < arr.length)
		{
			if(Math.abs(arr[negative]) <= Math.abs(arr[positive]))
			{
				
				arr2[i++] = arr[negative];
				negative--;
			}
			else 
			{
				arr2[i++] = arr[positive];
				positive++;
			}	
			
		}
		
		//copy remaining positive numbers
		while(positive < arr.length)
		{
			arr2[i++] = arr[positive++];
		}	
		
		//copy remaining negative numbers
		while(negative > -1)
		{
			arr2[i++] = arr[negative--];
		}	
		
		System.out.println(" arr2 == "+Arrays.toString(arr2));
	}

}
