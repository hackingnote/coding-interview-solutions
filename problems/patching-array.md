Patching Array
====

Problem
----

Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

[LeetCode 330](https://leetcode.com/problems/patching-array/)

Example #1
----

nums = [1, 3], n = 6

Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.

Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].

Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].

So we only need 1 patch.

Example #2
----

nums = [1, 5, 10], n = 20

Return 2.

The two patches can be [2, 4].

Example #3
----
nums = [1, 2, 2], n = 5

Return 0.

Solution
----
Greedy. 

Assume there is not any element in array.

[] -> [], the next missing value is 1.

[1] -> [1], the next missing value is 2.

[1, 2] -> [1, 2, 3], the next missing value is 4.

[1, 2, 4] -> [1, 2, 3, 4, 5, 6, 7], the next missing value is 8.

The greedy idea here is to get as many values as possible. Meanwhile, if we already can get values [1, k] and add a new value p, we are supposed to get [1, k] and [p, p+k]. If p <= k+1, it would be [1, p+k].

For example, [1, 1, 5, 10] and n = 20.

[] -> [], the next missing value is 1, and 1 is in given array.

[1] -> [1], there is another 1 <= max value, so we can get [1, 1], 1, and [2, 2].

[1, 1] -> [1, 2], the next missing value is 3. Add 3.

[1, 1, 3] -> [1, 2, 3, 4, 5], In array, 5 <= max value in range, so we can get [1, 5], 5 and [6, 10].

[1, 1, 3, 5] -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], Then we get [1, 10], 10 and [11, 20].

[1, 2, 3, 5, 10] -> [1, 2,..., 20]

Code
----

```cpp
class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        unsigned int cnt = 1, idx = 0;
        int ret = 0;
        while (cnt <= n) {
            // Extend the range by adding next missing value.
            if (idx >= nums.size() || cnt < nums[idx]) {
                cnt *= 2;
                ret++;
                continue;
            }
            // Merge two range together if there is intersection.
            // [1, cnt] and [nums[idx], nums[idx]+cnt].
            cnt += nums[idx];
            idx++;
        }
        return ret;
    }
};
```
