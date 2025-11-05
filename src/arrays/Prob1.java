package arrays;

import java.util.Arrays;

/*
Given a sorted array of integers, return an array of the squares of each number sorted in non-decreasing order.
Input: arr = [-4, -1,0,3,10]
Output: [0,1,9,16,100]

 */
public class Prob1 {

    public static void main(String[] args) {

        int[] arr = {-4, -1,0,3,10};

        int firstPosIndex;
        for ( firstPosIndex = 0; firstPosIndex < arr.length; firstPosIndex++) {
           if(arr[firstPosIndex] >= 0){
               break;
           }
        }
        System.out.println(" firstPosIndex = "+ firstPosIndex);
        for(int i = firstPosIndex-1; i>=0; i--){

            int key = arr[i];


            int j = i+1;

           // System.out.println(" key = "+ key  + " j = "+ j) ;
            while(j < arr.length && Math.abs(arr[j]) < Math.abs(key)){
                arr[j-1] = arr[j];
                j++;
            }
           // System.out.println(" j = "+ j);
            arr[j-1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
}
