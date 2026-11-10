import java.util.*;
/*
## Problem: K-th Smallest Term

You are given an integer array `arr` of length `n` and a long integer `k`.

Consider the cross-product array formed by pairing every element with every other element, including itself. For every pair of indices `i` and `j`, where `0 ≤ i, j < n`, include the pair:

`(arr[i], arr[j])`

This produces a total of `n × n` ordered pairs.

Sort all these pairs in **lexicographical order**, where pair `(a, b)` comes before pair `(x, y)` if:

1. `a < x`, or
2. `a == x` and `b < y`.

Your task is to return the **k-th pair (using 1-based indexing)** from the sorted list.

### Function Description

Complete the function `getKthSmallestTerm` with the following parameters:

- `arr[n]`: An array of integers.
- `k`: A long integer representing the position of the required pair.

### Returns

A list containing two integers representing the k-th lexicographically smallest pair.

### Example

**Input:**
```text
arr = [3, 1, 2]
k = 7
```

**Explanation:**

The cross-product contains the following nine pairs:

```text
(3,3), (3,1), (3,2),
(1,3), (1,1), (1,2),
(2,3), (2,1), (2,2)
```

After sorting in lexicographical order:

```text
(1,1), (1,2), (1,3),
(2,1), (2,2), (2,3),
(3,1), (3,2), (3,3)
```

The 7th pair is `(3,1)`.

**Output:**
```text
[3, 1]
```

### Constraints

- `1 ≤ n ≤ 10^5`
- `1 ≤ k ≤ n²`
 */
public class KthPair {
    public static List<Integer> getKthSmallestTerm(List<Integer> arr, long k) {
        Collections.sort(arr);
        int n = arr.size();
        // Count the frequency of each value
        Map<Integer, Long> freq = new LinkedHashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0L) + 1);
        }
        // Find the first element of the kth pair
        int first = 0;
        long remaining = k;
        for (Map.Entry<Integer, Long> entry : freq.entrySet()) {
            long count = entry.getValue() * n;
            if (remaining <= count) {
                first = entry.getKey();
                break;
            }
            remaining -= count;
        }
        // Find the second element of the kth pair
        for (Map.Entry<Integer, Long> entry : freq.entrySet()) {
            long count = freq.get(first) * entry.getValue();
            if (remaining <= count) {
                return Arrays.asList(first, entry.getKey());
            }
            remaining -= count;
        }
        return new ArrayList<>();
    }
}
