public class Solution {
  /**
   * @param A an array of Integer
   * @return an integer
   */
  public int longestIncreasingContinuousSubsequence(int[] A) {
    if (A.length == 0)
      return 0;
    int max = 1;
    int cntInc = 1;
    int cntDec = 1;
    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i - 1]) {
        cntInc++;
        cntDec = 1;
        max = Math.max(max, cntInc);
      } else if (A[i] < A[i - 1]) {
        cntDec++;
        cntInc = 1;
        max = Math.max(max, cntDec);
      } else {
        cntInc = 1;
        cntDec = 1;
      }
    }
    return max;
  }
}
