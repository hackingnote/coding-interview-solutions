Rotate Array
====

Problem
----

Rotate an array of n elements to the right by k steps.
*[LeetCode 189](https://leetcode.com/problems/rotate-array/)

Example
----

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Solution #1
----

Rotate one step to the right each time and rotate k times totally. Time complexity O(k*n), Space complexity O(1). (Status:Time Limit Exceeded) 

Code #1
----

```cpp
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (nums.empty()) return;
        k %= nums.size();
        if (k == 0) return;
        int i, j, tmp;
        for (i = 0; i < k; i++) {
            tmp = nums[nums.size()-1];
            for (j = nums.size()-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;
        }
    }
};
```

Solution #2
----

Create a new array and fill each element right into the position. Time complexity O(n), Space complexity O(n). (Status: 24 ms) 

Code #2
----

```cpp
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (nums.empty()) return;
        k %= nums.size();
        if (k == 0) return;
        int i;
        vector<int> tmp;
        for (i = 0; i < nums.size(); i++) tmp.push_back(nums[i]);
        for (i = 0; i < tmp.size(); i++) {
            nums[(i+k)%nums.size()] = tmp[i];
        }
    }
};
```

Solution #3
----

Firstly reverse the whole array in place. Then reverse the first k elements, and also the rest n-k elements. Time complexity O(n), Space complexity O(1). (Status: 24 ms) 

Code #3
----

```cpp
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (nums.empty()) return;
        k %= nums.size();
        if (k == 0) return;
        int i, j, tmp;
        for (i = 0, j = nums.size()-1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for (i = 0, j = k-1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for (i = k, j = nums.size()-1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
};
```

Solution #4
----
TBD
