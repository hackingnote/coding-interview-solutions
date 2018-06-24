# Jump Game II

## Problem

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

## Example

Given array A = `[2,3,1,1,4]`

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

## Code(Java)

```java
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        steps[0] = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= A[i]; j++) {
                if (i + j >= A.length) continue;
                steps[i + j] = Math.min(steps[i + j], steps[i] + 1);
            }
        }
        return steps[steps.length - 1];
    }
}
```
