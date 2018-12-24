public class Solution {
  /**
   * @param num: Given the candidate numbers
   * @param target: Given the target number
   * @return: All the combinations that sum to target
   */
  public List<List<Integer>> combinationSum2(int[] num, int target) {
    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(num);
    for (int i = 0; i < num.length; i++) {
      List<Integer> buffer = new ArrayList<>();
      buffer.add(num[i]);
      search(result, buffer, num, target - num[i], i);
    }
    return new ArrayList<>(result);

  }

  private void search(Set<List<Integer>> result, List<Integer> buffer, int[] num, int target,
      int level) {
    if (target < 0)
      return;
    if (target == 0) {
      result.add(buffer);
      return;
    }

    for (int i = level + 1; i < num.length; i++) {
      List<Integer> copy = new ArrayList<>(buffer);
      copy.add(num[i]);
      search(result, copy, num, target - num[i], i);
    }
  }
}
