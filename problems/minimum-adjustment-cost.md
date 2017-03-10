Minimum Adjustment Cost
===


Problem
-------

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Example
-------

Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.


Note
---------

You can assume each number in the array is a positive integer and not greater than 100.

Challenge
---------

Solution
--------



Code(Java)
----------

```java

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int[][] cost = new int[A.size()][101];

        int size = A.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= 100; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i <= 100; i++) {
            cost[0][i] = Math.abs(A.get(0) - i);
        }



        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= 100; j++) {
                int end = Math.min(j + target, 100);
                for (int k = Math.max(0, j - target); k <= end; k++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i - 1][k] + Math.abs(j - A.get(i)));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            min = Math.min(min, cost[size - 1][i]);
        }
        return min;
    }
}
```