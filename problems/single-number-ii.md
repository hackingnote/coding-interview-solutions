Single Number II
===

## Problem

Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.


## Example

Given [1,1,2,3,3,3,2,2,4,1] return 4

Code(Java)
----------

```java
public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer
	 */
    public int singleNumberII(int[] A) {
         int result = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += ((A[j] >> i) & 1);
            }
            result |= ((count % 3) << i);
        }
        return result;
    }
}
```