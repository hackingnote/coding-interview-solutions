
public class Solution {
  /**
   * @param nums: A list of integers
   * @return an integer
   */
  public int longestConsecutive(int[] num) {
    Set<Integer> set = new HashSet<>();
    for (int i : num) {
      set.add(i);
    }
    int max = 0;
    for (int i : num) {
      if (!set.contains(i)) {
        continue;
      }
      int cnt = 1;
      int k = i;
      while (set.contains(++k)) {
        cnt++;
      }
      k = i;
      while (set.contains(--k)) {
        cnt++;
      }
      max = Math.max(max, cnt);
    }
    return max;
  }
}
