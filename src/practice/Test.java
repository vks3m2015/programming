package practice;

import java.util.HashSet;
import java.util.Set;

public class Test {

	void printMajority(int a[], int n)
	{
		Set<Integer> set = new HashSet<Integer>();

		int majority = -1;

		for (int i = 0; i < n; i++){

			if (set.contains(a[i])) {
				majority = i;
			} else {
				set.add(a[i]);
			}
		}
        System.out.println("set = "+ set);
		System.out.println(a[majority]);
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		Test obj = new Test();
		int arr[] = {10, 5, 3, 4, 3, 5, 6, 10};
		int n = arr.length;
		obj.printMajority(arr, n);
	}



}
