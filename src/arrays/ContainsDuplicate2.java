package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1,2,3}; int k = 2;

        System.out.println(containsNearbyDuplicate2(arr,k ));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        for(int right = 0; right< nums.length; right++){



            if((right - left) > k ){
                set.remove(nums[left]);
                left++;
            }
            if(set.contains(nums[right])){
                return true;
            }
            set.add(nums[right]);
        }
        return false;

    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k){
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                int previousIndex = map.get(nums[i]);

                if (i - previousIndex <= k) {
                    return true;
                }
            }

            // Store/update the latest index
            map.put(nums[i], i);
        }

        return false;
    }
}
