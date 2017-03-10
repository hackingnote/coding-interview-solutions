Permutation Index
===


Problem
-------

Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Example
-------

Given [1,2,4], return 1.

Note
---------

Challenge
---------

Solution
--------
 

Code(Java)
----------

```java

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        long index = 1, fact = 1;

        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    rank++;
                }
            }
            index += rank * fact;
            fact *= A.length - i;
        }
        return index;
    }
}
```