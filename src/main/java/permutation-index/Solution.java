
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