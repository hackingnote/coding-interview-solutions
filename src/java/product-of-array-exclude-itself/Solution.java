Product of Array Exclude Itself 
===


Problem
-------

Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.


Example
-------

For A = [1, 2, 3], return [6, 3, 2].

Challenge
---------

Solution
--------

Code
----
    
    #!java
    public class Solution {
        /**
         * @param A: Given an integers array A
         * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
         */
        public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
            int len = A.size();
            long[] left = new long[len];
            long[] right = new long[len];
            ArrayList<Long> result = new ArrayList<>(len);
       
            for (int i = 0; i < len; i++) {
                result.add(1L);
            }
            
            if (len == 1) {
                return result;
            }
            
            left[0] = A.get(0);
            right[len - 1] = A.get(len - 1);
            
            for (int i = 1; i < len; i++) {
                left[i] = left[i - 1] * A.get(i);
                right[len - i - 1] = right[len - i] * A.get(len - i - 1);
            }
            
            result.set(0, right[1]);
            result.set(len - 1, left[len - 2]);
            for (int i = 1; i < len - 1; i++) {
                result.set(i, left[i - 1] * right[i + 1]);  
            }
            
            return result;
        }
    }

