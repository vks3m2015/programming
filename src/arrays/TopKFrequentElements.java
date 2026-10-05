package arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/top-k-frequent-elements/description/?envType=problem-list-v2&envId=array
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 Ex-
 Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]
 */
public class TopKFrequentElements {

    public static void main(String[] args) {

    }

    int[] topKFrequent(int[] nums, int k){
        return Arrays.stream(nums).mapToObj(num -> num)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, Long> entry) -> entry.getValue()).reversed())
                .limit(k)
                .map(entry -> entry.getKey())
                .mapToInt(num -> num)
                .toArray();
    }

    public List<Integer> topKFrequentBucketSort(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
