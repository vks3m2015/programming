
import java.util.*;
/*
## Problem: Count Redundant Backups

You are given two lists of equal length:

- `fileName`: A list of strings representing file names.
- `timestamp`: A list of integers representing the timestamps when backups were created.

The backup at index `i` corresponds to the file `fileName[i]` and was created at time `timestamp[i]`.

A file is considered to have **redundant backups** if it has at least **3 backups created within a 24-hour period**.

Your task is to count the number of distinct files that satisfy this condition.

### Function Description

Complete the function `countRedundantBackups` with the following parameters:

- `List<String> fileName`: The names of the files being backed up.
- `List<Integer> timestamp`: The corresponding backup timestamps, represented as integers in seconds.

### Returns

An integer representing the number of distinct files that have at least 3 backups within a 24-hour period.

### Rules

1. Group backup records by file name.
2. Consider the timestamps of each file independently.
3. A file qualifies if at least 3 of its backups occur within a time interval of 24 hours (86,400 seconds).
4. Count each qualifying file only once, regardless of how many qualifying groups of backups it has.
5. A time difference of exactly 86,400 seconds is considered within the 24-hour period.

### Example 1

**Input:**
```text
fileName = ["A.txt", "A.txt", "A.txt", "B.txt", "B.txt", "C.txt"]
timestamp = [1000, 2000, 3000, 1000, 90000, 5000]
```

**Explanation:**

- **A.txt:** Three backups occur at timestamps 1000, 2000, and 3000. The difference between the earliest and latest is 2,000 seconds, so this file qualifies.
- **B.txt:** Its two backups occur at timestamps 1000 and 90000. Only two backups exist, so it does not qualify.
- **C.txt:** Only one backup exists, so it does not qualify.

**Output:**
```text
1
```

### Example 2

**Input:**
```text
fileName = ["A.txt", "A.txt", "A.txt", "A.txt",
            "B.txt", "B.txt", "B.txt"]
timestamp = [100, 200, 300, 400,
             1000, 2000, 90000]
```

**Explanation:**

- **A.txt:** Four backups occur within 24 hours, so it qualifies.
- **B.txt:** The backups at 1000 and 2000 are within 24 hours, but the third backup at 90000 is more than 24 hours after the first. No group of three backups fits within a 24-hour interval, so it does not qualify.

**Output:**
```text
1
```
 */
public class CountRedundantBackups {

    public static int countRedundantBackups(
            List<String> fileName,
            List<Integer> timestamp) {

        Map<String, List<Integer>> map = new HashMap<>();
        // Group timestamps by filename
        for (int i = 0; i < fileName.size(); i++) {
            map.computeIfAbsent(fileName.get(i), k -> new ArrayList<>())
                    .add(timestamp.get(i));
        }
        int redundantFiles = 0;
        // Check each file
        for (List<Integer> times : map.values()) {
            // Sort timestamps
            Collections.sort(times);
            int left = 0;
            for (int right = 0; right < times.size(); right++) {
                // Keep window within 24 hours
                while (times.get(right) - times.get(left) > 86400) {
                    left++;
                }
                // At least 3 backups within 24 hours
                if (right - left + 1 >= 3) {
                    redundantFiles++;
                    break; // Count this file only once
                }
            }
        }
        return redundantFiles;
    }
}
