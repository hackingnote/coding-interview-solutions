Maximum Product Subarray
===

## Problem

Find the contiguous subarray within an array (containing at least one number) which has the largest product.


## Example

For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Code(Java)
----------

```java
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        int result = nums[0], max, min, maxPrev = nums[0], minPrev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(Math.max(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            min = Math.min(Math.min(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            
            result = Math.max(result, max);
            
            maxPrev = max;
            minPrev = min;
        }
        return result;
    }
}
```