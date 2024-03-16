package interview;

public class Test4 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int key = 4;
		int start = 0, end = arr.length - 1, mid;
		boolean found = false;
		
		while(start < end) {
			mid = start + (end-start)/2;
			System.out.println(" start = "+ start + " end = "+ end + " mid = "+ mid);
			System.out.println(" arr[mid] = "+ arr[mid]);
			if(key == arr[mid]) {
				found = true;
				System.out.println("Element present at index ="+ mid);
				break;
			}
			else if(arr[mid] > key) {
				end = mid - 1;
			}else {
				start = mid +1;
			}
		}
		
		if(!found)
		System.out.println("Element is not present");
		
		
		
		

	}
  }
