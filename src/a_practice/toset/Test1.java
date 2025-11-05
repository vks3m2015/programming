package a_practice.toset;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,10,13};
       int index = binarySearch(arr, 0, 6, 14 );
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int start, int end, int key){

        int mid = start + (end - start) /2;

        if(arr[mid] == key )
            return mid;

        if(key > arr[mid] ){
            return binarySearch(arr, mid + 1, end, key );
        }else {
            return binarySearch(arr, start , mid - 1, key );
        }
    }
}
