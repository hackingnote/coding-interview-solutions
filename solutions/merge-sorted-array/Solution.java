class Solution {
  /**
   * @param A: sorted integer array A which has m elements, but size of A is m+n
   * @param B: sorted integer array B which has n elements
   * @return: void
   */
  public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    int i = m - 1;
    int j = n - 1;
    for (int k = m + n - 1; k >= 0; k--) {
      if (i == -1) {
        A[k] = B[j--];
      } else if (j == -1) {
        A[k] = A[i--];
      } else if (A[i] > B[j]) {
        A[k] = A[i--];
      } else {
        A[k] = B[j--];
      }
    }
  }
}
