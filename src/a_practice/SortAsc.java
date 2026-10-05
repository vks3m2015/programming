package a_practice;

import java.util.Arrays;

/*
•	Given a sorted array of integers, return an array of the squares of each number sorted in non-decreasing order.
Input: arr = [-4, -1,0,3,10]
Output: [0,1,9,16,100]

 */
public class SortAsc {

    public static void main(String[] args) {
        int[] arr = {-4, -1,0,3,10};
        System.out.println(Arrays.toString(sortNonDesc(arr)));
    }

    static int[] sortNonDesc(int[] arr){
        int[] result = new int[arr.length];

        int i=0;
        while(arr[i] < 0){
                i++;
        }

        int j = i-1, k=0;

        while (i < arr.length && j>=0){

            if(arr[i] * arr[i] <= arr[j] * arr[j]){
                result[k++] = arr[i]* arr[i];
                i++;
            }else{
                result[k++] = arr[j]* arr[j];
                j--;
            }
        }

        while(i < arr.length){
           result[k++] = arr[i] * arr[i];
           i++;
        }

        while(j >= 0){
            result[k++] = arr[j] * arr[j];
            j--;
        }
        return result;
    }
}
