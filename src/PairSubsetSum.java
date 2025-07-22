import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairSubsetSum {
	
	public static void main(String[] arg)
	{
	   
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		System.out.println("Enter number of elements in array");
		int length = sc.nextInt();
		
		int[] intArr = new int[length];
		
		System.out.println(" Enter elements ");
		for(int i=0; i< length; i++)
		{
			int temp = sc.nextInt();
			intArr[i] = temp;
			set.add(new Integer(temp));
			
		}	
		
		System.out.println(" Enter sum ");
		int sum = sc.nextInt();
		
		for(int i=0; i< length; i++)
		{
			int temp = intArr[i];
			 int addInt = sum - temp;
			 
			 if(set.contains(new Integer(addInt)))
			 {
				 System.out.println(" ( "+ temp + " , "+ addInt + " ) ");
				 
			 }	 
			
		}	
		
	}

}
