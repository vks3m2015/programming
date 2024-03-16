package arrays;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class ReplaceWithGreatestEleRight {

   public int[] replaceElements(int[] arr) {
	   int greatest = -1;
	   for(int i = arr.length-1; i>=0; i--) {
		   int temp = arr[i];
		   arr[i] = greatest;
		   greatest = Math.max(greatest, temp);
	   }
	   return arr;
    }
	
	public static void main(String[] args) {

	}

}
