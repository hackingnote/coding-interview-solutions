public class Solution {
  /**
   * @param A an integer array
   * @return A list of integers includes the index of the first number and the index of the last
   *         number
   */
  public ArrayList<Integer> continuousSubarraySum(int[] A) {
    int sum = 0;
    int start = 0;
    int end = 0;
    int max = Integer.MIN_VALUE;
    int tmpStart = 0;
    int tmpEnd = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];

      if (sum > max) {
        max = sum;
        end = i;
        start = tmpStart;
      }

      if (sum < 0) {
        sum = 0;
        tmpStart = i + 1;
        tmpEnd = i + 1;
      }
    }
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(start);
    result.add(end);
    return result;
  }
}
