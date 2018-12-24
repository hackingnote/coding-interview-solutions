
public class Solution {
  /**
   * @param A: A list of integers
   * @return: The boolean answer
   */
  public boolean canJump(int[] A) {
    int max = 0;
    int i = 0;
    while (i <= max && i < A.length) {
      if (i + A[i] > max) {
        max = i + A[i];
      }
      i++;
    }
    return max >= A.length - 1;
  }
}
