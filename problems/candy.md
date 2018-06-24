# Candy

## Problem

There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.

Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

## Example

Given ratings = `[1, 2]`, return `3`.
Given ratings = `[1, 1, 1]`, return `3`.
Given ratings = `[1, 2, 2]`, return `4`. (`[1,2,1]`).

## Code(Java)

```java
public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum + ratings.length;
    }
}
```
