package arrays;

/* Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. 
 * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2
 * 
 * https://www.geeksforgeeks.org/leaders-in-an-array/
 */
public class LeaderElements {

	public void leaderElements(int[] arr, int size)
	{
	   int greatest = arr[size-1];
	   
	   for(int i= size-2 ; i>= 0; i--)
	   {
		   if(arr[i] > greatest)
		   {
			   greatest = arr[i];
			   System.out.println("  "+greatest);
		   }	   
	   }	   
	}
	public static void main(String[] args) {
	 
		    LeaderElements lead = new LeaderElements(); 
	        int arr[] = new int[]{16, 17, 4, 3, 5, 2}; 
	        int n = arr.length; 
	        lead.leaderElements(arr, n); 

	}

}
