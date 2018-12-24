public class Solution {
  /**
   * @param A: An array of non-negative integers.
   * @return: The maximum amount of money you can rob tonight
   */
  public long houseRobber(int[] A) {
    if (A.length == 0) {
      return 0;
    }

    long rob = A[0];
    long skip = 0;

    for (int i = 1; i < A.length; i++) {
      long tmpRob = skip + A[i];
      long tmpSkip = Math.max(rob, skip);
      skip = tmpSkip;
      rob = tmpRob;
    }

    return Math.max(rob, skip);
  }
}
