Backpack II
===


Problem
-------

Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

Example
-------

Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

Note
---------

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Challenge
---------

O(n x m) memory is acceptable, can you do it in O(m) memory?

Solution
--------



Code(Java)
----------

```java
Backpack II
        ===


        Problem
        -------

        Given n items with size Ai and value Vi,and a backpack with size m.What's the maximum value can you put into the backpack?

        Example
        -------

        Given 4items with size[2,3,5,7]and value[1,5,2,4],and a backpack with size 10.The maximum value is 9.

        Note
        ---------

        You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

        Challenge
        ---------

        O(n x m)memory is acceptable,can you do it in O(m)memory?

        Solution
        --------

        Code
        ----

        ```java

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A  & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        int[] bag = new int[m + 1];

        for (int k = 0; k < A.length; k++) {
            int n = A[k];
            for (int i = m; i >= 0; i--) {
                if ((i == 0 || bag[i] > 0) && i + n <= m && bag[i + n] < bag[i] + V[k]) {
                    bag[i + n] = bag[i] + V[k];
                }
            }
        }

        int max = 0;
        for (int v : bag) {
            max = Math.max(max, v);
        }

        return max;

    }

}
```
```