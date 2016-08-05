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

Given this sorted array, we start from []. If the value in array is out of range, use previous greedy idea to get the max number of integer from 1. Otherwise, we merge two range together.

Code
----

```cpp
class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        unsigned int cnt = 1, idx = 0;
        int ret = 0;
        while (cnt <= n) {
            // If the values in array is out of range,
            // add one value to maximize the range.
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
