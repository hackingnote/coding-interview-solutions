Partition Array
===


Problem
-------

Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Example
-------

If nums = [3,2,2,1] and k=2, a valid answer is 1.

Note
----

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Challenge
---------

Can you partition the array in-place and in O(n)?

Solution
--------
