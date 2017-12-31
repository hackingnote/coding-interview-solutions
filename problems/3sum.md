3Sum
===

Problem
-------

Given an array S of n integers, are there elements a, b, c in S such that ``a + b + c = 0``? Find all unique triplets in the array which gives the sum of zero.

Example
-------

For example, given array S = ``{-1 0 1 2 -1 -4}``, A solution set is:

    (-1, 0, 1)
    (-1, -1, 2)

Note
---------

Elements in a triplet ``(a,b,c)`` must be in non-descending order. (ie, ``a ≤ b ≤ c``)

The solution set must not contain duplicate triplets.


Solution
--------




Code(Java)
----------

```java
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
```