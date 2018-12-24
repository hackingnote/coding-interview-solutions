public class Solution {
  /**
   * @param A: A list of integers
   * @param elem: An integer
   * @return: The new length after remove
   */
  public int removeElement(int[] A, int elem) {
    int a = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] != elem) {
        A[a++] = A[i];
      }
    }

    return a;
  }
}
