package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class GreatestOnRightSide {

  //Optimized one	
   public static int[] replaceElements(int[] arr) {
    	
	   int mx = -1, n = arr.length, temp;
       for (int i = n - 1; i >= 0; --i) {
           temp = arr[i];
           arr[i] = mx;
           mx = Math.max(mx, temp);
       }
       return arr;
    }

    public static int[] replaceElements2(int[] arr) {
    	int[] ans = new int[arr.length];
    	int max = arr[arr.length-1];
    	ans[arr.length-1] = -1;
    	
    	for(int i = arr.length-2; i >= 0; i--) {
    		ans[i] = max;
    		if(arr[i] > max) max = arr[i];
    	}
    	
		return ans;
    }


	public static void main(String[] args) {
		int[] arr = {17,18,5,4,6,1};
		int[] ans = replaceElements(arr);

		System.out.println(Arrays.toString(ans));
	}

}
