Longest Consecutive Sequence
===


Problem
-------

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.


Example
-------

Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
---------

Your algorithm should run in O(n) complexity.

Challenge
---------

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<>();

        for (int i : num) {
            set.add(i);
        }

        int max = 0;

        for (int i : num) {
            if (!set.contains(i)) {
                continue;
            }

            int cnt = 1;
            int k = i;
            while (set.contains(++k)) {
                cnt++;
            }
            k = i;
            while (set.contains(--k)) {
                cnt++;
            }

            max = Math.max(max, cnt);

        }
        return max;
    }
}
```