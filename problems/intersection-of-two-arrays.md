Intersection of Two Arrays 
==========================

LintCode 574: https://www.lintcode.com/en/problem/intersection-of-two-arrays/

Problem
-------



Given two arrays, write a function to compute their intersection.
Notice

- Each element in the result must be unique.
- The result can be in any order.

Example
-------

Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].



Code(Java)
----------

```java

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) set1.add(i);

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }
        ;

        int[] arr = new int[result.size()];
        int k = 0;
        for (int i : result) {
            arr[k++] = i;
        }

        return arr;
    }
}

```