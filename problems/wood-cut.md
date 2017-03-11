Wood Cut
===

## Problem

Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

 Notice
You couldn't cut wood into float length.
If you couldn't get >= k pieces, return 0.



## Example

For L=[232, 124, 456], k=7, return 114.

Code(Java)
----------

```java
public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int max = 0;
        for (int i : L) {
            max = Math.max(max, i);
        }
        
        int longest = 0;
        int high = max, low = 1;
        
        while (low <= high) {
            int length = low + (high - low) / 2;
            int cnt = 0;
            for (int n : L) {
                cnt += n / length;
            }
            
            if (cnt >= k) {
                longest = Math.max(longest, length);
                low = length + 1;
            } else {
                high = length - 1;
            }
        }
            
            
        
        return longest;
    }
}
```