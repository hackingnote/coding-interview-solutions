
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int i = 0, j = 0;

        for (int k = 0; k < result.length; k++) {
            if (i == A.length) {
                result[k] = B[j++];
            } else if (j == B.length) {
                result[k] = A[i++];
            } else {
                result[k] = A[i] <= B[j] ? A[i++] : B[j++];
            }
        }

        return result;

    }
}