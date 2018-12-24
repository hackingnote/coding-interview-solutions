class Solution {
  /** @return: The same instance of this class every time */
  private static Solution solution = new Solution();

  private Solution() {}

  public static Solution getInstance() {
    return solution;
  }
};
