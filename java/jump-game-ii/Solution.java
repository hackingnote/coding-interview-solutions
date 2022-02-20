public class Solution {
  /**
   * @param A: A list of lists of integers
   * @return: An integer
   */
  public int jump(int[] A) {
    int[] steps = new int[A.length];
    for (int i = 0; i < steps.length; i++) {
      steps[i] = Integer.MAX_VALUE;
    }
    steps[0] = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = 1; j <= A[i]; j++) {
        if (i + j >= A.length)
          continue;
        steps[i + j] = Math.min(steps[i + j], steps[i] + 1);
      }
    }
    return steps[steps.length - 1];
  }
}
