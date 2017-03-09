
public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int diff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            diff = Math.min(diff, Math.abs(A[i] - B[j]));

            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return diff;
    }
}
