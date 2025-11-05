package arrays;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {

        int[] arr1 = {1,3,5,6,7,11};
        int[] arr2 = {2,4,8,9,10};
        int[] arr3 = new int[arr1.length + arr2.length];
        int ptr1 = 0, ptr2 = 0, ptr3 = 0;

        while(ptr1 < arr1.length && ptr2 < arr2.length){
            arr3[ptr3++] = arr1[ptr1] <= arr2[ptr2] ? arr1[ptr1++] : arr2[ptr2++];
        }

        while(ptr1<arr1.length){
            arr3[ptr3++] = arr1[ptr1++];
        }

        while(ptr2<arr2.length){
            arr3[ptr3++] = arr2[ptr2++];
        }

        System.out.println(Arrays.toString(arr3));
    }
}
