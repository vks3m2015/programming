

/* Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
 * The array might also contain duplicates. You may assume that both x and y are different and present in arr[]
 *
 * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
   Output: Minimum distance between 3 and 2 is 1.
 *
 * https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 */
public class MinDistance {


	/*@Test
	public void testCases()
	{
		MinDistance min = new MinDistance();

		int[] arr = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
		assertEquals(1,  min.minDistance(arr, 3, 6));

		arr = new int[] {2, 5, 3, 5, 4, 4, 2, 3};

		assertEquals(1, min.minDistance(arr, 3, 2));

	}*/

    public static void main(String[] args) {

        MinDistance min = new MinDistance();
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;

        System.out.println("Minimum distance between " + x + " and " + y
                + " is " + min.minDistance(arr, x, y));

    }

    public int minDistance(int[] arr, int x, int y)
    {
        int first = -1;  //first will have index of any of element x or y
        int min_distance = Integer.MAX_VALUE;

        for(int i=0; i< arr.length; i++)
        {
            if(arr[i] == x || arr[i] == y)
            {
                if(first == -1)  //updating for the first time
                {
                    first = i;
                    continue;
                }

                if(arr[i] != arr[first] && (i-first) < min_distance)
                {
                    min_distance = i-first;
                    first = i;
                }
                else
                {
                    first = i;
                }

            }
        }

        return min_distance;

    }

}
