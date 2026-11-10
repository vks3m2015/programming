# Sliding Window LeetCode Practice Guide

Work through the practice sequence in order. Each problem is listed once under its primary pattern; notes call out relevant overlaps.

## Fixed Size Sliding Window

Keep the window length constant. Add the incoming item, remove the outgoing item, then update the answer.

| No. | Problem | Difficulty | Pattern note |
| --- | --- | --- | --- |
| 643 | [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) | Easy | Running sum over exactly `k` elements. |
| 1343 | [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/) | Medium | Compare a fixed sum with `k * threshold`. |
| 1456 | [Maximum Number of Vowels in a Substring of Given Length](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) | Medium | Maintain a vowel count while the window slides. |
| 1052 | [Grumpy Bookstore Owner](https://leetcode.com/problems/grumpy-bookstore-owner/) | Medium | Baseline answer plus the best fixed-window gain. |
| 219 | [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) | Easy | Use a set or frequency map over the last `k` positions. |
| 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | Medium | Fixed-size frequency comparison. Also a frequency-map problem. |
| 438 | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | Medium | Fixed-size frequency comparison; collect valid start indices. Also frequency-map. |
| 30 | [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | Hard | Fixed word-width window with required and current word counts. Also frequency-map. |
| 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Use a monotonic deque rather than a running sum. |

## Variable Size Sliding Window

Expand `right` to explore. Move `left` only while the constraint is broken or while minimizing a valid window.

| No. | Problem | Difficulty | Pattern note |
| --- | --- | --- | --- |
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Medium | Shrink until every character is unique. Also frequency-map. |
| 209 | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | Medium | With positive numbers, shrink while sum is at least target. |
| 904 | [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/) | Medium | Longest window with at most two distinct values. Also frequency-map. |
| 1004 | [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | Medium | Longest window containing at most `k` zeroes. |
| 424 | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | Medium | Valid when `windowLength - maxFrequency <= k`. Also frequency-map. |
| 1493 | [Longest Subarray of 1s After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/) | Medium | Keep at most one zero; account for the required deletion. |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | Hard | Expand to cover all required characters, then shrink to minimize. Also frequency-map. |
| 713 | [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/) | Medium | Positive numbers only: divide from the left until valid. Also counting. |

## Frequency Map Sliding Window

Use a map or array when validity depends on counts, distinct values, or coverage of another string.

| No. | Problem | Difficulty | Pattern note |
| --- | --- | --- | --- |
| 159 | [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | Medium | Count distinct characters; shrink when more than two remain. Premium on LeetCode. |
| 340 | [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | Medium | General form of 159. Premium on LeetCode. |
| 487 | [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/) | Medium | At most one zero; a bridge to 1004. Premium on LeetCode. |
| 395 | [Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) | Medium | Enumerate target distinct counts and use frequency thresholds. |

## Counting Subarrays

When every window ending at `right` is valid, add the number of valid starts rather than recording only a maximum.

| No. | Problem | Difficulty | Pattern note |
| --- | --- | --- | --- |
| 930 | [Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/) | Medium | `atMost(goal) - atMost(goal - 1)`, or prefix sums. |
| 1248 | [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/) | Medium | Convert odd values to ones; count exactly `k` with at-most subtraction. |
| 1358 | [Number of Substrings Containing All Three Characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/) | Medium | After a valid window, add `n - right` for every valid `left`. |
| 992 | [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/) | Hard | `exactly(k) = atMost(k) - atMost(k - 1)`. |
| 2962 | [Count Subarrays Where Max Element Appears at Least K Times](https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/) | Medium | Once count reaches `k`, add `n - right` as `left` moves. |
| 2302 | [Count Subarrays With Score Less Than K](https://leetcode.com/problems/count-subarrays-with-score-less-than-k/) | Hard | Positive numbers: keep `sum * length < k`, then add window length. |

## Recommended Practice Sequence

- [ ] 643. Maximum Average Subarray I
- [ ] 1456. Maximum Number of Vowels in a Substring of Given Length
- [ ] 219. Contains Duplicate II
- [ ] 3. Longest Substring Without Repeating Characters
- [ ] 209. Minimum Size Subarray Sum
- [ ] 904. Fruit Into Baskets
- [ ] 1004. Max Consecutive Ones III
- [ ] 567. Permutation in String
- [ ] 438. Find All Anagrams in a String
- [ ] 424. Longest Repeating Character Replacement
- [ ] 713. Subarray Product Less Than K
- [ ] 76. Minimum Window Substring
- [ ] 1358. Number of Substrings Containing All Three Characters
- [ ] 1248. Count Number of Nice Subarrays
- [ ] 930. Binary Subarrays With Sum
- [ ] 992. Subarrays with K Different Integers
- [ ] 239. Sliding Window Maximum
- [ ] 30. Substring with Concatenation of All Words
- [ ] 2302. Count Subarrays With Score Less Than K

## Pattern Reminders

- **Frequency arrays:** increment when `right` enters; decrement when `left` leaves. The array reflects the current window.
- **Stale maximum frequency:** in 424, stored `maxFreq` can be historical; the optimization remains correct for the maximum length.
- **Exactly K:** a common conversion is `exactly(k) = atMost(k) - atMost(k - 1)`.
- **Positive-number condition:** sum and product shrinking arguments depend on positive values. With negatives, prefer prefix sums or a different approach.
