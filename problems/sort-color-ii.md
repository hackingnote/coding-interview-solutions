Sort Colors II
===========

LintCode 143: http://www.lintcode.com/en/problem/sort-colors-ii/

Problem
-------

Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Notice

You are not suppose to use the library's sort function for this problem.

Example
-------

Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Solution
---------


Code(Java)
----------

```java

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int left = 0, right = colors.length - 1;
        int small = 1, big = k;
    
        while (small < big) {
            
            for (int i = 0; i <= right;) {
                if (colors[i] == small) {
                    colors[i] = colors[left];
                    colors[left++] = small;
                    i++;
                } else if (colors[i] == big) {
                    colors[i] = colors[right];
                    colors[right--] = big; 
                } else {
                    i++;
                }
            }
            small++;
            big--;
        }
    }
}

```