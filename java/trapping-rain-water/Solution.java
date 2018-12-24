public class Solution {
  /**
   * @param heights: an array of integers
   * @return: a integer
   */
  public int trapRainWater(int[] heights) {
    int sum = 0;
    int left = 0, right = 0;
    int i = 0, j = heights.length - 1;
    while (i < j) {
      left = Math.max(heights[i], left);
      right = Math.max(heights[j], right);
      if (left < right) {
        sum += left - heights[i];
        i++;
      } else {
        sum += right - heights[j];
        j--;
      }
    }
    return sum;
  }
}
