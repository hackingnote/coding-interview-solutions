public class Solution {
  /**
   * @param A an integer array
   * @return void
   */
  public void sortIntegers(int[] A) {
    for (int i = 1; i < A.length; i++) {
      int j = i;
      while (j >= 1 && A[j] < A[j - 1]) {
        int tmp = A[j];
        A[j] = A[j - 1];
        A[j - 1] = tmp;
        j--;
      }
    }
  }
}
