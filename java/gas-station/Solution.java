public class Solution {
  /**
   * @param gas: an array of integers
   * @param cost: an array of integers
   * @return: an integer
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    for (int start = 0; start < gas.length; start++) {
      int i = start;
      int g = gas[start];
      while (true) {
        g -= cost[i];
        if (g < 0) break;
        i = (i + 1) % cost.length;
        if (i == start) return i;
        g += gas[i];
      }
    }
    return -1;
  }
}
