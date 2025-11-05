package arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/dsa/merge-two-sorted-arrays-o1-extra-space/
public class MergeSortedArrWithoutExSpace {

    public static void main(String[] args) {
        int[] arr1 = {1,5,9,15,20};
        int[] arr2 = {2,3,8,13};
        System.out.println("Before merge arr1 = "+ Arrays.toString(arr1));
        System.out.println("Before merge arr2 = "+ Arrays.toString(arr2));

        swapAndSort(arr1, arr2);

        System.out.println("After merge arr1 = "+ Arrays.toString(arr1));
        System.out.println("After merge arr2 = "+ Arrays.toString(arr2));



    }

    static void swapAndSort(int[] arr1, int[] arr2){
        int len1 = arr1.length, len2 = arr2.length;

        int ptr1 = len1-1, ptr2 = 0;

        while(ptr1 >= 0 && ptr2 < len2){

            if(arr1[ptr1] > arr2[ptr2]){
                //swap
                int tmp = arr1[ptr1];
                arr1[ptr1] = arr2[ptr2];
                arr2[ptr2] = tmp;
            }else {
                break;
            }

            ptr1--;
            ptr2++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

}
